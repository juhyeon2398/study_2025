import React from 'react';
import Image from 'next/image';

// 💡 TypeScript Interface 정의: Card 컴포넌트가 받을 Props의 타입을 명확히 정의합니다.
interface CardProps {
  title : string;
  drscription?: string;
  image : string;
  className?: string;
}

export const Card: React.FC<CardProps> = ({ title, drscription, image, className } :  CardProps) => {
  // 기본 스타일 정의: 하얀 배경, 큰 그림자, 모서리 둥글게, 내부 패딩
  const baseStyles = 'bg-white shadow-xl rounded-xl p-6 transition-shadow duration-300 hover:shadow-2xl text-black';

  return (
    // 기본 스타일과 전달받은 커스텀 클래스를 병합합니다.
    <div className={`${baseStyles} ${className ?? ''}`}>
      {image && (
        <Image
          src={image}
          alt={title}
          width={400}
          height={192}
          className="w-full h-48 object-cover mb-4 rounded-md"
        />
      )}
      <h3 className="text-lg font-semibold mb-2">{title}</h3>
      {drscription && <p className="text-gray-600">{drscription}</p>}
    </div>
  );
};