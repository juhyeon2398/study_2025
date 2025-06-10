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



function App() {
  
  return (
    <div className="App">
       <InputCount/>
    </div>
  );
}

export default App;
