package member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.domain.MemberVO;
import static member.persistence.JDBCUtil.*;

public class MemberDAO {

	private Connection conn;

	public MemberDAO(Connection conn) {
		this.conn = conn;
	}

	// DML 담당
	public int insert_member(MemberVO vo) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = "insert into member values(member_id_seq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getAddr());
			ps.setString(3, vo.getNation());
			ps.setString(4, vo.getEmail());
			ps.setInt(5, vo.getAge());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int modify_member(MemberVO vo) {
		// 이름, 주소 : 이름이 일치한 사람의 주소를 변경
		int result = 0;
		PreparedStatement ps = null;
		String sql = "update member set addr = ? where name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getAddr());
			ps.setString(2, vo.getName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int remove_member() {
		int result = 0;

		return result;
	}

	// 조회 select one
	public MemberVO getMember(String name) {
		return null;
	}

	// 조회 select all
	public ArrayList<MemberVO> getMembers() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setAddr(rs.getString(3));
				vo.setNation(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setAge(rs.getInt(6));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return list;
	}
}
