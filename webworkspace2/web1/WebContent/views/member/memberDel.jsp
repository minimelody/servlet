<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
<%@ page import="member.model.vo.*" 
		import="member.model.service.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  <% 
	String inputPass = request.getParameter("userPwd");
	String sessionPass = ((Member)session.getAttribute("user")).getMemberPwd;
	if(inputPass == sessionPass)
	{
		int result = new MemberService().memberDelete(id);
		if(result>0)
		{
			out.println("<h1 탈퇴 정상 처리 되었습니다.</h1>");
		}
		else
		{
			out.println("<h1>탈퇴 실패 처리 되었습니다.</h1>");
		}
	}else{
		out.println("<h1>비밀번호가 맞지 않습니다.</h1>");
%>

<%
	String inputPass = request.getParameter("userPwd");
	String sessionPass = session.getAttribute("user");
	if(inputPass == sessionPass)
	{
		
	}else{
%>
		<h1>비밀번호가 같지 않습니다. 재확인 바랍니다.</h1>
<% 	}
	%>

-->



<script>
	function delCheck()
	{
		var userPwd = document.getElementById('userPwd').value;
		<%Member m = (Member)session.getAttribute("user"); 
			String pwd = m.getMemberPwd();
			String id = m.getMemberId();
		%>
		
		
		if(userPwd==<%=pwd%>)
		{
			if(window.confirm("정말 탈퇴하시겠습니까?"))
			{
				<%
				boolean result = new MemberService().memberDelete(id);
				%>
				var result = <%=result%>;
				
				if(result==true)
				{
					alert("회원 탈퇴에 성공하셨습니다.");
					<%
						session.invalidate();
					%>
					location.href="/web1/views/member/memberIndex.html";
				}else
				{
					alert("회원 탈퇴에 실패하셨습니다.");
					location.href="/web1/views/member/memberIndex.html";
				}
				
			}else
			{
				alert("탈퇴 취소하셨습니다.")
			}
			
			
		}else
		{
			alert("비밀번호가 맞지 않습니다.");
		}
		
		
	}
	
</script>

<center>
		<h1>회원탈퇴</h1>
		비밀번호 입력 : <input type="password" id="userPwd">
		<button onclick="delCheck()">확인</button>
</center>


</body>
</html>











