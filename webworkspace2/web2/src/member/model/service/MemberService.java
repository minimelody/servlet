package member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import common.JDBCTemplate;

public class MemberService {

	public Member selectOne(String userId, String userPwd) {
		Connection conn = JDBCTemplate.conn();
		Member m = new MemberDao().selectOne(conn, userId, userPwd);
		JDBCTemplate.close(conn);
		return m;
	}

	public ArrayList<Member> allMember() {
		Connection conn = JDBCTemplate.conn();
		ArrayList<Member> list = new MemberDao().allMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int activation(String activation, String userId) {
		Connection conn = JDBCTemplate.conn();
		int result = new MemberDao().activation(conn, activation, userId);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.conn();
		int result = new MemberDao().insertMember(conn,m);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}
		else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public boolean idCheck(String id) {
		Connection conn = null;
		boolean result = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","login_member","login_member");
			result = new MemberDao().idCheck(conn,id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.conn();
		int result = new MemberDao().updateMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}	
	
}
