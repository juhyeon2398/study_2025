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