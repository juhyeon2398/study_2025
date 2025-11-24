import React from 'react';
import { Card } from '../common/Card';
import LineChart from '../charts/LineChart';

// Header 컴포넌트에는 특별한 Props가 필요하지 않지만, 
// TypeScript 환경을 위해 React.FC를 사용합니다.
export const Main: React.FC = () => {
  return (
    // Tailwind CSS를 사용하여 스타일링: 
    // 상단 고정, 흰색 배경, 그림자, 패딩
      <section className="grid grid-cols-2 md:grid-cols-4 gap-6 mb-8">
        <Card
          title="CURRENT PRICE"
          description="Tailwind로 간단하게 구성한 카드 컴포넌트입니다."
          image="https://placehold.co/400x250"
          className="p-4"
        />
        <Card
          title="24H CHANGE"
          description="Tailwind로 간단하게 구성한 카드 컴포넌트입니다."
          image="https://placehold.co/400x250"
          className="p-4"
        />
        <Card
          title="24H VOLUME"
          description="Tailwind로 간단하게 구성한 카드 컴포넌트입니다."
          image="https://placehold.co/400x250"
          className="p-4"
        />
        <Card
          title="MARKET CAP"
          description="Tailwind로 간단하게 구성한 카드 컴포넌트입니다."
          image="https://placehold.co/400x250"
          className="p-4"
        />

        <LineChart/>

      </section>
  );
};