<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ include file="HomePage.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Enroll Student </title>
    <link rel="stylesheet" href="enrollStudent.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

    
</head>
<body style="background-color: rgb(235, 235, 235);">

    <div class="container">
        <div class="title"> Enroll Student </div>
        <form action="./enrollStudent">
            <div class="info">
                <div class="input-box">
                    <span class="details"> Whatsapp Number </span>
                    <input type="text" name="wp-number" placeholder="Enter whatsapp number" required>
                </div>
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
                			
                			ps = conn.prepareStatement("select * from course_details order by course_code;");
                			
                			rs = ps.executeQuery();
                			
                			while(rs.next())
                			{
                				out.println("<option value=" + rs.getInt(1) + "> " + rs.getString(2) + " </option>");
                			}
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
        			catch(Exception e)
        			{
        				e.printStackTrace();	
        			}
        %>
                    </select>
                </div>
                <div class="input-box">
                    <span class="details"> Fee Type </span>
                    <select name="fee-type" id="type" required>
                        <option value="" disabled selected hidden> Select your preferred Fee Method... </option>
                        <option value="installment"> Installment </option>
                        <option value="full"> Full Payment </option>
                    </select>
                </div>
                <div class="input-box">
                    <span class="details"> Amount In Numbers </span>
                    <input type="text" name="amount-in-num" placeholder="Enter amount in numbers" required>
                </div>
                <div class="input-box">
                    <span class="details"> Enrollment Date </span>
                    <input type="date" name="date" id="date-input" required>
                </div>
                <div class="paydetails">
                    <input type="radio" name="pay" id="dot-1" value="Cash">
                    <input type="radio" name="pay" id="dot-2" value="UPI">
                    <input type="radio" name="pay" id="dot-3" value="DebitCard">
                    <input type="radio" name="pay" id="dot-4" value="Cheque">
                    <span class="paytitle"> Payment Type </span>
                    <div class="category">
                        <label for="dot-1">
                            <span class="dot one"></span>
                            <span class="pay">Cash</span>
                        </label>
                        <label for="dot-2">
                            <span class="dot two"></span>
                            <span class="pay">UPI</span>
                        </label>
                        <label for="dot-3">
                            <span class="dot three"></span>
                            <span class="pay">Debit Card</span>
                        </label>
                        <label for="dot-4">
                            <span class="dot four"></span>
                            <span class="pay">Cheque</span>
                        </label>
                    </div>
                </div>
                <h5 style="margin-bottom:0px;font-weight: bold;color:green;">${message}</h5>
                <h5 style="margin-bottom:0px;font-weight: bold;color:red;">${error}</h5>
                <div class="button">
                    <input type="submit" name="Submit" value="Enroll Student">
                </div>
              </div>
        </form>
    </div>
</body>
</html>