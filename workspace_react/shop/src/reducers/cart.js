import { ADD_ITEM, DECREASE_COUNT, DELETE_ITEM, INCREASE_COUNT } from "./type";

const initialState = [

];

const cart = (state = initialState, action) => {
  switch (action.type) {
    case ADD_ITEM:
      return state.find(item => 
        item.id === action.payload.id) === undefined ? 
        [...state, action.payload] :
        
        state.map(item => 
          item.id === action.payload.id ? 
          {...item, count : item.count + 1} : 
          item
      );

    case DELETE_ITEM:
      return state.filter(item => item.id !== action.payload);

    case INCREASE_COUNT:
      return state.map(item => 
        item.id === action.payload ? 
        {...item, count : item.count + 1} : 
          item
      );
    case DECREASE_COUNT:
      return state.map(item => 
        item.id === action.payload ? 
        {...item, count : item.count - 1} : 
        item
      );
    default:
      return state;
  }
};

export default cart;