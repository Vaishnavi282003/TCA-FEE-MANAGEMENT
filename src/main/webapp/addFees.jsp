<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="HomePage.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> TCA | Student Details </title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
	<style>

	
.container
{
margin-top:150px;
    max-width: 700px;
    height: 100%;
    width: 100%;
    background: #fff;
    padding: 30px 30px 30px 30px;
    border-radius: 5px;
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
    top: 30px;
    margin-top:10px;
    bottom: 0px;
    height: 3px;
    width: 130px;
    background: linear-gradient(135deg, rgb(104, 104, 241), rgb(11, 11, 66));
}

.container form .info
{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    margin: 20px 0 12px 0;
}
form .info .input-box
{
    margin-bottom: 15px;
    width: calc(100% / 2 - 20px);
}
.info .input-box .details
{
    display: block;
    font-weight: 500;
    margin-bottom: 5px;
}
.info .input-box input,select
{
    color: #999;
    height: 45px;
    width: 100%;
    outline: none;
    border-radius: 5px;
    border: 1px solid rgb(11, 11, 66);
    padding-left: 15px;
    font-size: 13px;
    border-bottom-width: 2px;
    transition: all 0.3s ease;
}
option
{
    color: black;
}
.info .input-box input:focus,
.info .input-box input:valid{
    border-color: rgb(11, 11, 66);
}

/* Payment Info*/
form .paydetails .paytitle
{
    font-size: 16px;
    font-weight: 500;
}
form .paydetails .category
{
    display: flex;
    width: 120%;
    margin: 20px 0;
    justify-content: space-between;
}
.paydetails .category label
{
    display: flex;
    align-items: center;
}
.paydetails .category .dot
{
    height: 18px;
    width: 18px;
    background: #d9d9d9;
    border-radius: 50%;
    margin: 10px 10px;
    border: 5px solid transparent;
    transition: all 0.3 ease;
}
#dot-1:checked ~ .category label .one,
#dot-2:checked ~ .category label .two,
#dot-3:checked ~ .category label .three,
#dot-4:checked ~ .category label .four
{
    border-color: #d9d9d9 ;
    background: rgb(11, 11, 66);
}
form input[type="radio"]
{
    display: none;
}

/*button*/
form .button
{
    height: 40px;
    width: 100%;
}
form .button input
{
    height: 100%;
    width: 95%;
    outline: none;
    color: #fff;
    border: none;
    margin:10px;
    align-content: center;
    font-size: 18px;
    font-weight: 500;
    border-radius: 5px;
    letter-spacing: 1px;
    background: linear-gradient(135deg, rgb(104, 104, 241), rgb(11, 11, 66));
}
form .button input:hover{
    background: linear-gradient(-135deg, rgb(104, 104, 241), rgb(11, 11, 66));
}
@media (max-width: 585px)
{
    .container
    {
        max-width: 100%;
    }
    form .info .input-box
   {
    margin-bottom: 15px;
    width: 100%;
   }
   form .paydetails .category
  {
    width: 100%;
  }
  .container form .info
  {
    max-height: 300px;
    overflow-y: scroll;
  }
  .info::-webkit-scrollbar
  {
    width: 0;
  }
}
	
	</style>
</head>
<body>
<div class="main">
    <div class="container">
        <div class="title"> Student Details </div>
        <form action="./addFeesServlet">
            <div class="info">
                <div class="input-box">
                    <span class="details"> Student Full Name </span>
                    <input type="text" name="Name" placeholder="Enter your name" required>
                </div>
                <div class="input-box">
                    <span class="details"> Email Address </span>
                    <input type="text" name="email" placeholder="Enter your mail ID" required>
                </div>
                <div class="input-box">
                    <span class="details"> Phone Number </span>
                    <input type="text" name="phn-number" placeholder="Enter your number" required>
                </div>
                <div class="input-box">
                    <span class="details"> Whatsapp Number </span>
                    <input type="text" name="wp-number" placeholder="Enter whatsapp number" required>
                </div>
                <div class="button">
                    <input type="submit" name="Submit" value="Confirm Your Admission">
                </div>
                <h5 style="margin-top:30px;margin-bottom:0px;font-weight: bold;color:green;">${message}</h5>
                <h5 style="margin-top:30px;margin-bottom:0px;font-weight: bold;color:red;">${error}</h5>
                </div>
        </form>
    </div>
 </div>
 <!-- <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
 <script type="text/javascript">
 function myfunction(){
	 Swal.fire(${message});
 }
 </script>  -->  
</body>
</html>