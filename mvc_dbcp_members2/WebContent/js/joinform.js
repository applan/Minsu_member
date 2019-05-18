/**
 * joinForm.jsp의 validation
 */
/*$(function() {
	$("#").validate({
		
	});
}) 기본 모양*/
$(function() {
	$("#joinform").validate({ 
		errorPlacement:function(error,element){
			 $(element).closest("form").find("small[id='"+element.attr("id")+"']")
		      .append(error); // closest ( 부모[상위]요소 찾아달라는것 )
		},
		rules:{
			// required,
			// 아이디는 숫자,영대소문자 사용해서 5~12자리 허용
			userid :{
				required : true,
				remote:{
					url:"../checkId.do",
					type:"post",
					data:{
						userid:function(){
							return $("#userid").val();
						}
					}
				},
				validUser_Id : true
			},
			
			// 비밀번호는 문자,숫자,특수문자 사용해서 8~15자리 허용
		    password :{
		    	required: true,
		    	validUser_Pwd : true
		    },
			// equalTo 
		    confirm_password:{
		    	required: true,
		    	equalTo : "#password"
		    },
		    // 이름에 숫자 , 특수문자 넣지 못함
		    gender : {
		    	required: true
		    },
		    name : {
		    	required: true,
		    	validUser_Name : true
		    },
			// 이메일 형식
		    email : {
		    	required: true,
		    	validUser_Email : true
		    }
		    
			
		},
		messages:{
			userid :{
				required : "아이디 항목은 필수 입니다.",
				remote :"이 아이디는 사용할 수 없습니다."
			},
			password :{
				required : "비밀번호 항목은 필수 입니다.",
			    validUser_Pwd : "비밀번호 형식을 확인해주세요"
			},
			confirm_password :{
				required : "비밀번호 확인 항목은 필수 입니다.",
			    equalTo : "입력한 비밀번호와 다릅니다."
			},
			gender :{
				required: "성별을 선택해주세요"
			},
			name :{
				required : "이름 항목은 필수입니다."
			},
			email :{
				required : "이메일 항목은 필수입니다."
			}
			
		}
	});
});

$.validator.addMethod("validUser_Id",function(value){
	var regUserId=/^[a-zA-Z0-9]{5,12}$/;
	
	return regUserId.test(value);
},"아이디에는 한글,특수문자는 포함할 수 없습니다.");

$.validator.addMethod("validUser_Pwd",function(value){
	var regUserPwd=/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,15}$/;
	
	return regUserPwd.test(value);
},"비밀번호에는 하나 이상의 영대소문자와 하나 이상의 숫자 혹은 특수문자를 포함해야합니다.");

$.validator.addMethod("validUser_Name",function(value){
	var regUserName=/^(?=.*?[A-Z])|(?=.*?[a-z])|(?=.*?[ㄱ-ㅎ|ㅏ-ㅣ|가-힣])/;
	
	return regUserName.test(value);
},"이름에는 특수문자,숫자 입력이 불가능합니다.");

$.validator.addMethod("validUser_Email",function(value){
	var regUserEmail=/^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	
	return regUserEmail.test(value);
},"이메일을 확인해주세요");

