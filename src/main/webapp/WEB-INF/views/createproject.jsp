<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" type="text/css">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function()
		{
		    $(document).on('click', '.btn-add', function(e)
		    {
		        e.preventDefault();

		        var controlForm = $('.controls form:first'),
		            currentEntry = $(this).parents('.entry:first'),
		            newEntry = $(currentEntry.clone()).appendTo(controlForm);

		        newEntry.find('input').val('');
		        controlForm.find('.entry:not(:last) .btn-add')
		            .removeClass('btn-add').addClass('btn-remove')
		            .removeClass('btn-success').addClass('btn-danger')
		            .html('<span class="glyphicon glyphicon-minus"></span>');
		    }).on('click', '.btn-remove', function(e)
		    {
				$(this).parents('.entry:first').remove();

				e.preventDefault();
				return false;
			});
		});


</script>


</head>
<body>     

	<div class="row">
        <div class="control-group" id="fields">
        
            <label class="control-label" for="field1"><h3>Project</h3></label>
            <div class="controls"> 
                <form  class="form form-horizontal" action="addproject.htm" method="post">
                
         <div class="row">
         <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" value = "create" class="btn btn-primary"> 
    </div>
  </div>
         <div class="form-group">
    <label for="pname" class="col-sm-2 control-label">Project Name :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="pname" placeholder="Enter Project Name">
    </div>
  </div>
  <div class="form-group">
    <label for="sdate" class="col-sm-2 control-label">Start Date : :</label>
    <div class="col-sm-6">
      <input type="date" class="form-control" name="sdate" placeholder="Enter Start Date" >
    </div>
  </div>
  <div class="form-group">
    <label for="edate" class="col-sm-2 control-label">End Date :</label>
    <div class="col-sm-6">
      <input type="date" class="form-control" name="edate" placeholder = "Enter End Date">
    </div>
    </div>
    <div class="form-group">
    <label for="ptype" class="col-sm-2 control-label">Project type :</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="ptype" placeholder = "Enter Project Type">
    </div>
    </div>
         
         
         </div>
                
          <h3>Project Phases</h3>      
                
                
                    <div class="entry input-group ">
                    <div class="row">
                    <div class="col-xs-3">
                        <input class="form-control " name="phasename" type="text" placeholder="Phase Name" >                    
                    </div>
                    <div class="col-xs-3">
                        <input class="form-control " name="startdate" type="text" placeholder="Start Date" >                    
                    </div>
                    <div class="col-xs-3">
                        <input class="form-control " name="enddate" type="text" placeholder="End Date" >                    
                    </div>
                    	
                    	
                    	<div class="col-xs-3">
                    	<span class="input-group-btn">
                            <button class="btn btn-success btn-add" type="button">
                                <span class="glyphicon glyphicon-plus"></span>
                            </button>
                        </span>
                        </div>
                        </div>
                    </div>
                    
                </form>
            <br>
            <small>Press <span class="glyphicon glyphicon-plus gs"></span> to add one more Phase .</small>
            
            
            
            </div>
        </div>
	</div>

         
  
 
 
</body>
</html>