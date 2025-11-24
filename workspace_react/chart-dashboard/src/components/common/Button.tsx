import React from 'react';

// 💡 TypeScript Interface 정의: Card 컴포넌트가 받을 Props의 타입을 명확히 정의합니다.
interface ButtonProps {
  children: React.ReactNode;
  className?: string;
}

export const Button: React.FC<ButtonProps> = ({ children, className = '' }) => {
  const baseStyles = 'bg-white shadow-xl rounded-xl p-6 transition-shadow duration-300 hover:shadow-2xl';

  return (
    // 기본 스타일과 전달받은 커스텀 클래스를 병합합니다.
    <div className={`${baseStyles} ${className}`}>
      {children}
    </div>
  );
};