<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 작성</title>
</head>
<body>
<form action="/noticeWrite" method="post">
	제목 : <input type="text" name="subject" size=92><br>
	<textarea rows="20" cols="100" name="contents" style="resize:none;"></textarea>
	<input type="submit" value="제출">
	<button type="button" onclick="back();">목록</button>
</form>
<script>
	function back(){
		history.go(-1);
	}
</script>
</body>
</html>