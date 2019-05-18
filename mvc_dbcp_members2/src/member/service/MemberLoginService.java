package member.service;

import member.domain.MemberVO;
import member.persistence.MemberDAO;
import static member.persistence.JDBCUtil.*;

import java.sql.Connection;

public class MemberLoginService {
  public MemberVO isLogin(String user,String current_password) {
	  MemberVO vo=null;
	  Connection con = getConnection();
	  MemberDAO dao = new MemberDAO(con);
	  vo = dao.isLogin(user, current_password);
	  close(con);
	  return vo;
  }
}
