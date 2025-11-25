import { useEffect, useState } from 'react';
import { MainChartProps } from '@/src/types';

// Yahoo Finance API 응답 타입 정의
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

const LineChart = ({}: MainChartProps) => {
  const baseStyles = 'bg-white shadow-xl rounded-xl p-6 transition-shadow duration-300 hover:shadow-2xl text-black';
  const [price, setPrice] = useState<number | null>(null);
  const [loading, setLoading] = useState(true);
  const [fullData, setFullData] = useState<YahooFinanceResponse | null>(null);
  
  useEffect(() => {
    fetch('/api/stocks?symbol=AAPL&range=1mo')
      .then(res => res.json())
      .then((json: YahooFinanceResponse) => {
        setFullData(json);
        const result = json?.chart?.result?.[0];
        const closes = result?.indicators?.quote?.[0]?.close;
        setPrice(closes ? closes[closes.length - 1] : null);
        setLoading(false);
      });
  }, []);

  if (loading) return <div>Loading...</div>;

  return (
    <div className={baseStyles}>
      <h2>MAIN CHART</h2>
      <div>최근 AAPL 종가: {price !== null ? price : '데이터 없음'}</div>
      <pre className="mt-4 p-4 bg-gray-100 rounded overflow-auto max-h-96">
        {JSON.stringify(fullData, null, 2)}
      </pre>
    </div>
  );
};

export default LineChart;