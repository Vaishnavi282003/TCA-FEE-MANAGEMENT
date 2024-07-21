package com.tca.dashboard;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class viewAllCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public viewAllCourses() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("./HomePage.jsp");
		rd.include(request, response);
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title> View Courses </title>\r\n"
				+ "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n"
				+ "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n"
				+ "    <link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap\" rel=\"stylesheet\">\r\n"
				+ "    <style>\r\n"
				+ ".main\r\n"
				+ "{\r\n"
				+ "    margin-top: 100px;\r\n"
				+ "}\r\n"
				+ ".container\r\n"
				+ "{\r\n"
				+ "    max-width: 700px;\r\n"
				+ "    height: 90%;\r\n"
				+ "    width: 100%;\r\n"
				+ "    background: #fff;\r\n"
				+ "    padding: 25px 30px;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "}\r\n"
				+ ".container .title\r\n"
				+ "{\r\n"
				+ "    font-size: 25px;\r\n"
				+ "    font-weight: 500;\r\n"
				+ "    position: relative;\r\n"
				+ "}\r\n"
				+ ".container .title::before\r\n"
				+ "{\r\n"
				+ "    content: '';\r\n"
				+ "    position: absolute;\r\n"
				+ "    left: 0;\r\n"
				+ "    bottom: 0;\r\n"
				+ "    height: 3px;\r\n"
				+ "    width: 180px;\r\n"
				+ "    background: linear-gradient(135deg, rgb(104, 104, 241), rgb(11, 11, 66));\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "*{\r\n"
				+ "    margin: 0;\r\n"
				+ "    padding: 0;\r\n"
				+ "    box-sizing: border-box;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".table thead tr th{\r\n"
				+ "    font-size: 16px;\r\n"
				+ "    font-weight: 600;\r\n"
				+ "    letter-spacing: 0.45;\r\n"
				+ "    color:rgb(255, 255, 255);\r\n"
				+ "    opacity: 1;\r\n"
				+ "    padding: 35px;\r\n"
				+ "    padding-bottom: 10px;\r\n"
				+ "    padding-top: 10px;\r\n"
				+ "    border: 1px solid ;\r\n"
				+ "    background-color: rgb(11, 11, 66);\r\n"
				+ "}\r\n"
				+ ".table tbody tr td{\r\n"
				+ "    font-size: 15px;\r\n"
				+ "    font-weight: 600;\r\n"
				+ "    letter-spacing: 0.35;\r\n"
				+ "    color: black;\r\n"
				+ "    background-color: white;\r\n"
				+ "    padding: 35px;\r\n"
				+ "    padding-bottom: 10px;\r\n"
				+ "    padding-top: 10px;\r\n"
				+ "    border: 1px solid #000000fe;\r\n"
				+ "}\r\n"
				+ ".table{\r\n"
				+ "    margin-top: 30px;\r\n"
				+ "    width: 640px;\r\n"
				+ "    height: 200px;\r\n"
				+ "    border-collapse: collapse;\r\n"
				+ "    padding: 200 500px;\r\n"
				+ "}\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<div class=\"main\">\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        <div class=\"title\"> Course Details </div>");
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
	
		Integer course_code = null;
		String course_name = null;
		Double course_fee = null;
		
		String dbUrl="jdbc:postgresql://localhost/tca_project";
		String user="aniket";
		String password="212003";
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(dbUrl,user,password);
			
			ps = conn.prepareStatement("select * from course_details order by course_code;");
			
			rs = ps.executeQuery();
			
			out.println("<table class=\"table table-hover\">\r\n"
					+ "            <thead>\r\n"
					+ "              <th>Course Code</th>\r\n"
					+ "              <th>Course name</th>\r\n"
					+ "              <th>Course Fees</th>\r\n"
					+ "            </thead>\r\n"
					+ "            <tbody>");
			
			while(rs.next())
			{
				course_code = rs.getInt(1);
				course_name = rs.getString(2);
				course_fee = rs.getDouble(3);
				
				out.println("<tr>\r\n"
						+ "            <td> " + course_code + "</td>\r\n"
						+ "            <td> " + course_name + " </td>\r\n"
						+ "            <td> " + course_fee + " </td>\r\n"
						+ "        </tr>");
			}
			
			out.println("</tbody>\r\n"
					+ "            </table>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "</div>\r\n"
					+ "    \r\n"
					+ "</body>\r\n"
					+ "</html>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
