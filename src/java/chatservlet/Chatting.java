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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minela
 */
public class Chatting extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException{
        PrintWriter printwriter = response.getWriter();
        try
        {
            response.setContentType("text/html");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
      
            String username = request.getParameter("uname");
            String message = request.getParameter("msg");
            SimpleDateFormat sdtf1 = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat sdtf2 = new SimpleDateFormat("hh:mm:ss a");
            Date localDate = new Date();
            String date = sdtf1.format(localDate);
            String time = sdtf2.format(localDate);
      
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException{
        doGet(request, response);
    }
}
