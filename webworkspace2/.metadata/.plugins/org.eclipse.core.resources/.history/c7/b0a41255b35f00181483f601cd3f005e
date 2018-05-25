<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" import="java.util.ArrayList"%>
<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("userList"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	function goback(){
		history.go(-1);
	}
</script>
<h1>관리자 : 회원 관리 페이지</h1>
<table border="1">
	<tr>
		<th>ID</th><th>이름</th><th>나이</th><th>이메일</th><th>휴대폰</th><th>주소</th><th>성별</th><th>취미</th><th>가입날짜</th><th>활성화</th>
	</tr>
	<% for(Member m : list){ %>
	<tr>
		<td><%=m.getUserId() %></td><td><%=m.getUserName() %></td><td><%=m.getAge() %></td>
		<td><%=m.getEmail() %></td><td><%=m.getPhone() %></td><td><%=m.getAddress() %></td>
		<td><%=m.getGender() %></td><td><%=m.getHobby() %></td><td><%=m.getEnrolldate() %></td>
		<td>
			<form action="memberActivation" method="post">
				<input type="hidden" value="<%=m.getActivation() %>" name="active">
				<input type="hidden" value="<%=m.getUserId() %>" name="userId">
				<input type="submit" value="<%=m.getActivation() %>" style="width:100%;">
			</form>
		</td>
	</tr>
	<% } %>
</table>
<button onclick="goback();">이전 페이지로</button>
</body>
</html>