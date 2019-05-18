<%@page import="member.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/header.jsp" %>
${login }


<form action="../leave.do" id="modifyform" method="post">
   <div class="card" style="width:40rem;margin:40px auto;">
      <div class="card-header">
         <h4>회원탈퇴</h4>
      </div>
      <div class="card-body">
         <div class="form-group row justify-content-center">
            <div class="col-sm-10">
               <input type="text" name="userid" id="userid"
               class="form-control" value="${vo.userid }" readonly="readonly"/>
            </div>
         </div>
         <div class="form-group row justify-content-center">
            <div class="col-sm-10">
               <input type="password" name="current_password" id="current_password"
               class="form-control" placeholder="비밀번호"/>
            </div>
         </div>
         <div class="form-group text-center">
            <button type="submit" class="btn btn-primary">탈퇴</button>
            <button id="cancel" type="button" class="btn btn-secondary">취소</button>
         </div>
      </div>
   </div>
</form>
<%@include file="../layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
<script src="../js/menu.js"></script>
<script src="../js/button.js"></script>
<script src="../js/modifyform.js"></script>
<script>
$(function(){
   $("#modify").detach();   //비밀번호 변경 버튼 없애기   
   $("#cancel").click(function(){
      location.href="loginForm.jsp";
   });
});
</script>