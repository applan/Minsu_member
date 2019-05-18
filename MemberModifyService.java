package member.service;

import java.sql.Connection;

import member.domain.MemberVO;
import member.persistence.MemberDAO;

import static member.persistence.JDBCUtil.*;

public class MemberModifyService {
	public boolean modifyFlag(MemberVO vo) {
		boolean modifyFlag = false;
		Connection conn = getConnection();
		MemberDAO dao = new MemberDAO(conn);
		int result = dao.modify_member(vo);
		
		if (result > 0) {
			commit(conn);
			modifyFlag = true;
		} else {
			rollback(conn);
		}
		
		return modifyFlag;
	}
}
