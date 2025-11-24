import { useEffect, useState } from 'react';
import { MainChartProps } from '@/src/types';

const LineChart = ({}: MainChartProps) => {
  const baseStyles = 'bg-white shadow-xl rounded-xl p-6 transition-shadow duration-300 hover:shadow-2xl text-black';
  const [price, setPrice] = useState<number | null>(null);
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    fetch('/api/stocks?symbol=AAPL&range=1mo')
      .then(res => res.json())
      .then(json => {
        // Yahoo Finance v8 응답 구조에 맞게 데이터 추출
        const result = json?.chart?.result?.[0];
        const closes = result?.indicators?.quote?.[0]?.close;
        // 마지막 종가를 price로 설정
        setPrice(closes ? closes[closes.length - 1] : null);
        setLoading(false);
      });
  }, []);

  if (loading) return <div>Loading...</div>;

  return (
    <div className={baseStyles}>
      <h2>MAIN CHART</h2>
      <div>최근 AAPL 종가: {price !== null ? price : '데이터 없음'}</div>
    </div>
  );
};

export default LineChart;