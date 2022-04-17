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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Minela
 */
public class userLogin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter printwriter =response.getWriter();
        try {
        response.setContentType("text/html");     
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
        Statement localStatement = con.createStatement();
        String username = request.getParameter("uname");
        System.out.println(username);
        String query = "select*from chatting where username='" + username + "'";       
        ResultSet localResultSet = localStatement.executeQuery(query);
        
        if (localResultSet.next()){
            String uname= localResultSet.getString("username");
            HttpSession localHttpSession = request.getSession();
            localHttpSession.setAttribute("name",uname);
        }
        else{
            printwriter.println("Incorrect Username.");
        }
        con.close();
        }catch (Exception localException){
            localException.printStackTrace();
            System.out.println("Invalid User");
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    doGet(request, response);
  }
}
