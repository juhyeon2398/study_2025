window - preferences - web - html/css/javascript 인코딩 변경   
error 
  - 500 서버에러   
  - 404 경로에러

## **JSP**
* 서블릿(Servlet) 기반의 서버측 스크립트(Back-end)
* out.print() - jsp 영역에서 syso 용도로 사용

### 용도   
1. JSP : View를 만드는 용도   
2. Servlet : Logic을 만드는 용도

### 스크립트 요소
1. <%@ 지시어 %>	: 지시어 (Directive)
2. <%! 선언부 %>	: 선언부 (Declaration), 전역 변수 선언, 메소드
3. <%= 표현식 %>	: 표현식(Expression), 결과 값 출력(변수값, 리턴값)
4. <% 스크립트릿%>	: 스크립트릿(Scriptlet), 일반 자바 코드

### 4가지 영역
* 데이터가 저장되는 4가지 영역(객체)가 있다.
* 영역에 따라 데이터가 유지되는 생명주기(life cycle)가 다르다.
* 4가지 영역(객체)(짧은 생명주기부터 순서대로!!)
   - **pageContext** 객체 
    1. 하나의 페이지를 처리할 때 사용하는 영역
    2. page 영역
    3. 해당 페이지를 벗어나면 데이터가 삭제됨
    - **request** 객체
    1. 하나의 요청을 처리할 때 사용하는 영역
    2. request 영역
    3. response 하면 데이터가 삭제됨
    - **session** 객체
    1. 하나의 웹 브라우저를 처리할 때 사용하는 영역
    2. session 영역
    3. 웹 브라우저를 종료하면 데이터가 삭제됨 
    - **application** 객체 
    1. 하나의 웹 애플리케이션에서 사용하는 영역
    2. application 영역
    3. 웹 애플리케이션을 종료하면 데이터가 삭제됨

* 저장하기 - 객체명.setAttribute("속성", "값")
* 불러오기 - 객체명.getAttribute("속성");

### 세션(session)
1. 세션에 데이터 저장하기   
    session.setAttribute("속성","값");
2. 세션에 저장된 데이터 불러오기    
    session.getAttribute("속성");
3. 세션에 저장된 데이터 삭제하기		
    session.removeAttribute("속성");	
4. 세션에 저장된 데이터 초기화 하기		
    session.invalidate();

### JPS에서 페이지 이동 방법

1. **a태그** href 속성으로 이동하기
```html
<a href="Ex05_03_page_move.jsp">파라미터 X</a>
<a href="Ex05_03_page_move.jsp?name=<%=name%>&age=<%= age %>">파라미터 o</a>
```

2. **loaction** 객체로 이동하기
```html
<button onclick="location.href='Ex05_03_page_move.jsp'">
    파라미터 X
</button>
<button onclick="location.href='Ex05_03_page_move.jsp?name=<%= name %>&age=<%=age%>'">
    파라미터 X
</button>
```
3. **forward** 로 이동하기 (주소변경 X)
```jsp
<% request.getRequestDispatcher("Ex05_03_page_move.jsp").forward(request, response); %>
```
4. **redirect** 로 이동 (주소 변경 O)
```jsp
<% response.sendRedirect("Ex05_03_page_move.jsp"); %>
```

### 파라미터 받기
- 단수 데이터 받을 때 : request.getParameter()
- 복수 데이터 받을 때 : request.getParameterValues()
- 데이터는 문자열로 반환

```javascript
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String[] pet = request.getParameterValues("pet");
String info = request.getParameter("info");
```

## 서블릿(Servlet)
1. 자바를 사용하여 웹을 만들기 위해 필요한 기술
2. 특징
    - 클라이언트의 요청에 대해 동적으로 작동하는 웹 어플리케이션 컴포넌트
    - HTML을 사용하여 요청에 응답한다.

