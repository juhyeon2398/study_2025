### HTML 폼과 JavaScript 기초 예시

#### **HTML 폼 (Form)**

1. **사용자 입력 받기 위한 태그**: 폼은 사용자로부터 데이터를 입력받기 위해 사용됩니다.
2. **주요 속성**:
    - **action**: 정보를 처리할 경로(서버 주소).
    - **method**: 데이터 전송 방식.
        - **get**: URL을 통해 데이터를 전송 (정보 노출).
        - **post**: HTTP 본문을 통해 데이터를 전송 (보안 처리됨).
        - **enctype**: 파일 업로드 시 사용.

#### **Input 태그 속성 예시**

- `text`: 문자를 입력받는 필드.
- `password`: 비밀번호를 입력받는 필드.
- `email`: 이메일을 입력받는 필드.
- `tel`: 전화번호를 입력받는 필드.
- `number`: 숫자만 입력받는 필드.
- `date`: 날짜 입력 필드.
- `time`: 시간 입력 필드.
- `file`: 파일 업로드 필드.
- `range`: 진행 상태를 나타내는 슬라이드 바.
- `color`: 색상 선택 필드.
- `checkbox`: 여러 개 선택 가능한 체크 박스.
- `radio`: 하나만 선택 가능한 라디오 버튼.
- `button`: 일반 버튼.
- `submit`: 폼 제출 버튼.
- `hidden`: 화면에 보이지 않는 숨김 처리된 필드.
- `reset`: 입력 값을 초기화하는 버튼.
- `image`: 이미지가 들어간 버튼.

---

#### **JavaScript 기초**

##### **변수와 상수**
- 자바스크립트에서는 자료형을 명시하지 않으며, 변수의 자료형은 값에 따라 자동으로 결정됩니다.
- 변수는 `let`, `var`, `const` 키워드를 사용하여 선언합니다.

##### **var, let, const 차이**

1. **var**: ES6 이전에 사용된 변수 선언. 중복 선언 및 재할당 가능.
2. **let**: ES6에서 추가된 변수 선언 방법. 재할당은 가능하나 중복 선언 불가.
3. **const**: 상수 선언. 반드시 초기화가 이루어져야 하며, 재할당 불가.

---

##### **자료형**

- **숫자**: `number`
- **문자열**: `string`
- **논리형**: `boolean`
- **널**: `null`
- **언디파인드**: `undefined`

**형변환 예시**:
1. **문자 -> 숫자**: `Number()`, `parseInt()`, `parseFloat()`
2. **숫자/문자 -> 문자열**: `String()`, `+` 연산자.

---

##### **비교 연산자**
- `==`은 타입을 변환하여 비교, `===`는 타입과 값을 모두 비교.
- `true`는 1, `false`는 0.

---

##### **메시지 출력창**

1. **alert**: 경고 메시지 출력
    ```javascript
    alert("경고 메시지");
    ```
2. **confirm**: 확인 메시지 출력, 사용자가 확인을 클릭하면 `true`, 취소를 클릭하면 `false` 반환.
    ```javascript
    let yn = confirm("계속 진행할까요?");
    console.log(yn);
    ```
3. **prompt**: 사용자 입력 받기, 반환값은 문자열.
    ```javascript
    let inputName = prompt('이름을 입력하세요');
    console.log(inputName);
    ```

---

##### **반복문**

1. **for문**:
    ```javascript
    for(let i = 0; i < 10; i++) {
        console.log(i);  // i 값 출력
    }
    ```

2. **for-of문**:
    배열의 값을 반복할 때 사용.
    ```javascript
    let names = ['김', '이', '박', '최', '정'];
    for (let name of names) {
        console.log(name);  // 이름 출력
    }
    ```

3. **for-in문**:
    객체나 배열의 인덱스를 반복.
    ```javascript
    const person = { name: '김', age: 20, address: '서울' };
    for (let key in person) {
        console.log(`${key}: ${person[key]}`);
    }
    ```

