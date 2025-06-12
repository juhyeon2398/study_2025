import React, { useEffect, useRef, useState } from 'react';
import styled from 'styled-components';
import Product from './Product';

const ProductGrid = styled.div`
  max-width: 70%;
  margin-right: auto;
  margin-left: auto;
  display: grid;
  gap:10px 20px;
  grid-template-rows: 1fr;
  grid-template-columns: 1fr 1fr 1fr;
`;

const ProductList = ({data}) => {
   const init = data.filter((item,idx) => idx < 3);
   const [pageCnt, setPageCnt] = useState(1);
   const [displayArr, setDisplayArr] = useState(init);
   const handlePageCnt = () => {
      setPageCnt(prev => prev + 1);
   }
   const ref = useRef();
   useEffect(() => {
      const newData = data.filter((item,idx) => idx < (3*pageCnt));
      setDisplayArr(newData);
      if(data.length !== 0 && 3*pageCnt > data.length && data.length%3 !== 0){
         ref.current.style.display = 'none';
      }
   },[data, pageCnt])

   
   return (
      <>
         <ProductGrid>
            {
               displayArr.map((item,idx) => {
                  return <Product key={item.id} data={item}/>
               })
            }
         </ProductGrid>
         <button style={{padding:'30px',width:'500px',margin:'0 auto 50px',display:'block'}} ref={ref} onClick={handlePageCnt}>더보기 {pageCnt}</button>
      </>
   );
};

export default ProductList;