3. request가 가지고 있는 기본 정보
```javascript	
    String url = request.getRemoteAddr();
    String host = request.getRemoteHost();
    String user = request.getRemoteUser();
    int port = request.getRemotePort();
    
    out.print("요청 주소 : " + url + "<br>");
    out.print("요청 호스트 : " + host + "<br>");
    out.print("요청 사용자 : " + user + "<br>");
    out.print("요청 포트 : " + port);
```

4. 인코딩
```javascript
request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=UTF-8");
```

## **필터(Filter)**
1) 클라이언트(Client)에서 서버(Server)로 요청이 들어오기 전 서블릿을 거쳐서 필터링 하는 것   
    HTTP 요청 -> WAS -> 필터 -> 서블릿
2) 서블릿 3.x 버전 이후 추가된 기술
3) Servlet과 ServletFilter의 차이   
    (1) Servlet은 HTTPServeltRequest   
        Filter는 ServletRequest   
        => Filter의 ServletRequest가 부모 클래스
4) 주요 사용 기능
    (1) 사용자 인증
    (2) 로깅
5) 사용 방법
    - Filter 인터페이스를 구현하여 사용
    - init(), doFilter(), destroy() 메소드 사용
    - init()
        - 서블릿 컨테이너가 필터 인스턴스를 초기화 할 때 호출되는 메소드
    - doFilter()
        - 실제 필터링 코드 구현 메소드
    - destroy()
        - 필터 인스턴스가 종료될 때 호출되는 메소드


    java EE Tools - generate dployment descriptor stub - XML 파일생성

필터 설정 
```xml
</welcome-file-list>
<!-- 아래 -->

<!-- 필터 정의 -->
<filter>
    <filter-name>EncodingFilter</filter-name>   <!-- 필터 이름 -->
    <filter-class>org.joonzis.filter.EncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</filter>
<!-- 필터 맵핑하기 (요청 pattern 확인) -->
<filter-mapping>
    <filter-name>EncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

(2) Filter 파일 내에서 @WebFilter() 어노테이션 사용

#### 자동인코딩 filter
```java
package org.joonzis.filter;

import java.io.IOException;
import javax.servlet.*;

public class EncodingFilter implements Filter{
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 필터가 실제 구동되는 영역
		System.out.println("-----EncodingFilter doFilter() 동작중...");
		
        // 인코딩 세팅이 없으면 실행
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}
}

```

#### 로그인 여부 판단
```java
//	1. 로그인 된 클라이언트인지 확인
// (HttpSession 필요 -> HttpServletRequest 필요)
HttpServletRequest req = (HttpServletRequest)request;
HttpSession session = req.getSession();

String id = (String) session.getAttribute("id");
String pw = (String) session.getAttribute("pw");

if(id != null && pw != null) {
    // 요청의 흐름 계속 이어가기
    chain.doFilter(request, response);
}else {
    // 로그인 페이지로 돌려보냄
    HttpServletResponse rep = (HttpServletResponse)response;
    String cPath = req.getContextPath();
    rep.sendRedirect(cPath + "/login/loginPage.jsp");
}
```
		
### 액션태그 
#### **액션 태그를 이용한 자바 빈 사용 방법**
1. 특정 패키지에 자바 빈을 만든다.
2. 자바 빈을 생성한다.
```jsp
<jsp:useBean id="별명" class="패키지.클리스명"
```
3. 자바 빈에 값을 저장한다.
```jsp
<jsp:setProperty property="파리미터명" name="별명">
```
4. 자바 빈 값을 사용한다.
```jsp
<jsp:getProperty property="파라미터명" name="별명">	
```
### **include**
1. **include 지시어**
```jsp
<%@ include file="Ex01_include2.jsp" %>
```
2. **액션태그**
```jsp
<jsp:include page="Ex01_include2.jsp">
    <jsp:param name="name" value="김씨"/>
    <jsp:param name="age" value="20"/>
    <jsp:param name="addr" value="서울"/>
