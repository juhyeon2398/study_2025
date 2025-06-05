import React, { useEffect, useRef, useState } from 'react';

const RefTest = () => {
   const init = '';
   const [text, setText] = useState(init);
   const textInput = useRef();
   const handleChangeInput = (e) => {
      setText(e.target.value);
   }
   
   const reset = () => {
      setText(init);
      textInput.current.focus();
   }

   const refValue = useRef(0);
   let varValue = 0;
   // 일반변수는 랜더 시 초기화 
   // ref는 랜더시 값을 유지
   console.log('랜더링 후 ref : ' + refValue.current);
   console.log('랜더링 후 var : ' + varValue);
   

   useEffect(() => {
      refValue.current++;
      varValue++;
   })
   
   return (
      <div>
         <input type="text" value={text} onChange={handleChangeInput} ref={textInput}/>
         <button onClick={reset}>reset</button>
      </div>
   );
};

export default RefTest;