import './App.css';
import Display from './display/Display';
import {BrowserRouter} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Display />
      </BrowserRouter>
    </div>
  );
}

export default App;
