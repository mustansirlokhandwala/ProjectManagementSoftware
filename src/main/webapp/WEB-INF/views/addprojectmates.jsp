<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

<script>
 function getprojectmates(project)
{
if (project.length==0)
  { 
	  document.getElementById("displayarea").innerHTML="";
	  
  }
var xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    		if(xmlhttp.responseText==""){
	    		document.getElementById("displayarea").innerHTML="";
	    		return;
    		}
    		else{
	    		document.getElementById("displayarea").innerHTML=xmlhttp.responseText;
	    	}
    }
   }
xmlhttp.open("GET","projectmates.htm?project="+project,true);
xmlhttp.send();
}
</script>
<script>
 
 function addmates(addid)
 {
	 var project = document.getElementById("projectname");
	 
 if (addid.length==0)
   { 
 	  document.getElementById("displayarea").innerHTML="";
 	  
   }
 var xmlhttp=new XMLHttpRequest();
 xmlhttp.onreadystatechange=function()
   {
   if (xmlhttp.readyState==4 && xmlhttp.status==200)
     {
     		if(xmlhttp.responseText==""){
 	    		document.getElementById("displayarea").innerHTML="";
 	    		return;
     		}
     		else{
 	    		document.getElementById("displayarea").innerHTML=xmlhttp.responseText;
 	    	}
     }
    }
 xmlhttp.open("GET","projectmates.htm?addid="+addid+"&project="+project,true);
 xmlhttp.send();
 }
</script>







</head>
<body>
<div class="row" >
<select class="form-control" id="projectname" onchange="getprojectmates(this.value)">
<option >-Select Project -</option>
<c:forEach items="${prolist}" var="var">
<option >${var.projectName}</option>
</c:forEach>
</select>
</div>
<br>
<br>
<div id="displayarea">


</div>
</body>
</html>