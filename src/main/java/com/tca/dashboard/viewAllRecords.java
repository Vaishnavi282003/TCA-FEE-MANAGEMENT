package com.tca.dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class viewAllRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public viewAllRecords() {
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
				+ "    <title>Document</title>\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n"
				+ "    <style>\r\n"
				+ ".container\r\n"
				+ "{\r\n"
				+ "    margin: 0px;\r\n"
				+ "    padding-top: 100px;\r\n"
				+ "}\r\n"
				+ "\r\n"
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
				+ "    margin-top: 5px;\r\n"
				+ "    height: 3px;\r\n"
				+ "    width: 180px;\r\n"
				+ "    background: linear-gradient(135deg, rgb(104, 104, 241), rgb(11, 11, 66));\r\n"
				+ "}\r\n"
				+ ".search {\r\n"
				+ "    display: inline-block;\r\n"
				+ "    position: relative;\r\n"
				+ "  }\r\n"
				+ "  \r\n"
				+ "  .search input[type=\"text\"] {\r\n"
				+ "    margin-top: 30px;\r\n"
				+ "    width: 700px;\r\n"
				+ "    padding: 10px;\r\n"
				+ "    border: none;\r\n"
				+ "    border-radius: 20px;\r\n"
				+ "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
				+ "  }\r\n"
				+ "  \r\n"
				+ "  .search button[type=\"submit\"] \r\n"
				+ "  {\r\n"
				+ "    margin-top: 30px;\r\n"
				+ "    background-color: #111156;\r\n"
				+ "    border: none;\r\n"
				+ "    color: #fff;\r\n"
				+ "    cursor: pointer;\r\n"
				+ "    padding: 10px 20px;\r\n"
				+ "    border-radius: 20px;\r\n"
				+ "    box-shadow: 0 0 10px rgb(31, 19, 121);\r\n"
				+ "    position: absolute;\r\n"
				+ "    top: 0;\r\n"
				+ "    right: 0;\r\n"
				+ "    transition: .9s ease;\r\n"
				+ "  }\r\n"
				+ "  \r\n"
				+ "  .search button[type=\"submit\"]:hover {\r\n"
				+ "    transform: scale(1.1);\r\n"
				+ "    color: rgb(255, 255, 255);\r\n"
				+ "    background-color: rgb(22, 22, 85);\r\n"
				+ "  }\r\n"
				+ "\r\n"
				+ "  .table\r\n"
				+ "  {\r\n"
				+ "    margin-top: 20px;\r\n"
				+ "    width: 100%;\r\n"
				+ "    height: 200px;\r\n"
				+ "    border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "  .table thead th\r\n"
				+ "{\r\n"
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
				+ "\r\n"
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
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "    <div class=\"title\"> View All records </div>\r\n");
		
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
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
	
		String dbUrl="jdbc:postgresql://localhost/tca_project";
		String user="aniket";
		String password="212003";
		
		try
		{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(dbUrl,user,password);
			
			ps = conn.prepareStatement("SELECT * \r\n"
					+ "FROM student_fee_details, course_details, student_course_details \r\n"
					+ "WHERE  student_fee_details.student_no = student_course_details.student_no\r\n"
					+ "AND    course_details.course_code = student_course_details.course_code;\r\n"
					+ "");
			rs = ps.executeQuery();
			
			out.println("<table class=\"table table-hover\">\r\n"
					+ "            <thead class=\"table-dark\">\r\n"
					+ "              <th scope=\"col\">Student No</th>\r\n"
					+ "              <th scope=\"col\">Student Name</th>\r\n"
					+ "              <th scope=\"col\">Email Address</th>\r\n"
					+ "              <th scope=\"col\">Phone Number</th>\r\n"
					+ "              <th scope=\"col\">Whatsapp Number</th>\r\n"
					+ "              <th scope=\"col\">Course Code</th>\r\n"
					+ "              <th scope=\"col\">Course Name</th>\r\n"
					+ "              <th scope=\"col\">Course Fee</th>\r\n"
					+ "              <th scope=\"col\">Fee Type</th>\r\n"
					+ "              <th scope=\"col\">Amount Paid</th>\r\n"
					+ "              <th scope=\"col\">Enrolled Date</th>\r\n"
					+ "              <th scope=\"col\">Payment Mode</th>\r\n"
					+ "            </thead>\r\n"
					+ "            <tbody>");
			
			while(rs.next())
			{
				student_no = rs.getInt(1);
				name = rs.getString(2);
				email = rs.getString(3);
				phone_num = rs.getLong(4);
				wp_num = rs.getLong(5);
				course_code = rs.getInt(6);
				course_name = rs.getString(7);
				course_fee = rs.getDouble(8);
				fee_type = rs.getString(11);
				amount_paid = rs.getDouble(12);
				sqldate = rs.getDate(13);
				payment_mod = rs.getString(14);
	            String formattedDate = formatter.format(sqldate);
	            
	            out.println("<tr>\r\n"
	            		+ "            <td> " + student_no + "</td>\r\n"
	            		+ "            <td> " + name + " </td>\r\n"
	            		+ "            <td> " + email + " </td>\r\n"
	            		+ "            <td> " + phone_num + " </td>\r\n"
	            		+ "            <td> " + wp_num + " </td>\r\n"
	            		+ "            <td> " + course_code + " </td>\r\n"
	            		+ "            <td> " + course_name + " </td>\r\n"
	            		+ "            <td> " + course_fee + " </td>\r\n"
	            		+ "            <td> " + fee_type + " </td>\r\n"
	            		+ "            <td> " + amount_paid + " </td>\r\n"
	            		+ "            <td> " + formattedDate + " </td>\r\n"
	            		+ "            <td> " + payment_mod + " </td>\r\n"
	            		+ "        </tr>");
			}
			
			out.println("</tbody>\r\n"
					+ "        </table>\r\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\r\n"
					+ "    </div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			
			
            conn.close();
            out.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
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
