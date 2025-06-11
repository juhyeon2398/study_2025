import React from 'react';
import {Link, useNavigate} from 'react-router-dom';

const Main = () => {

   const nav = useNavigate();// javscript로 페이지 이동

   return (
      <div>
         <h1>Main 페이지 입니다.</h1>
         <Link to={'/view/10?search=postName&q=demo#test'}>view페이지로 이동</Link> {/*a태그처럼 활용*/}
         <button onClick={()=>nav('/write')}>write페이지로 이동</button>
      </div>
   );
};

export default Main;