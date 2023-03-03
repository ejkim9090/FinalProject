<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kh.member.model.vo.MemberVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내정보 보기</h1>
	<c:if test="${empty myinfo }">
		<div>
			<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
			<a href="<%=request.getContextPath() %>/login">로그이페이지 이동</a>		
		</div>
	</c:if>
	<c:if test="${not empty myinfo }">
		id: ${myinfo.id }
		<br>
		name: ${myinfo.name }
		<br>
		email: ${myinfo.email }
	</c:if>
<%
	Object obj = request.getAttribute("myinfo");
	MemberVo vo = null;
	if(obj == null) {
%>
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
	
<%
		}
	}
%>
</body>
</html>