import axios from "axios";
import { BOARDVIEW } from "./type";

const initialState = {
  title: '',
  writer: '',
  content: '',
};

const cart = (state = initialState, action) => {
  switch (action.type) {
    case BOARDVIEW:
      
      return state;
    default:
      return state;
  }
};

export default cart;