<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<script>
	function getBoardList() {
		location.href = '/boardList';
	}
</script>
<body>
	<h1>Main Page!</h1>
	<ul>
		<li><a href="javascript: getBoardList();">Board List</a></li>
	</ul>
</body>
</html>
