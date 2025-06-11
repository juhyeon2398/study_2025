import { ADD_ITEM, DELETE_ITEM } from "../reducers/type";

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


export {addItem, deleteItem};