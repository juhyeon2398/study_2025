import './globals.css'; // Tailwind CSS 지시문이 포함된 파일
import type { Metadata } from 'next';
import { Inter } from 'next/font/google';

// 폰트 정의
const inter = Inter({ subsets: ['latin'] });

// 메타데이터 정의 (SEO)
export const metadata: Metadata = {
  title: 'Data Visualization Dashboard',
  description: 'Next.js, TypeScript, Tailwind 기반의 대시보드 프로젝트',
};

// 루트 레이아웃 컴포넌트
export default function RootLayout({
  children,
}: {
  children: React.ReactNode; // 자식 요소의 타입 명시
}) {
  return (
    <html lang="ko">
      {/* Tailwind CSS를 사용한 기본 스타일링: 폰트, 배경색 */}
      <body className={`${inter.className} bg-gray-50 antialiased`}>
        {children}
      </body>
    </html>
  );
}