import { NextResponse } from 'next/server';
import axios from 'axios';

// Yahoo Finance API의 기본 URL (예시)
const YAHOO_FINANCE_BASE_URL = 'https://query1.finance.yahoo.com/v8/finance/chart';

export async function GET(request: Request) {
  const { searchParams } = new URL(request.url);
  const symbol = searchParams.get('symbol') || 'AAPL'; // 기본값 설정
  const range = searchParams.get('range') || '1mo';   // 기간 설정 (1mo = 1개월)

  try {
    // 1. Axios를 사용하여 Yahoo Finance 엔드포인트에 요청
    const response = await axios.get(`${YAHOO_FINANCE_BASE_URL}/${symbol}`, {
      params: {
        range: range,
        interval: '1d', // 일별 데이터 요청
      },
    });

    const yahooData = response.data;

    // 2. 받은 데이터의 유효성 검사 및 필요한 경우 가공 (src/utils/dataTransformer.ts 활용)
    // 이 단계에서 복잡한 캔들스틱 변환을 수행할 수 있습니다.
    
    // 3. 가공된 데이터를 클라이언트에게 JSON 형태로 반환
    
    return NextResponse.json(yahooData); // Next.js의 NextResponse는 더 편리합니다.

  } catch (error) {
    console.error('Yahoo Finance API 호출 오류:', error);
    
    const errorMessage = 'External API fetch failed.';
    if (axios.isAxiosError(error) && error.response) {
      // Axios 에러일 경우 상세 상태 코드 반환
      return NextResponse.json({ 
        error: errorMessage, 
        details: error.response.statusText 
      }, { status: error.response.status });
    }

    return NextResponse.json({ error: errorMessage }, { status: 500 });
  }
}