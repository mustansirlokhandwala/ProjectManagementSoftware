<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" type="text/css">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>


</head>
<body>

<div class="container">
<form class="form-horizontal"   name ="deliverable" action="#" method="post">
<div class="form-group">
    <label for="fname" class="col-sm-2 control-label">Deliverable Name :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" placeholder="Enter Deliverable Name">
    </div>
  </div>
  <div class="form-group">
    <label for="lname" class="col-sm-2 control-label">Deliverable Date</label>
    <div class="col-sm-6">
      <input type="date" class="form-control" name="date" placeholder="Enter Last Name ">
    </div>
  </div>
  
    <label for="lname" class="col-sm-2 control-label">Deliverable File Upload</label>
    <div class="col-sm-6">
      <input type="file" class="btn btn-danger" name="upload" >
    </div>
  
</div>

</body>