<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ include file="HomePage.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TCA | ADMIN</title>
    <link rel="icon" type="image/x-icon" sizes="42x42" href="images/CircleLogo.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="viewReport.css" rel="stylesheet">
</head>
<body>
    <div class="container">
    <form action="./viewReport">
        <div class="input-box">
            <span class="details"> Course Name </span>
            <select name="course" id="course" required>
                <option value="" disabled selected hidden> Select Course... </option>
                <%
                    try
        			{
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
                			//course's
                			ps = conn.prepareStatement("select * from course_details order by course_code;");
                			
                			rs = ps.executeQuery();
                			
                			while(rs.next())
                			{
                				out.println("<option value=" + rs.getInt(1) + "> " + rs.getString(2) + " </option>");
                			}
                			
        %>
            </select>
        </div>
        <br>
        <div class="input-box">
                    <span class="details"> Enter Name : </span>
                    <input type="text" name="file" placeholder="Enter File Name " required>
        </div>
        <div class="button">
            <input type="submit" name="Submit" value="Submit">
            <input type="submit" name="Submit" value="Export to Excel">
        </div>
        <%
      //table and total values
		Integer courseCode = Integer.parseInt(request.getParameter("course"));
		if(courseCode != null)
		{
			ps = conn.prepareStatement("SELECT count(*) from student_course_details WHERE course_code = ?;");
			ps.setInt(1,courseCode);
			rs = ps.executeQuery();
			Integer totalCount = null;
			while(rs.next())
			{
				totalCount = rs.getInt(1);
			}
			
			ps = conn.prepareStatement("SELECT sum(course_fee) FROM course_details, student_fee_details, student_course_details WHERE student_fee_details.student_no = student_course_details.student_no AND    course_details.course_code = student_course_details.course_code AND course_details.course_code = ?;");
			ps.setInt(1,courseCode);
			rs = ps.executeQuery();
			Double totalamount = null;
			while(rs.next())
			{
				totalamount = rs.getDouble(1);
			}
			
			ps = conn.prepareStatement("SELECT sum(amount_in_num) FROM course_details, student_fee_details, student_course_details WHERE student_fee_details.student_no = student_course_details.student_no AND    course_details.course_code = student_course_details.course_code AND course_details.course_code = ?;");
			ps.setInt(1,courseCode);
			rs = ps.executeQuery();
			Double amount = null;
			Double pending = null;
			while(rs.next())
			{
				amount = rs.getDouble(1);
				pending = totalamount - amount ;  
			}
               
        %>
        <div class="total">
            <span class="details">Total Count : <b><% out.println(totalCount); %>&emsp;</b></span>
            <span class="details">Amount Received : <b style="color:green;"><% out.println(totalamount); %>&emsp;</b></span>
            <span class="details">Amount Pending : <b style="color:red;"><% out.println(pending); %></b></span>
        </div>
        <marquee>All these records will be Exported to Excel !!</marquee>
        <h4 style="color:green;"><b>${file}</b></h4>
        <h4 style="color:red;"><b>${error}</b></h4>
        <table class="table table-striped">
            <thead>
                <th>Student No.</th>
                <th>Student Name</th>
                <th>Course Name</th>
                <th>Course Fees</th>
                <th>Amount Paid</th>
                <th>Amount Pending</th>
            </thead>
            <tbody>
        <%
        				
        					ps = conn.prepareStatement("SELECT student_fee_details.student_no, student_full_name, course_name, course_fee, amount_in_num\r\n"
								+ "FROM course_details, student_fee_details, student_course_details\r\n"
								+ "WHERE student_fee_details.student_no = student_course_details.student_no\r\n"
								+ "AND    course_details.course_code = student_course_details.course_code\r\n"
								+ "AND course_details.course_code = ?;");
							ps.setInt(1,courseCode);
		
							rs = ps.executeQuery();
		
							while(rs.next())
							{
								Double amountPending = rs.getDouble(4) - rs.getDouble(5);
								out.println("<tr>\r\n"
		    							+ "                    <td>" + rs.getInt(1) + "</td>\r\n"
		    							+ "                    <td>" + rs.getString(2) + "</td>\r\n"
		    							+ "                    <td>" + rs.getString(3) + "</td>\r\n"
		    							+ "                    <td>" + rs.getDouble(4) + "</td>\r\n"
		    							+ "                    <td>" + rs.getDouble(5) + "</td>\r\n"
		    							+ "                    <td>" + amountPending + "</td>\r\n"
		    							+ "                </tr>");
							}
							conn.close();
        				}
    			}
				catch(Exception e)
				{
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
			catch(Exception e)
			{
				e.printStackTrace();	
			}        	
        %>
            </tbody>
        </table>
    </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>