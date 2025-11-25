import React from 'react';

interface SearchProps {
    data : string;
    className?: string;
}

export const Search: React.FC<SearchProps> = ({ data, className } :  SearchProps) => {
  const inputStyles = '';
  return (
      <input type="text" placeholder="Search..." className={`border border-gray-300 rounded-xl p-4 bg-white placeholder:text-gray-400 ${className}`}/>
  );
};