<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>		

<!DOCTYPE html>
<html lang="en">
<%-- <%

if(request.getMethod().equals("GET"))
{
	response.sendRedirect("./LoginPage.html");
}

%> --%>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TCA | ADMIN</title>
    <link rel="icon" type="image/x-icon" href="./images/TCA_LOGO.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="Dashboard.css"/>

    <nav class="navbar navbar-dark fixed-top" style="background-color: rgb(11, 11, 66)">
      <div class="container-fluid">
        <a class="navbar-brand mx-3" href="#" style="font-size: 40px;"><b>TCA FEE MANAGEMENT</b></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="offcanvas offcanvas-end " style="background-color: rgb(11, 11, 66);" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
          <div class="offcanvas-header pb-0 mb-0" style="background-color: white;">
            <h5 class="offcanvas-title text-center py-4 primary-text fs-4 fw-bold text-uppercase" id="offcanvasDarkNavbarLabel" style="color: rgb(11, 11, 66); font-size: 40px;"><i
              class="fas fa-user-secret me-2"></i>TCA ADMIN</h5>
            <button type="button" class="btn-close btn-close-rgb(11, 11, 66)" data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>
          
          <div class="offcanvas-body">
            <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="./dashboard"><i
                  class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="./addFees.jsp"><i
                  class="fa-solid fa-circle-plus me-2"></i>Add Student</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="./enrollStudent.jsp"><i
                  class="fa-solid fa-circle-plus me-2"></i>Enroll Student</a>
              </li> 
              <li class="nav-item">
                <a class="nav-link" href="./searchRecord.jsp"><i
                  class="fa-solid fa-magnifying-glass me-2"></i>Search Record</a>
              </li> 
              <li class="nav-item">
                <a class="nav-link" href="./viewAllRecords"><i
                  class="fas fa-chart-line me-2"></i>View-all records</a>
              </li> 
              <li class="nav-item">
                <a class="nav-link" href="./viewAllCourses"><i
                  class="fa-solid fa-list-check me-2"></i>View Courses</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="./editCourse.jsp"><i
                  class="fa-solid fa-pen-to-square me-2"></i>Edit Course</a>
              </li> 
              <li class="nav-item">
                <a class="nav-link" href="./viewReport.jsp"><i
                  class="fa-solid fa-address-card me-2"></i>View Report</a>
              </li>               
              <li class="nav-item">
                <a class="nav-link" href="./LoginPage.html" style="color: red;"><i 
                  class="fa-solid fa-right-from-bracket me-2 text-danger"></i>Logout</a>
              </li> 
            </ul>
          </div>
        </div>
      </div>
    </nav>
  </head>
  
  <body style="background-color: rgb(235, 235, 235);">
   
   
   
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

  </body>
</html>