---

##### **내장객체**

**내장객체: Date 객체**

JavaScript의 `Date` 객체는 날짜와 시간을 다루는 데 사용되는 내장 객체로, 다양한 메서드를 통해 날짜 및 시간 정보를 생성하고 조작할 수 있습니다.

**1. 객체 생성하기**

- **현재 날짜와 시간 생성**:
  
```javascript
  let now = new Date();
  console.log(now);  // 현재 날짜와 시간 출력
  ```


- **특정 날짜와 시간 생성**:
  
```javascript
  // 월은 0부터 시작하므로 0은 1월을 의미합니다.
  let specificDate = new Date(2025, 1, 26, 17, 48, 12);
  console.log(specificDate);  // 2025년 2월 26일 17시 48분 12초 출력
  ```


**2. Getter 메서드**

- **getFullYear()**:
  
```javascript
  console.log(now.getFullYear());  // 현재 연도 출력
  ```


- **getMonth()**:
  
```javascript
  console.log(now.getMonth());  // 현재 월 (0~11) 출력
  ```


- **getDate()**:
  
```javascript
  console.log(now.getDate());  // 현재 일 출력
  ```


- **getDay()**:
  
```javascript
  console.log(now.getDay());  // 현재 요일 (0:일요일, 1:월요일, ..., 6:토요일) 출력
  ```


- **getHours()**:
  
```javascript
  console.log(now.getHours());  // 현재 시 (0~23) 출력
  ```


- **getMinutes()**:
  
```javascript
  console.log(now.getMinutes());  // 현재 분 출력
  ```


- **getSeconds()**:
  
```javascript
  console.log(now.getSeconds());  // 현재 초 출력
  ```


- **getMilliseconds()**:
  
```javascript
  console.log(now.getMilliseconds());  // 현재 밀리초 출력
  ```


- **getTime()**:
  
```javascript
  console.log(now.getTime());  // 1970년 1월 1일 00:00:00 UTC부터의 밀리초 경과 시간 출력
  ```


**3. Setter 메서드**

- **setFullYear(year)**:
  
```javascript
  now.setFullYear(2025);
  console.log(now.getFullYear());  // 2025 출력
  ```

- **setMonth(month)**:
```javascript
  now.setMonth(1);  // 2월로 설정 (0:1월, 1:2월, ..., 11:12월)
  console.log(now.getMonth());  // 1 출력
  ```

- **setDate(date)**:
```javascript
  now.setDate(15);
  console.log(now.getDate());  // 15 출력
  ```

- **setHours(hours)**:
```javascript
  now.setHours(10);
  console.log(now.getHours());  // 10 출력
  ```

- **setMinutes(minutes)**:
```javascript
  now.setMinutes(30);
  console.log(now.getMinutes());  // 30 출력
  ```

- **setSeconds(seconds)**:
```javascript
  now.setSeconds(45);
  console.log(now.getSeconds());  // 45 출력
  ```
- **setMilliseconds(milliseconds)**:
  
```javascript
  now.setMilliseconds(500);
  console.log(now.getMilliseconds());  // 500 출력
  ```

2. **Math 객체**:
    수학적 함수 제공.
    ```javascript
    console.log(Math.PI);  // 파이 값 출력
    console.log(Math.sqrt(4));  // 제곱근 출력
    ```

3. **Random 객체**:
    난수 생성.
    ```javascript
    console.log(Math.floor(Math.random() * 10));  // 0~9 사이의 난수
    ```

---

##### **함수 Function**

1. **함수 선언**:
    ```javascript
    function add(a, b) {
        return a + b;
    }
    console.log(add(2, 3));  // 5
    ```

2. **함수 표현식**:
    함수는 변수에 저장 가능.
    ```javascript
    let subtract = function(a, b) {
        return a - b;
    };
    console.log(subtract(5, 3));  // 2
    ```

3. **호이스팅**:
    함수 선언식은 호이스팅되어 위로 올라가지만, 함수 표현식은 그렇지 않음.

