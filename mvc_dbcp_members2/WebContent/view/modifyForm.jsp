<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../layout/header.jsp" %>
<%
  String result = (String)session.getAttribute("result");
    if("1".equals(result)){
    	session.removeAttribute("result");
    	%>
    	 <script>
    	 alert("현재 아이디의 패스워드가 일치하지않습니다.");
    	 </script>
    	<% 
    }else if("2".equals(result)){
    	session.removeAttribute("result");
    	%>
   	 <script>
   	 alert("수정이 실패했습니다.");
   	 </script>
   	<% 
    }else{
    	result = "0";
    }
%>
<form action="../modify.do" id="modifyform" method="post">
   <div class="card" style="width:40rem;margin:40px auto;">
     <div class="card-header">
       <h4>비밀번호 변경</h4>
     </div>
     <div class="card-body">
       <div class="form-group row justify-content-center">
         <div class="clo-sm-10">
           <input type="password" name="current_password" id="current_password"
            class="form-control" placeholder="현재 비밀번호" autofocus="autofocus"/>
            <small id="current_password" class="text-info"></small>
         </div>
       </div>
       <div class="form-group row justify-content-center">
         <div class="clo-sm-10">
           <input type="password" name="new_password" id="new_password"
            class="form-control" placeholder="변경 비밀번호" autofocus="autofocus"/>
            <small id="new_password" class="text-info"></small>
         </div>
       </div>
       <div class="form-group row justify-content-center">
         <div class="clo-sm-10">
           <input type="password" name="confirm_password" id="confirm_password"
            class="form-control" placeholder="변경 비밀번호 재입력" autofocus="autofocus"/>
            <small id="confirm_password" class="text-info"></small>
         </div>
         <div>
         </div>
       </div>
          <div class="form-group text-center">
           <button type="submit" class="btn btn-primary">수정</button>
           <button type="button" id="cancel"class="btn btn-secondary">취소</button>
          </div>
     </div>
   </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
<script src="../js/modifyForm.js"></script>
<%@include file="../layout/footer.jsp" %>
<script src="../js/menu.js"></script>
<script src="../js/button.js"></script>
<script>
$(function() {
 $("#modify").detach();  // 비밀번호 변경 버튼 없애기
});
$("#cancel").click(function() {
	alert("로그인 화면으로 돌아갑니다.");
	location.href="loginForm.jsp";
});
</script>