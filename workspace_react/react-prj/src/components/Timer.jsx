import React, { useEffect, useRef, useState } from 'react';

const Timer = () => {
   const [count,setCount] = useState(0);
   let time = useRef(null);
   const handleTimerControl = (type) => {
      if(type === 'START'){
         time.current = setInterval(() => {
            setCount(prev => prev + 1);
         }, 1000);
      }else if(type === 'STOP'){
         clearInterval(time.current);
      }else{
         if(time != null){
            clearInterval(time.current);
            time.current = null;
         }
         setCount(0);
      }
   }
 
   // useEffect(()=>{
   // },[count])

   return (
      <div>
         <h2>Timer</h2>
         <p>경과 시간 : {count}초</p>
         <button onClick={()=>handleTimerControl('START')}>시작</button>
         <button onClick={()=>handleTimerControl('STOP')}>정지</button>
         <button onClick={()=>handleTimerControl('RESET')}>초기화</button>
      </div>
   );
};

export default Timer;