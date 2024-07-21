package com.tca.dashboard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class viewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public viewReport() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
	try
	{
		Integer courseCode = Integer.parseInt(request.getParameter("course"));
		String fileName = request.getParameter("file");
		String option = request.getParameter("Submit");
		
		if(option.equals("Export to Excel"))
		{
			Integer student_no = null;
			String name = null;
			String email = null;
			Long phone_num = null;
			Long wp_num = null;
			Integer course_code = null;
			String course_name = null;
			Double course_fee = null;
			String fee_type = null;
			Double amount_paid = null;
			Date sqldate = null;
			String payment_mod = null;
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String dbUrl="jdbc:postgresql://localhost/tca_project";
			String user="aniket";
			String password="212003";
			
			try
			{
				Class.forName("org.postgresql.Driver");
				conn=DriverManager.getConnection(dbUrl,user,password);
				
				ps = conn.prepareStatement("SELECT *\r\n"
						+ "FROM course_details, student_fee_details, student_course_details\r\n"
						+ "WHERE student_fee_details.student_no = student_course_details.student_no\r\n"
						+ "AND    course_details.course_code = student_course_details.course_code\r\n"
						+ "AND course_details.course_code = ?;");
				
				ps.setInt(1,courseCode);
				rs = ps.executeQuery();
				
				File file = new File("D:\\Aniket\\STUDY\\JAVA THE KING\\WEB eclipse\\WebEclipse-Projects\\TCA-FEE-MANAGEMENT\\src\\main\\resources\\"+ fileName +".csv");
				FileWriter fw = new FileWriter(file);
				fw.append("Student No, Student Name, Student email, Student Contact, WhatsApp, Course Code, Course Name, Course Fee, Fee Type, Amount Paid, Payment Mode, Date");
				
				
				while(rs.next())
				{
					course_code = rs.getInt(1);
					course_name = rs.getString(2);
					course_fee = rs.getDouble(3);
					student_no = rs.getInt(4);
					name = rs.getString(5);
					email = rs.getString(6);
					phone_num = rs.getLong(7);
					wp_num = rs.getLong(8);
					fee_type = rs.getString(11);
					amount_paid = rs.getDouble(12);
					sqldate = rs.getDate(13);
					payment_mod = rs.getString(14);
		            String formattedDate = formatter.format(sqldate);
		            
		           fw.append("\n" + student_no + "," + name + "," + email + "," + phone_num + "," + wp_num + "," + course_code + "," + course_name + "," + course_fee + "," + fee_type + "," + amount_paid + "," + payment_mod + "," + formattedDate); 
				}
				String message = "File : " + fileName + ".csv created Successfully !!";
				request.setAttribute("file",message);
				fw.close();
				conn.close();
    		}
    		catch(Exception e)
    		{
    			String error = "File : " + fileName + ".csv Failed !!";
				request.setAttribute("file",error);
    			e.printStackTrace();
    			try 
    			{
    				conn.close();
    			} 
    			catch (SQLException e1) 
    			{
    				e1.printStackTrace();
    			}
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
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		request.getRequestDispatcher("./viewReport.jsp").forward(request, response);
	}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
