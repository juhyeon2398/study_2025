// 변환된 차트 데이터 타입
export interface ChartDataPoint {
  date: string;
  timestamp: number;
  close: number;
  open: number;
  high: number;
  low: number;
  volume: number;
}

/**
 * 날짜를 포맷팅 (YYYY-MM-DD 형식) - 한국 시간 기준
 */
export function formatDate(timestamp: number): string {
  const date = new Date(timestamp * 1000);
  // 한국 시간으로 변환 (UTC+9)
  const koreaDate = new Date(date.toLocaleString('en-US', { timeZone: 'Asia/Seoul' }));
  const year = koreaDate.getFullYear();
  const month = String(koreaDate.getMonth() + 1).padStart(2, '0');
  const day = String(koreaDate.getDate()).padStart(2, '0');
  return `${year}-${month}-${day}`;
}

/**
 * 날짜와 시간을 포맷팅 (YYYY-MM-DD HH:mm 형식) - 한국 시간 기준
 */
export function formatDateTime(timestamp: number): string {
  const date = new Date(timestamp * 1000);
  // 한국 시간으로 변환 (UTC+9)
  const koreaDate = new Date(date.toLocaleString('en-US', { timeZone: 'Asia/Seoul' }));
  const year = koreaDate.getFullYear();
  const month = String(koreaDate.getMonth() + 1).padStart(2, '0');
  const day = String(koreaDate.getDate()).padStart(2, '0');
  const hours = String(koreaDate.getHours()).padStart(2, '0');
  const minutes = String(koreaDate.getMinutes()).padStart(2, '0');
  return `${year}-${month}-${day} ${hours}:${minutes}`;
}



export function formatNumber(value: number): string {
  return value.toLocaleString('en-US', {
    minimumFractionDigits: 2,
    maximumFractionDigits: 2,
  });
}