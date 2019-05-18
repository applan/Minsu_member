package member.service;

import member.persistence.MemberDAO;
import static member.persistence.JDBCUtil.*;

import java.sql.Connection;

public class MemberJoinService {
  public boolean JoinService(String userid, String password,String name,String gender,String email) {
	  boolean tf = false;
	  Connection con = getConnection();
	  MemberDAO dao = new MemberDAO(con);
	  try {
		  int result = dao.insertNewMember(email, gender, name, password, userid);
		  
	       if(result >0) 
	       {commit(con);tf = true;}
	       else {rollback(con);}
		  
	} catch (Exception e) {
	      e.printStackTrace();
	}finally {		
		close(con);
	}
	  return tf;		
  }
}
