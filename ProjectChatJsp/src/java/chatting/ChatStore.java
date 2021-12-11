/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatting;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minela
 */
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatStore extends HttpServlet
{
  public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
          throws ServletException, IOException
  {
    PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
    try
    {
      paramHttpServletResponse.setContentType("text/html");
      
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
      
      String username = paramHttpServletRequest.getParameter("uname");
      String message = paramHttpServletRequest.getParameter("msg");
      SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
      SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("hh:mm:ss a");
      Date localDate = new Date();
      String date = localSimpleDateFormat1.format(localDate);
      String time = localSimpleDateFormat2.format(localDate);
      
      Statement st=con.createStatement();
      String sql = "insert into chatting(username,message,date,time) values('"+username+"','"+message+"','"+date+"','"+time+"')";
      st.executeUpdate(sql);
      st.execute("commit"); 
    }
    catch (Exception localException) {
      localException.printStackTrace();
      System.out.println("Invalid User");
    }
  }
  
  public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) 
          throws ServletException, IOException
  {
    doGet(paramHttpServletRequest, paramHttpServletResponse);
  }
}
