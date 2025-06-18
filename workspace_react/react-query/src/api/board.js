import axios from 'axios';

// axios
const boardRegisterAxios = async (board) => {
  const resp = await axios.post(`/board`, board);
  if(resp.status !== 200) throw new Error("에러발생");
  const data = await resp.data;
  return data;
  
}
const boardRegisterFetch = async (board) => {
  const resp = await fetch(`/boad`, {
    body : JSON.stringify(board),
    method : 'post',
    headers : {
      'Content-type' : 'application/json; charset=utf-8'
    }
  });
  if(!resp.ok) throw new Error("에러발생");
  const data = await resp.text();
  return data
}

export default {boardRegisterAxios, boardRegisterFetch};