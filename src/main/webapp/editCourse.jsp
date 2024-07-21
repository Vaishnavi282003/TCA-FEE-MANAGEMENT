<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file="HomePage.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Edit Course </title>
    <link rel="stylesheet" href="./EditCourse.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>

    <div class="container">
        <div class="title"> Edit Course </div>
        <form action="./editCourse">
            <div class="info">
                <div class="input-box">
                    <span class="details"> Course ID: </span>
                    <input type="text" name="cid" required>
                </div>
                <div class="input-box">  
                    <span class="details"> Course Name: </span>
                    <input type="text" name="cname" required>
                </div>    
                <div class="input-box">
                    <span class="details"> Course Fees: </span>
                    <input type="text" name="cfees" required>
                </div>
            </div>    
                
                 <div class="button">
                    <input  type="submit" name="submit" value="Add">
                    <input  type="submit" name="submit" value="Update">
                    <input  type="submit" name="submit" value="Delete">   
                 </div>
        </form>
        <h5 style="margin-top:8px;margin-bottom:0px;font-weight: bold;color:green;">${add}</h5>
        <h5 style="margin-top:8px;margin-bottom:0px;font-weight: bold;color:red;">${adderror}</h5>
        <h5 style="margin-top:8px;margin-bottom:0px;font-weight: bold;color:red;">${editexception}</h5>
        <h5 style="margin-top:8px;margin-bottom:0px;font-weight: bold;color:green;">${update}</h5>
        <h5 style="margin-top:8px;margin-bottom:0px;font-weight: bold;color:red;">${updateerror}</h5>
        <h5 style="margin-top:8px;margin-bottom:0px;font-weight: bold;color:green;">${delete}</h5>
        <h5 style="margin-top:8px;margin-bottom:0px;font-weight: bold;color:red;">${doesNotExist}</h5>
        <table class="table table-hover">
            <thead class="table-dark">
              <th>Sr No</th>
              <th>Course ID</th>
              <th>Course Name</th>
              <th>Course Fees</th>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>${courseCode}</td>
                    <td>${courseName}</td>
                    <td>${courseFee}</td>
                </tr>
            </tbody>
        </table>
    </div>
    
</body>
</html>