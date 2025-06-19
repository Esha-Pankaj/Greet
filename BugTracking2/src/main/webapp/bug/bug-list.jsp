<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Homepage</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<jsp:include page="../common/header2.jsp"></jsp:include>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Bugs</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Add New Bug Details</a>
			</div>
			<br>
			<table class="table table-bordered">
			
				<thead>
					<tr>
						<th>Bug Name</th>
						<th>Target Date</th>
						<th>Bug Status</th>
						<th>Bug Assigned</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bug" items="${listBug}">

						<tr>
							<td><c:out value="${bug.title}" /></td>
							<td><c:out value="${bug.targetDate}" /></td>
							<td><c:out value="${bug.status}" /></td>
							<td><c:out value="${bug.userassign}" /></td>
							<td><a href="edit?id=<c:out value='${bug.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${bug.id}' />">Delete</a></td>

							<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
