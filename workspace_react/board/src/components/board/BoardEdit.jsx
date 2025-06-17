import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardEdit = ({board, setBoard, setIsRead}) => {

  const nav = useNavigate();
  const handleInput = (e) =>{
    const {name, value} = e.target;
    setBoard({
      ...board,
      [name] : value
    })
  }

  const updateBoard = async () => {

    const {title, writer, content} = board;
    if(!title || !writer || !content){
      alert("모든 내용을 입력해주세요.");
      return;
    }
    
    // 2. 빈 값 검증 방법
    // 객체 value 값을 배열로 생성
    const inputArr = Object.values(board);
    // some => or개념
    const isEmpty = inputArr.some(value => value === '');
    if(isEmpty){
      alert("모든 내용을 입력해주세요.");
      return;
    }

    const result = await axios.put("/board", board);
    const data = result.data;
    if(data === 'success'){
      alert("등록에 성공하였습니다.");
      
      nav("/board");
    }else{
      alert("등록에 실패하였습니다.")
    }
  }
 
  const resetInputs = () =>{
    setBoard(board);
  }
  const moveToBoardList = () =>{
    nav("/board");
  }
  if (board === null) return <div>로딩중</div>;
  return (
    <div>
        <div><label htmlFor="">제목</label> : <input type="text" name="title" onChange={handleInput} value={board.title}/></div>
        <div><label htmlFor="">작성자</label> : <input type="text" name="writer" onChange={handleInput} value={board.writer}/></div>
        <div><label htmlFor="">내용 : </label><textarea name="content" cols='30' rows='10' id="" onChange={handleInput} value={board.content}></textarea></div>
        <div>
          <button onClick={updateBoard}>등록</button>
          <button onClick={resetInputs}>다시 입력</button>
          <button onClick={moveToBoardList}>목록으로 이동</button>
        </div>
    </div>
  );
};

export default BoardEdit;