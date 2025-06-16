<!-- react-router-dom 설치 -->
# react-router-dom 설치
### 1. npm install react-router-dom

# proxy
- '/api' -> /api 로 요청하는것에 대해서만 변경
// 허용을 할 요청 주소 CORS 처리
- @CrossOrigin(origins = "*"
# axios

# redux
1. install
```bash
npm install redux react-redux
```
2. 상태값 확인
- Redux DevTools 설치
  ```js
  // store 변경
  const store = createStore(
      rootReducer,
      window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
  );
  ``` 
- 정보를 devtool에서 확인가능
