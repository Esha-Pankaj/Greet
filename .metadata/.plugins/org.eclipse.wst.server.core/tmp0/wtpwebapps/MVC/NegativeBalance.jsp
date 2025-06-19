<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="badCustomer" type="com.abc.BankCustomer" scope="request" />
    Watch out, ${badCustomer.firstName}, we know where you live.
    
   
      Pay us the $<jsp:getProperty name="badCustomer" property="balanceNoSign" />
      you owe us before it is too late!
</body>
</html>