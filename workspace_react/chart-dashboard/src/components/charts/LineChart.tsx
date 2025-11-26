import { useEffect, useState } from 'react';
import { FilterType } from '@/src/types';
import { 
  transformYahooFinanceData, 
  getLatestPrice, 
  getMetaInfo,
  ChartDataPoint, 
  formatNumber,
  formatDateTime
} from '@/src/utils/dataTransformer';
import { fetchStockData } from '@/src/services/stockApi';

const LineChart = ({ filter }: { filter: FilterType }) => {
  const baseStyles = 'bg-white shadow-xl rounded-xl p-6 transition-shadow duration-300 hover:shadow-2xl text-black';
  const [chartData, setChartData] = useState<ChartDataPoint[]>([]);
  const [price, setPrice] = useState<number | null>(null);
  const [meta, setMeta] = useState({ symbol: '', currency: '' });
  const [loading, setLoading] = useState(true);
  const [latestDate, setLatestDate] = useState<string>('');
  const [error, setError] = useState<string | null>(null);
  
  useEffect(() => {
    // 비동기 함수로 분리
    console.log("🚀 ~ fetchData ~ filter.symbol:", filter.symbol)
    const fetchData = async () => {
      try {
        setLoading(true);
        setError(null);
        
        // API 서비스 사용
        const json = await fetchStockData(filter.symbol, filter.day);
        
        // 데이터 변환
        const transformedData = transformYahooFinanceData(json);
        setChartData(transformedData);
        
        // 최근 가격 추출
        setPrice(getLatestPrice(json));
        
        // 메타 정보 추출
        setMeta(getMetaInfo(json));
        
        // 최근 날짜 추출
        if (transformedData.length > 0) {
          const lastData = transformedData[transformedData.length - 1];
          setLatestDate(formatDateTime(lastData.timestamp));
        }
      } catch (err) {
        console.error('데이터 로드 오류:', err);
        setError(err instanceof Error ? err.message : '데이터를 불러오는데 실패했습니다.');
      } finally {
        setLoading(false);
      }
    };
    
    fetchData();
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