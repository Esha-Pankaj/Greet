<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Bug Details</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>

</head>
<body style="background-color:#DEF2F1">
	<jsp:include page="../common/header3.jsp"></jsp:include>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${bug != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${bug == null}">
					<form action="insert" method="post">
				</c:if>

				<c:if test="${bug != null}">
					<input type="hidden" name="id" value="<c:out value='${bug.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Bug Name</label> <input type="text"
						value="<c:out value='${bug.title}' />" class="form-control"
						name="title" required="required" minlength="1">
				</fieldset>

				<fieldset class="form-group">
					<label>Bug Assigned</label> <input type="text"
						value="<c:out value='${bug.userassign}' />" class="form-control"
						name="userassign" minlength="1">
				</fieldset>

				<fieldset class="form-group">
					<label>Bug Status</label> <select class="form-control"
						name="isDone">
						<option value="Not Assigned">Not Assigned</option>
						<option value="In progress">In Progress</option>
						<option value="Completed">Complete</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Target Date</label> <input type="date"
						value="<c:out value='${bug.targetDate}' />" class="form-control"
						name="targetDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
