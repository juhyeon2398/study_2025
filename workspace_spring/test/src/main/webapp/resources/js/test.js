/**
 * 
 */

let movieList = document.querySelector(".movieList");
let str = '';

Test();
Test2();
function Test(){
	fetch(`http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=c25d536e9ebce5efed6435b10b11d021&targetDt=20250101`)
	.then(response => response.json())
	.then(data => {
		console.log(data);
		str += `<li>${data.title}</li>`;
	})
	.catch(err => console.log(err));
	
	movieList.innerHTML = str;
}
function Test2(){
	fetch(`https://api.themoviedb.org/3/movie/now_playing?api_key=94a08a3ffe784cf92f01aa40978deae5&language=ko-KR`)
	.then(response => response.json())
	.then(data => {
		console.log(data)
	})
	.catch(err => console.log(err));
}