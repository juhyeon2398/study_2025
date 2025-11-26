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

// 한글 확인
function containsKorean(text: string): boolean {
  return /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/.test(text);
}

// 한국 주식 데이터 (확장 가능)
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
  { code: '091990', name: '셀트리온헬스케어', market: 'KOSPI' },
  { code: '096770', name: 'SK이노베이션', market: 'KOSPI' },
  { code: '207940', name: '삼성바이오로직스', market: 'KOSPI' },
  { code: '006400', name: '삼성SDI', market: 'KOSPI' },
  { code: '373220', name: 'LG에너지솔루션', market: 'KOSPI' },
  { code: '003670', name: '포스코퓨처엠', market: 'KOSPI' },
  { code: '352820', name: '하이브', market: 'KOSPI' },
  { code: '000120', name: 'CJ대한통운', market: 'KOSPI' },
  { code: '028260', name: '삼성물산', market: 'KOSPI' },
  { code: '012330', name: '현대모비스', market: 'KOSPI' },
  { code: '017670', name: 'SK텔레콤', market: 'KOSPI' },
  { code: '055550', name: '신한지주', market: 'KOSPI' },
  { code: '086790', name: '하나금융지주', market: 'KOSPI' },
  { code: '032830', name: '삼성생명', market: 'KOSPI' },
  { code: '009150', name: '삼성전기', market: 'KOSPI' },
  { code: '011170', name: '롯데케미칼', market: 'KOSPI' },
  { code: '034730', name: 'SK', market: 'KOSPI' },
  { code: '036570', name: '엔씨소프트', market: 'KOSPI' },
  { code: '251270', name: '넷마블', market: 'KOSPI' },
  { code: '259960', name: '크래프톤', market: 'KOSPI' },
  { code: '035900', name: 'JYP Ent.', market: 'KOSPI' },
  { code: '041510', name: 'SM', market: 'KOSPI' },
];

// 한국 주식 검색
function searchKoreanStocks(query: string): SearchResult[] {
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

interface YahooQuote {
  symbol: string;
  shortname?: string;
  longname?: string;
  exchange?: string;
  exchDisp?: string;
  quoteType?: string;
  typeDisp?: string;
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

  const isKorean = containsKorean(query);

  // 1. 한글이면 자체 한국 주식 리스트에서 검색
  if (isKorean) {
    console.log('🇰🇷 한국 주식 검색 중...');
    const koreanResults = searchKoreanStocks(query);
    
    if (koreanResults.length > 0) {
      console.log(`✅ 한국 주식 ${koreanResults.length}개 발견`);
      return Response.json({ quotes: koreanResults });
    }
    
    console.log('⚠️ 한국 주식에서 결과 없음');
    return Response.json({ quotes: [] });
  }

  // 2. 영어면 Yahoo Finance에서 검색
  try {
    console.log('🌐 Yahoo Finance 검색 중...');
    const response = await axios.get(
      `https://query1.finance.yahoo.com/v1/finance/search`,
      {
        params: {
          q: query,
          quotesCount: 10,
          newsCount: 0
        },
        headers: {
          "User-Agent": "Mozilla/5.0",
          "Accept": "application/json"
        },
        timeout: 10000,
      }
    );
    
    const quotes = (response.data.quotes || []).map((q: YahooQuote) => ({
      symbol: q.symbol,
      name: q.longname || q.shortname || q.symbol,
      shortname: q.shortname || q.longname || q.symbol,
      exch: q.exchange || '',
      type: q.quoteType || '',
      exchDisp: q.exchDisp || q.exchange || '',
      typeDisp: q.typeDisp || q.quoteType || ''
    }));

    console.log(`✅ ${quotes.length}개 결과 반환`);
    return Response.json({ quotes });
  } catch (error) {
    console.error('❌ 검색 오류:', error);
    return Response.json({ quotes: [] });
  }
}