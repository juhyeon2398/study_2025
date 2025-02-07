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
3. 공통 자원으로 활용가능
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
1. 
