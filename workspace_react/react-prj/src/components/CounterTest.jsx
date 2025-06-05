import React, { useEffect, useRef, useState } from 'react';

const CounterTest = () => {
   const [number,setNumber] = useState(0);
   const [count,setCount] = useState(0);

   const headleText = () =>{
      setCount(count + 1);
   }

   const ref = useRef(null);
   console.log(" CounterTest  :  ref", ref)


   useEffect(()=> {
      if(count !== 0 && count < 3)
           setNumber(number + 1);
   }, [count])

 
   return (
      <div>
         <p>number : {number}</p>
         <p>count : {count}</p>
         <button onClick={headleText}>Click!</button>
      </div>
   );
};

export default CounterTest;