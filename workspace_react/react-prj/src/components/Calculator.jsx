import React, { useReducer, useState } from 'react';


function reducer (state, action) {
   switch (action.type) {
      case "PLUS":
         return {result : Number(action.num1) + Number(action.num2)};
      case "MINUS":
         return {result : Number(action.num1) - Number(action.num2)};
      case "MULTIPLY":
         return {result : Number(action.num1) * Number(action.num2)};
      case "DIVISION":
         return {result : Number(action.num1) / Number(action.num2)};
      default:
         new Error('정해지지 않은 타입 ERROR');
   }
}


const Calculator = () => {
   const initialState = {result: 0};
   // const [number, setNumber] = useState(0);
   const [num1, setNum1] = useState(0);
   const [num2, setNum2] = useState(0);
   const [state, dispatch] = useReducer(reducer,initialState);
   
   const handleInput = (e) => {
      const {name,value} = e.target;
      name === 'number1' ? setNum1(value) : setNum2(value);
   }
   return (
      <div>
         <input type="number" name='number1' value={num1} onChange={handleInput} />
         <input type="number" name='number2' value={num2} onChange={handleInput} />

         <div>
            <button onClick={() => dispatch({type:'PLUS', num1:num1 , num2:num2})}>더하기</button>
            <button onClick={() => dispatch({type:'MINUS', num1:num1 , num2:num2})}>빼기</button>
            <button onClick={() => dispatch({type:'MULTIPLY', num1:num1 , num2:num2})}>곱하기</button>
            <button onClick={() => dispatch({type:'DIVISION', num1:num1 , num2:num2})}>나누기</button>
         </div>
         <p>결과 : {state.result}</p>
      </div>
   );
};

export default Calculator;