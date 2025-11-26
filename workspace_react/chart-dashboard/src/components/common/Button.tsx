import React from 'react';
import { FilterType } from '@/src/types';

// 💡 TypeScript Interface 정의: Card 컴포넌트가 받을 Props의 타입을 명확히 정의합니다.
interface ButtonProps {
  value: string;
  className?: string;
  setFilter?: React.Dispatch<React.SetStateAction<FilterType>>;
}

export const Button: React.FC<ButtonProps> = ({ value, className = '', setFilter }) => {
  const baseStyles = 'bg-white shadow-xl rounded-xl p-4 text-center transition-shadow duration-300 hover:shadow-2xl';

  const handleClick = () => {
    if (setFilter) {
      setFilter((prevFilter) => ({
        ...prevFilter,
        day: value,
      }));
    }
  };

  return (
    // 기본 스타일과 전달받은 커스텀 클래스를 병합합니다.
    <button className={`${baseStyles} ${className}`} onClick={handleClick}>
      {value === '1d' ? '1DAY' : value === '1w' ? '1WEEK' : value === '1mo' ? '1MONTH' : value}
    </button>
  );
};