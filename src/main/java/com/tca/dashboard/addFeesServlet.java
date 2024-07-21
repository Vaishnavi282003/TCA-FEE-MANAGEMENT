package com.tca.dashboard;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class addFeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public addFeesServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		try 
		{
			String name = request.getParameter("Name");
			String email = request.getParameter("email");
			Long phone_num = Long.parseLong(request.getParameter("phn-number"));
			Long whatsapp_num = Long.parseLong(request.getParameter("wp-number"));
		
			Connection conn=null;
			PreparedStatement ps=null;
		
			String dbUrl="jdbc:postgresql://localhost/tca_project";
			String user="aniket";
			String password="212003";
		
			try 
			{
				Class.forName("org.postgresql.Driver");
				conn=DriverManager.getConnection(dbUrl,user,password);
			
				ps = conn.prepareStatement("insert into student_fee_details(student_full_name,student_email,student_phone_num,student_whatsapp_num) values(?,?,?,?);");
				
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setLong(3, phone_num);
				ps.setLong(4, whatsapp_num);
			
				ps.executeUpdate();
			
				String message = "Record for Saved For : " + name;
				request.setAttribute("message", message);
				request.getRequestDispatcher("./addFees.jsp").forward(request, response);
				conn.close();
			}
			catch(Exception e)
			{
				String error = "Record Faild to Save for Student : " + name;
				request.setAttribute("error", error);
				request.getRequestDispatcher("./addFees.jsp").forward(request, response);
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
		}
		catch(Exception e)
		{
			String error = "Invalid Input !!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("./addFees.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
