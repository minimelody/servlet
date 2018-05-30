<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" %>
<% Member m = (Member)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 페이지</title>
</head>
<body>
<% if(m==null) {%>
	<fieldset>
		<legend>로그인</legend>
		<form action="login" method="post" style="display:inline;">
			ID : <input type="text" placeholder="ID를 입력하세요" name="userId"><br>
			PW : <input type="password" placeholder="PW를 입력하세요" name="userPwd"><br>
			<input type="submit" value="로그인">
		</form>
		<a href="views/member/joinus.html">회원가입</a>
		<a href="">ID 찾기</a> / 
		<a href="">PW 찾기</a>
	</fieldset>
<% }else{ %>
	[<%=m.getUserName() %>]님 환영 합니다<br>
	<lable onclick="myInfo();" id="infoBtn">마이페이지</lable>
	<form action="myPage" method="post" style="display:none;" id="myInfo">
		<label style="color:red;">비밀번호 입력 : </label>
		<input type="password" name="userPwd">
		<input type="submit" value="확인">
	</form>
	<br>
	<a href="logout">로그아웃</a><br>
	<a href="delete">회원탈퇴</a><br>
	<% if(m.getUserId().equals("admin")){%>
		<a href="allMember">전체회원조회</a>
	<% } %>
<% } %>
	<br>
	<a href="/notice">공지사항</a>
	<style>
		#infoBtn{
			cursor:pointer;
			text-decoration:underline;
			color:blue;
		}
	</style>
	<script>
		function myInfo(){
			document.getElementById("myInfo").style="display:inline";
		}
	</script>
</body>
</html>