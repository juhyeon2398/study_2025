import { useMemo, useReducer, useRef, useState } from 'react';
import './App.css';
import Counter from './components/Counter';
import CounterTest from './components/CounterTest';
import ReducerTest from './components/ReducerTest';
import RefTest from './components/RefTest';
import HookTest from './components/HookTest';
import Calculator from './components/Calculator';
import Gallery from './components/Gallery';
import LoginPage from './components/LoginPage';
import ShoppingList from './components/ShoppingList';
import Timer from './components/Timer';
import InputCount from './components/InputCount';
import Parent from './components/Parent';
import Product from './components/Product';
import Header from './components/layout/Header';
import Main from './components/page/Main';
import View from './components/page/View';
import Write from './components/page/Write';
import About from './components/page/About';
import Content from './components/page/Content';
import {BrowserRouter, Route,Routes} from 'react-router-dom';


function App() {
  return (
    <div>
      <BrowserRouter>
        <Header/>
        <Routes>
          <Route path='/' element={<Main/>}/>
          <Route path='/view/:postid' element={<View/>}>
            <Route path='content' element={<Content/>}/>
            <Route path='about' element={<About/>}/>
          </Route>
          <Route path='/write' element={<Write/>}/>

          <Route path='*' element={<div>404페이지</div>}/>
        </Routes>
      </BrowserRouter>

      
    </div>
  );
}

export default App;
