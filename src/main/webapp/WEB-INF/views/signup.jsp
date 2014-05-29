<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css" type="text/css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>

</head>

<body>
<div class="row" margin="10px">
<div class="col-sm-9" style="min-height:150px;   "></div>
</div>
<form class="form-horizontal"   name ="signup" action="signup.htm" method="post">
<div class="form-group">
    <label for="fname" class="col-sm-2 control-label">First Name :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="fname" placeholder="Enter First Name">
    </div>
  </div>
  <div class="form-group">
    <label for="lname" class="col-sm-2 control-label">Last Name :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="lname" placeholder="Enter Last Name ">
    </div>
  </div>
  <div class="form-group">
    <label for="Date of Birth" class="col-sm-2 control-label">Date of Birth :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="dob" placeholder="Enter Date of Birth">
    </div>
  </div>
  <div class="form-group">
    <label for="title" class="col-sm-2 control-label">Title :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="title" placeholder="Enter Title">
    </div>
  </div>
  <div class="form-group">
    <label for="company" class="col-sm-2 control-label">Company :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="company" placeholder="Enter Company">
    </div>
  </div>
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email :</label>
    <div class="col-sm-6">
      <input type="email" class="form-control" name="email" placeholder="Enter Email">
    </div>
  </div>
  <div class="form-group">
    <label for="phone" class="col-sm-2 control-label">Phone Number :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="phone" placeholder="Enter Phone Number">
    </div>
  </div>
  </div>
  <div class="form-group ">
  <label for="street" class="col-sm-2 control-label">Street :</label>
  <div class="col-sm-2">
  <input type="text" class="form-control" name="street" placeholder="Enter Street Name">
  </div>
  <label for="city" class="col-sm-1 control-label">City :</label>
  <div class="col-sm-2">
  <input type="text" class="form-control" name="city" placeholder="Enter City Name">
  </div>
  
  </div>
  <div class="form-group ">
  <label for="state" class="col-sm-2 control-label">State :</label>
  <div class="col-sm-2">
  <input type="text" class="form-control" name="state" placeholder="Enter State Name">
  </div>
  <label for="zipcode" class="col-sm-1 control-label">Zip Code :</label>
  <div class="col-sm-2">
  <input type="text" class="form-control" name="zipcode" placeholder="Enter Zip Code">
  </div>  
  </div>
  <div class="form-group ">
  <label for="username" class="col-sm-2 control-label">Username :</label>
  <div class="col-sm-2">
  <input type="text" class="form-control" name="username" placeholder="Enter User Name">
  </div>
  <label for="passowrd" class="col-sm-1 control-label">Password :</label>
  <div class="col-sm-2">
  <input type="password" class="form-control" name="password" placeholder="Enter Password">
  </div>  
  </div>
  
    
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default btn-primary">Sign in</button>
    </div>
  



</form>
</body>
</html>
