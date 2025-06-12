import React from 'react';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';
import DetailHead from './DetailHead';
import DetailBody from './DetailBody';
const DetailWrapper = styled.div`
   margin : 60px auto 0;
   max-width : 1200px;
   width : 80%;
`;

const Detail = ({data}) => {
   const {pId} = useParams();
  
   // 1번 방법 - filter 배열 
   // const product = data.filter(
   //    obj => obj.id === parseInt(pId));

   // 2번 방법 - find 객체
   const product = data.find(
      obj => obj.id === parseInt(pId)
   );
   
   return (
      <DetailWrapper>
         <DetailHead data={product}/>
         <DetailBody detail={product.detail}/>
      </DetailWrapper>
   );
};

export default Detail;