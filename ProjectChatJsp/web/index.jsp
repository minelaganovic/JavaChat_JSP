<%-- 
    Document   : index
    Created on : Dec 7, 2021, 9:17:06 PM
    Author     : Minela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <script type="text/javascript" src="check.js"></script>
        <title>The Chat Room</title>
    <link rel="shortcut icon" href="icon.jpeg" />

    </head>
    <body>
        <div class="middle" id="result-data">
            <form autocomplete="off">
            <table>
                <tr height="80px">
                    <td class="name">Username:</td>
                    <td><input type="text" id="uname" class="textbox" autocomplete="off"></td>
                </tr>
                <br>
                <tr>
                    <td>         </td>
                    <td><input type="button" value="Login to chat" class="dugme" onclick="startchating();"></td>                 
                </tr>
                <tr> 
                    <td>         </td>
                    <td><div id="loading-icon"></div>
                    </td>
                </tr>
            </table>
            </form>
        </div>

    </body>
</html>

