import axios from "axios";

export async function GET(request: Request) {
  const { searchParams } = new URL(request.url);
  const exchange = searchParams.get('exchange') || 'US';

  try {
    const response = await axios.get(
      `https://query1.finance.yahoo.com/v1/finance/trending/${exchange}`,
      {
        headers: {
          "User-Agent": "Mozilla/5.0",
          "Accept": "application/json"
        }
      }
    );

    return Response.json(response.data);
  } catch (error) {
    console.error('인기 종목 조회 오류:', error);
    return Response.json({ quotes: [] }, { status: 500 });
  }
}