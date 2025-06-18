import { useQuery } from '@tanstack/react-query';
import React from 'react';

// 패칭 함수
const getPosts = async () => {
  const resp = await fetch(`https://jsonplaceholder.typicode.com/posts`);
  const result = await resp.json();
  return result;
}

// 단일데이터
const getPosts2 = async (number) => {
  const resp = await fetch(`https://jsonplaceholder.typicode.com/posts/${number}`);
  const result = await resp.json();
  return result;
}

const Example = ({number}) => {

  // const {data, isLoading, refetch} = useQuery({
  //   queryKey : ['posts'],
  //   queryFn : getPosts,
  //   staleTime : 3000,
  // });

  const {data, isLoading, refetch} = useQuery({
    queryKey : ['posts',number],
    queryFn : () => getPosts2(number),
    staleTime : 3000,
  });

  if(isLoading) return <div>로딩중</div>

  return (
    <div>
      <button onClick={refetch}>다시 불러오기</button>
      {/* <ul>
        {
          data.map(post => {
            return <li key={post.id}>{post.title}</li>
          })
        }
      </ul> */}
      {data.title}
    </div>
  );
};

export default Example;