<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<style>
	ul {
		list-style:none;
	}
	
	li {
		display: inline;
		padding: 10px;
	}
</style>
</head>
<body>
	LIST CNT : 
	<select id="pageUnit" onchange="javascript: pagination('1');">
		<option value="10" <c:if test="${pageUnit eq '10'}">selected</c:if>>10</option>
		<option value="30" <c:if test="${pageUnit eq '30'}">selected</c:if>>30</option>
		<option value="50" <c:if test="${pageUnit eq '50'}">selected</c:if>>50</option>
		<option value="100" <c:if test="${pageUnit eq '100'}">selected</c:if>>100</option>
		<option value="200" <c:if test="${pageUnit eq '200'}">selected</c:if>>200</option>
		<option value="300" <c:if test="${pageUnit eq '300'}">selected</c:if>>300</option>
		<option value="500" <c:if test="${pageUnit eq '500'}">selected</c:if>>500</option>
	</select>
	<br> <br> <br>
	TITLE
	<hr>
	<c:forEach items="${boardList}" var="list">
		<div>
			<c:out value="${list.title}" />
		</div>
	</c:forEach>
	<br> <br> <br>
	<ul>
		<c:if test="${startPage ne 1}">
			<li><a href="javascript: pagination('1');">&lt;&lt;</a></li>
			<li><a href="javascript: pagination('${startPage - 1}');">&lt;</a></li>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:choose>
				<c:when test="${i eq cp}">
					<li style="color: red;">${i}</li>
				</c:when>
				<c:otherwise>
					<li><a href="javascript: pagination('${i}');">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${cp ne finalPage && finalPage > 10}">
			<li><a href="javascript: pagination('${endPage + 1}');">&gt;</a></li>
			<li><a href="javascript: pagination('${finalPage}');">&gt;&gt;</a></li>
		</c:if>
	</ul>
	
	<script>
	function pagination(page) {
		var title = ''; 
		var pageUnit = document.getElementById('pageUnit').value;
		location.href = '/boardList?title=' + title + '&cp=' + page + '&pageUnit=' + pageUnit;
	}
	</script>
</body>
</html>
