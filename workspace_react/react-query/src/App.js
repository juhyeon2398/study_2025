import './App.css';
import BoardRegister from './components/BoardRegister';
import Example from './components/Example';
import InfiniteExample from './components/InfiniteExample';
import InfiniteScrollExample from './components/InfiniteScrollExample';
import PostListExample from './components/PostListExample';

function App() {
  return (
    <div className="App">
      {/* <Example number={1}/>
      <Example number={2}/>
      <PostListExample/> */}
      <InfiniteScrollExample/>
    </div>
  );
}

export default App;
