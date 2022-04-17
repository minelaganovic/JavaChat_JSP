<%-- 
    Document   : chat
    Created on : Dec 11, 2021, 11:16:02 PM
    Author     : Minela
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%if(session.getAttribute("name")==null)
  response.sendRedirect("/chatting");
%>

<html>
    <%String uname=(String)session.getAttribute("name"); %>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <script type="text/javascript" src="function.js"></script>
        <title>The Chat</title>
        <link rel="shortcut icon" href="icon.jpeg" />
        <script>
            setInterval(reloaddata, 3000);
        </script>
    </head>
    <body>
        <table>
            <tr>
                <td><h1 id="result">Welcome to chat,<%=uname%></h1></td>
                <td><div class="logout-div" align="center"><a href="logout.jsp" class="logout-chat">Logout</a></div></td>
            </tr>
        </table>
                <div id="list">
                    <div id="content"></div>
                    <input style="display: none" type="text" id="u" value="<%=uname%>">
                    <textarea id='h' style="width: 100%; height: 20%;"></textarea>
                    <input type="button" style="background-color: lightblue;margin-left: 500px; border: 2psx solid black; color: black; font-size: 24px; width:200px; height: 39px;" value="send" onclick="addText()" />
                </div>
    </body>
</html>

