<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="container" >
<button class="btn btn-success" onclick="var t = document.getElementById('row11'); if(t.style.display == 'block') t.style.display = 'none';  else t.style.display = 'block';">New Message +</button>
	<div class="row" id="row11" style="display: none">
      <div class="col-md-6 col-md-offset-1">
        <div class="well well-sm">
          <form class="form-horizontal" action="" method="post">
          <fieldset>
            <legend class="text-center"> Message </legend>
    
            
            <div class="form-group">
              <label class="col-md-3 control-label" for="name">To :</label>
              <div class="col-md-9">
                <input id="name" name="name" type="text" placeholder="Receipient... " class="form-control">
              </div>
            </div> 
           
    
            
            <div class="form-group">
              <label class="col-md-3 control-label" for="message">Your message</label>
              <div class="col-md-9">
                <textarea class="form-control" id="message" name="message" placeholder="Please enter your message here..." rows="5"></textarea>
              </div>
            </div>
    
            <input type="hidden" name = "recipient" id="hidden" value=""/>
            <div class="form-group">
              <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-primary ">Submit</button>
              </div>
            </div>
          </fieldset>
          </form>
        </div>
      </div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Messages</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover table-bordered">
					<thead>
							<tr>
								<th>Message From </th>
								<th colspan="4">Message</th>
								<th>Replay</th>
								<th>Delete</th>
							</tr>
					</thead>
					<tbody>
							<c:forEach items="${messagelist}" var="var">
							<tr>
								<td>${var.fromUser}</td>
								<td colspan="4">${var.message}</td>
								<td><button class="btn btn-info">Reply</button></td>
								<td><button class="glyphicon glyphicon-remove red" ></button></td>
							</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</div>
</div>
</body>
</html>