</jsp:include>
```
		
## **쿠키 (Cookie)**
1. 클라이언트(웹 브라우저)가 관리하는 정보 쿠키는 클라이언트가 관리, 세션은 서버가 관리
2. javax.servlet.http 패키지의 Cookie 클래스 사용
3. 보안에 취약 (중요 정보는 세션으로 관리)
4. 구성 요소 : 이름, 값, 유효기간
5. 동작 방식
    - 웹 브라우저의 정보(쿠키)를 웹 브라우저에 저장하므로, 이후에 서버로 전송되는   요청에는 쿠키가 가지고 있는 정보가 같이 포함돼 전송된다.   
    이때 웹 서버는 웹 브라우저의 요청 속에 포함되어 있을 쿠키를 읽어서 새로운 웹 브라우저인지 이전에 요청을 했던 웹 브라우저인지를 판단할 수 있다.
6. **주요 메소드**
<pre>
1. void addCookie(String)   // 쿠키 추가하기
2. Cookie[] getCookies()    // 전체 쿠키 가져오기
3. void setValue(String)    // 쿠키 값 저장하기
4. String getValue()        // 쿠키 값 가져오기	
5. String getName()         // 쿠키 이름 가져오기
6. void setDomain(String)   // 쿠키 도메인 지정하기
7. String getDomain()       // 쿠키 도메인 가져오기
8. void setPath(String)     // 쿠키 전송 경로 지정하기
9. String getPath()         // 쿠키 전송 경로 가져오기
10. void setMaxAge(int)     // 쿠키 유효시간 지정하기 
    (초 단위, -1: 브라우저 종료 시점까지) --> 삭제가 없으므로 유효시간을 0으로 하면 삭제됨
11. int getMaxAge()		// 쿠키 유효시간 가져오기
</pre>
```jsp
/* 1. 쿠키 만들기 ( 서버로 쿠키 만들기 ) */
Cookie cookie = new Cookie("id", "admin");

// 유효기간 설정 (1일)
cookie.setMaxAge(60 * 60 * 24);

// 값에 공백, 콤마, 괄호 등을 저장하라면 인코딩 필요
Cookie bisket = new Cookie("name", URLEncoder.encode("김씨","UTF-8"));

// bisket의 유효 기간을 20분으로 설정
bisket.setMaxAge(60 * 20);

// 쿠키저장
response.addCookie(cookie);
response.addCookie(bisket);

// 쿠키 저장소의 모든 데이터 확인하기
Cookie[] cookieBox = request.getCookies();

