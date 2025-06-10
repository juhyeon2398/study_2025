import React, { useReducer, useState } from 'react';

function reducer(state, action){
   switch (action.type) {
      case "INCREASE":
         if(state.num !== parseInt(action.max.max)) {
            return {
               num : state.num + 1
            }
         }else{
            return {
               num : state.num
            }
         }
      case "DECREASE":
         if(state.num !== 0) {
            return {
               num : state.num - 1
            }
         }else{
            return {
               num : state.num
            }
         }
      default:
         break;
   }
}


const Display = ({max}) => {
   const initState = {num:0};
   const [state,dispatch] = useReducer(reducer,initState)
   
   return (
      <div>
         <h2>총 {state.num}/{max}명</h2>
         <button onClick={()=> dispatch({type:'INCREASE',max : {max}})}>증가</button>
         <button onClick={()=> dispatch({type:'DECREASE',max : {max}})}>감소</button>
      </div>
   );
};

export default Display;