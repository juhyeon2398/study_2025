import React, { useEffect, useState } from 'react';

const Counter = () => {
   const [count,setCount] = useState(0);
   const handleCounting = () => {
      // 이전 데이터 참조 하려면 변수 선언
      setCount(prev => prev + 1);
      setCount(prev => prev + 2);
      setCount(prev => prev + 3);
   }

   useEffect(()=>{
      console.log("랜더");
      return () => {
         console.log("cleanup");
         // 언마운트 후 랜더링
         // 일반 로그를 출력하거나 특정 함수를 실행할 수 있다.
         // ex) 접속 해제, 로그아웃 등
      }
   });

   return (
      <div>
         <p>현재 값 : {count}</p>
         <button onClick={handleCounting}>+1</button>
      </div>
   );
};

export default Counter;