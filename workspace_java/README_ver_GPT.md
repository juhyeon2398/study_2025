# 객체 (Object)
- 객체는 속성을 가지며, 속성은 **필드**와 **메소드**로 구성됨.
- **인스턴스**: 클래스로부터 생성된 객체.

# 클래스 (Class)
- 객체를 만드는 도구이자 설계도.
- **규칙**:
  - 첫 글자는 대문자로 시작.
  - 특수문자 및 Java 키워드는 사용할 수 없음.
- 하위 클래스를 선언하지 않고 값만 넘겨줄 수도 있음.

# 메소드 (Method)
- **작성 규칙**:  
  ```java
  리턴타입 메소드명 (매개변수) { 본문; return 값; }
  ```
- **오버로딩 (Overloading)**:
  - 매개변수의 종류나 개수에 따라 같은 이름의 메소드 여러 개 정의 가능.
  - 리턴 타입은 상관없음.

# `return`
- 함수 종료 시 단독으로 사용.
- 값을 반환할 경우 타입과 값을 함께 지정.

# 생성자 (Constructor)
- 객체 생성 시 자동으로 호출되는 메소드.
- 모든 객체는 생성될 때 반드시 생성자를 호출.
- **특징**:
  - 클래스명과 동일한 이름을 가짐.
  - 오버로딩 가능.
  - 객체를 필드로 받아서 사용할 수도 있음.
- **자동 완성 단축키**:
  - `Alt + Shift + S → Generate Constructor using Fields`

# `this`
- 생성된 객체 자기 자신을 호출하는 방식.
- **사용법**:
  - `this.필드명` → 필드 호출
  - `this()` → 같은 클래스 내의 다른 생성자 호출

# `static`
- 객체 생성 전에 만들어짐.
- **정적 멤버**:
  - 객체 생성 없이 사용 가능한 필드 및 메소드 (예: `Math`, `Integer`).
  - 한 번만 만들어져 공통 자원으로 활용 가능.

# `final`
- 변경할 수 없는 값을 지정할 때 사용.
- **사용 예시**:
  - **상수** (`final int MAX_VALUE = 100;`)
  - **메소드** (오버라이드 불가)
  - **클래스** (상속 불가)
- 상수는 **대문자**로 쓰는 것이 관례 (`PI`, `MAX_LENGTH`).
- 상수 접근 시 **객체명이 아닌 클래스명**을 사용 (`Math.PI`).

# `Random()` / `Math`
```java
System.out.println(ran.nextInt()); // 난수 발생
System.out.println(ran.nextInt(10)); // 0 ~ 9
System.out.println(ran.nextInt(6) + 1); // 1 ~ 6
System.out.println(ran.nextDouble()); // 0.0 ~ 0.999
System.out.println((int)(Math.random() * 6) + 1); // 1 ~ 6
```

# 상속 (Inheritance)
- 부모 클래스의 데이터와 기능을 자식 클래스가 물려받음.
- **특징**:
  - 기존 클래스를 확장 (`extends`)하여 코드 중복 제거.
  - `private` 필드는 상속되지 않음.
  - 한 부모에게만 상속 가능하지만, 자식 클래스는 여럿 생성 가능.
  - 자바의 최상위 클래스는 `java.lang.Object`.
  - `super()`를 통해 부모 생성자 호출 가능.

```java
class Child extends Parent {
  void doChild() {
    System.out.println("Child() 호출");
  }
}
```

# 메소드 오버라이딩 (Method Override)
- **부모 클래스의 메소드를 재정의**하는 것.
- **어노테이션**: `@Override`
  - 부모 클래스에 해당 메소드가 없으면 컴파일 오류 발생.

# 정보 은닉 (Information Hiding)
- **캡슐화 원칙**:
  - 필드는 `private`으로 숨김.
  - **생성자**와 **메소드**는 `public` 또는 `private`으로 설정.
  - 접근 지정자: `public`, `protected`, `default`, `private`.

# Getters & Setters
- `private` 필드에 접근하기 위해 사용.
- **예제**:
  ```java
  public void setName(String name) { this.name = name; }
  public String getName() { return name; }
  ```

# 다형성 (Polymorphism)
- `instanceof`를 사용하여 객체 타입을 확인할 수 있음.

# 추상 메소드 & 추상 클래스
- **추상 메소드**:
  ```java
  abstract public 리턴타입 메소드명();
  ```
  - 본문 없이 선언만 존재.
- **추상 클래스**:
  ```java
  abstract class 클래스명 {}
  ```
  - 하나 이상의 추상 메소드를 포함한 클래스.
  - **객체 생성 불가 (업캐스팅 필요)**.

# 인터페이스 (Interface)
- **추상 메소드의 모음**.
- 클래스가 특정 규칙을 따르도록 강제.
- **특징**:
  - `implements` 키워드 사용.
  - 다중 구현 가능 (`class C implements A, B {}`).

# 예외 처리 (Exception Handling)
```java
try {
  // 예외 발생 가능 코드
} catch (Exception e) {
  // 예외 처리
} finally {
  // 예외 발생 여부와 관계없이 실행
}
```
- `printStackTrace()` → 오류 메시지 출력.
- `throws` → 예외를 호출자에게 넘김.
- `throw` → 강제 예외 발생.

# API
- `java.lang` 패키지는 **import 없이 사용 가능**.
- `String` 연산이 많으면 `StringBuffer`나 `StringBuilder` 사용.

# `toString()`
- `@Override`하여 객체를 문자열로 변환 가능.

# `StringBuffer`
- 문자열 추가/삭제가 가능.

# 날짜 (`Date`)
- `java.util.Date` → 일반적인 날짜 처리.
- `java.sql.Date` → 데이터베이스 저장용.

# `Thread` (멀티 스레드)
- `Thread` 클래스를 상속받거나 `Runnable` 인터페이스 구현.
- **사용법**:
  ```java
  Thread t = new Thread(new Runnable() {
      public void run() { System.out.println("Running"); }
  });
  t.start(); // 스레드 실행
  ```
- `synchronized` 블록을 사용해 실행 순서 제어 가능.

# 컬렉션 (Collection)
- **List** → 순서 있음, 중복 가능 (`ArrayList`).
- **Set** → 순서 없음, 중복 불가 (`HashSet`).
- **Map** → `key-value` 구조, `key` 중복 불가 (`HashMap`).

# 파일 I/O (Input & Output)
- `BufferedOutputStream.flush()` → 버퍼에 남은 데이터 전송.
- `File.exists()` → 파일 존재 여부 확인.
- `File.getPath()` → 상대 경로.
- `File.getAbsolutePath()` → 절대 경로.

# 데이터베이스 연동 (DB Connection)
```plaintext
프로젝트 우클릭 → Build Path → Libraries 탭 → Classpath → Add External Jars → 파일 추가 후 저장
```