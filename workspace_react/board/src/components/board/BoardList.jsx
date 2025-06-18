import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import paging from '../../util/paging';

const BoardList = () => {
  // 상태 값으로 관리할 데이터
  // 1. 게시글 리스트( boardList )
  // 2. 현재 페이지 ( curPage )
  // 3. 현재 페이지 에서 확인할 목록 개수( amount )
  // 4. 로딩 처리 ( loading )
  // 5. 검색 값 ( filter )
  const nav = useNavigate();
  const [boardList, setBoardList] = useState([]);
  const [curPage, setCurPage] = useState(1);
  const [amount, setAmount] = useState(10);
  const [loading, setLoading] = useState(true);
  const [filter, setFilter] = useState('');
  
  // 2. 게시글 목록 데이터 받기
  const getBoardList = async () => {
    const resp = await axios.get("/boardList");
    if(resp.status === 200){
      const data = resp.data;
      // 3. 게시글 목록 데이터 상태 값에 할당
      setBoardList(data);
      setLoading(false);
    }else{
      new Error('데이터 실패...')
    }
  }
  useEffect(()=>{
    getBoardList(); // 1.게시글 목록 조회 함수 호출
  },[])


  const handleMoveWritePage = () => {
    nav("/board/write");
  }

  // 페이징 및 필터 게시글 목록 계산
  // 필터링 된 데이터만 추출
  const tmpPosts = filter ? 
    boardList.filter(post => 
    post.title.toLowerCase().includes(filter.toLowerCase())):
    boardList;
  
  // 필터링 된 데이터를 한번에 보여줄 개수로 나눔
  // 현재 보여줄 글의 마지막 인덱스
  const indexOfLastPost = curPage * amount;
  // 현재 보여줄 글의 처음 인덱스
  const indexOfFirstPost = indexOfLastPost - amount;
  const filterPosts = tmpPosts.slice(indexOfFirstPost, indexOfLastPost);

  // 페이징을 만들기 위해 현재 필터링의 적용된
  // 글의 개수인지, 전체 글의 개수인지 판단
  const cnt = filter === '' ? boardList.length : tmpPosts.length;
  const obj = paging(cnt,curPage,amount);
  const {endPage, startPage, prev, next} = obj;
  // 페이지 버튼 생성
  const pageList = [];
  for (let i = startPage; i <= endPage; i++) {
    pageList.push(i);
  }

  // 페이지 번호 변경 함수
  const handleChangePageNum = (e) =>{
    const type = e.target.value;
    if(type === 'next'){
      setCurPage(parseInt(endPage) + 1)
    }else if(type === 'prev'){
      setCurPage(parseInt(startPage) - 1)
    }else{
      setCurPage(type);
    }
  }

  const handleChangeFilter = (e) =>{
    const search = e.target.value;
    setFilter(search);
    setCurPage(1);
  }
  const handleChangeAmount = (e) =>{
    const amountCnt = e.target.value;
    setAmount(amountCnt);
    setCurPage(1);
  }
  return (
    <div>
      <div>
        <button onClick={handleMoveWritePage}>글쓰기</button>
      </div>
      <input type="text" name="" id="" value={filter} placeholder='검색어 입력' onChange={handleChangeFilter}/>
      <select name="" id="" onChange={handleChangeAmount}>
        <option value="10">10</option>
        <option value="20">20</option>
      </select>
      <ul>
          {
            filterPosts.map(el => {
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
      <div>
        {
          prev && <button value='prev' onClick={handleChangePageNum}>&lt;</button>
        }
        {
          pageList.map(num => (
            <button key={num} value={num} onClick={handleChangePageNum}>{num}</button>
          ))
        }
        {
          next && <button value='next' onClick={handleChangePageNum}>&gt;</button>
        }
      </div>
    </div>
  );
};

export default BoardList;