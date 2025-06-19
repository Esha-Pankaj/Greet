<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation Title</title>
</head>
<body>
  The student is confirmed: ${param.firstName}  ${ param.lastName}
  <br/><br/>
  Favorite programming language: <br/>
  
  <ul>
     
     <% 
     String[] store = request.getParameterValues("favoriteLanguage");
     
     for(String i:store){
     out.println("<li>"+i+"</li>");
     }
     
     %>
  
  </ul>
</body>
</html>