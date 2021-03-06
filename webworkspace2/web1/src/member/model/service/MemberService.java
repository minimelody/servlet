package member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	public MemberService() {} //디폴트 생성자
	
	public Member selectMember(String userId,String userPwd)
	{
		Connection conn = null;
		Member m = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","login_member","login_member");
			m = new MemberDao().selectMember(conn,userId,userPwd);
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
		return m;	
	}
	
	public boolean updateMember(Member m)
	{
		Connection conn = null;
		boolean chk=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","login_member","login_member");
			chk = new MemberDao().updateMember(conn,m);
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
		return chk;
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
	
	public boolean insertMember(Member m)
	{
		Connection conn = null;
		boolean result = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","login_member","login_member");
			result = new MemberDao().insertMember(conn,m);
			System.out.println("회원가입 확인"+result);
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
	
	public boolean memberDelete(String id)
	{
		Connection conn = null;
		boolean result = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","login_member","login_member");
			result = new MemberDao().deleteMember(conn,id);
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
}
