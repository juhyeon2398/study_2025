import { ADD_ITEM, DECREASE_COUNT, DELETE_ITEM, INCREASE_COUNT } from "../reducers/type";

function addItem(item) {
   return {
      type : ADD_ITEM,
      payload : item
   }
}
function deleteItem(num) {
   return {
      type : DELETE_ITEM,
      payload : num
   }
}
function increaseCount(num) {
   return {
      type : INCREASE_COUNT,
      payload : num
   }
}
function decreaseCount(num) {
   return {
      type : DECREASE_COUNT,
      payload : num
   }
}


export {addItem, deleteItem, increaseCount, decreaseCount};