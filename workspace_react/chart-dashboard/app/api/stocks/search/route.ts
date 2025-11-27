import axios from "axios";

interface SearchResult {
  symbol: string;
  name: string;
  shortname: string;
  exch: string;
  type: string;
  exchDisp: string;
  typeDisp: string;
}

// 한국투자증권 API 설정
const KIS_API_CONFIG = {
  appKey: 'PSnDkA6UGlqDgzmAUrksz7qVZJRyEDZpQv78',
  appSecret: 'NSglqcq/89fct097dw6xBuEqyMVlhoaw+LPdY3hwfB84sKw775kQ0gWB33Ly7GwA2/oKm1fRkquJCA2MpJAoQFdt2DiMxZGGPE0xNTBRayt2bP1s5CQ/s4rQjoC1rd+VeamfWvHRF2MEUU6zyiCYdZbRdyMfeC/ly+MKm/bnapWzJ+IOshU=',
  baseUrl: 'https://openapi.koreainvestment.com:9443' // 모의투자 URL
};

// 액세스 토큰 캐시
let accessToken: string | null = null;
let tokenExpiry: number = 0;

// 한국투자증권 액세스 토큰 발급
async function getKISAccessToken(): Promise<string> {
  // 캐시된 토큰이 유효하면 재사용
  if (accessToken && Date.now() < tokenExpiry) {
    console.log('✅ 캐시된 토큰 사용');
    return accessToken;
  }

  try {
    console.log('🔑 한국투자증권 토큰 발급 중...');
    const response = await axios.post(
      `${KIS_API_CONFIG.baseUrl}/oauth2/tokenP`,
      {
        grant_type: 'client_credentials',
        appkey: KIS_API_CONFIG.appKey,
        appsecret: KIS_API_CONFIG.appSecret
      }
    );

    accessToken = response.data.access_token;
    // 토큰 만료 시간 설정 (발급 후 23시간)
    tokenExpiry = Date.now() + (23 * 60 * 60 * 1000);
    
    console.log('✅ 토큰 발급 성공');
    return accessToken!;
  } catch (error) {
    console.error('❌ 토큰 발급 실패:', error);
    throw error;
  }
}

interface KISStockItem {
  pdno: string;
  prdt_name: string;
}

// 한국투자증권 API로 종목 검색
async function searchKISStocks(query: string): Promise<SearchResult[]> {
  try {
    const token = await getKISAccessToken();
    
    console.log('🔍 한국투자증권 API 검색 중...');
    
    // 종목 조회 API
    const response = await axios.get(
      `${KIS_API_CONFIG.baseUrl}/uapi/domestic-stock/v1/quotations/search-stock-info`,
      {
        headers: {
          'authorization': `Bearer ${token}`,
          'appkey': KIS_API_CONFIG.appKey,
          'appsecret': KIS_API_CONFIG.appSecret,
          'tr_id': 'CTPF1604R'
        },
        params: {
          PRDT_TYPE_CD: '300',
          PDNO: query
        }
      }
    );

    const results: SearchResult[] = [];
    
    if (response.data.output && response.data.output.length > 0) {
      response.data.output.forEach((item: KISStockItem) => {
        results.push({
          symbol: `${item.pdno}.KS`,
          name: item.prdt_name,
          shortname: item.prdt_name,
          exch: 'KOSPI',
          type: 'EQUITY',
          exchDisp: 'KOSPI',
          typeDisp: '주식'
        });
      });
    }

    console.log(`✅ ${results.length}개 종목 발견`);
    return results.slice(0, 10);
  } catch (error) {
    console.error('❌ 한국투자증권 검색 실패:', error);
    return [];
  }
}

// 백업용 한국 주식 데이터
const KOREAN_STOCKS = [
  { code: '005930', name: '삼성전자', market: 'KOSPI' },
  { code: '000660', name: 'SK하이닉스', market: 'KOSPI' },
  { code: '035420', name: 'NAVER', market: 'KOSPI' },
  { code: '035720', name: '카카오', market: 'KOSPI' },
  { code: '005380', name: '현대차', market: 'KOSPI' },
  { code: '066570', name: 'LG전자', market: 'KOSPI' },
  { code: '051910', name: 'LG화학', market: 'KOSPI' },
  { code: '068270', name: '셀트리온', market: 'KOSPI' },
  { code: '000270', name: '기아', market: 'KOSPI' },
  { code: '005490', name: 'POSCO홀딩스', market: 'KOSPI' },
  { code: '105560', name: 'KB금융', market: 'KOSPI' },
  { code: '086520', name: '에코프로', market: 'KOSDAQ' },
  { code: '247540', name: '에코프로비엠', market: 'KOSDAQ' },
];

// 백업 검색 함수
function searchKoreanStocksBackup(query: string): SearchResult[] {
  const lowerQuery = query.toLowerCase().trim();
  
  return KOREAN_STOCKS
    .filter(stock => 
      stock.name.toLowerCase().includes(lowerQuery) ||
      stock.code.includes(lowerQuery)
    )
    .slice(0, 10)
    .map(stock => ({
      symbol: `${stock.code}.${stock.market === 'KOSPI' ? 'KS' : 'KQ'}`,
      name: stock.name,
      shortname: stock.name,
      exch: stock.market,
      type: 'EQUITY',
      exchDisp: stock.market,
      typeDisp: '주식'
    }));
}

/**
 * 주식 검색 API
 */
export async function GET(request: Request) {
  const { searchParams } = new URL(request.url);
  const query = searchParams.get('q') || '';

  console.log('\n=== 주식 검색 시작 ===');
  console.log('원본 검색어:', query);

  if (!query) {
    return Response.json({ quotes: [] });
  }

  console.log('🇰🇷 한국 주식 검색 중...');
  
  // 먼저 KIS API 시도
  const kisResults = await searchKISStocks(query);
  
  if (kisResults.length > 0) {
    console.log(`✅ KIS API: ${kisResults.length}개 발견`);
    return Response.json({ quotes: kisResults });
  }
  
  // KIS API 실패 시 백업 리스트 사용
  console.log('⚠️ KIS API 실패, 백업 리스트 사용');
  const backupResults = searchKoreanStocksBackup(query);
  
  if (backupResults.length > 0) {
    console.log(`✅ 백업 리스트: ${backupResults.length}개 발견`);
    return Response.json({ quotes: backupResults });
  }
  
  console.log('⚠️ 검색 결과 없음');
  return Response.json({ quotes: [] });
}