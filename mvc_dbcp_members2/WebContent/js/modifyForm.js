/**
 * 
 */
$(function() {
	$("#modifyform").validate({ 
		errorPlacement:function(error,element){
			 $(element).closest("form").find("small[id='"+element.attr("id")+"']")
		      .append(error); // closest ( 부모[상위]요소 찾아달라는것 )
		},
		rules:{
			// 비밀번호는 문자,숫자,특수문자 사용해서 8~15자리 허용
			current_password :{
		    	required: true,
		    	validUser_Pwd : true
		    },
		    new_password :{
		    	required: true,
		    	validUser_NewPwd : true
		    },
		    confirm_password :{
		    	required: true,
		    	equalTo: "#new_password"
		    }
		},
		messages:{
			current_password :{
				required : "비밀번호 항목은 필수 입니다.",
			},
		    new_password :{
		    	required: "새로운 비밀번호 항목은 필수 입니다."
		    },
		    confirm_password :{
		    	required: "비밀번호 확인 항목은 필수 입니다.",
		    	equalTo: "수정할려는 비밀번호와 다릅니다"
		    }

			
		}
	});
});


$.validator.addMethod("validUser_Pwd",function(value){
	var regUserPwd=/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,15}$/;
	
	return regUserPwd.test(value);
},"비밀번호에는 하나 이상의 영대소문자와 하나 이상의 숫자 혹은 특수문자를 포함해야합니다.");
$.validator.addMethod("validUser_NewPwd",function(value){
	var regUserPwd=/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,15}$/;
	
	return regUserPwd.test(value);
},"비밀번호에는 하나 이상의 영대소문자와 하나 이상의 숫자 혹은 특수문자를 포함해야합니다.");

