
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../layout/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result == '3'}">
   <script>
    alert("회원 정보 변경에 성공했습니다.");
  </script>
</c:if>
<c:if test="${result != '3' && result != '0'}">
 <c:remove var="login"/>
</c:if>
<%-- <%
String result = (String)session.getAttribute("result");
if("3".equals(result)){
	session.removeAttribute("result");
	%>
	 <script>
	 alert("회원 정보 변경에 성공했습니다.");
	 </script>
	<% 
}else {
	result = "0";
}
%>
<%
	//loginForm.jsp에서는 세션 정보를 확인하여
	MemberVO login=(MemberVO)session.getAttribute("login");
	//세션 정보가 있으면 ~님 반갑습니다 메세지 보여주기
	//세션 정보가 없으면 로그인 폼 보여주기 
	if(login==null){
%> --%>
  <c:if test="${empty login }">

<link rel="stylesheet" href="../css/floating-labels.css" />
<form class="form-signin" name="loginform" action="../login.do" method="post">
      <div class="form-label-group">
        <input type="text" id="userid" name="userid" class="form-control" placeholder="id" required autofocus>
        <label for="userid">아이디</label>
      </div>
      <div class="form-label-group">
        <input type="password" id="current_password" name="current_password" class="form-control" placeholder="Password" required>
        <label for="pass">비밀번호</label>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
    </form>
   </c:if>
   <c:if test="${!empty login }">

   		<script>
   			var name="${login.username}";
   			
   		</script>
   		<script src="../js/menu.js"></script>
  
     </c:if>
   <script src="../js/button.js"></script>
<%--  <script>
 $(function() {
	$("#logout").click(function() {
		alert("로그아웃되었습니다.")
		<%session.removeAttribute("login");%>
		location.href="loginForm.jsp";
	})
})
 </script> --%>
<%@include file="../layout/footer.jsp" %>