---

##### **배열 예시**

```javascript
let arr = [1, 2, 3, 4, 5];  // 숫자 배열
let arr2 = ["apple", "banana", "cherry"];  // 문자열 배열
let arr3 = [10, "Hello", true, null];  // 다양한 자료형을 포함한 배열
```

---

##### **배열 내장 함수 예시**

1. **push()**: 배열의 끝에 값 추가.
    ```javascript
    arr.push(6);  // [1, 2, 3, 6]
    ```

2. **pop()**: 배열의 마지막 값 제거.
    ```javascript
    arr.pop();  // 4 (삭제된 값)
    ```

3. **shift()**: 배열의 첫 번째 값 제거.
    ```javascript
    arr.shift();  // 1 (삭제된 값)
    ```

4. **forEach()**: 배열의 각 요소를 순차적으로 실행.
    ```javascript
    arr.forEach(item => console.log(item));
    ```

5. **map()**: 배열의 각 요소를 변형한 새 배열 생성.
    ```javascript
    let doubled = arr.map(i => i * 2);  // [2, 4, 6]
    ```

6. **filter()**: 조건을 만족하는 요소만 필터링.
    ```javascript
    let evenNumbers = arr.filter(i => i % 2 === 0);  // [2, 4]
    ```

7. **sort()**: 배열의 요소를 정렬.
    ```javascript
    arr.sort((a, b) => a - b);  // 오름차순 정렬
    ```

8. **concat()**: 여러 배열을 합침.
    ```javascript
    let arr1 = [1, 2];
    let arr2 = [3, 4];
    let result = arr1.concat(arr2);  // [1, 2, 3, 4]
    ```

이 예시들을 통해 HTML 폼과 자바스크립트 기초에 대해 이해할 수 있습니다.

9. **`join()`**: 배열의 요소들을 특정 구분자로 합쳐 문자열로 반환합니다.

```javascript
let arr = [1, 2, 3, 4, 5];
console.log(arr.join('-'));  // "1-2-3-4-5"
console.log(arr.join('/'));  // "1/2/3/4/5"
console.log(arr.join(' '));  // "1 2 3 4 5"
```

10. **`every()`**: 배열의 모든 요소가 조건을 만족하는지 확인합니다.

```javascript
let arr = [2, 4, 6];
let result = arr.every(i => i % 2 === 0);
console.log(result);  // true
```

11. **`some()`**: 배열의 일부 요소라도 조건을 만족하는지 확인합니다.

```javascript
let arr = [1, 2, 3];
let result = arr.some(i => i > 2);
console.log(result);  // true
```

### 객체 생성 방법
객체는 `{}`로 감싸고, 그 안에 속성 (키)과 값 (value)을 콜론(`:`)으로 구분하여 작성합니다. 여러 개의 속성은 쉼표(`,`)로 구분합니다.

```javascript
let person = { name: '김씨', age: 30, job: '배우' };
```

### 속성 접근 방법

#### 1. **마침표 표기법 (Dot Notation)**
속성의 이름을 직접 사용하여 접근합니다. 마침표 표기법은 간단하고 가독성이 좋습니다.

```javascript
console.log(person.name);  // "김씨"
console.log(person.age);   // 30
```

#### 2. **대괄호 표기법 (Bracket Notation)**
대괄호 표기법은 속성 이름을 문자열로 사용해야 할 때 유용합니다. 또한, 변수로 속성 이름을 다룰 때 사용됩니다.

```javascript
console.log(person['name']);  // "김씨"
console.log(person['age']);   // 30
```

대괄호 표기법은 마침표 표기법과 달리 변수나 동적으로 생성된 속성 이름을 사용할 때 매우 유용합니다.

```javascript
let prop = 'job';
console.log(person[prop]);  // "배우"
```
- - - - - - -

### 객체 생성과 활용 예시

#### 1. **일반 방식 (기존 방식)**

