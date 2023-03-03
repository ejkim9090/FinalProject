<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
	<div>커뮤니티 페이지</div>
		<c:choose>
			<c:when test="${ empty lgnss}">
				<div>
					<button type="button" class="btn login">로그인</button>
					<button type="button" class="btn join">회원가입</button>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<button type="button" class="btn logout">로그아웃</button>
					<button type="button" class="btn myinfo">내정보</button>
				</div>
			</c:otherwise>
		</c:choose>
</section>