# JSP, Servlet, Filter 정리

## 에러 코드

- **500**: 서버 에러
- **404**: 경로 에러

## JSP

- **Servlet** 기반의 서버측 스크립트 (Back-end)
- `out.print()`: JSP 영역에서 System.out.println 용도로 사용

### 용도

1. **JSP**: View 생성
2. **Servlet**: Logic 처리

### 스크립트 요소

1. `<%@ 지시어 %>`: Directive
2. `<%! 선언부 %>`: Declaration (전역 변수 및 메소드 선언)
3. `<%= 표현식 %>`: Expression (결과 값 출력)
4. `<% 스크립트릿 %>`: Scriptlet (일반 자바 코드)

### 4가지 영역과 생명주기

1. **pageContext**
   - 하나의 페이지 처리 시 사용
   - 페이지 벗어나면 삭제
2. **request**
   - 하나의 요청 처리 시 사용
   - 응답 시 삭제
3. **session**
   - 하나의 웹 브라우저에 대해 사용
   - 브라우저 종료 시 삭제
4. **application**
   - 전체 웹 애플리케이션에서 사용
   - 애플리케이션 종료 시 삭제

- **데이터 저장**: `객체명.setAttribute("속성", "값");`
- **데이터 불러오기**: `객체명.getAttribute("속성");`

### 세션 관리

```java
session.setAttribute("속성", "값");
session.getAttribute("속성");
session.removeAttribute("속성");
session.invalidate();
```

### 페이지 이동 방법

1. **a 태그**

```html
<a href="page.jsp">이동</a>
<a href="page.jsp?name=홍길동&age=30">파라미터 전달</a>
```

2. **location 객체**

```html
<button onclick="location.href='page.jsp'">이동</button>
```

3. **forward** (주소 변경 X)

```jsp
<% request.getRequestDispatcher("page.jsp").forward(request, response); %>
```

4. **redirect** (주소 변경 O)

```jsp
<% response.sendRedirect("page.jsp"); %>
```

### 파라미터 받기

```java
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String[] pets = request.getParameterValues("pet");
String info = request.getParameter("info");
```

## Servlet

- 클라이언트 요청에 동적으로 작동하는 웹 애플리케이션 컴포넌트

### 기본 정보 가져오기

```java
String url = request.getRemoteAddr();
String host = request.getRemoteHost();
String user = request.getRemoteUser();
int port = request.getRemotePort();
```

### 인코딩 설정

```java
request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=UTF-8");
```

## Filter

- 서블릿 요청 전 필터링
- `init()`, `doFilter()`, `destroy()` 메소드 사용

### 필터 설정 (web.xml)

```xml
<filter>
    <filter-name>EncodingFilter</filter-name>
    <filter-class>org.joonzis.filter.EncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>EncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

### 자동 인코딩 필터

```java
public class EncodingFilter implements Filter {
    private String encoding;

    public void init(FilterConfig config) {
        encoding = config.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }
}
```

### 로그인 여부 판단 필터

```java
HttpServletRequest req = (HttpServletRequest)request;
HttpSession session = req.getSession();
String id = (String) session.getAttribute("id");
String pw = (String) session.getAttribute("pw");

if (id != null && pw != null) {
    chain.doFilter(request, response);
} else {
    ((HttpServletResponse)response).sendRedirect("/login/loginPage.jsp");
}
```

## EL (Expression Language)

- `${변수}` 형태로 사용
- 4가지 영역(pageContext, request, session, application)에서 사용
- 연산자: `+`, `-`, `div`, `mod`, `eq`, `ne`, `gt`, `lt`, `ge`, `le`, `and`, `or`, `not`, `empty`

## JSTL (JSP Standard Tag Library)

- **변수 선언**

```jsp
<c:set var="name" value="홍길동" />
```

- **조건문**

```jsp
<c:if test="${age > 20}">성인입니다.</c:if>
```

- **반복문**

```jsp
<c:forEach var="i" begin="1" end="10">${i}</c:forEach>
```

- **향상된 forEach**

```jsp
<c:forEach var="name" items="${names}">
    ${name}<br>
</c:forEach>
```

- **formatNumber**

```jsp
<c:set var="n" value="123456789.123456789" />
<fmt:formatNumber value="${n}" pattern="#.##" />
<fmt:formatNumber value="${n}" groupingUsed="no" />
<fmt:formatNumber value="0.1" type="percent" />
<fmt:formatNumber value="${n}" type="currency" currencySymbol="$" />
```

- **formatDate**

```jsp
<c:set var="now" value="<%= new Date() %>" />
<fmt:formatDate value="${now}" type="date" />
<fmt:formatDate value="${now}" type="time" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
```

## Cookie

- 클라이언트가 관리하는 정보
- 주요 메소드: `addCookie()`, `getCookies()`, `setValue()`, `getValue()`, `setMaxAge()`

```java
Cookie cookie = new Cookie("id", "admin");
cookie.setMaxAge(86400);
response.addCookie(cookie);

Cookie[] cookies = request.getCookies();
for (Cookie c : cookies) {
    out.println(c.getName() + ": " + c.getValue());
}
```

---

이 문서는 JSP, Servlet, Filter의 기초 개념과 사용법을 체계적으로 정리한 자료입니다.

