/**
 *  loginForm.jsp와 modifyForm.jsp에서 공통적으로 사용할
 *   메뉴 부분 
 */
$(function() {
	$("#2").detach();  //register : 화면에서 메뉴 안보이게
	$("#3").detach();  //login : 화면에서 메뉴 안보이게
	//새롭게 보여줄 메뉴 작성
	var $tag="<span class='navbar-text'>"+name+" 님 반갑습니다.</span>"
	+"&nbsp;&nbsp;"
	+"<button type='button' id='modify' class='btn btn-success'>비밀번호 수정</button>"
	+"&nbsp;&nbsp;"
	+"<button type='button' id='logout' class='btn btn-primary'>로그아웃</button>"
	+"&nbsp;&nbsp;"
	+"<button type='button' id='leave' class='btn btn-danger'>회원탈퇴</button>";
	$("#navbarCollapse").append($tag);
});