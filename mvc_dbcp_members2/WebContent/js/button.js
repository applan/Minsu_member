/**
 * 
 */

   $(function() {
// 로그아웃 버튼 클릭시 - logoutProcess.jsp로 이동
	$("#logout").click(function() {
    location.href="logoutProcess.jsp";
    })
    $("#modify").click(function() {
	location.href="modifyForm.jsp";
	});
	$("#leave").click(function(){
    location.href="leaveForm.jsp"
	});
});
