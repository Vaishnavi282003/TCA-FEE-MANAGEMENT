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

public class editCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public editCourse() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	response.setContentType("text/html");
		
	try 
	{
		Integer course_code = Integer.parseInt(request.getParameter("cid"));
		String course_name = request.getParameter("cname");
		Double course_fee = Double.parseDouble(request.getParameter("cfees"));
		String action = request.getParameter("submit");

	
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
		  
			  if(action.equals("Add"))
			  {
				  ps = conn.prepareStatement("insert into course_details values(?,?,?);");
				  try
				  {
					  if(course_name != null && course_fee != null)
					  {
						  ps.setInt(1, course_code);
						  ps.setString(2, course_name);
						  ps.setDouble(3, course_fee);
				  
						  ps.executeUpdate();
						  String recordInserted = "Course Added : " + course_name ;
						  request.setAttribute("add", recordInserted);
						  request.setAttribute("courseCode", course_code);
						  request.setAttribute("courseName", course_name);
						  request.setAttribute("courseFee", course_fee);
					  }
					  else
					  {
						  String warning = "Enter All Fields";
						  request.setAttribute("adderror", warning);
					  }
					  request.getRequestDispatcher("./editCourse.jsp").forward(request, response);
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
					  String editexception = "Error : " + course_code ;
					  request.setAttribute("editexception", editexception);
					  request.getRequestDispatcher("./editCourse.jsp").forward(request, response);
				  }
			  }
			  else if(action.equals("Update"))
			  {
				  Integer sqlCourse_code = null;
				  ps = conn.prepareStatement("select * from course_details where course_code = ?;");
				  ps.setInt(1,course_code);
				  rs = ps.executeQuery();
				  
				  while(rs.next())
				  {
					sqlCourse_code =  rs.getInt(1);
				  }
				  
				  if(course_code.equals(sqlCourse_code))
				  {
					  		  
					  ps = conn.prepareStatement("Update course_details SET course_name = ? , course_fee = ? WHERE course_code = ?;");
					  try
					  {
						  if(course_name != null && course_fee != null)
						  {
							  ps.setString(1, course_name);
							  ps.setDouble(2, course_fee);
							  ps.setInt(3, course_code);
				  
							  ps.executeUpdate();
							  String recordInserted = "Course Updated : " + course_name ;
							  request.setAttribute("update", recordInserted);
							  request.setAttribute("courseCode", course_code);
							  request.setAttribute("courseName", course_name);
							  request.setAttribute("courseFee", course_fee);
						  }
						  else
						  {
							  String warning = "Enter fields to update";
						  		request.setAttribute("updateerror", warning);
						  }
						 request.getRequestDispatcher("./editCourse.jsp").forward(request, response);
					  }
					  catch(Exception e)
					  {
						  e.printStackTrace();
						  String editexception = "Error : " + course_code ;
						  request.setAttribute("editexception", editexception);
						  request.getRequestDispatcher("./editCourse.jsp").forward(request, response);
					  }
				  }
				  else
				  {
					  String doesNotExist = "Does not exist : " + course_code ;
					  request.setAttribute("doesNotExist", doesNotExist);
					  request.getRequestDispatcher("./editCourse.jsp").forward(request, response);
				  }
			  }
			  else if(action.equals("Delete"))
			  {
				  Integer sqlCourse_code = null;
				  String deleteRecordName = null;
				  ps = conn.prepareStatement("select * from course_details where course_code = ?;");
				  ps.setInt(1,course_code);
				  rs = ps.executeQuery();
				  
				  while(rs.next())
				  {
					sqlCourse_code =  rs.getInt(1);
				  }
				  
				  if(course_code.equals(sqlCourse_code))
				  {
					  ps = conn.prepareStatement("DELETE FROM course_details WHERE course_code = ? returning course_name;");
					  ps.setInt(1,course_code);
					  rs = ps.executeQuery();
					  while(rs.next())
					  {
						  deleteRecordName = rs.getString(1);
					  }
					  String deletedCourse = "Course Deleted : " + deleteRecordName ;
					  request.setAttribute("delete", deletedCourse);
				  }
				  else
				  {
					  String doesNotExist = "Does not exist : " + course_code ;
					  request.setAttribute("doesNotExist", doesNotExist);
				  }
				  request.getRequestDispatcher("./editCourse.jsp").forward(request, response);
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
	} 
	catch(Exception e)
	{
				e.printStackTrace();
				String addexception = "Something Went Wrong !! " ;
				request.setAttribute("addexception", addexception);
				request.getRequestDispatcher("./editCourse.jsp").forward(request, response);
	}

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
