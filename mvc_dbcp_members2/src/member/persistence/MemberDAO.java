package member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.domain.MemberVO;
import static member.persistence.JDBCUtil.*;

public class MemberDAO {
    Connection con =null ;
    
	public MemberDAO() {
		super();
	}

	public MemberDAO(Connection con) {
		super();
		this.con = con;
	}

	// insert 메소드 작성 
   public int insertNewMember(String email,String gender,String username,String password, String userid) {
	   PreparedStatement ps = null;
	   int result = 0;
	   
	   String sql = "insert into member2 values(?,?,?,?,?)";
	   try {
		ps = con.prepareStatement(sql);
	    ps.setString(1, userid);
	    ps.setString(2, password);
	    ps.setString(3, username);
	    ps.setString(4, gender);
	    ps.setString(5, email);
	    result = ps.executeUpdate();
	   } catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(ps);
	}
	   return result;
   }
   
   public MemberVO isLogin(String userid,String current_password) {
	   // 이름하고 아이디만 담기
	   MemberVO vo = null;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   
	   String sql = "SELECT userid,username FROM member2 WHERE userid = ? and password = ?";
	   try {
		ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setString(2, current_password);
		rs = ps.executeQuery();
		if(rs.next()) {
			vo = new MemberVO();
			vo.setUserid(rs.getString(1));
			vo.setUsername(rs.getString(2));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(ps);
	}
	   return vo;
   }
   
   public MemberVO getMember(String userid) {
	  // 전체 정보 담기
	   MemberVO vo = null;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   
	   String sql = "SELECT * FROM member2 WHERE userid = ?";
	   try {
		ps = con.prepareStatement(sql);
        ps.setString(1, userid);
        rs = ps.executeQuery();
        if(rs.next()) {
        	vo = new MemberVO();
        	vo.setUserid(rs.getString(1));
        	vo.setPassword(rs.getString(2));
        	vo.setUsername(rs.getString(3));
        	vo.setGender(rs.getString(4));
        	vo.setEmail(rs.getString(5));
        }
	   } catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(ps);
	}
	   return vo;
   }
   
   public int updateMember(MemberVO vo) {
	   // 아이디가 일치하면 비밀번호 변경
	   int result = 0;
	   PreparedStatement ps= null;

	   
	   String sql = "UPDATE member2 SET password = ? WHERE userid=?";
	   try {
		ps = con.prepareStatement(sql);
        ps.setString(1, vo.getPassword());
        ps.setString(2, vo.getUserid());
        result = ps.executeUpdate();
	   } catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(ps);
	}
	   return result;
   }
   
   public int leaveMember(String userid,String current_password) {
	   // 아이디일치하고 비밀번호 일치하면 회원 탈퇴 (삭제)
	   int result = 0;
	   PreparedStatement ps = null;
	   
	   String sql = "DELETE FROM member2 WHERE userid = ? AND password = ?";
	   try {
		ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setString(2, current_password);
		result = ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(ps);
	}
	   return result;
   }
   
   public boolean checkId(String userid) {
	   boolean flag = false;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   
	   String sql = "SELECT * FROM member2 WHERE userid=?";
	   try {
		ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		rs = ps.executeQuery();
		if(rs.next()) {
			flag=true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(ps);
	}
	   return flag;
   }
}
