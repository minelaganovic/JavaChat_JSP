<%-- 
    Document   : logout
    Created on : Dec 11, 2021, 11:15:32 PM
    Author     : Minela
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logout Chat</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <script type="text/javascript" src="function.js"></script>
        <link rel="shortcut icon" href="icon.jpg" />
    </head>
    <body>
        <% session.invalidate();%>
    <center>
        <h1>You logout of the chat<a class="logout" href="http://localhost:8080/JSPChatProject/">Login</a> to continue..</h1>
    </center>
    </body>
</html>

