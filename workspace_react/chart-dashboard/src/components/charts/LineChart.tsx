import { FilterType } from '@/src/types';

const LineChart = ({ filter }: { filter: FilterType }) => {
  const baseStyles = 'bg-white shadow-xl rounded-xl p-6 transition-shadow duration-300 hover:shadow-2xl text-black';

  return (
    <div className={baseStyles}>
      <h2 className="text-2xl font-bold mb-4">
        {filter.symbol || '주식'} 차트
      </h2>
      <div className="mb-2">
        최근 종가: 데이터 없음
      </div>
      <div className="mb-4 text-sm text-gray-500">
        업데이트: -
      </div>
      
      {/* TODO: KIS API 또는 다른 데이터 소스로 주식 데이터 가져오기 구현 필요 */}
      <div className="mb-4">
        <h3 className="font-semibold mb-2">데이터 포인트 개수: 0</h3>
      </div>
      
      {/* 실제 차트는 여기에 추가 (recharts, chart.js 등) */}
      <pre className="mt-4 p-4 bg-gray-100 rounded overflow-auto max-h-96 text-xs">
        선택된 기간: {filter.day}일
        {'\n'}선택된 심볼: {filter.symbol || '없음'}
      </pre>
    </div>
  );
};

export default LineChart;