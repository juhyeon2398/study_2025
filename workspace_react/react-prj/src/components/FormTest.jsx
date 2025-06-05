import React, { useState } from 'react';

const FormTest = () => {

   const init = {
      name : '',
      age : '',
      email : '',
      gender : '남자',
      addr : '강남',
   }

   const [user, setUser] = useState(init);
   
   const handleInputChange = (e) => {
      const {name, value} = e.target;
      setUser({
         ...user,
         [name] : value
      })
      
   }

   const handleSubmit = () => {
 
   }
   
   const handleReset = () => {
      setUser(init);
   }
   
   return (
      <div>
         <form action="#">
            <ul style={{listStyle:'none',margin:30,padding:0}}>
               <li>
                  <label htmlFor="name" style={{width:'50px',display:'block'}}>이름</label>
                  <input type="text" name="name" id="name" value={user.name} onChange={handleInputChange}/>
               </li>
               <li>
                  <label htmlFor="age" style={{width:'50px',display:'block'}}>나이</label>
                  <input type="text" name="age" id="age" value={user.age} onChange={handleInputChange}/>
               </li>
               <li>
                  <label htmlFor="email" style={{width:'50px',display:'block'}}>이메일</label>
                  <input type="text" name="email" id="email" value={user.email} onChange={handleInputChange}/>
               </li>
               <li>
                  <label style={{width:'50px',display:'block'}}>성별</label>
                  <input type="radio" name="gender" id="gender1" value={'남자'} checked={user.gender === '남자' ? true : false} onChange={handleInputChange}/><label htmlFor="gender1">남자</label>
                  <input type="radio" name="gender" id="gender2" value={'여자'} checked={user.gender === '여자' ? true : false} onChange={handleInputChange}/><label htmlFor="gender2">여자</label>
               </li>
               <li>
                  <select name="addr">
                     <option type="radio" name="addr" id="addr1" value={user.addr} checked={user.addr === '강동' ? true : false}>강동</option>
                     <option type="radio" name="addr" id="addr2" value={user.addr} checked={user.addr === '강서' ? true : false}>강서</option>
                     <option type="radio" name="addr" id="addr3" value={user.addr} checked={user.addr === '강남' ? true : false}>강남</option>
                     <option type="radio" name="addr" id="addr4" value={user.addr} checked={user.addr === '강북' ? true : false}>강북</option>
                  </select>

               </li>
               <li>
                  <button type='button' onClick={handleSubmit}>Click</button>
               </li>
               <li>
                  <button type='button' onClick={handleReset}>초기화</button>
               </li>
            </ul>
         </form>
      </div>
   );
};

export default FormTest;