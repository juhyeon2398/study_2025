import React, { useMemo, useState } from 'react';

function Multiply({num1,num2}) {

  // const result = () => {
  //   console.log(`Calculationg...`);
  //   return num1 * num2;
  // }
  // 특정 연산 영역을 변경값이 발생했을 때만 랜더링 진행
  const result = useMemo(()=>{
      console.log(`Calculationg...`);
      return num1 * num2;
  },[num1,num2]);
  return (
    <div>
      <p>첫 번째 숫자 : {num1}</p>
      <p>두 번째 숫자 : {num2}</p>
      <p>두 숫자의 곱 : {result}</p>

    </div>
  )
}

const MemoTest = () => {
   const [number1, setNumber1] = useState(5);
   const [number2, setNumber2] = useState(3);
   const [count, setCount] = useState(0);
   const handleInputChage = (e) => {
      const {name, value} = e.target;
      name === 'number1' ? setNumber1(value) : setNumber2(value);
   }
   const handleCount = (e) => {
     setCount(count + 1);
   }
   return (
      <div>
         <input type='number' name='number1' value={number1} onChange={handleInputChage}/>
        <input type='number' name='number2' value={number2} onChange={handleInputChage}/>
        <br/>
        <Multiply num1={number1} num2={number2}/>
        <br/>
        <span>{count}</span>
        <button onClick={handleCount}>증가</button>
      </div>
   );
};

export default MemoTest;