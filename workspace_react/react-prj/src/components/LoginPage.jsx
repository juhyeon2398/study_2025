import React, { useEffect, useState } from 'react';

const LoginPage = () => {
   
   const init = {
      id : '',
      password : ''
   }
   const authInfo = {
      id : 'admin',
      password : '1234'
   }

   const [ck,setCk] = useState(false);
   const [info,setInfo] = useState(init);
   
   // 유저 정보 저장
   const handleInputChage = (e) => {
      const {name, value} = e.target;
      setInfo({
         ...info,
         [name] : value
      })
   }
   // 유저 정보 확인
   const handleLoginControl = () => {
      if(ck){
         setCk(false);
         setInfo(init);
      }else{
         (String(info.id) === String(authInfo.id) && Number(info.password) === Number(authInfo.password)) ?
         setCk(true) : (alert("정보가 일치하지 않습니다.") && setCk(false));
      }
      console.log(ck);
   }

   return (
      <div>
         {ck ? 
            <>
               안녕하세요 {info.id}님
               <button onClick={handleLoginControl}>로그아웃</button>
            </> 
            : 
            <>
               <h2>로그인페이지</h2>
               <div>
                  <label htmlFor="userId"></label><input type="text" id="userId" name="id" value={info.id} onChange={handleInputChage}/><br/>
                  <input type="password" id="userPw" name="password" value={info.password} onChange={handleInputChage}/><br/>
                  <button onClick={handleLoginControl}>로그인</button>
               </div>
            </>
         }
      </div>
   );
};

export default LoginPage;