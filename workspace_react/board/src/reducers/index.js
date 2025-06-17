import {combineReducers} from 'redux';
import board from './board';

// 여러 reducer를 사용하는 경우 reducer를 하나로 묶어주는 함수
const rootReducer = combineReducers({
   board,
})

export default rootReducer;