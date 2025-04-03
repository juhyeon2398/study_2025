## spring 세팅

C:\wi\dev\workspace\workspace_spring\.metadata\.plugins\org.springsource.ide.eclipse.commons.content.core -> https-content.xml 파일 추가   
lombok.jar 설치 -> sprint.exe select

org.springframework.templates.mvc-3.2.2.zip 파일 경로에 첨부   
C:\wi\dev\workspace\workspace_spring\.metadata\.sts\content\org.springframework.templates.mvc-3.2.2

### pom.xml 수정
```xml
<java-version>11</java-version>
<org.springframework-version>5.0.7.RELEASE</org.springframework-version>

<!-- Logging -->
<scope>runtime</scope> // 삭제 or 주석
<!-- Servlet -->
// servlet-api -> javax.servlet-api
<artifactId>javax.servlet-api</artifactId>
<version>3.1.0</version>

<!-- Test -->
<version>4.12</version>

<!-- <build> -->
<!-- 자바 버전과 동일 -->
<source>11</source>
<target>11</target>

// lombok 추가
<dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.0</version>
      <scope>provided</scope>
</dependency>
```
### web.xml 수정
```xml
// 추가 인코딩
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

### ojdbc build path 추가
ojdbc class path 추가 -> deployment assembly -> java build path entries


### 각종 라이브러리 추가
* spring-tx ⇒ 트랜잭션을 사용하기 위한 라이브러리 ( 5.0.7 )
    - https://mvnrepository.com/artifact/org.springframework/spring-tx
* spring-jdbc ⇒ DB와 연동하기 위한 라이브러리 ( 5.0.7 )
    - https://mvnrepository.com/artifact/org.springframework/spring-jdbc
* spring-test ⇒ 단위 테스트를 진행하기 위한 라이브러리 ( 5.0.7 )
    - https://mvnrepository.com/artifact/org.springframework/spring-test

* HikariCP ⇒ 대용량 데이터 처리 속도를 빠르게 하기 위한 라이브러리 ( 2.7.8 )
    - https://mvnrepository.com/artifact/com.zaxxer/HikariCP
* MyBatis ⇒ DB 프레임워크 ( 3.4.6 )
    - https://mvnrepository.com/artifact/org.mybatis/mybatis
* mybatis-spring ⇒ MyBatis를 사용하기 위한 스프링 라이브러리 ( 1.3.2 )
    - https://mvnrepository.com/artifact/org.mybatis/mybatis-spring
* Log4jdbc ⇒ 데이터베이스 실행 시, 단위 테스트를 위한 라이브러리 ( 1.16 )
    - https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1

* aspectjrt ( 1.9.5 ) ⇒ AspectJ 기능을 사용하기 위한 런타임 라이브러리
    - https://mvnrepository.com/artifact/org.aspectj/aspectjrt
* aspectjweaver ( 1.9.5 ) ⇒ aspect 정보를 바탕으로 코드를 생성하는데에 필요한 라이브러리
    - https://mvnrepository.com/artifact/org.aspectj/aspectjweaver

log4jdbc.log4j2.properties -> src/main/resources에 추가

root-context.xml -> namespace -> context, mybatis 선택

### root-context.xml 추가
```xml
<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
    <!-- Old Driver -->
    <!-- 
        <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
    -->
    
    <!-- log4jdbc --> 
    <property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
    <property name="jdbcUrl" value="jdbc:log4jdbc:oracle:thin:@localhost:1521:XE"></property>
    <property name="username" value="scott"></property>
    <property name="password" value="tiger"></property>
</bean>

<!-- HikariCP configuration -->
<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
    <constructor-arg ref="hikariConfig"></constructor-arg>
</bean>

<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"></property>
</bean>

