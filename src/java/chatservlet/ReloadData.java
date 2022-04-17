/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minela
 */
public class ReloadData extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    try
    {
      response.setContentType("text/html");      
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
      String query = "select*from chatting";
      PreparedStatement localPreparedStatement = con.prepareStatement(query);      
      ResultSet localResultSet = localPreparedStatement.executeQuery();
      
      while (localResultSet.next()) {
        String username = localResultSet.getString(1);
        String message = localResultSet.getString(2);
        String date= localResultSet.getString(3);
        String time= localResultSet.getString(4);
        PrintWriter printwriter = response.getWriter();
        printwriter.print("<p>" + username+ "-<g>" + message + "</g><br><small>" + date+ " " + time + "</small></p>");
      }
      con.close();
    }
    catch (Exception localException){
      localException.printStackTrace();
      System.out.println("Something went wrong");
    }
    }
    public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException{
    doGet(paramHttpServletRequest, paramHttpServletResponse);
  }
}
