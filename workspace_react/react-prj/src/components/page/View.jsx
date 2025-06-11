import React from 'react';
import { Outlet, useLocation, useParams } from 'react-router-dom';

const View = () => {

   // useParams();
   // REST 방식처럼 파라미터를 url에 설정하여 사용하는 방법
   // 1. const {파라미터} = useParams();
   // 2. const 변수명 = useParams().파라미터명;
   const {postid} = useParams();
   const po = useParams().postid;
   const location = useLocation();
   console.log(" location", location)

   // useLocation()
   // hash : 주소의 #문자열 뒤 값
   // pathname : 현재 주소 경로
   // search  : ?를 포함한 쿼리스트링
   // state : 페이지로 이동시 임의로 넣을 수 있는 값
   // key : location 객체의 고유값

   return (
      <div>
         <h1>View 페이지 입니다.</h1>
         <h1>{postid}번 view페이지입니다.</h1>
         <h1>{po}번 view페이지입니다.</h1>
         
         <Outlet></Outlet>
      </div>
   );
};

export default View;