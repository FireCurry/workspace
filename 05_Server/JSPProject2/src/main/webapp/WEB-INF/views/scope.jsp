<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Servlet/JSP 내장 객체와 범위</title>
  <style>
    pre{
      font-size: 16px;
      font-family: "NanumGothic";
    }
  </style>
</head>
<body>
  <h1>Servlet/JSP 내장 객체와 범위</h1>
  
  <pre>
    Servlet/JSP에는 4종류 범위를 나타낸 내장 객체가 존재한다!
    -> 각 종류마다 영향을 끼치는 범위가 달라진다

    <h4>1. page (pageContext) : 현재 페이지</h4>
    -> 현재 JSP에서만 사용 가능한 객체(Servlet X)

    <h4>2. request (요청)</h4>
    -> 요청 받은 페이지(Servlet/JSP)와
       위임 받은 페이지(Servlet/JSP)에서 유지되는 객체
       (HttpServletRequest 객체라고 생각)

    <h4>3. session (입회, 접속)</h4>
    - session : 서버에 접속한 클라이언트를 나타내거나,
                관련 정보를 get/set 할 수 있는 객체
                (session 객체는 서버에서 관리함)

    - [중요!] session은 브라우저마다 하나씩 생성된다!!
      (새탭, 새창은 아님)

    - [유지 범위] : 사이트 접속 ~ 브라우저 종료 | 세션 만료

    - session이 유지되는 상태에서는 아무곳에서나 가져다 사용할 수 있다

    <h4>4. application (ServletContext)</h4>
    - 하나의 웹 어플리케이션마다 한 개만 생성되는 객체
      (Server를 키면 한 개만 생성되는 객체)

    - application 객체는 어디서든 사용 가능

    - [유지 범위] : 서버 실행 ~ 서버 종료

    <h4>5. 내장 객체의 우선 순위 : page > request > session > application</h4>
    <br>
    (좁을수록 먼저!)
  </pre>

  <hr><hr><hr>

  <h1>내장 객체 확인</h1>

  <% // 스크립틀릿 : JSP에 Java 코드 작성하는 영역

  // pageContext == page 범위(scope) 객체
  //  -> JSTL의 c:set으로 대체
    pageContext.setAttribute("pageMessage", "page scope 입니다");
  %>
  <ul>
    <li>page : ${pageMessage}</li>

    <li>request : ${requestMessage}</li>

    <li>session : ${sessionMessage}</li>

    <li>application : ${applicationMessage}</li>

    <li><a href="/scopecheck">scope 확인하기</a></li>
  </ul>

  <hr><hr><hr>

  <h1>우선 순위 확인</h1>

  <% // page scope
    pageContext.setAttribute("str", "page scope에 세팅된 문자열");
  %>

  <h2> \${key} : 
    4종류의 scope 객체를 좁은 순서대로 탐색해서 
    key가 일치하는 속성이 존재하면 출력
  </h2>
  <h2> ${str}</h2>

  <hr>

  <h2>\${XXXScope.key} : 
    XXX 자리에 scope를 작성하면 해당 scope에서 
    key가 일치하는 속성을 찾아 출력
  </h2>

  <h4>${pageScope.str}</h4>
  <h4>${requestScope.str}</h4>
  <h4>${sessionScope.str}</h4>
  <h4>${applicationScope.str}</h4>
</body>
</html>