```javascript
const person1 = { name: '김씨', age: 30, job: '배우' };
const person2 = { name: '박씨', age: 40, job: '개발자' };

function printInfo(info) {
    const str = `${info.name}의 나이는 ${info.age}살이고 직업은 ${info.job}`;
    console.log("printInfo str : ", str);
}

printInfo(person1);
```

#### 2. **비구조화 할당 (객체 구조 분해)**

객체 구조 분해(Destructuring)는 객체에서 값을 추출하여 변수에 바로 할당하는 방법입니다.

```javascript
function printInfo2(info) {
    const { name, age, job } = info;
    const str = `${name}의 나이는 ${age}살이고 직업은 ${job}`;
    console.log("printInfo2 str : ", str);
}

printInfo2(person2);
```

#### 3. **`typeof`를 이용한 타입 확인**

```javascript
function printInfo3(info) {
    const { name, age, job } = info;
    console.log("printInfo3 typeof job : ", typeof job); // "string"
    const str = `${name}의 나이는 ${age}살이고 직업은 ${job}`;
    console.log("printInfo3 str : ", str);
}

printInfo3(person2);
```

### 객체에 프로퍼티 추가, 수정, 삭제

#### 1. **객체 생성**

```javascript
let book = {
    title: '백설공주',
    price: 30000,
    stock: 10
};
```

#### 2. **프로퍼티 수정**

객체의 속성 값을 수정하려면, 마침표 표기법이나 대괄호 표기법을 사용하여 수정할 수 있습니다.

```javascript
book.price = 35000;
```

#### 3. **프로퍼티 추가**

새로운 속성을 객체에 추가할 때도 마찬가지로 마침표 표기법이나 대괄호 표기법을 사용할 수 있습니다.

```javascript
book.salePrice = book.price * 0.9;  // salePrice 추가
console.log(book);  // salePrice 속성이 추가됨
```

#### 4. **프로퍼티 제거**

속성을 삭제하려면 `delete` 키워드를 사용합니다.

```javascript
delete book.stock;  // stock 속성 제거
console.log(book);   // stock 속성이 삭제됨
```

### `.표기법` vs `[] 표기법`

- **`.표기법`**: 변수나 동적인 값을 사용할 수 없고, 직접 정의된 속성에만 접근 가능합니다.
- **`[] 표기법`**: 변수나 동적인 속성 이름을 사용할 수 있습니다.

```javascript
let book = {
    title: '백설공주',
    price: 30000,
    stock: 10
};

let prop = 'title';  // 변수 사용
console.log(book[prop]);  // "백설공주"
```

### 객체를 `for...in` 루프로 순회하기

객체의 속성을 순회할 때는 `for...in` 루프를 사용합니다. 이 방식은 객체의 속성 이름을 반복해서 가져옵니다.

```javascript
for (let key in book) {
    console.log(`${key} : ${book[key]}`);
}
```

이 코드에서는 `key`가 객체의 속성 이름을 차례대로 가져오고, `book[key]`를 통해 그 값을 출력합니다.

### 생성자 함수

생성자 함수는 객체를 생성하는 함수로, 객체를 동적으로 생성하여 각각 다른 값으로 초기화할 때 사용됩니다. 생성자 함수는 `new` 키워드와 함께 호출되며, 객체를 생성하고 초기화하는 역할을 합니다.

#### 1. **생성자 함수 정의**

생성자 함수는 일반적으로 첫 글자가 대문자로 시작하는 것이 관례입니다. 생성자 함수 내부에서는 `this`를 사용하여 객체의 속성(프로퍼티)을 정의합니다.

```javascript
function Person(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
}
```

#### 2. **생성자를 이용하여 객체 2개 생성**

`new` 키워드를 사용하여 생성자 함수를 호출하면, 그 함수는 새로운 객체를 생성하고, 그 객체의 `this`가 해당 객체를 가리키게 됩니다.

```javascript
let person1 = new Person('김씨', 20, '남');
let person2 = new Person('이씨', 30, '여');

console.log("person1 : ", person1);
console.log("person2 : ", person2);
```

