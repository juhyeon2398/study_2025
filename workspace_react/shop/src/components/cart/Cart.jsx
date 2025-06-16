import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import { decreaseCount, deleteItem, increaseCount } from '../../actions/cartAction';

const CartWrapper = styled.div`
  max-width : 80%;
  margin : auto; 
  table {
    width : 100%;
  }
  td {
    text-align : center;
  }
`;

const Cart = () => {
  const cart = useSelector(state => state.cart);
  const dispatch = useDispatch();

  const handleInCrease = (id) =>{
    dispatch(increaseCount(id));
  }
  const handleDeCrease = (id) =>{
    dispatch(decreaseCount(id));
  }
  const handleItemDelete = (id) =>{
    dispatch(deleteItem(id));
  }
  return (
    <CartWrapper>
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>상품이름</th>
            <th>수량</th>
            <th>가격</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
            {
              cart.map(item => {
                console.log(item);
                return (
                  <tr key={item.id}>
                    <td>{item.id}</td>
                    <td>{item.productName}</td>
                    <td>
                      <button onClick={()=> handleInCrease(item.id)}>+</button>
                      {item.count}
                      <button disabled={item.count === 1} onClick={()=> handleDeCrease(item.id)}>-</button>
                    </td>
                    <td>{item.price}</td>
                    <td><button onClick={()=> handleItemDelete(item.id)}>삭제</button></td>
                  </tr>
                )
              })

            }
        </tbody>

      </table>
    </CartWrapper>
  );
};

export default Cart;