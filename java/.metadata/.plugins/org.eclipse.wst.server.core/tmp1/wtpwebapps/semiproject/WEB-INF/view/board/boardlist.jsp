<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
	<c:if test="${not empty lgnss }">	
		<span>${lgnss.getId() }님 접속중</span>
	</c:if>
	<h1>자유게시판</h1>
	<table border="1" style="text-align: center">
		<tr>
			<td>게시글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${boardlist }" var="vo" varStatus="s">
			<tr>
				<td>${vo.boardId }</td>
				<td><a href="<%=request.getContextPath() %>/boardcontent?id=${vo.boardId }" style="text-decoration: none">${vo.title }</a></td>
				<td>${vo.boardUser }</td>
				<td>${vo.submitDate }</td>
				<td>${vo.readCount }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:if test="${not empty lgnss }">
		<button type="button" class="btn insertBoard">게시글 작성</button>
	</c:if>
	<br>
	<div>
		<c:if test="${startPageNum > 1 }">
			<span>이전</span>
		</c:if>
		<c:forEach begin="${startPageNum }" end="${endPageNum }" step="1" var="page">
			<c:choose>
				<c:when test="${page == currentPage }">
					<span><b>${page }</b></span>
				</c:when>
				<c:otherwise>
					<span><a href="<%=request.getContextPath() %>/?pg=${page}">${page }</a></span>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${endPageNum < pageCnt }">
			<span>이전</span>
		</c:if>
	</div>
</section>
<script>
	$(".btn.insertBoard").on("click", handlerClickInsertBoard);
	
	function handlerClickInsertBoard() {
		console.log("게시판작성");
		location.href="<%=request.getContextPath() %>/insertboard";
	}
</script>