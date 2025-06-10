import React, { useRef, useState } from 'react';
import Display from './Display';

const InputCount = () => {

   const [max,setMax] = useState(0);
   const [display,setDisplay] = useState(false);
   let ref = useRef(false);
   const handleChangeMax = (e) =>{
      const {name, value} = e.target;
      setMax(value);
   }
   const handleDisplay = () => {
      if(max > 0){
         setDisplay(true);
      }else{
         setDisplay(false);
      }
   }

   return (
      <div>
         <h2>최대인원을 정하시오.</h2>
         <input type="number" name="number" value={max} onChange={handleChangeMax}/><button onClick={handleDisplay}>확인</button>
         {
            display ?
               <Display max={max}/>
            :
            <></>
         }
      </div>
   );
};

export default InputCount;