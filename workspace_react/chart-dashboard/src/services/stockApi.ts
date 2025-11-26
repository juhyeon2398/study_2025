// Yahoo Finance API 응답 타입 정의
export interface YahooFinanceResponse {
  chart: {
    result: Array<{
      meta: {
        symbol: string;
        currency: string;
      };
      timestamp: number[];
      indicators: {
        quote: Array<{
          close: number[];
          open: number[];
          high: number[];
          low: number[];
          volume: number[];
        }>;
      };
    }>;
    error: null | string;
  };
}

/**
 * Yahoo Finance 주식 데이터 가져오기
 * @param symbol 종목 심볼 (예: AAPL)
 * @param range 기간 (예: 1d, 1w, 1mo)
 */
export async function fetchStockData(
  symbol: string,
  range: string
): Promise<YahooFinanceResponse> {
  const res = await fetch(`/api/stocks?symbol=${symbol}&range=${range}`);

  if (!res.ok) {
    throw new Error(`API 호출 실패: ${res.status} ${res.statusText}`);
  }

  return res.json();
}


/**
 * 검색 결과 타입
 */
export interface SearchResult {
  symbol: string;
  name: string;
  exch: string;
  type: string;
  exchDisp: string;
  typeDisp: string;
}

/**
 * 종목 검색 (키워드로 검색)
 * @param query 검색 키워드 (예: "Apple", "삼성") - 한글/영어 모두 지원
 */
export async function searchSymbols(query: string): Promise<SearchResult[]> {
  if (!query || query.trim().length === 0) {
    return [];
  }
  
  const res = await fetch(`/api/stocks/search?q=${encodeURIComponent(query)}`);
  
  if (!res.ok) {
    throw new Error(`검색 실패: ${res.status} ${res.statusText}`);
  }
  
  const data = await res.json();
  return data.quotes || [];
}