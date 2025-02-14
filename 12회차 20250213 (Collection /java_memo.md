# 객체
1. 객체는 속성을 가지며 속성은 필드, 메소드라고 부른다.
2. 인스턴스 : 클래스로부터 만들어진 객체
# 클래스
1. 객체를 만드는 도구이자 설계도
2. 규칙
   * 첫글자는 대문자
   * 특수문자, 자바키워드 X
3. 하위 클래스는 선언하지 않고 값만 넘겨주어도 된다.
# 메소드
1. 작성규칙 
   * 리턴타입 메소드명 ( 매개변수명 ) { 본문; return 값; }
2. 오버로딩   
   * 매개변수 선언에 따라 메소드가 여러게 존재할 수 있다.
   * 리턴 타입은 상관 없음.
# return
1. 함수를 종료할때는 단독
2. 값을 넘길때는 타입, 값
# 생성자 ( Constructor )  
1. 객체가 생성될때 자동으로 호출되는 메소드
2. 모든 객체는 생성될 때 반드시 생성자를 호출한다.
3. 클래스명과 동일하게 생성
4. 오버로딩이 가능하다.
5. 자동완성 alt+shift+s -> generate constuctor tostring fileds
6. 객체를 필드로 받아서 사용도 가능
# this
1. 생성된 객체의 자기 자신을 호출하는 방식
2. this.필드 -> 필드 호출
3. this() 생성자 -> 같은 이름의 생성자를 찾음
# static
1. 객체 생성전 만들어진다.
2. 정적 멤버 : 객체를 생성하지 않고 사용가능한 필드와 메소드 (Math, Intiger)
3. 한번만 만들어 공통 자원으로 활용가능
# final
1. 다시 바꾸지 않을 때 사용
2. 상수, 메소드 (오버라이드 불가), 클래스 (상속 불가) 사용가능
3. 상수는 대문자로 쓰는것이 관례
4. 상수 접근은 객체명이 아닌 클래스 명으로 접근
# Random() / Math
<pre>
  System.out.println(ran.nextInt());
  System.out.println(ran.nextInt(10)); // 난수 발생 (0 ~ 9);
  System.out.println(ran.nextInt(6)); // 0~5
  System.out.println(ran.nextInt(6) + 1); // 1~6
  System.out.println(ran.nextDouble()); // 0~0.999
  System.out.println(ran.nextDouble() * 10); // 0~9.999
  System.out.println((int) ran.nextDouble() * 10); // 0~9
  System.out.println((int) (ran.nextDouble() * 6) + 1); // 1~6
  
  ((int)(Math.random()*6 +1));
</pre>
# 상속 (Inheritance)
1. 부모가 자식에게 데이터를 전달해줌 -> 클래스 재활용
2. 기존 클래스를 확장(extends), 중복 제거
3. private 필드, 메소드는 제외
4. 한 부모에게만 상속 가능, 자식은 여럿 가능
5. 객체선언은 자식만해도 사용가능
6. 자바의 최상위 클래스 (슈퍼클래스) -> java.long.Objext
7. super() -> 부모의 생성자이며 이를 통해 부모 필드 초기화가능
<pre>
class Child extends Parent {
  void doChild() {
    System.out.println("Child() 호출");
  }
}
</pre>
# 메소드 오버라이드 (Method Override)
1. 상속 받은 클래스를 재정의
2. 어노테이션 - @Override
  * 선언한 메소드가 오버라이드 되었다는것을 나타냄
  * 상위 클래스에서 해당 메소드를 못 찾으면 컴파일 에러발생
3. 자동완성 -> Override/Impement Methods
# 정보 은닉 (Information Hiding)
1. 필드는 숨김 : 필드
2. 노출 시키는 정보 : "생성자","메소드" 객체 생성을 위함 (new 생성자)
  * 필드 : private
  * 생성자 : public
  * 메소드 : public or private
3. 접근 지시자 : public, protected, default, private
# Getters & Setters
1. 필드를 private 처리하면 필드에 접근하기 위한 메소드
2. 초기화시 예외처리에 용이
<pre>
  //setter
  public void set필드명(메개변수){}
  
  //getter
  public void set필드명(메개변수){
    return 값;
  }
</pre>
# 다형성 (Polymorphism)
1. instanceof :객체 타입 확인
# 추상 메소드
1. 본문이 없는 메소드
   * abstract public 리턴 타입 메소드 명(); -> 주로 부모 클래스에서 자식들이 불러서 쓸수 있다록 사용
   * 구조만 배포하기 위함
# 추상 클래스
1. abstract class 클래스명 {}
2. 추상 메소드가 1개 이상있으면 추상 클래스
3. 추상 클래스는 new를 할 수 없다. - 업캐스팅 필요
# 인터페이스
1. 인터페이스는 추상메소드의 모음이다.
2. 특정 규칙을 지킨 추상클래스
3. 상수와 메소드만 구성 멤버로 갖음
4. class C implements A,B {}
  * C는 A,B의 구현 클래스
5. 업캐스팅이 가능하다.
# 예외 (exception)
1. 처리형식
<pre>
  try{
    예외가 발생할 가능성이 있는 구역
  } catch {
    받은 예외 처리
  } finally{
    예외 유무와 상관없이 무조건 실행
  }
</pre>
2. Exception으로 처리가능하나 명확하게 하는 것이 좋음
3. printStackTrace -> catch 영역에서 오류 메시지 출력
4. throws : 공통 자원의 예외처리를 호출자에가 예외처리를 넘김
5. throw : 예외 강제 발생
# API
1. java.long 패키지 
2. import 없이 사용가능
3. 연산이 일어날 경우 주소값이 계속 생김
  * 연산이 많이 일어날경우 StringBuffer, StringBilder 객체형태로 사용
# Object
1. 최상위 클래스
2. 모든 데이터가 들어감
# toString
1. @override 오버라이딩 시키면 출력 객체처럼사용가능
# StringBuffer
1. 문자열 추가 삭제 가능
# Date 
1. java.util -> 자바단에서사용
2. java.sql -> DB에 날짜저장할때 사용
# Thread 스레드
1. Thread 클래스를 상속받아 객체생성
2. Runnalbe 인터페이스 구현 -> Thread를 상속받으면 다른 클래스를 상속받지 못 하기 때문
3. run() 스레드 객체 생성
4. start() 스레드 실행
5. 스레드는 실행 및 종료 순서는 정하지 못 하지만 synchronized 사용하여 블록내 순서는 정할 수 있다.
# 제네릭 Generic
1. 잘못된 타입이 사용될 문제를 컴파일 과정에서 제거가능
2. 제네릭 메소드/클래스 생성 가능
   * class 클래스명<제네릭 변수 T> 클래스 사용
   * static <T> void printArray(T[] arr) 메소드 사용
3. 캐스팅 타입 변환을 거치지 않아도 된다.
4. 메소드는 타입을 지정하지 않아도 입력된 값에 따라 동적으로 변함
# Collection
1. 변수명을 호출하면 값이 나옴
2. Set 순서가 없는 데이터 집함 -> 중복 불가
3. List 순서가 있는 데이터 집합 -> 중복 허용
4. ArrayList
  * size() = length() -> Array는 length(), ArrayList는 size()로 배열의 크기를 확인함
  * .add(); // 추가
  * .get(idx); // 요소 가져옴
  * .clear(); // 저장된 모든 객체 삭제
  * .remove(0); // 인덱스 객체 삭제
5. Map
  * key와 value가 쌍으로 이루어진 순서가 없는 데이터 집합
  * key는 중복 X
  * value 중복 O
4. Iterator (반복자)
  * 주소값을 공유하여 해당 배열에서도 삭제가 일어남
  * hasNext() : 다음요소 유무 확인 메소드
  * next() : 다음 요소 가져옴
  * remove() : next()로 가져온 요소 삭제
  * 구조 : Iterator itr = list.iterator();
  * 사용 하면 비워지는 구조여서 재사용시 다시 넣어야함
# IO 
1. BufferedOutputStream 
  * flush() 채워지지 않은 데이터를 보냄
  * close() 객체를 생성한것의 역순으로 닫아야 좋음
2. file
  * file.exists() - 파일 존재여부 확인 메소드
  * file.getPath() - 상대경로
  * file.getAbsolutePath() - 절대경로
