import { useEffect, useState } from 'react';
import { FilterType } from '@/src/types';
import { 
  ChartDataPoint, 
  formatNumber,
  formatDateTime
} from '@/src/utils/dataTransformer';

const LineChart = ({ filter }: { filter: FilterType }) => {
  const baseStyles = 'bg-white shadow-xl rounded-xl p-6 transition-shadow duration-300 hover:shadow-2xl text-black';
  const [chartData, setChartData] = useState<ChartDataPoint[]>([]);
  const [price, setPrice] = useState<number | null>(null);
  const [meta, setMeta] = useState({ symbol: '', currency: '' });
  const [loading, setLoading] = useState(true);
  const [latestDate, setLatestDate] = useState<string>('');
  const [error, setError] = useState<string | null>(null);
  
  useEffect(() => {
    // TODO: KIS API 또는 다른 데이터 소스로 주식 데이터 가져오기 구현 필요
    setLoading(false);
  }, [filter.day, filter.symbol]);

  if (loading) return <div className="p-6">Loading...</div>;
  if (error) return <div className="p-6 text-red-600">{error}</div>;

  return (
    <div className={baseStyles}>
      <h2 className="text-2xl font-bold mb-4">
        {meta.symbol} 차트
      </h2>
      <div className="mb-2">
        최근 종가: {price !== null ? `${formatNumber(price)} ${meta.currency}` : '데이터 없음'}
      </div>
      <div className="mb-4 text-sm text-gray-500">
        업데이트: {latestDate}
      </div>
      
      {/* 변환된 데이터 확인용 */}
      <div className="mb-4">
        <h3 className="font-semibold mb-2">데이터 포인트 개수: {chartData.length}</h3>
      </div>
      
      {/* 실제 차트는 여기에 추가 (recharts, chart.js 등) */}
      <pre className="mt-4 p-4 bg-gray-100 rounded overflow-auto max-h-96 text-xs">
        {JSON.stringify(chartData, null, 2)}
      </pre>
    </div>
  );
};

export default LineChart;