cookieBox[0].getName(); // 쿠키 이름
cookieBox[0].getValue(); // 쿠키 값
```
## **EL(Expression Language)**
1) JSP 에서 사용하는 새로운 스크립트 언어
2) 표현식을 대체하는 역할 (<%= 변수값 %>, <%= 계산식 %>, <%= 함수() %>)
3) 4가지 영역(객체)에서 사용
    (1) pageContext, request, session, application
4) EL 표현 방식
    (1) <%= 변수값 %> --> ${변수값}	
5) EL 내장객체 중 파라미터를 사용하는 경우 param, paramValues를 사용
                                (변수)		(배열)	
6) EL 연산자
(1) 산술 연산자 
    - +	: 더하기
    - - 	: 빼기
    - div : a를 b로 나눈 몫
    - mod : a를 b로 나눈 나머지 
(2) 비교 연산자  
    - eq 	: == 같다  .
    - ne 	: != 같지않다.
    - gt 	: > 크다.
    - lt 	: < 작다.
    - ge 	: >= 크거나 같다.
    - le	: <= 작거나 같다.
(3) EL 논리 연산자
    - and : && 그리고
    - or 	: || 또는  
    - not : ! 아니다
(4) empty 연산자(empty 값)
    - 값이 null이면 true 리턴
    - 값이 빈 문자열("")이면 true 리턴
    - 값의 길이가 0인 배열이면 true 리턴
    - 값이 빈 Map이면 true 리턴
    - 값이 빈 Collection이면 true 리턴
(5) 비교 선택 연산자(수식?값1:값2)
(6) 문자열 연결
    <% request.setAttribute("title", "JSP 프로그래밍"); %>
    - ${"문자" += "열" += "연결"} -> 문자열연결
    - ${"제목 : " += title} -> 제목 : JSP 프로그래밍


## JSTL 
* JSP 표준 태그 라이브러리(여러 태그들의 집합)

### core 라이브러리
1. **변수 지원**   
    (1) set		: 변수 선언 (EL의 setAttribute)   
    (2) remove	: 변수 삭제 (EL의 removeAttribute)
2. **제어문 지원**
    * if		: else는 없다.~
    ```jsp
    <c:if test="조건"></c:if>
    ```
    * choose	: 다중 if 처리
    ```jsp
    <c:choose>
        // if 영역
		<c:when test="${ avg >= 90 }"> 
			<c:set var="grade" value="A" />
		</c:when>
        // else 영역
		<c:otherwise>                
			<c:set var="grade" value="F" />
		</c:otherwise>
	</c:choose>
    ```
    * forEach	: 루프, 컬렉션 루프  		
    ```jsp
    <c:forEach var="i" begin="1" end="10" step="1">$
        { i }<br>
    </c:forEach>
    ```
    ```jsp
    // 향상 forEach
    <c:forEach var="name" items="${ Names }">
		${ name }
	</c:forEach>

    ```
    * forTokens: 구분자(delim)로 데이터를 분리(토큰 생성)
	```jsp
    <c:set var="animals" value="사자,호랑이;사슴,곰;이구아나^뱀" />
	<!-- 값에 특수기호가 포함된 경우 -->
	<c:forTokens items="${animals}" delims=",;^" var="animal">
		${animal}<br>
	</c:forTokens>
    ```	 

### **formatNumber**

```
<c:set var="n" value="123456789.123456789" />
<h3>formatNumber의 groupingUsed</h3>
천 단 위 구분 기호 + 소수 3자리 : 
<fmt:formatNumber value="${n}" /><br>
천 단 위 구분 기호 없이 + 소수 3자리 : 
<fmt:formatNumber value="${n}" groupingUsed="no"/><br>
<hr>
<h3>formatingNumber의 pattern</h3>
천 단위 구분 기호 + 소수 2자리 : 
<fmt:formatNumber value="${n}" pattern="#,##0.00"/><br>
천 단위 구분 기호 + 정수 : 
<fmt:formatNumber value="${n}" pattern="#,000"/><br>
<hr>
<h3>formatingNumber의 type</h3>
퍼센트 : <fmt:formatNumber value="0.1" type="percent" /><br>
원화 표기 : <fmt:formatNumber value="${n }" type="currency" /><br>
달러 표기 : <fmt:formatNumber value="${n }" type="currency" currencySymbol="$"/>
<hr>
<h3>parseNumber</h3>
<c:set var="a" value="13" />
<fmt:parseNumber var="num1" value="${a }" 
```

### **formatDate**

```
<c:set var="now" value="<%= new Date() %>"></c:set>
	
