<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" type="text/css">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>
                <table class="table">
                <thead>
<tr class="filters">
<th>User First Name</th>
<th>User Last Name </th>
<th>User Organization</th>
</tr>
</thead>
<tbody>
<c:forEach  items="${userlist}" var="var">
<tr>
<td>${var.firstName}</td>
<td>${var.lastName }</td>
<td>${var.company }</td>
</tr>

</c:forEach>
 </tbody>
 
</table>
       

</body>
</html>