#### 출력

```javascript
person1 :  Person { name: '김씨', age: 20, gender: '남' }
person2 :  Person { name: '이씨', age: 30, gender: '여' }
```

### 생성자 함수의 작동 원리

1. `new Person()` 호출 시:
    - 새로운 빈 객체가 생성됩니다.
    - `this`는 그 빈 객체를 가리킵니다.
    - 생성자 함수 내에서 `this.name`, `this.age`, `this.gender`와 같이 객체의 속성이 설정됩니다.
    - 함수가 끝나면, 생성된 객체가 반환됩니다.

### 생성자 함수 활용

생성자 함수는 객체를 동적으로 생성할 때 유용하며, 여러 개의 객체를 동일한 구조로 생성할 때 사용됩니다. 이를 통해 코드의 재사용성과 효율성을 높일 수 있습니다.

### 추가 예시: 메소드 추가

생성자 함수 내부에서 메소드를 추가할 수도 있습니다.

```javascript
function Person(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    
    // 메소드 추가
    this.sayHello = function() {
        console.log(`안녕하세요, 제 이름은 ${this.name}입니다.`);
    };
}

let person1 = new Person('김씨', 20, '남');
person1.sayHello();  // "안녕하세요, 제 이름은 김씨입니다."
```

### 클래스 ( Class )
1. 객체 지향 프로그램에서 특정 객체를 생성하기 위해 필드와 메소드를 정의해 놓은 틀
2. 독적으로 여러 객체를 생성한는 것이 목적
3. 클래스 작성 시 이름은 대문자로 시작하며, 앞에 class 키워드를 사용한다.
```javascript
class Person {
    constructor(name) {
        this.name = name;
    }
    print() {
        console.log(`이름은 ${this.name}입니다.`);
    }
}
let kim = new Person('김씨');
kim.print();

class Human {
    constructor(age) {
        this._age = age;
    }
    set name(name) {
        if (name) {
            this._name = name; 
        }
    }
    get name() {
        return this._name.toUpperCase(); 
        // this.name 으로 호출할 경우 매개변수와 동일하여 
        // 오류를 발생하므로 '_' 등을 붙여 차이를 둔다.
    }
}

let lee = new Human();
lee.name ='lee';
console.log(" lee.name : ", lee.name)
```
# 생성자 함수와 프로토타입

자바스크립트에서 생성자 함수와 프로토타입을 활용하면 객체 지향 프로그래밍의 개념을 구현할 수 있습니다. 생성자 함수는 객체를 생성하는 데 사용되며, 프로토타입은 객체 간에 메서드를 공유하여 메모리 사용을 최적화하는 데 도움을 줍니다.

## 1. 생성자 함수 (프로토타입 미사용)

생성자 함수 내부에서 메서드를 정의하면 각 객체마다 해당 메서드가 중복 생성되어 메모리 낭비가 발생합니다.

```javascript
function Student(name, kor, mat, eng) {
    this.name = name;
    this.kor = kor;
    this.mat = mat;
    this.eng = eng;
    this.getAverage = function() {
        return (this.kor + this.mat + this.eng) / 3;
    };
    this.info = function() {
        console.log(`${this.name}의 평균점수 : ${this.getAverage()}`);
    };
}

let student1 = new Student('김씨', 30, 60, 80);
let student2 = new Student('박씨', 60, 30, 20);

student1.info();
student2.info();
```

위 코드에서 `getAverage`와 `info` 메서드는 각 객체마다 중복 생성되어 메모리 사용이 비효율적입니다.

## 2. 생성자 함수 (프로토타입 사용)

프로토타입을 사용하면 메서드를 한 번만 정의하고 모든 인스턴스가 이를 공유하게 되어 메모리 사용을 최적화할 수 있습니다.

