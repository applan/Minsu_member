<%@page import="member.persistence.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.persistence.MemberDAO"%>
<%@page import="member.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
   request.setCharacterEncoding("utf-8");
  // joinForm.jsp에서 넘긴 값 가져오기
  String userid = request.getParameter("userid"); 
  String password = request.getParameter("password"); 
  String username = request.getParameter("name"); 
  String gender = request.getParameter("gender"); 
  String email = request.getParameter("email"); 
  // db insert 작업
  Connection con = JDBCUtil.getConnection();
  MemberDAO dao = new MemberDAO();
  int result = dao.insertNewMember(con, email, gender, username, password, userid);
  
  if(result > 0){
	  JDBCUtil.commit(con);
	  JDBCUtil.close(con);
	  %>
	  <script>
	  	alert("회원 정보 저장에 저장했습니다.");
	    location.href="loginForm.jsp";
	  </script>
	  <% 
  }else{
	  JDBCUtil.rollback(con);
	  JDBCUtil.close(con);
	  %>
	   <script>
	    alert("회원 정보 저장에 실패했습니다.");
	    location.href="joinForm.jsp";
	   </script>
	  <%
  } --%>
  // 작업 결과에 따라서 
  // insert가 성공하면 loginForm.jsp로 이동
  
  // insert 실패시 메시지 띄우고 joinForm.jsp로 이동


%>