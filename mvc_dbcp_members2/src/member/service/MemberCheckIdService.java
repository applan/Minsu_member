package member.service;

import java.sql.Connection;

import member.persistence.MemberDAO;

import static member.persistence.JDBCUtil.*;

public class MemberCheckIdService {
 public boolean checkId(String userid) {
	 Connection con = getConnection();
	 MemberDAO dao = new MemberDAO(con);
	 return dao.checkId(userid);
 }
}