```javascript
function Student(name, kor, mat, eng) {
    this.name = name;
    this.kor = kor;
    this.mat = mat;
    this.eng = eng;
}

Student.prototype.getAverage = function() {
    return (this.kor + this.mat + this.eng) / 3;
};

Student.prototype.info = function() {
    console.log(`${this.name}의 평균점수 : ${this.getAverage()}`);
};

let student1 = new Student('김씨', 30, 60, 80);
let student2 = new Student('박씨', 60, 30, 20);

student1.info();
student2.info();
```

이렇게 하면 `getAverage`와 `info` 메서드는 `Student` 생성자 함수의 프로토타입에 정의되어 모든 인스턴스가 이를 공유하게 됩니다.

## 3. 생성자 함수 외부에서 동적으로 프로토타입의 프로퍼티 추가

생성자 함수 외부에서 프로토타입에 메서드를 추가할 수도 있습니다.

```javascript
function Student(name, kor, mat, eng) {
    this.name = name;
    this.kor = kor;
    this.mat = mat;
    this.eng = eng;
}

Student.prototype.getAverage = function() {
    return (this.kor + this.mat + this.eng) / 3;
};

Student.prototype.info = function() {
    console.log(`${this.name}의 평균점수 : ${this.getAverage()}`);
};

let student1 = new Student('김씨', 30, 60, 80);
let student2 = new Student('박씨', 60, 30, 20);

student1.info();
student2.info();
```

위 코드에서 `getAverage`와 `info` 메서드는 생성자 함수 외부에서 프로토타입에 추가되었습니다.

# BOM (Browser Object Model)

BOM은 브라우저의 기능들을 제어할 수 있는 객체 모델로, 다양한 객체를 통해 브라우저의 기능에 접근할 수 있습니다.

## 1. window

- **브라우저의 최상위 객체**로, 모든 전역 객체, 함수, 변수 등이 자동으로 `window` 객체에 속합니다.
- `window` 생략 가능: `window.alert()` → `alert()`

```javascript
// 새 창 열기
window.open('https://example.com', 'newWindow', 'width=400,height=300');
```

## 2. history

- **브라우저의 방문 기록을 제어하는 객체**로, `history.back()`, `history.forward()`, `history.go()` 메서드를 통해 이전 페이지로 이동하거나 앞으로 이동할 수 있습니다.

```javascript
// 뒤로가기
history.back();
// 앞으로가기
history.forward();
// 이전 페이지로 가기
history.go(-1);
// 전 전 페이지로 가기
history.go(-2);
```

## 3. screen

- **현재 화면에 대한 정보를 제공하는 객체**로, `screen.width`, `screen.height`, `screen.availWidth`, `screen.availHeight` 등의 프로퍼티를 통해 화면의 크기와 사용 가능한 영역을 알 수 있습니다.

```javascript
// 화면 가로 크기
console.log(screen.width);
// 화면 세로 크기
console.log(screen.height);
// 화면 가로크기 (스크롤 제외)
console.log(screen.availWidth);
// 화면 세로크기 (작업표시줄 제외)
console.log(screen.availHeight);
```

## 4. location

- **문서의 주소와 관련된 객체**로, `location.href`, `location.hostname`, `location.pathname` 등을 통해 현재 페이지의 URL 정보를 얻을 수 있습니다.

```javascript
// 페이지 이동 수단으로도 사용
console.log(location.href);
// 현재 실행되는 파일의 주소
console.log(location.hostname);
// 현재 실행되는 파일의 디폴트 경로
console.log(location.pathname);
```

- **히스토리를 이용한 화면 이동**
  - 히스토리 남기고 이동: `location.assign('경로')`
  - 히스토리 남기지 않고 이동: `location.replace('경로')`

## 5. document

- **현재 문서에 대한 정보를 담고 있는 객체**로, DOM을 통해 HTML 요소를 동적으로 제어할 수 있습니다.

