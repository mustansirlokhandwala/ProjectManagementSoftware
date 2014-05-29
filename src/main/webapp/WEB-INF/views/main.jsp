<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" type="text/css">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#createproject").click(function() {
		$("#bdashboard").load("project.htm");
	});
	$("#viewproject").click(function() {
		$("#bdashboard").load("viewproject.htm");
	});
	$("#addmembers").click(function() {
		$("#bdashboard").load("addteam.htm");
	});
	$("#viewuser").click(function() {
		$("#bdashboard").load("viewuser.htm");
	});
	$("#adduser").click(function() {
		$("#bdashboard").load("adduser.htm");
	});
	$("#viewrequest").click(function() {
		$("#bdashboard").load("viewrequest.htm");
	});
	$("#message").click(function() {
		$("#bdashboard").load("message.htm");
	});
	
	
});


</script>
</head>
<body>
<!-- Navbar -->


<nav class="navbar navbar-default  " role="navigation">   
<div class="container"> 
    <div class="navbar-header">      
      <a class="navbar-brand" href="WEB-INF/views/main.jsp" >PROJECT MANAGEMENT SYSTEM</a>         
      <p class="navbar-text">${user.firstName}</p>
      <a class="navbar-brand navbar-right" href="login.htm" >Logout</a>
    </div>
    </div>
    </nav>
    
    
    
  
  <!-- BOdy  -->
  <div class="container">
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><span class="glyphicon glyphicon-file">
                            </span> Project </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                    <span class="glyphicon glyphicon-pencil text-primary" ></span><a id="createproject" style="cursor:pointer"> Create Project</a>  
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-flash text-success"></span><a id="viewproject" style="cursor:pointer" > Manage Projects</a>
                                    </td>
                                </tr>                               
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-flash text-info"></span><a id="addmembers" style="cursor:pointer"> Add Members</a>
                                    </td>
                                </tr>
                                
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"><span class="glyphicon glyphicon-qrcode">
                            </span> People</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <a id="viewuser" style="cursor:pointer" > Friends </a> <span class="label label-success">${user.colleagues.size() }</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a id="adduser" style="cursor:pointer"> Add People</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a id="viewrequest" style="cursor:pointer"> Pending Requests</a><span class="label label-info"> 5 </span>
                                    </td>
                                </tr>   
                                <tr>
                                    <td>
                                        <a id="message" style="cursor:pointer">Messaging</a><span class="label label-info"> 5 </span>
                                    </td>
                                </tr>                               
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"><span class="glyphicon glyphicon-user">
                            </span>Account</a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">Change Password</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="http://www.jquery2dotnet.com">Notifications</a> <span class="label label-info">5</span>
                                    </td>
                                </tr>                                
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-trash text-danger"></span><a href="http://www.jquery2dotnet.com" class="text-danger">
                                            Delete Account</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour"><span class="glyphicon glyphicon-file">
                            </span>Reports</a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-usd"></span><a href="http://www.jquery2dotnet.com">Sales</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-user"></span><a href="http://www.jquery2dotnet.com">Customers</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-tasks"></span><a href="http://www.jquery2dotnet.com">Products</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-shopping-cart"></span><a href="http://www.jquery2dotnet.com">Shopping Cart</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9 col-md-9">
            <div class="well" id="bdashboard">
                <h1>
                    Welcome to your DashBoard</h1>
                <h2>${user.firstName} Dashboard Accordion Menu
            </div>
        </div>
    </div>
</div>
  

</body>
</html>