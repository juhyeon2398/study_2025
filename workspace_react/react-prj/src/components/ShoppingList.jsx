import React, { useEffect, useRef, useState } from 'react';

const ShoppingList = () => {
   const init = {
      name : '',
      cnt : ''
   }
   const [info, setInfo] = useState(init);
   const [items,setItems] = useState([]);
   const ref = useRef([]);

   const handleInfo = (e) =>{
      const {name,value} = e.target;
      setInfo({
         ...info,
         [name] : value
      })
   }
   const handleAddItem = () => {
      if(info.name !== '' && info.cnt !== ''){
         if(!chkItem(info)){
            if(/\d/.test(info.name)){
               alert("문자만 입력해주세요.");
            }else{
               setItems([...items, info]);   // 신규 배열 추가
            }
         }else{
            alert("동일한 상품이 등록되어있습니다.");
         }
         setInfo(init);  // input 초기화
      }else{
         alert("상품정보를 입력해주세요.");
      }
   }
   const handleDeleteItem = (key) => {
      const newList = items.filter((item,idx) => idx !== key); // 삭제된 item 필터링
      setItems(newList);
   }

   const handleItemCnt = (e, key) => {
      const {name, value} = e.target;
      const newList = items.map((item,idx) => {
         if(idx === key){
            return {...item, [name] : value}
         }
      })
      setItems(newList);
   }

   // 동일 상품 체크
   function chkItem(info){
      let result = false;
      let target = info.name.replaceAll(" ",'');
      items.map(item => {
         if(item.name.replaceAll(" ",'') === target){
            result = true;
         }
      })
      return result;
   }

   return (
      <div>
         <div className="">
            <input type="text" name="name" value={info.name} placeholder='상품 이름' onChange={handleInfo}/>
            <input type="number" name="cnt" value={info.cnt} placeholder='수량' onChange={handleInfo}/>
            <button onClick={handleAddItem}>추가</button>
         </div>
         <ul className='item-list'>
            {items.map((item,idx) => {
               return (
                  <li key={idx}>
                     <label htmlFor="">{item.name} : </label><input type='number' name="cnt" value={item.cnt} onChange={(e) => handleItemCnt(e, idx)}/>
                     <button onClick={() => handleDeleteItem(idx)}>삭제</button>
                  </li>
               )
            })}
         </ul>
      </div>
   );
};

export default ShoppingList;