<h3>formatDate의 타입</h3>
date타입 : 
<fmt:formatDate value="${now }" type="date"/><br>
time 타입 : 
<fmt:formatDate value="${now }" type="time"/><br>
both 타입 : 
<fmt:formatDate value="${now }" type="both"/><br>
<hr>
<h3>formatDate의 스타일</h3>
default : 
<fmt:formatDate value="${now }" type="both" dateStyle="default" timeStyle="default"/><br>
short : 
<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/><br>
medium : 
<fmt:formatDate value="${now }" type="both" dateStyle="medium" timeStyle="medium"/><br>
long : 
<fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"/><br>
full : 
<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
<hr>
<h3>formatDate의 패턴</h3>
사용자 패턴 : 
<fmt:formatDate value="${now }" pattern="yyyy년 MM월 dd일 E요일 a hh:mm:ss"/><br>
```
## **mybatis**
* mapper에서는 ?(물음표)를 사용할 수 없다.  
* 대신 전달한 파라미터의 이름은 #{}을 통해 적는다.   
* sql문 뒤에 ;(세미콜론)이 없다.

### **각 태그 속성**
1. id : id를 통해서 sql문을 선택 (임의로 결정 가능)
2. parameterType : 매개변수의 타입
3. resultType : 리턴 데이터의 타입 (풀 패키지로 작성)
    - insert, update, delete의 경우 무조건 int 형식이기 때문에 작성할 필요가 없다

* SqlSessionFactoryBuilder에서   SqlSessionFactory 을 생성하고,
* Factory에서  SqlSession을 생성한다.
* mybaytis를 이용하려면 SqlSession이 필요하다!!!!!!

* openSession() &emsp;&emsp;&emsp;// select 문에서 사용(커밋을 하지 않음)
* openSession(true)&ensp;&emsp;// 자동 커밋
* openSession(false)&emsp; // 수동 커밋

### **SqlSession의 메소드 종류**
1. selectList("mapper에서 사용할 id")				
    * 검색 결과가 여러 개 일때 List(테이블)
2. selectList("mapper에서 사용할 id", 파라미터)		
    * 파라미터 전달 시
3. selectOne("mapper에서 사용할 id")				
    * 검색 결과가 한 개 일 때(테이블)
4. selectOne("mapper에서 사용할 id", 파라미터)
5. insert("mapper에서 사용할 id", 파라미터)
6. update("mapper에서 사용할 id")
7. delete("mapper에서 사용할 id")

  *** 각 메소드의 두번 째 인자 값으로 파라미터를 던질 수 있다.
  던질 파라미터가 없을 시 생략


### 모델 1/2 차이

1. 모델 1 구조
	1) JSP 파일 하나로 처리 가능
	2) 간단한 로직, 프로젝트에 적합
	3) Java코드와 JSP코드가 섞여있어 가독성이 떨어짐
```
   ┌───────┐   요청/응답
   │Browser│ <────────> JSP <────────> Service, JavaBean
   └───────┘			 
```					 
						 
2. 모델 2 구조
	1) 웹 브라우저의 요청을 하나의 서블릿이 받는다(단일 진입점)
```					 
			       요청
   ┌───────┐ ──────────> Servlet <────> Logic Class 	
   │Browser│	응답		   ↓ 
   └───────┘<──────────	  JSP <────────> Service, JavaBean		 
```					 

3. 모델 1 대비 모델 2의 장/단점
	* 장점
		- 출력을 위한 뷰 코드와 로직 처리를 위한 자바 코드를 분리였기 때문에
			모델 1 방식에 비해 코드가 복잡하지 않다.
		- 뷰, 로직처리 분업 용이
		- 기능이 분리됨에 따라 유지보수가 용이
	* 단점
		- 구조가 복잡하여 습득이 어렵고 작업량이 많다.
		- java에 대한 이해도가 필요


4. MVC 패턴
	* M : model, 비지니스 로직 / DB 처리, JAVA 파일 (POJO : 순수 자바)
	* V : view, 화면처리, JSP 파일
	* C : controller, 흐름 제어, Servlet 파일 
	* 기본 흐름   
		화면(JSP) => 요청(검색,로그인 등) => 컨트롤러 (Servlet) => 요청에 맞는 Model 호출 
	* 이동 경로   
		jsp -> Controller -> action(Model) -> dao -> mapper -> dto -> Controller -> jsp
		
```
				요청				           로직 처리
   ┌───────┐ ──────────> Controller <────────> Model 
   │Browser│	응답		   ↓
   └───────┘<──────────	  View 
```
