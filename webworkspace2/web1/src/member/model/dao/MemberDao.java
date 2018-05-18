package member.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import member.model.vo.Member;

public class MemberDao {

	public Member selectMember(Connection conn, String userId, String userPwd) {
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM member WHERE MEMBER_ID = '" + userId + "' AND MEMBER_PWD = '" + userPwd + "'";
		
		Member m = new Member();
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next())
			{
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberAddr(rset.getString("member_addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return m;
	}
	
}
