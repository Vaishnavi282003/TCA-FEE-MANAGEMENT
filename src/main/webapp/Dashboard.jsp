<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="HomePage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.Container{
margin-top:90px;
}
h2{
padding-top:10px;
padding-left:23px;
font-weight: bold;
}
hr{
margin-left:23px;
width:96%;
 border: 1px solid black;
}
</style>
</head>
<body>
<form action="./dashboard">
<div class="Container">
	<h2>DASHBOARD</h2>
	<hr>
	<div class="container-fluid px-4">
                <div class="row g-3 my-2">
                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <h3 class="fs-2"><b>${total_students}</b></h3>
                                <p class="fs-5">Total Students</p>
                            </div>
                            <i class="fa-solid fa-users fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <h3 class="fs-2" style="color:green;"><b>${fees}</b></h3>
                                <p class="fs-5">Total Fees</p>
                            </div>
                            <i class="fas fa-hand-holding-usd fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <h3 class="fs-2" style="color:red;"><b>${amountPending}</b></h3>
                                <p class="fs-5">Fees Pending</p>
                            </div>
                            <i class="fa-solid fa-hourglass-half fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <h3 class="fs-2"><b>${totalCourses}</b></h3>
                                <p class="fs-5">Total Courses</p>
                            </div>
                            <i class="fa-solid fa-table-list fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                        </div>
                    </div>
                </div>
           </div>
</div>
</form>
</body>
</html>