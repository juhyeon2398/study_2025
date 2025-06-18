import { useQuery } from '@tanstack/react-query';
import React from 'react';

const getPosts = async () => {
  const resp = await fetch(`https://jsonplaceholder.typicode.com/posts`);
  const result = await resp.json();
  return result;
}
const PostListExample = () => {
  const { data, isLoading, refetch } = useQuery({
    queryKey: ['posts'],
    queryFn: getPosts,
    // initialData : [{
    //   id : 1,
    //   title : '데이터가 없습니다.'
    // }]
    // select : data => data.map(post => post.title),
    // staleTime : 1000 * 60 * 5 // 5분동안 fresh
    gcTime : 1000 * 60 * 10, // 10분동안 메모리에 유지
  });

  const { 
      data : postData, 
      isLoading : isPostLoding, 
      refetch: userRefetch } = useQuery({
    queryKey: ['users'],
    queryFn: getPosts,
  });
  if (isLoading) return <div>로딩중</div>
  console.log(data);
  
  return (
    <div>
      <ul>
        {
          data.map((post,idx) => {
            return <li key={post.id}>{post.title}</li>
          })
        }
      </ul>
    </div>
  );
};

export default PostListExample;