```javascript
// 문서의 제목 변경
document.title = '새로운 제목';
// 특정 ID를 가진 요소 선택
let element = document.getElementById('elementId');
// 새로운 요소 생성
let newElement = document.createElement('div');
// 요소 추가
document.body.appendChild(newElement);
```
자바스크립트에서 폼(Form) 요소에 접근하는 방법은 여러 가지가 있습니다. 주로 `id`, `class`, `name` 속성을 활용하여 폼과 그 내부 요소에 접근합니다.

### 1. `id` 속성으로 접근

`id` 속성은 문서 내에서 유일해야 하므로, 특정 요소를 정확하게 식별할 수 있습니다.

```html
<form id="myForm">
    <input type="text" id="username" name="username">
    <input type="password" id="password" name="password">
    <button type="submit">로그인</button>
</form>
```

```javascript
// 폼 요소에 접근
const form = document.getElementById('myForm');

// 내부 입력 요소에 접근
const username = document.getElementById('username');
const password = document.getElementById('password');
```

### 2. `class` 속성으로 접근

`class` 속성은 여러 요소에 동일하게 적용할 수 있어, 여러 요소를 한 번에 선택할 때 유용합니다.

```html
<form>
    <input type="text" class="input-field" name="username">
    <input type="password" class="input-field" name="password">
    <button type="submit">로그인</button>
</form>
```

```javascript
// 클래스 이름으로 모든 입력 요소 선택
const inputFields = document.getElementsByClassName('input-field');

// 첫 번째 입력 요소에 접근
const username = inputFields[0];
const password = inputFields[1];
```

### 3. `name` 속성으로 접근

`name` 속성은 폼 요소의 이름을 지정하며, 자바스크립트에서 해당 이름으로 요소에 접근할 수 있습니다.

```html
<form name="loginForm">
    <input type="text" name="username">
    <input type="password" name="password">
    <button type="submit">로그인</button>
</form>
```

```javascript
// 폼 요소에 접근
const form = document.forms['loginForm'];

// 내부 입력 요소에 접근
const username = form['username'];
const password = form['password'];
```


또는 `document.forms`를 사용하여 폼에 접근할 수 있습니다.

```javascript
// 첫 번째 폼에 접근
const form = document.forms[0];

// 내부 입력 요소에 접근
const username = form['username'];
const password = form['password'];
```

### 4. `querySelector`와 `querySelectorAll` 사용

CSS 선택자를 사용하여 요소를 선택할 수 있습니다.

```html
<form>
    <input type="text" id="username" name="username">
    <input type="password" id="password" name="password">
    <button type="submit">로그인</button>
</form>
```

```javascript
// id로 요소 선택
const username = document.querySelector('#username');
const password = document.querySelector('#password');

// name으로 요소 선택
const username = document.querySelector('[name="username"]');
const password = document.querySelector('[name="password"]');
```


`querySelector`는 첫 번째 일치하는 요소를 반환하며, `querySelectorAll`은 모든 일치하는 요소를 반환합니다.

### 5. `elements` 컬렉션 사용

폼의 `elements` 속성을 사용하여 폼 내부의 모든 요소에 접근할 수 있습니다.

```html
<form id="myForm">
    <input type="text" name="username">
    <input type="password" name="password">
    <button type="submit">로그인</button>
</form>
```

```javascript
// 폼 요소에 접근
const form = document.getElementById('myForm');

// 내부 입력 요소에 접근
const username = form.elements['username'];
const password = form.elements['password'];
```
다듬은 버전을 아래에 정리해드릴게요. 마크다운 문법을 유지하면서 더욱 깔끔하게 정리했습니다.  

---

# 정규식 (Regular Expressions)

정규 표현식(Regular Expression, RegExp)은 특정 패턴을 가진 문자열을 찾거나 검증하는 데 사용됩니다.  
주로 **입력값 검증**, **문자열 검색 및 치환** 등에 활용됩니다.

## 1. 정규식 기본 문법

