import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';
import BoardEdit from './BoardEdit';

const BoardDetail = () => {
 
  const [isRead, setIsRead] = useState(true);

  const { idx } = useParams("idx");
  const [board, setBoard] = useState(null);
  const getBoard = async () => {
    const resp = await axios.get(`/board/${idx}`);
    if (resp.status === 200) {
      setBoard(resp.data);
    } else {
      new Error("데이터 수신 실패...");
    }
  }
  useEffect(() => {
    getBoard();
  }, [])

  const nav = useNavigate();
  const moveToBoardList = () =>{
    nav("/board");
  }
  
  // 수정페이지
  const handleEdit = () =>{
    setIsRead(false);
  }
  const handleDelete = async () =>{
    const result = await axios.delete(`/board/${idx}`);
    const data = result.data;
    if(data === 'success'){
      alert("삭제되었습니다.");
      nav("/board");
    }else{
      alert("삭제에 실패하였습니다.");
    }
  }
  
  if (board === null) return <div>로딩중</div>;
  return (
    <>
    {
        isRead ?
        <div>
          <ul>
            <li>제목 : {board.title}</li>
            <li>내용 : {board.content}</li>
            <li>작성자 : {board.writer}</li>
            <li>등록 시간 : {board.regdate}</li>
          </ul>
          <div>
            <button onClick={handleEdit}>수정</button>
            <button onClick={handleDelete}>삭제</button>
            <button onClick={moveToBoardList}>목록이동</button>
          </div>
          
        </div> 
      :
      <BoardEdit board={board} setBoard={setBoard} setIsRead={setIsRead}/>
    }
    </>
  );
};

export default BoardDetail;