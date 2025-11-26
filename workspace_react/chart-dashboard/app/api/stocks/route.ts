import axios from "axios";

export async function GET(request: Request) {
  const { searchParams } = new URL(request.url);
  const symbol = searchParams.get('symbol') || 'AAPL';
  const range = searchParams.get('range') || '1d';

  try {
    const url = `https://query1.finance.yahoo.com/v8/finance/chart/${symbol}`;
    
    const response = await axios.get(url, {
      params: {
        range: range,
        interval: getInterval(range),
      },
      headers: {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36",
        "Accept": "application/json"
      },
      timeout: 10000,
    });

    return Response.json(response.data);
  } catch (error) {
    console.error('주식 데이터 조회 오류:', error);
    if (axios.isAxiosError(error)) {
      console.error('Axios 오류:', error.response?.data);
    }
    return Response.json({ 
      chart: { 
        result: [], 
        error: error instanceof Error ? error.message : 'Failed to fetch stock data'
      } 
    }, { status: 500 });
  }
}

// range에 따른 interval 결정
function getInterval(range: string): string {
  switch(range) {
    case '1d':
      return '5m';
    case '1w':
    case '5d':
      return '1h';
    case '1mo':
      return '1d';
    case '3mo':
      return '1d';
    case '1y':
      return '1d';
    default:
      return '1d';
  }
}
