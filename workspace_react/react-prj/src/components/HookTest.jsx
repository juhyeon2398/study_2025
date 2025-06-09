import React, { useState } from 'react';

function useInput(initialValue){
   const [value,setValue] = useState(initialValue);
   const handleChange = (e) =>{
      
   }
   return (
      {
         value : value,
         onChange : handleChange()
      }
   )
}

const HookTest = () => {

   const firstName = useInput('');
   const lastName = useInput('');
   console.log(" HookTest  :  firstName : ", firstName)
   console.log(" HookTest  :  lastName : ", lastName)

   return (
      <div>
         <input type="text" {...firstName}/><br/>
         <input type="text" {...lastName} />
         <p>Full Name : {firstName.value} {lastName.value}</p>
      </div>
   );
};

export default HookTest;