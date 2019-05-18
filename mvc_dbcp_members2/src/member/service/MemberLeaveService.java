package member.service;

import member.persistence.MemberDAO;
import static member.persistence.JDBCUtil.*;

import java.sql.Connection;



public class MemberLeaveService {

	public boolean remove(String userid,String current_password) {
		 Connection con = getConnection();
		 MemberDAO dao = new MemberDAO(con);
		boolean tf = false;
       try {
       		
       int result = dao.leaveMember(userid, current_password);
       
       if(result >0) 
       {commit(con);tf = true;}
       else {rollback(con);}
       
       }catch (Exception e) {
         e.printStackTrace();
	}finally {
		close(con);
	}
       return tf;
	}
}
