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
<script type="text/javascript">




</script>
</head>
<body>
               <table class="table table-hover">
<tr>
<th>Project Name</th>
<th>Project Start Date </th>
<th>Project End Date</th>
<th>Project type</th>
<th>Add Members</th>
</tr>
<c:forEach  items="${prolist}" var="var">
<tr onclick="var e = document.getElementById(${var.projectID}); if(e.style.display == 'block') e.style.display = 'none';  else e.style.display = 'block';">
<td>${var.projectName}</td>
<td>${var.startDate }</td>
<td>${var.endDate }</td>
<td>${var.type }</td>
<td><a href="addteam.htm?project=${var.projectID }">Add as Friend</a>
</tr>

<div class="well " id="${var.projectID}"  style="display:none;" >
<c:forEach items="${var.phases}" var="var2">
${var2.phaseName } ${var2.startDate } ${var2.endDate }
</c:forEach>
</div>

</c:forEach> 
</table>


</body>
</html>