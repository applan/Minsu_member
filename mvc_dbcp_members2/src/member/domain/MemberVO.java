package member.domain;

public class MemberVO {
 private String email, gender, username, password, userid;

 
public MemberVO() {
	super();
	// TODO Auto-generated constructor stub
}


public MemberVO(String email, String gender, String username, String password, String userid) {
	super();
	this.email = email;
	this.gender = gender;
	this.username = username;
	this.password = password;
	this.userid = userid;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}
 
 
}
