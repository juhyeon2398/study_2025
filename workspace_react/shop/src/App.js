import { BrowserRouter } from 'react-router-dom';
import Display from './display/Display';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Display/>
      </BrowserRouter>
    </div>
  );
}

export default App;
