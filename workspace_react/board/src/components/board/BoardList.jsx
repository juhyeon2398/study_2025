import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

const BoardList = () => {
  const [boardList, setBoardList] = useState([]);
  
  // 2. 게시글 목록 데이터 받기
  const getBoardList = async () => {
    const resp = await axios.get("/boardList");
    if(resp.status === 200){
      const data = resp.data;
      // 3. 게시글 목록 데이터 상태 값에 할당
      setBoardList(data);
    }else{
      new Error('데이터 실패...')
    }
  }
  useEffect(()=>{
    getBoardList(); // 1.게시글 목록 조회 함수 호출
  },[])

  const nav = useNavigate();

  const handleMoveWritePage = () => {
    nav("/board/write");
  }

  return (
    <div>
      <div>
        <button onClick={handleMoveWritePage}>글쓰기</button>
      </div>
      <ul>
          {
            boardList.map(el => {
              return (
                <Link key={el.idx} to={`/board/${el.idx}`}>
                  <li>
                    {el.idx}
                    {el.title}
                    {el.writer}
                    {el.regdate}
                  </li>
                </Link>
              )
            })
          }
      </ul>
    </div>
  );
};

export default BoardList;