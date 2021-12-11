<%-- 
    Document   : logout
    Created on : Dec 7, 2021, 9:23:51 PM
    Author     : Minela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>

    <title>::Sign out::</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="script.js"></script>
    <link rel="shortcut icon" href="icon.jpg" />

  </head>

  <body>
<% session.invalidate();%>
<center>
<h1>You are currently Signed out<br>
<a href="http://localhost:8080/ProjectChatJsp/">Login</a> to continue..
</h1>
</center>
  </body>
</html>
