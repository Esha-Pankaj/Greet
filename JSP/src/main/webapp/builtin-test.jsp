
<html>
<body>
  <h3> JSP Built-In Objects</h3>
  Request user agent: <%= request.getHeader("User-Agent") %>
  <br/><br/>
  Request language: <%= request.getLocale() %>
  
  <p>Request object example: <%= request.getHeader("User-agent") %>
</body>
</html>