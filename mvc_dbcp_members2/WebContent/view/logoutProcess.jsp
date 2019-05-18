<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 session.removeAttribute("login");
// 로그인 세션 가지고 온 후 세션 해제
// index.jsp 이동 
// response.sendRedirect(location)
%>
<script>
 alert("로그아웃 되었습니다.");
 location.href="../index.jsp";
</script>