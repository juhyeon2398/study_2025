import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const BoardWrite = () => {

  const init = {
    title : '',
    writer : '',
    content : '',
  }
  const [inputs, setInputs] = useState(init);
  

  const nav = useNavigate();
  const handleInput = (e) =>{
    const {name, value} = e.target;
    setInputs({
      ...inputs,
      [name] : value
    })
  }

  const registerBoard = async () => {

    const {title, writer, content} = inputs;
    if(!title || !writer || !content){
      alert("모든 내용을 입력해주세요.");
      return;
    }
    
    // 2. 빈 값 검증 방법
    // 객체 value 값을 배열로 생성
    const inputArr = Object.values(inputs);
    // some => or개념
    const isEmpty = inputArr.some(value => value === '');
    if(isEmpty){
      alert("모든 내용을 입력해주세요.");
      return;
    }

    const result = await axios.post("/board", inputs);
    const data = result.data;
    if(data === 'success'){
      alert("등록에 성공하였습니다.");
      nav("/board");
    }else{
      alert("등록에 실패하였습니다.")
    }
  }
 
  const resetInputs = () =>{
    setInputs(init);
  }
  const moveToBoardList = () =>{
    nav("/board");
  }

  return (
    <div>
        <div><label htmlFor="">제목</label> : <input type="text" name="title" onChange={handleInput} value={inputs.title}/></div>
        <div><label htmlFor="">작성자</label> : <input type="text" name="writer" onChange={handleInput} value={inputs.writer}/></div>
        <div><label htmlFor="">내용 : </label><textarea name="content" cols='30' rows='10' id="" onChange={handleInput} value={inputs.content}></textarea></div>
        <div>
          <button onClick={registerBoard}>등록</button>
          <button onClick={resetInputs}>다시 입력</button>
          <button onClick={moveToBoardList}>목록으로 이동</button>
        </div>
    </div>
  );
};

export default BoardWrite;