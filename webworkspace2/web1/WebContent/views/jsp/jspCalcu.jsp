<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int first = Integer.parseInt(request.getParameter("firstValue")); 
 	   int second = Integer.parseInt(request.getParameter("secondValue")); 
	   String cal = request.getParameter("cal"); 

		String result = "";
		switch(cal)
			{
				case "+" : 
					result = (first + second) + "";
					break;
				case "-" : 
					result = (first - second) + "";
					break;
				case "*" : 
					result = (first * second) + "";
					break;
				case "/" : 
					result = ((double)first / second) + "";
					break;
			}%>
		<%=first + cal + second + "=" + result %>
</body>
</html>