import React from 'react';

// 💡 TypeScript Interface 정의: Card 컴포넌트가 받을 Props의 타입을 명확히 정의합니다.
interface CardProps {
  /** 카드 내부에 렌더링될 React 요소 (차트, 텍스트, 다른 컴포넌트 등) */
  children: React.ReactNode;
  /** Tailwind CSS 클래스를 오버라이드하거나 추가할 때 사용합니다. */
  className?: string;
}

/**
 * @description Tailwind CSS 기반의 재사용 가능한 컨테이너 컴포넌트입니다.
 * 모든 차트 및 KPI 섹션에 일관된 배경, 그림자, 모서리 둥글기를 제공합니다.
 */
export const Card: React.FC<CardProps> = ({ children, className = '' }) => {
  // 기본 스타일 정의: 하얀 배경, 큰 그림자, 모서리 둥글게, 내부 패딩
  const baseStyles = 'bg-white shadow-xl rounded-xl p-6 transition-shadow duration-300 hover:shadow-2xl';

  return (
    // 기본 스타일과 전달받은 커스텀 클래스를 병합합니다.
    <div className={`${baseStyles} ${className}`}>
      {children}
    </div>
  );
};