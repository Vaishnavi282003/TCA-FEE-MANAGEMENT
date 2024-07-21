package com.tca.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginPageServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		String dbUrl="jdbc:postgresql://localhost/tca_project";
		String user="aniket";
		String password="212003";
		String userdb="";
		String passdb="";
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(dbUrl,user,password);
			
			ps = conn.prepareStatement("select * from com_tca_admin;");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				userdb = rs.getString(2);
				passdb = rs.getString(3);
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{	
			try 
			{
				conn.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		String username = request.getParameter("username");
		String password1 = request.getParameter("password");
		
		if(username.equals(userdb) && password1.equals(passdb))
		{
	            RequestDispatcher rd = request.getRequestDispatcher("./dashboard");
	            rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("LoginPage.html");
		}	
	}

}