import React from 'react';
import Header from '../layout/Header';
import Main from '../layout/Main';
import BoardList from '../components/board/BoardList';
import { Route, Router, Routes } from 'react-router-dom';
import BoardDetail from '../components/board/BoardDetail';
import BoardWrite from '../components/board/BoardWrite';
import BoardEdit from '../components/board/BoardEdit';

const Display = () => {
  const myStyle = {
    margin : "50px",
    padding : "50px",
  }

  return (
    <div style={myStyle}>
      <Header/>
      <Routes>
        <Route path='/' element={<Main/>}></Route>
        <Route path='/board' element={<BoardList/>}></Route>
        <Route path='/board/:idx' element={<BoardDetail/>}></Route>
        <Route path='/board/write' element={<BoardWrite/>}></Route>
        {/* <Route path='/board/edit/:idx' element={<BoardEdit/>}></Route> */}
      </Routes>
    </div>
  );
};

export default Display;