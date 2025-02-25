# form
1. 사용자로부터 정보를 입력 받을 때 사용하는 태그
2. 주요속성
    * action : 정보를 받아서 어디서 처리할 것인지 처리할 장소(위치, 경로)를 지정
    * method : 정보를 전달하는 방식
        - get :	default, 정보를 header에 포함시켜서 보냄 정보가 노출됨(보안 처리가 안됨) 빠름 (ex: 검색)            
        - post : 정보를 body에 포함시켜서 보냄 정보가 보안처리됨 느림(ex:회원가입, 로그인)
        - enctype : 파일 업로드 할때 사용
# input
1. 속성
     * text - 문자를 입력받음
     * passward - 문자를 숨심처리 하여 입력받음
     * email - 메일 형식을 입력 받음
     * tel - 전화번호를 입력받음
     * number - 숫자만 입력
     * date - 날짜 입력
     * time - 시간 입력
     * file - 파일 첨부
     * range - 진행바
     * color - 색상표
     * checkbox - 체크 박스를 생성하며 중복 선택가능
     * radio - 라디오 버튼을 생성하며 중복 선택불가
     * button - 일반 버튼
     * submit - 전송 버튼
     * hidden - 숨김처리
     * reset - 입력하던 값 초기화
     * image - 이미지 주소로 생성

# JavaScript

## 변수 & 상수
    1. 선언 시 자료형을 명시하지 않는다.
    2. 저장되는 값에 의해 자료형이 결정
    3. 선언 방법
    * 키워드 변수명
    * ex) let name;
    4. 문자 + 숫자 + 특수문자 (_ , $) 조합 가능
    5. 공백 문자는 사용 X
    6. 선언하지 않은 변수도 사용할 수 있다.


## var, let, const 차이
    1. var
        * ES6 이전에 사용하던 변수
        * 변수 중복 선언 및 재 할당 가능
        * 변수 선언 전 변수를 참조하면 undefined 반환

    2. let
        * ES6 버전에서 추가
        * 변수 재 할당은 가능, 재 선언은 불가능

    3. const
        * ES6 버전에서 추가
        * 반드시 선언과 동시에 초기화가 이루어져야 함
    
## 자료형
    * 기본 자료형
    1. 숫자 - number
    2. 문자열 - string
    3. 논리형 - boolean
    4. 널 - null (숫자인지 문자인지 모름)
    5. 언디파인드 - undefined (값 자체를 모름)

    * 데이터 타입을 확인하는 법
    - typeof 데이터
    - typeof(데이터)
## 형변환
    데이터 타입들 간 형태를 변환 시켜스 처리하는 경우에 사용

    1. 문자 -> 숫자
    - Number(값)
      * 해당 값의 실수 부분까지 모두 변환
      * 값을 변환 하지 못하면 NaN 반환
    - parseInt(값)
      * 해당 값을 변환 후 정수부분만 반환
      * 특정 값에서 정수 부분만을 반환
    - parseFloat(값)
      * 해당 값을 변환 후 실수부분만 반환
      * 특정 값에서 실수 부분만을 반환
      
    2. 다른 데이터 -> 문자열
    - String(값) : 해당 값을 모두 다 문자열로 변환
    - 문자열 + 값 : 변환할 값 앞에 문자열 데이터와 '+'연산자를 이용하여 변경

    ** NaN : Not a Number 숫자아님 // 형변환시 나올수 있는 오류
## 비교 연산자
    두 값을 비교할 때에는 '==' 혹은 '===' 기호를 사용
    '==' 경우 데이터 타입을 자동 변환하여 값을 비교
    '===' 경우 값의 타입까지 비교 (오류 확률 감소);

    true는 1 false는 0 의 값을 가지며 == 비교가능
## 메시지 출력창
    js 에서 사용 할수 있는 여러 알림 창들
    
    1. alert
       * 경고 메세지를 출력하는 함수
       EX)
       window.alert("경고 메세지");
       alert("경고 메세지");
   
    2. confirm
       * 사용자에게 확인을 받는 함수
       * (확인 버튼 클릭시 true 리턴)
       EX)
       let yn = confirm("계속 진행할까요?");
       console.log(" yn : ", yn)
   
    3. prompt
       * 사용자에게 값을 입력 받는 함수
       * 입력 내용은 무조건 문자열로 반환
       * 숫자사용시 형변환 필요
       EX)
       let inputName = prompt('이름을 입력하세요');
       console.log(" inputName : ", inputName)
## 반복문
### 1. for 문
<pre>
    for(let i = 0; i < 10; i ++){
        console.log(" i : ", i)
    }
</pre>

### 2. for-of 문
- 배열의 내용을 편하게 사용하기 위한 반복문
- 배열 내의 각 인덱스 요소를 순차적으로 가져와서 사용하는 방식
<pre>
    let names = ['김','이','박','최','정'];
    for( let name of names ){
        console.log(name);
    }
</pre>
### 3. for-in 문
- 배열 사용시 인덱스를 가져와서 사용
- 객체 사용시 프로퍼티(key)를 가져와서 사용
<pre>
    const person = {
        name : '김',
        age : 20,
        address : '서울'
    }
    console.log(person);
    console.log(person.address);
    console.log(person['address']);
    console.log(Object.entries(person)); // 배열
    console.log(Object.keys(person));    // 프로퍼티 배열 형식
    console.log(Object.values(person));  // 값만 배열 형식

    for(let key in person){
        console.log(`${key} : ${person[key]}`)
    }