<mybatis-spring:scan base-package="org.joonzis.mapper"/>
```

### REST를 사용하기 위한 라이브러리
* Jackson-databind ⇒ jackson-core 및 jackson-annotation 라이브러리의 의존성을 포함하여 사용할 수 있도록 하는 라이브러리 **( 2.12.2 )**
    - https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
* Jackson-dataformat-xml ⇒ xml 형식으로 사용하기 위해 **( 2.12.2 )**
    - https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
- gson ⇒ 테스트 시 json 타입의 문자열로 변환하기 위해 **( 2.8.6 )**
    - https://mvnrepository.com/artifact/com.google.code.gson/gson
* lombok **( 1. 18. 0 )**
    - https://mvnrepository.com/artifact/org.projectlombok/lombok
* spring-test **( 5.0.7 )**
    - https://mvnrepository.com/artifact/org.springframework/spring-test


<!-- 서버수정 기본 경로 수정 -->
서버 클릭 -> path -> 경로 삭제

HomeController -> 서블릿



<br><br> <hr><hr> <br><br>

## 스프링 프레임워크

### **Maven의 주 용도(pom.xml)**
* 프로젝트에 필요한 의존적인 라이브러리를 자동으로 관리해주는 용도
### **MVC 프로젝트 템플릿의 구조**
* src/main/java	
    - 개발되는 java 코드의 경로
* src/main/resources	
    - 서버가 실행될 때 필요한 파일들의 경로
* src/test/java	테스트 전용 경로
* src/test/resources	
    - 테스트 시에만 사용되는 파일들 경로
* src/main/webapp/WEB-INF/spring	
    - Spring 설정 파일의 경로
* src/main/webapp/WEB-INF/views	
    - JSP 파일 경로
* pom.xml 
    - Maven의 설정 파일


1. dependencies
* 라이브러리의 선언 모음
* dependency 태그로 라이브러리 추가


1. 프레임워크 
* 소프트웨어 관점에서 접근하면 아키텍처에 해당하는 골격 코드
* 어플리케이션의 구조를 결정하는 코드를 프레임워크가 제공한다.
* 장점
 - 빠른 구현시간  ( 소규모의 프로젝트는 제외 )
 - 쉬운 관리
 - 개발자들의 역량 획일화

2. Maven의 용도 (pom.xml)
* 프로젝트에 필요한 의존적인 라이브러리를 자동으로 관리해주는 용도


## 스프링의 주요 특징
1. **POJO (Plain Old Java Object)**
자바 객체의 라이프 사이클을 스프링컨테이너가 직접관리하여 스프링컨테이너로부터 피료한 객체를 얻을 수 있다.

2. **의존성 주입 DI 지원**
* 각 계층이나 서비스들 사이 또는 객체들 사이에 의존성이 존재할 경우 스프링 프레임워크가 서로 연결 시켜준다. 클래스 사이 약한 결합
* 생성자, set method, annotation

3. **AOP 지원**
* 트랜젝션, 로깅, 보안 등 여러 모듈에서 공통적으로 지원하는 기능을 분리하여 사용 가능
(반복 코드 X)

4. 확장성이 높다.

## 스프링 MVC의 기본 구성
* Presentation (화면계층) -> Business (비지니스 계층) -> Persistence (영속 or 데이터 계층)

1. Presentation (화면계층)
* 화면에 보여주는 기숙을 사용하는 영역
* servelt / jsp이나 MVC가 담당하는 영역

2. Business (비지니스 계층)
* 순수 비즈니스 영역

3. Persistence (영속 or 데이터 계층)


### ResponseEntity
* 200 - 통신 성공   
* 404 - 파일 경로 error   
* 500 - 서버 error
* etc..
```java
@GetMapping(value = "/check", produces = {
        MediaType.APPLICATION_JSON_UTF8_VALUE,
        MediaType.APPLICATION_XML_VALUE
})
public ResponseEntity<TestVO> checkTest(@RequestParam("age") double age) {
    ResponseEntity result = null;
    
    TestVO tvo = new TestVO(0, Double.toString(age));
    if(age > 150) {
        result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(tvo);
    }else {
        result = ResponseEntity.status(HttpStatus.OK).body(tvo);
    }
    
    return result;
}
```

### REST 방식
1. REST(Representational State Transfer)
* 정의: 
    - REST는 분산 시스템을 위한 소프트웨어 아키텍처 스타일 중 하나로, 자원을 정의 하고 이 자원에 대한 상태 전이를 표현하는 방식.
    - HTTP를 기반으로 하며, 리소스를 URI로 식별하고 HTTP 메서드를 통해 리소스에 대한 행위를 정의
* 장점: 
    - REST는 간결하고 확장 가능한 구조를 가지며, HTTP 프로토콜을 기반으로 하기
    때문에 널리 사용되는 웹 표준을 따른다.
* 활용 예시: 
    - REST는 주로 웹 서비스에서 사용되며, 클라이언트와 서버 간의 통신을 위해
    HTTP 메서드(GET, POST, PUT, DELETE 등)를 이용한다.

* 경로를 변수화 
```
@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") int pid) {
		return new String[] {"category : "+ cat + ", productId : " + pid};
	}
```
2. 전송방식
    * Create ->  POST
    * Read -> GET
    * Update -> PUT
    * Delete -> DELETE


## @ 어노테이션
* @RequestParam("bno") int bno --> 파라미터를 가지고옴 // 어노테이션을 사용하면 파라미터 값을 강제함 

* @RequestMapping 
    - Controller과 매핑하여 지정하는 어노테이션
    - 클래스 단위로 선언한 경우 해당 value를 전역으로 설정이 가능하다.

* @GetMapping, @PostMapping 
    - HTTP GET,POST 요청을 처리하는 메서드를 맵핑(@RequestMapping)하는 어노테이션
    - produces : 응답에 대한 데이터 타입 (생략 가능)
    ```java
    @GetMapping(value = "/getObject", 
        produces = {
                MediaType.APPLICATION_JSON_UTF8_VALUE, 
                MediaType.APPLICATION_XML_VALUE
            })
    ```

* @Autowired
    - @Autowired란 스프링 컨테이너에 등록한 빈에게 의존관계주입이 필요할 때, DI(의존성 주입)을 도와주는 어노테이션이다.

* @RestController 
    - Controller가 REST 방식을 처리하기 위한 것을 명시
* @ResponseBody 
    - 일반적인 JSP와 같은 뷰로 전달하는 것이 아닌 데이터를 전달하기 위한 용도
* @PathVariable 
    - URL 경로에 있는 값을 파라미터로 추출할 때 사용
* @CrossOrigin 
    - 크로스 도메인 문제를 해결해주는 어노테이션
* @RequestBody 
    - JSON 데이터를 원하는 타입으로 바인딩 처리

## ETC
 
* 경로 앞에 "redirect:"를 사용하면 redirect 방식으로 이동