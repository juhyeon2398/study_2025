import React from 'react';
import Link from 'next/link';

// Header 컴포넌트에는 특별한 Props가 필요하지 않지만, 
// TypeScript 환경을 위해 React.FC를 사용합니다.
export const Header: React.FC = () => {
  return (
    // Tailwind CSS를 사용하여 스타일링: 
    // 상단 고정, 흰색 배경, 그림자, 패딩
    <header className="fixed top-0 left-0 right-0 bg-white shadow-md z-20">
      <div className="container mx-auto px-4 md:px-8 py-3 flex items-center justify-between">
        
        {/* 1. 프로젝트 로고/이름 (좌측) */}
        <Link href="/" className="flex items-center space-x-2">
          <svg 
            className="w-6 h-6 text-blue-600" 
            fill="none" 
            stroke="currentColor" 
            viewBox="0 0 24 24" 
            xmlns="http://www.w3.org/2000/svg"
          >
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M11 3.055A9.001 9.001 0 1020.945 13H11V3.055z" />
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M20.488 9H15V3.512A9.025 9.025 0 0120.488 9z" />
          </svg>
          <h1 className="text-xl font-bold text-gray-800">ChartViz Pro</h1>
        </Link>

        {/* 2. 내비게이션 및 액션 (우측) */}
        <nav className="flex items-center space-x-4">
          
          {/* GitHub 링크 버튼 */}
          <a
            href="[당신의-GitHub-프로젝트-링크]"
            target="_blank"
            rel="noopener noreferrer"
            className="text-sm font-medium text-gray-600 hover:text-blue-600 transition duration-150"
          >
            GitHub
          </a>

          {/* 데모 버튼 (예시) */}
          <button 
            className="px-3 py-1 bg-blue-600 text-white rounded-md hover:bg-blue-700 transition duration-150 text-sm"
            onClick={() => alert("데모 액션")}
          >
            대시보드
          </button>
        </nav>
      </div>
    </header>
  );
};