| 기호 | 설명 |
|------|------|
| `^`  | 문자열의 **시작**을 의미 |
| `$`  | 문자열의 **끝**을 의미 |
| `[0-9]` | 숫자(0~9) 범위 |
| `[a-z]` | 알파벳 소문자 범위 |
| `[A-Z]` | 알파벳 대문자 범위 |
| `+`  | 앞의 패턴이 **1개 이상 반복** |
| `*`  | 앞의 패턴이 **0개 이상 반복** |
| `?`  | 앞의 패턴이 **0개 또는 1개 존재** |
| `{n}`  | 정확히 **n개 반복** |
| `{n,}` | **최소 n개 이상 반복** |
| `{n,m}` | **n개 이상 m개 이하 반복** |

### 예제

```javascript
let regExp = /^[a-zA-Z0-9]+$/;  // 영문 + 숫자만 허용
console.log(regExp.test("abc123"));  // true
console.log(regExp.test("abc 123")); // false (공백 포함)
```

---

## 2. 정규식 생성 방법

1. **슬래시(`/`)를 이용한 생성**
   ```javascript
   let re = /ab+c/;
   ```
2. **RegExp 객체를 이용한 생성**
   ```javascript
   let re = new RegExp('ab+c');
   ```

---

## 3. 정규식 메서드

### `test()`
- 문자열이 정규식을 만족하는지 검사 (`true` 또는 `false` 반환)
- 주로 조건문에서 사용됨

```javascript
let regExp = /^[0-9]+$/;  // 숫자로만 구성된 문자열 체크
console.log(regExp.test("12345"));  // true
console.log(regExp.test("12a45"));  // false
```

---

### `exec()`
- 패턴에 매칭되는 값을 배열로 반환 (`null` 반환 가능)
- 찾은 값의 **자세한 정보**를 알고 싶을 때 사용

```javascript
let regExp = /([0-9]+)px/;
console.log(regExp.exec("width: 120px;"));  
// ["120px", "120"]
```

---

### `search()`
- 문자열에서 패턴을 찾아 **인덱스 반환** (`-1` 반환 가능)

```javascript
let regExp = /hello/;
console.log("hello world".search(regExp));  // 0 (첫 번째 위치)
console.log("hi world".search(regExp));     // -1 (찾지 못함)
```

---

### `match()`
- 패턴과 일치하는 **배열 반환** (`null` 반환 가능)
- 여러 개의 일치하는 값을 찾을 수 있음

```javascript
let regExp = /\d+/g;  // 모든 숫자 찾기
console.log("오늘은 2025년 2월 28일입니다.".match(regExp));  
// ["2025", "2", "28"]
```

---

# 이벤트

## 1. 주요 이벤트 종류

| 이벤트명 | 설명 |
|----------|----------------|
| `onclick` | 요소를 클릭할 때 발생 |
| `onchange` | 입력값이 변경될 때 발생 |
| `onload` | 문서가 로드될 때 발생 |
| `onmouseover` | 마우스가 요소 위로 올라올 때 발생 |
| `onmouseout` | 마우스가 요소에서 벗어날 때 발생 |
| `onkeyup` | 키를 눌렀다 뗄 때 발생 |
| `onkeydown` | 키를 누를 때 발생 |

---

## 2. 기본 이벤트 제거

어떤 요소들은 기본적으로 동작하는 이벤트가 존재합니다.  
예를 들어 `<a href="#">` 태그는 클릭 시 페이지가 이동합니다.  
이러한 기본 이벤트를 막고 추가적인 작업을 수행할 때 `preventDefault()`를 사용할 수 있습니다.

```javascript
document.querySelector("a").addEventListener("click", function(event) {
    event.preventDefault();  // 기본 이벤트 제거
    alert("링크 클릭 방지됨!");
});
```

---

## 3. 이벤트 리스너 추가 방법

### `addEventListener()` 사용
```javascript
document.getElementById("btn").addEventListener("click", function(event) {
    alert("버튼 클릭됨!");
});
```

### 프로퍼티 방식
```javascript
document.getElementById("btn").onclick = function() {
    alert("버튼 클릭됨!");
};
```