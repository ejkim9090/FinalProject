<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="signUp" method="post">
		<input type="text" name="id" placeholder="id">
		<input type="password" name="passwd" placeholder="passwd">
		<input type="text" name="name" placeholder="name">
		<input type="text" name="email" placeholder="email">
		<button type="submit">제출</button>
	</form>
</body>
</html>