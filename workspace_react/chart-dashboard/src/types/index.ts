// ChartData.ts (또는 index.ts)

// 1. API 또는 JSON에서 가져오는 원시 데이터 타입
export interface RawStockData {
  t: number;      // timestamp
  o: number;      // open
  h: number;      // high
  l: number;      // low
  c: number;      // close
  v: number;      // volume
}

// 2. 차트 라이브러리에 전달하기 위해 가공된 데이터 타입 (Candlestick)
export interface CandleStick {
  date: string;
  open: number;
  close: number;
  high: number;
  low: number;
}

// 3. 차트 컴포넌트의 Props 타입
export interface MainChartProps {
  data: CandleStick[];
  title: string;
  color?: string; // Tailwind 색상 클래스 등을 위한 선택적 속성
}

// 4. KPI 카드 데이터 타입
export interface KPIData {
  label: string;
  value: string;
  change: number;
  isPositive: boolean;
}

// Filter 타입 정의
export interface FilterType {
  day: string;
  searchData: string;
  symbol: string;
}