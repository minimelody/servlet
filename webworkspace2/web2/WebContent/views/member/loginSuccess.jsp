<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" %>
<% Member m = (Member)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	window.onload = function(){
		if(opener!=null){
			//자신이 팝업창 일때
			opener.location.reload();
			window.close();
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공</h1>
	[<%=m.getUserName() %>]님 환영 합니다<br>
	<a href="../../index.jsp">메인페이지로 이동</a>	
</body>
</html>