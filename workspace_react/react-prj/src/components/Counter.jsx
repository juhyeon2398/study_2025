import React, { useState } from 'react';

const Counter = () => {
   const [count,setCount] = useState(0);
   const handleCounting = () => {
      // 이전 데이터 참조 하려면 변수 선언
      setCount(prev => prev + 1);
      setCount(prev => prev + 2);
      setCount(prev => prev + 3);
      
   }

   return (
      <div>
         <p>현재 값 : {count}</p>
         <button onClick={handleCounting}>+1</button>
      </div>
   );
};

export default Counter;