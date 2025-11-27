// /api/stocks 엔드포인트는 현재 사용되지 않습니다
// TODO: KIS API 또는 다른 데이터 소스로 차트 데이터 가져오기 구현

export async function GET(request: Request) {
  return Response.json({ 
    error: 'This endpoint is deprecated. Please use KIS API or other data sources.'
  }, { status: 410 });
}
