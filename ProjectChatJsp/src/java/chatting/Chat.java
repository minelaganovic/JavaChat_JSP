/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatting;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Chat extends javax.servlet.http.HttpServlet
{
  public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
          throws ServletException, IOException
  {
    PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
    try {
      paramHttpServletResponse.setContentType("text/html");
      
      Class.forName("com.mysql.jdbc.Driver");
      Connection localConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
      Statement localStatement = localConnection.createStatement();
      
      String str1 = paramHttpServletRequest.getParameter("uname");
      System.out.println(str1);
      String str3 = "select*from chatting where username='" + str1 + "'";
      
      ResultSet localResultSet = localStatement.executeQuery(str3);
      if (localResultSet.next())
      {
        String str4 = localResultSet.getString("username");
        HttpSession localHttpSession = paramHttpServletRequest.getSession();
        localHttpSession.setAttribute("name", str4);
      } else {
        localPrintWriter.println("Incorrect Username.");
      }
      localConnection.close();
    } catch (Exception localException) {
      localException.printStackTrace();
      System.out.println("Invalid User");
    }
  }
  
  public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
    doGet(paramHttpServletRequest, paramHttpServletResponse);
  }
}
