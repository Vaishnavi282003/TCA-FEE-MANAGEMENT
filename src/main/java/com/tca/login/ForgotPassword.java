package com.tca.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ForgotPassword() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		response.setContentType("text/html");
	try
	{		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		String dbUrl="jdbc:postgresql://localhost/tca_project";
		String user="aniket";
		String password="212003";
		String userdb="";
		
		String for_username = request.getParameter("for-username");
		String for_password = request.getParameter("for-password");
		String for_re_password = request.getParameter("for-re-password");
		
		try
		{
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(dbUrl,user,password);
			
			ps = conn.prepareStatement("select * from com_tca_admin;");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				userdb = rs.getString(2);
			}
			
			if(for_username.equals(userdb) && for_password.equals(for_re_password))
			{
				try 
				{
					ps =  conn.prepareStatement("UPDATE com_tca_admin SET password = ? WHERE admin_username = ?;");
					ps.setString(1, for_re_password);
					ps.setString(2, for_username);
					ps.executeUpdate();
					String message = "PASSWORD UPDATED !!";
					request.setAttribute("message", message);
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					String error = "FAILED TO UPDATE PASSWORD !!";
					request.setAttribute("error", error);
				}
			}
			else
			{
				String error = "FAILED TO UPDATE PASSWORD !!";
				request.setAttribute("error", error);
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
				request.getRequestDispatcher("./ForgotPassword.jsp").forward(request, response);
				conn.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}	

	}
	catch(Exception e)
	{
		e.printStackTrace();
		String error = "FAILED TO UPDATE PASSWORD !!";
		request.setAttribute("error", error);
		request.getRequestDispatcher("./ForgotPassword.jsp").forward(request, response);
	}
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
