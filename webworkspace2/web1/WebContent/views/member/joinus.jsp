<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" import="member.model.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Member m = new Member();
		request.setCharacterEncoding("utf-8");
		m.setMemberId(request.getParameter("userId"));
		m.setMemberPwd(request.getParameter("userPwd"));
		m.setMemberName(request.getParameter("userName"));
		m.setMemberAge(Integer.parseInt(request.getParameter("userAge")));
		m.setMemberAddr(request.getParameter("userAddr"));
		boolean result = new MemberService().insertMember(m);
		if(result==true)
		{
	%>
			<h1>회원가입을 성공하였습니다.</h1>
	<% }else{%>
			<h1>회원가입에 실패하였습니다.</h1>
	<% } %>
<a href="/web1/views/member/memberIndex.html">로그인 페이지로 이동</a>

</body>
</html>