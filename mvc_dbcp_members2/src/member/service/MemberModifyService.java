package member.service;

import member.domain.MemberVO;
import member.persistence.MemberDAO;
import static member.persistence.JDBCUtil.*;

import java.sql.Connection;

public class MemberModifyService {
 public boolean searchOverlap(String userid,String current_password) {
	 Connection con = getConnection();
	 MemberDAO dao = new MemberDAO(con);
	 boolean tf = false;
	 try {
		 MemberVO vo = dao.isLogin(userid, current_password);
		 if(vo!= null) {
			 tf = true;
		 }else { 
		 }		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close(con);
	}
	 return tf;
 }
 
 public boolean ModifyMember(MemberVO vo) {
	 Connection con = getConnection();
	 MemberDAO dao = new MemberDAO(con);
	 boolean tf = false;
	 try {
		int result = dao.updateMember(vo);
		if(result >0) {
			tf = true;
		}
	} catch (Exception e) {
         e.printStackTrace();
	}finally {
		close(con);
	}
	 return tf;
 }
}
