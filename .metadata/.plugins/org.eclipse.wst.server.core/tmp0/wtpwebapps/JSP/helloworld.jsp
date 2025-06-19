<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple JSP Example</title>
</head>
<body>
   <h3> Hello World of Java</h3>
   The time on the server is <%= new java.util.Date() %>
   
   <br/><br/>
   
   Converting a string to upper case: <%=  new String("Hello World").toUpperCase() %>
   <br/><br/>
   25 multiplied by 4 equals <%= 25*4 %>
</body>
</html>