</pre>
## 내장객체
### 1. Date
#### getter : 날짜에서 필요한 정보 추출
	1. getFullYear()		년도(yyyy)
	2. getMonth()			월(0 ~ 11)
	3. getDate()			일(1 ~ 31)
	4. getDay()				요일번호(0:일, 1:월, ..., 6:토 )
	5. getHours()			시(0 ~ 23)
	6. getMinutes()			분(0 ~ 59)
	7. getSeconds()			초(0 ~ 59)
	8. getMilliseconds()	밀리초(0 ~ 999)
	9. getTIme()			1970년 1월 1일 기준 몇 밀리초가 지났는지 추출
	
#### setter : 날짜나 시간을 원하는 정보로 변경	
	1. setFullYear(년도)		년도(yyyy)
	2. setMonth(월)			월 (0 ~11)
	3. setDate(일)			일(1 ~ 31)
	4. setHours(시)			시(0 ~ 23)
	5. setMinutes(분)		분(0 ~ 59)
	6. setSecond(초)			초(0 ~ 59)
	7. setMillisecond(밀리초)	밀리초(0 ~ 999)
#### EX )
<pre>
let now = new Date();   // 현재 날짜 시간
console.log(now);

// 년, 월, 일, 시, 분, 초 (월은 0 ~ 11)
let date1 = new Date(2019, 8, 16, 12, 30, 50);
console.log(date1);

let date2 = new Date(2019, 10, 13);				// 년, 월, 일 
console.log(date2);

let date3 = new Date(2019, 11);					// 년, 월, 1일
console.log(date3);

let date4 = new Date( 24 * 60 * 60 * 1000 );		
// 1970년 1월 1일 기준, 괄호 안 숫자는 밀리초 (1일 :24 * 60 * 60 * 1000 밀리초)
console.log(date4);

let date5 = new Date('2019-11-15');
let y = date5.getFullYear();
let m = date5.getMonth() + 1;
let d = date5.getDate();
let resultDate = `${y}-${m}-${d}`;
console.log(resultDate);
</pre>
### 2. Math
- 수학에 관련된 여러 정보를 담고있는 객체
<pre>
console.log(`파이 : ${Math.PI} `);
console.log(`제곱 : ${Math.pow(2,3)} `);
console.log(`제곱 : ${2 ** 3} `);
console.log(`절대값 : ${Math.abs(-10)} `);
console.log(`루트 : ${Math.sqrt(4)} `);
console.log(`최대값 : ${ Math.max(1, 2, 3, 4, 5)} `);
console.log(`최소값 : ${ Math.min(1, 2, 3, 4, 5)} `);
console.log(`정수로 반올림 : ${ Math.round(123.456)} `);
console.log(`소수 1자리 남기고 반올림 : ${(Math.round(123.456 * 10) / 10)} `);
console.log(`소수 2자리 남기고 반올림 : ${(Math.round(123.456 * 100) / 100)} `);
console.log(`올림 : ${ Math.ceil(123.456)} `);
console.log(`내림 : ${ Math.floor(123.456)} `);
</pre>

### 3. Random
- 난수를 추출하는 객체
<pre>
// 0 ~ 9 사이의 난수를 1개 출력하시오.
console.log(`0 ~ 9 사이 난수 : ${Math.floor(Math.random() * 10)} `);
// 1 ~ 10 사이의 난수를 1개 출력하시오.
console.log(`1 ~ 10 사이 난수 : ${Math.floor(Math.random() * 10)+1} `);
</pre>

## 함수 Function
### 1. 함수 (function)
- 특정 기능을 수행할 수 있는 코드의 집합
- 형식
<pre>function 함수명(매게변수){
    실행코드 
    return 반환데이터;
}</pre>
### 2. 선언적 함수 (함수 선언식)
* 이름 있는 함수 (자바스크립트 영역은 두 번 읽힌다.) 
* 함수를 정의하고 , 호출하는 과정이 필요
* 정의와 호출 순서 상관 없음
* 동일한 함수를 두 개 이상 만들면 덮어쓴다.
* 자바의 오버로드 불가
<pre>
// 선언적 함수를 변수에 저장할 수 있다. 
// 변수 저장시 기존 함수명은 사용 불가능 
let view = function yourFunction(){
    console.log('yourFunction 실행');
}
view();</pre>
<pre>
// 정의된 선언적 함수를 나중에 변수에 저장할 수 있다.
function ourFunction(){
    console.log('ourFunction 실행');
}
let view2 = ourFunction;
view2();</pre>

### 3. 표현식 (함수 표현식)
* 이름이 없는 함수 (익명 함수)
* 표현식 함수는 변수에 저장한 뒤 호출

<pre>
// 1. 표현식 함수 정의 + 변수에 저장
let view1 = function(){
console.log('첫 번째 표현식 함수');
}
view1();
view2();
let view2 = function(){
console.log('두 번째 표현식 함수');
}
</pre>

### 4. 호이스팅
    < view2() 함수가 실행되지 않는 이유 >
    자바스크립트 영역은 두 번 읽히는데, 
    첫 번째로는 '선언적 함수 정의' 부분을 읽고,
    두 번째로는 나머지 부분을 순차적으로 읽어낸다. 
    ( * 호이스팅 )

    < * 호이스팅 >
    자바스크립트 함수가 실행되기 전에 함수 안에 
    필요한 변수값 들을 모두 모아서 
    유효 범위의 최상단에 선언하는 것 ( 끌어올림 )
    현재 스크립트 영역에는 선언적 함수 
    정의 부분이 없기 때문에 
    미리 view2 함수가 존재하는 지 알 수 없다. 
    ( 변수인 view2 만 존재 )
    선언적 함수 ( 함수 선언식 ) 은 호이스팅의
    영향을 받지만 표현식 함수 ( 함수 표현식 )은
    호이스팅 영향을 받지 않는다.
<pre>
function plus(){}
let minus; //변수 먼저 생성

plus();
minus(); // 변수가 먼저 생성되어 undefined 이므로 오류 발생

minus = function(){}
</pre>