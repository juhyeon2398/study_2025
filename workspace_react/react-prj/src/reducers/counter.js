import { INCREASE,DECREASE } from "./type";

// 초기 상태 값 설정
// 다른 곳에서 상태를 생서하고 부여할 수 없다
const initialState = {count : 0};

const counter = (state=initialState, action) => {
   switch(action.type){
      case INCREASE : 
         return {count : state.count + action.payload};
      case DECREASE : 
         return {count : state.count - 1};
      default : return state;
   }
}
export default counter;