<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>This page is SIGN_UP.</h3>
	
	<form action="/hello/signUpconfirm">
		ID : <input type="text" name="m_id"><br>
		PW : <input type="password" name="m_pw"><br>
		NAME : <input type="text" name="m_name">
		<input type="submit" value="Sign Up">
		<input type="reset" value="Cancel">
	</form>
</body>
</html>