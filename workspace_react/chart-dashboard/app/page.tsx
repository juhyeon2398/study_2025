// 상태 관리, 이벤트 핸들링 등 클라이언트 측 상호작용이 필요하므로 명시
'use client';

import React from 'react';
import { Header } from '../src/components/layout/Header';
import { Main } from '@/src/components/layout/Main';
// hooks, types 등 다른 모듈 임포트

// 💡 타입 정의는 별도의 파일에서 가져오는 것을 권장합니다.
// type StockData = { date: string; close: number; };

const DashboardPage: React.FC = () => {
  // const [data, setData] = useState<StockData[]>([]); 
  // 💡 여기에 useDataFetcher 훅 및 상태 관리 로직을 추가합니다.

  return (
    <div className="min-h-screen pt-20 pl-8 pr-8 pb-8">
      <main className="">
        {/* 헤더 컴포넌트 삽입 */}
        <Header />
        {/* 메인 콘텐츠 영역 */}
        <Main />
      </main>
    </div>
  );
};

export default DashboardPage;