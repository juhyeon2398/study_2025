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