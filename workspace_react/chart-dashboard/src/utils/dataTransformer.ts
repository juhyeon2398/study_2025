// Yahoo Finance API 응답 타입
interface YahooFinanceResponse {
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

// 변환된 차트 데이터 타입
export interface ChartDataPoint {
  date: string;
  timestamp: number;
  close: number;
  open: number;
  high: number;
  low: number;
  volume: number;
}

/**
 * 날짜를 포맷팅 (YYYY-MM-DD 형식) - 한국 시간 기준
 */
export function formatDate(timestamp: number): string {
  const date = new Date(timestamp * 1000);
  // 한국 시간으로 변환 (UTC+9)
  const koreaDate = new Date(date.toLocaleString('en-US', { timeZone: 'Asia/Seoul' }));
  const year = koreaDate.getFullYear();
  const month = String(koreaDate.getMonth() + 1).padStart(2, '0');
  const day = String(koreaDate.getDate()).padStart(2, '0');
  return `${year}-${month}-${day}`;
}

/**
 * 날짜와 시간을 포맷팅 (YYYY-MM-DD HH:mm 형식) - 한국 시간 기준
 */
export function formatDateTime(timestamp: number): string {
  const date = new Date(timestamp * 1000);
  // 한국 시간으로 변환 (UTC+9)
  const koreaDate = new Date(date.toLocaleString('en-US', { timeZone: 'Asia/Seoul' }));
  const year = koreaDate.getFullYear();
  const month = String(koreaDate.getMonth() + 1).padStart(2, '0');
  const day = String(koreaDate.getDate()).padStart(2, '0');
  const hours = String(koreaDate.getHours()).padStart(2, '0');
  const minutes = String(koreaDate.getMinutes()).padStart(2, '0');
  return `${year}-${month}-${day} ${hours}:${minutes}`;
}

/**
 * Yahoo Finance API 응답을 차트에 사용할 수 있는 형태로 변환
 */
export function transformYahooFinanceData(
  response: YahooFinanceResponse
): ChartDataPoint[] {
  const result = response?.chart?.result?.[0];
  
  if (!result) {
    return [];
  }

  const { timestamp, indicators } = result;
  const quote = indicators.quote[0];

  // timestamp 배열과 각 지표 배열을 결합
  return timestamp.map((time, index) => ({
    date: formatDate(time),
    timestamp: time,
    close: quote.close[index] ?? 0,
    open: quote.open[index] ?? 0,
    high: quote.high[index] ?? 0,
    low: quote.low[index] ?? 0,
    volume: quote.volume[index] ?? 0,
  }));
}

/**
 * 최근 종가만 추출
 */
export function getLatestPrice(response: YahooFinanceResponse): number | null {
  const result = response?.chart?.result?.[0];
  const closes = result?.indicators?.quote?.[0]?.close;
  return closes && closes.length > 0 ? closes[closes.length - 1] : null;
}

/**
 * 심볼과 통화 정보 추출
 */
export function getMetaInfo(response: YahooFinanceResponse) {
  const result = response?.chart?.result?.[0];
  return {
    symbol: result?.meta?.symbol ?? '',
    currency: result?.meta?.currency ?? '',
  };
}

export function formatNumber(value: number): string {
  return value.toLocaleString('en-US', {
    minimumFractionDigits: 2,
    maximumFractionDigits: 2,
  });
}