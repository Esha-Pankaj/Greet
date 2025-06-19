<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-color:#DEF2F1">
	<jsp:include page="../common/header2.jsp"></jsp:include>
	<h1 style="text-align:center">BUG TRACKER</h1>
	<div class="button" style="padding:50px;text-align:center">
		<a href="<%=request.getContextPath()%>/list"
					class="btn btn-success">List of Bugs</a>
	</div>
	
	<div class="button" style="padding:10px; text-align:center">
		<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Add New Bug Details</a>
	</div>

</body>
</html>