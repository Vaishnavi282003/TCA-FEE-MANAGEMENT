<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
   <%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="HomePage.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
    .container
    {
    	margin : 0px;
    	padding-top: 100px;
    }
.container .title
{
    font-size: 25px;
    font-weight: 500;
    position: relative;
}
.container .title::before
{
    content: '';
    position: absolute;
    left: 0;
    bottom: 0;
    margin-top: 5px;
    height: 3px;
    width: 180px;
    background: linear-gradient(135deg, rgb(104, 104, 241), rgb(11, 11, 66));
}
.search {
    display: inline-block;
    position: relative;
  }
  
  .search input[type="text"] {
    margin-top: 30px;
    width: 700px;
    padding: 10px;
    border: none;
    border-radius: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  
  .search button[type="submit"] 
  {
    margin-top: 30px;
    background-color: #111156;
    border: none;
    color: #fff;
    cursor: pointer;
    padding: 10px 20px;
    border-radius: 20px;
    box-shadow: 0 0 10px rgb(31, 19, 121);
    position: absolute;
    top: 0;
    right: 0;
    transition: .9s ease;
  }
  
  .search button[type="submit"]:hover {
    transform: scale(1.1);
    color: rgb(255, 255, 255);
    background-color: rgb(22, 22, 85);
  }

  .table
  {
    margin-top: 20px;
    width: 100%;
    height: 200px;
    border-collapse: collapse;
}
  .table thead th
{
    font-size: 16px;
    font-weight: 600;
    letter-spacing: 0.45;
    color:rgb(255, 255, 255);
    opacity: 1;
    padding: 35px;
    padding-bottom: 10px;
    padding-top: 10px;
    border: 1px solid ;
    background-color: rgb(11, 11, 66);
}
.table tbody tr td{
    font-size: 15px;
    font-weight: 600;
    letter-spacing: 0.35;
    color: black;
    background-color: white;
    padding: 35px;
    padding-bottom: 10px;
    padding-top: 10px;
    border: 1px solid #000000fe;
}    
    </style>
</head>
<body>
    <div class="container">
    <div class="title"> Search Record </div>
    <form action="./searchRecord.jsp">
        <div class="search">
            <input placeholder=" Search by whatsapp number..." name="whatsappNum" type="text">
            <button type="submit">Search</button>
        </div>
     </form>
        <table class="table table-hover">
            <thead>
                <th scope="col">Student No</th>
                <th scope="col">Student Name</th>
                <th scope="col">Email Address</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Whatsapp Number</th>
                <th scope="col">Course Code</th>
                <th scope="col">Course Name</th>
                <th scope="col">Course Fee</th>
                <th scope="col">Fee Type</th>
                <th scope="col">Amount Paid</th>
                <th scope="col">Enrolled Date</th>
                <th scope="col">Payment Mode</th>
            </thead>
            <tbody>
  <%
  		
  		response.setContentType("text/html");		
  	try
  	{
  		String whatsappNum = request.getParameter("whatsappNum");
      	if(whatsappNum != null)
      	{
    	  
    		Long wpNum = Long.parseLong(whatsappNum);
        	Connection conn=null;
  			PreparedStatement ps=null;
  			ResultSet rs = null;
  	
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
						+ "AND    course_details.course_code = student_course_details.course_code\r\n"
						+ "AND student_whatsapp_num = ?;");
  				ps.setLong(1, wpNum);
  				rs = ps.executeQuery();
  			
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
  			}
  			catch(Exception e)
  			{
  				e.printStackTrace();
  				request.getRequestDispatcher("./searchRecord.jsp").forward(request, response);
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
  		request.getRequestDispatcher("./searchRecord.jsp").forward(request, response);
  	}
  %>
            </tbody>
        </table>
        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>