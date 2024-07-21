package com.tca.dashboard;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public dashboard() {
        super();
       
    }

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
	try 
	{
		
		Integer total_students = null;
		Double total_fees = null;
		Double amountPending = null;
		Integer totalCourses = null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
	
		String dbUrl="jdbc:postgresql://localhost/tca_project";
		String user="aniket";
		String password="212003";
		
		try
		{
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(dbUrl,user,password);
			
			//total students
			ps = conn.prepareStatement("select count(*) AS total from student_fee_details;");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				total_students = rs.getInt("total");
				request.setAttribute("total_students", total_students);
			}
			
			//total fees
			ps = conn.prepareStatement("select sum(amount_in_num) as fees from student_course_details;");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				total_fees = rs.getDouble("fees");
				request.setAttribute("fees",total_fees);
			}
			
			//total amount pending
			ps = conn.prepareStatement("SELECT  sum(course_fee) AS TOTAL_AMOUNT, sum(amount_in_num) AS AMOUNT_PENDING\r\n"
					+ "FROM course_details, student_fee_details, student_course_details\r\n"
					+ "WHERE student_fee_details.student_no = student_course_details.student_no\r\n"
					+ "AND    course_details.course_code = student_course_details.course_code;");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Double courseFee = rs.getDouble(1);
				Double amountPaid = rs.getDouble(2);
				
				amountPending = courseFee - amountPaid;
				request.setAttribute("amountPending", amountPending);
			}
			
			//total courses
			ps = conn.prepareStatement("select count(*) from course_details;");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				totalCourses = rs.getInt(1);
				request.setAttribute("totalCourses", totalCourses);
			}
			
			
			request.getRequestDispatcher("./Dashboard.jsp").forward(request, response);
			 
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
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
