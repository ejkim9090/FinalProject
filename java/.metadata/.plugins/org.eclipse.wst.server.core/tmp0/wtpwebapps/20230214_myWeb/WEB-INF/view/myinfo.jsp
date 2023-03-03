<%@page import="kh.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
내정보 보기
<%
	Object obj = request.getAttribute("myinfo");
	MemberVo vo = null;
	if(obj == null) {
%>
	<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
	<a href="<%=request.getContextPath() %>/login">로그이페이지 이동</a>
<%
	} else {
		if(obj instanceof MemberVo){
			vo = (MemberVo)obj;
		}
		if(vo == null) {
%>
		<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
		<a href="<%=request.getContextPath() %>/login">로그인페이지 이동</a>
	<%
		} else {		
	%>
	id: <%=vo.getId() %>
	<br>
	pw: <%=vo.getName() %>
	<br>
	email: <%=vo.getEmail() %>
<%
		}
	}
%>
id
email
name
pw
</body>
</html>