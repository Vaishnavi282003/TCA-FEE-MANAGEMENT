package com.tca.dashboard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class enrollStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public enrollStudent() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		try 
		{
			Long whatsapp_num = Long.parseLong(request.getParameter("wp-number")); 
			Integer course_code = Integer.parseInt(request.getParameter("course"));
			String fee_type = request.getParameter("fee-type");
			Double amount_in_num = Double.parseDouble(request.getParameter("amount-in-num"));
			String enrollment_date = request.getParameter("date");
			String payment_type = request.getParameter("pay");
			Integer student_no = 0;
			String name_stud = "";
			Date sqlDate = Date.valueOf(enrollment_date);
		
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
				
				ps = conn.prepareStatement("select student_no, student_full_name from student_fee_details where student_whatsapp_num = ?;");
				ps.setLong(1,whatsapp_num);
				rs = ps.executeQuery();
				
				while(rs.next())
				{
					student_no = rs.getInt(1);
					name_stud = rs.getString(2);
				}
								
				ps = conn.prepareStatement("insert into student_course_details values (?,?,?,?,?,?);");
				
				ps.setInt(1,student_no);
				ps.setInt(2,course_code);
				ps.setString(3, fee_type);
				ps.setDouble(4, amount_in_num);
				ps.setDate(5, sqlDate);
				ps.setString(6, payment_type);
			
				ps.executeUpdate();
			
				String message = "Student : " + name_stud + " Enrolled For : " + course_code;
				request.setAttribute("message", message);
				request.getRequestDispatcher("./enrollStudent.jsp").forward(request, response);
				conn.close();
			}
			catch(Exception e)
			{
				String error = "Record Faild to Save for Student : " + whatsapp_num;
				request.setAttribute("error", error);
				request.getRequestDispatcher("./enrollStudent.jsp").forward(request, response);
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
