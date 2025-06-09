import React, { useState } from 'react';

const Gallery = () => {
   const images = [
    "https://via.placeholder.com/300",
    "https://picsum.photos/300",
    "https://placeimg.com/300/300/any",
    "https://source.unsplash.com/random/300x300",
    "https://dummyimage.com/300",
    "https://loremflickr.com/300/300",
    "https://loremflickr.com/320/240",
    "https://www.fillmurray.com/300/300",
    "https://www.placecage.com/300/300",
    "https://www.stevensegallery.com/300/300"
   ];

   
  const [idx,setIdx] = useState(0);
  const handleImage = (e) => {
      e.target.name === 'prev' ? 
      (idx === 0 ? setIdx(images.length - 1) : setIdx(idx - 1)) : 
      (idx === (images.length - 1) ? setIdx(0) : setIdx(idx + 1))
  }
   return (
      <>
         <p>{idx + 1}번째 사진</p>
         <div style={{display:'flex',alignItems:'flex-start'}}>
            <button name="prev" onClick={handleImage}>이전</button>
            <img src={images[idx]} alt="" />
            <button name="next" onClick={handleImage}>다음</button>
         </div>
      </>
   );
};

export default Gallery;