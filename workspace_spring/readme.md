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


### 라이브러리 추가
* spring-tx ⇒ 트랜잭션을 사용하기 위한 라이브러리 ( 5.0.7 )
    - https://mvnrepository.com/artifact/org.springframework/spring-tx
* spring-jdbc ⇒ DB와 연동하기 위한 라이브러리 ( 5.0.7 )
    - https://mvnrepository.com/artifact/org.springframework/spring-jdbc
* spring-test ⇒ 단위 테스트를 진행하기 위한 라이브러리 ( 5.0.7 )
    - https://mvnrepository.com/artifact/org.springframework/spring-test
${org.springframework-version} 버전 받아옴


* HikariCP ⇒ 대용량 데이터 처리 속도를 빠르게 하기 위한 라이브러리 ( 2.7.8 )
    - https://mvnrepository.com/artifact/com.zaxxer/HikariCP
* MyBatis ⇒ DB 프레임워크 ( 3.4.6 )
    - https://mvnrepository.com/artifact/org.mybatis/mybatis
* mybatis-spring ⇒ MyBatis를 사용하기 위한 스프링 라이브러리 ( 1.3.2 )
    - https://mvnrepository.com/artifact/org.mybatis/mybatis-spring
* Log4jdbc ⇒ 데이터베이스 실행 시, 단위 테스트를 위한 라이브러리 ( 1.16 )
    - https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1

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


<!-- 서버수정 기본 경로 수정 -->
서버 클릭 -> path -> 경로 삭제

HomeController -> 서블릿

<hr><hr>

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

## MVC 구조 
* Presentation (화면계층) -> Business (비지니스 계층) -> Persistence (영속 or 데이터 계층)

1. Presentation (화면계층)
* 화면에 보여주는 기숙을 사용하는 영역
* servelt / jsp이나 MVC가 담당하는 영역

2. Business (비지니스 계층)
* 순수 비즈니스 영역

3. Persistence (영속 or 데이터 계층)
데이터를 어떤
