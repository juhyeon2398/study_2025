import React, { useEffect, useState } from 'react';
import {useDispatch, useSelector} from 'react-redux';
import { decrease, increase } from '../actions/counterAction';
import { addItem, deleteItem } from '../actions/cartAction';

const Product = () => {

   // store에 접근해서 state 가져오기
   const counter = useSelector(
      state => state.counter.count
   );
   // dispatch를 사용하기 위한 준비
   const dispatch = useDispatch();
   
   // state를 변경하는 함수들
   const handleIncrease = () => {
      dispatch(increase(1));
   }
   const handleDecrease = () => {
      dispatch(decrease());
   }
   const cart = useSelector(
      state => state.cart
   );
   const handleAddItem = () => {
      const obj = {
         id : 2,
         productName : 'candy',
         price : 200
      }
      dispatch(addItem(obj));
   }
   const handleDeleteItem = () => {
      dispatch(deleteItem(2));
   }
   const init = {
      productName : '',
      price : '',
   }
   const [item, setItem] = useState(init);
   const handleItem = (e) =>{
      const {name,value} = e.target;
      setItem({
         ...item,
         [name] : value
      })
   }

   return (
      <div>
         <h1>hello Redux</h1>
         <p>{counter}</p>
         <button onClick={handleIncrease}>+</button>
         <button onClick={handleDecrease}> - </button>
         <br/>
         <br/>
         <br/>
         <br/>
         <div>
            상품명 : <input type="text" name='productName' value={item.productName} onChange={handleItem}/><br/>
            가&emsp;격 : <input type="number" name="price" value={item.price} onChange={handleItem}/>
            <button onClick={handleAddItem}>아이템 추가</button>
            <ul>
               {
                  cart.map((item,idx) => {
                     return (
                        <li key={idx}>
                           {item.productName}&emsp;
                           <button onClick={handleDeleteItem}>아이템 삭제</button>
                        </li>
                     )
                  })
               }
            </ul>
         </div>
      </div>
   );
};

export default Product; 