import React, { useState } from 'react';
import { searchSymbols, SearchResult } from '@/src/services/stockApi';
import { FilterType } from '@/src/types';

interface SearchProps {
    className?: string;
    setFilter?: React.Dispatch<React.SetStateAction<FilterType>>;
}

export const Search: React.FC<SearchProps> = ({ className, setFilter } :  SearchProps) => {
  const [query, setQuery] = useState('');
  const [results, setResults] = useState<SearchResult[]>([]);
  const [showResults, setShowResults] = useState(false);
  const [loading, setLoading] = useState(false);

  const handleSearch = async (q: string) => {
    if (q.length > 1) {
      try {
        setLoading(true);
        const data = await searchSymbols(q);
        setResults(data || []);
        setShowResults(true);
      } catch (error) {
        console.error('검색 오류:', error);
        setResults([]);
      } finally {
        setLoading(false);
      }
    } else {
      setResults([]);
      setShowResults(false);
    }
  };

  const handleSelect = (symbol: string) => {
    if (setFilter) {
      setFilter((prev) => ({ ...prev, symbol }));
    }
    setQuery('');
    setResults([]);
    setShowResults(false);
  };

  // debounce 적용
  React.useEffect(() => {
    const timer = setTimeout(() => {
      if (query) {
        handleSearch(query);
      } else {
        // 검색어가 없으면 결과 초기화
        setResults([]);
        setShowResults(false);
      }
    }, 300); // 0.5초 → 0.3초로 단축

    return () => clearTimeout(timer);
  }, [query]);

  return (
    <div className="relative flex-1">
      <input 
        type="text" 
        value={query}
        onChange={(e) => setQuery(e.target.value)}
        placeholder="종목 검색... (예: Apple, 인텔, 삼성)" 
        className={`w-full border border-gray-300 rounded-xl p-4 bg-white placeholder:text-gray-400 ${className ?? ''}`}
      />
      {loading && (
        <div className="absolute top-full left-0 right-0 mt-2 bg-white border border-gray-300 rounded-xl shadow-lg p-3 z-10">
          <div className="text-sm text-gray-500">검색 중...</div>
        </div>
      )}
      {showResults && results.length > 0 && (
        <div className="absolute top-full left-0 right-0 mt-2 bg-white border border-gray-300 rounded-xl shadow-lg max-h-60 overflow-y-auto z-10">
          {results.map((item) => (
            <div
              key={item.symbol}
              onClick={() => handleSelect(item.symbol)}
              className="p-3 hover:bg-gray-100 cursor-pointer border-b border-gray-100 last:border-b-0"
            >
              <div className="font-semibold text-sm text-black">{item.symbol}</div>
              <div className="text-xs text-gray-600">{item.name}</div>
              <div className="text-xs text-gray-400">{item.exchDisp}</div>
            </div>
          ))}
        </div>
      )}
      {showResults && results.length === 0 && !loading && query.length > 1 && (
        <div className="absolute top-full left-0 right-0 mt-2 bg-white border border-gray-300 rounded-xl shadow-lg p-3 z-10">
          <div className="text-sm text-gray-500">검색 결과가 없습니다.</div>
        </div>
      )}
    </div>
  );
};