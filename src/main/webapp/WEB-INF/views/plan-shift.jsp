<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 


<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Shift Allocator - Plan Shift</title>
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/css/bootstrap.css" />"  rel="stylesheet">
    <link href="<c:url value="/resources/css/custom.css" />"  rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico" />"  type="image/x-icon">
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />"   type="image/x-icon">
    <script type="text/javascript">
    function remErrors(text) {
		document.getElementById(text + 'Err').innerHTML = '';
	}
    </script>
   <script type="text/javascript" src="<c:url value='/resources/js/user.js'/>"></script>

  </head>
  <body>
  	
   <body>
<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<img src="<c:url value="/resources/images/logo.png" />" alt="" />
				</div>
				<div class="col-md-7">
					<ul class="header_nav">
						<li><a href="<c:url value="/get-plan-shifts-page" />"  class="header_nav_active">PlanShift</a></li>
						<li><a href="<c:url value="/get-planned-shifts-page" />">Planned Shifts</a></li>
						<li><a href="<c:url value="/user/createUser" />" >Create User</a></li>
					</ul>
				</div>
				<div class="col-md-1 right">
					<a href="<c:url value="/user/logOff" />" class="login_out">Logout</a>
				</div>
			</div>
		</div>
	</div>
    
    <!--content start-->
    <div class="container main_container">
    	<div class="alert alert-success">
        	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        	<i class="fa fa-check-circle-o fa-lg"></i> <strong>Enter Following Details to Plan Shifts!</strong>
        </div>
         
		<div class="col-md-6 col-md-offset-3 col-lg-8 col-lg-offset-2">
        <form:form class="form-horizontal" role="form" method="post" command="command" action="plan-shifts" autocomplete="off">
          <div class="form-group">
            <label class="col-md-5 col-lg-4 control-label" >Date</label>
            <div class="col-md-7 col-lg-8">
              <form:input type="date" class="form-control"  min="2014-05-01" max="2014-07-01" name="date" path="dateStr" id="dateStr" onchange="remErrors(this.id)"/><span class="error-label" id="dateStrErr">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-5 col-lg-4 control-label" >Number of Shifts</label>
            <div class="col-md-7 col-lg-8">
              <form:select  class="form-control" name="shiftCount" path="shiftCount" id="shiftCount" onchange="remErrors(this.id)">
              	 
              	  <form:option value="0">-- Select --</form:option>
                  <form:option value="1" >1</form:option>
                  <form:option value="2"> 2</form:option>
                  <form:option value="3" selected="true">3</form:option>
                </form:select><span class="error-label" id="shiftCountErr"></span>
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-5 col-lg-4 control-label" >Number of Employees per Shift</label>
            <div class="col-md-7 col-lg-8">
            	<form:input class="form-control bottom-space" id="shiftOneCount" path="shiftOneCount"  placeholder="Enter Strength of 1st shift employees" onkeypress="remErrors(this.id)"/><span
									class="error-label" id="shiftOneCountErr"></span>
                <form:input class="form-control bottom-space" id="shiftTwoCount" path="shiftTwoCount" placeholder="Enter Strength of 2nd shift employees" onkeypress="remErrors(this.id)"/><span
									class="error-label" id="shiftTwoCountErr"></span>
                <form:input class="form-control" id="shiftThreeCount" path="shiftThreeCount"  placeholder="Enter Strength of 3rd shift employees" onkeypress="remErrors(this.id)"/><span
									class="error-label" id="shiftThreeCountErr"></span>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-offset-5 col-md-7 col-lg-8 col-lg-offset-4">
              <button type="submit" class="btn btn-primary btn-block bold_btn" onclick="return planshiftFormvalidation('form');" >Plan Shift</button>
            </div>
          </div>
        </form:form>
        </div>
    </div>
    <!--content end-->
    
    <div class="footer">
		<div class="container">
		 <div class="copyright">&copy; 2014 Techgene Solutions. All Rights Reserved.</div>
			<div class="techgene">
			<img src="<c:url value="/resources/images/techgene.png" />" alt="Techgene" />
			</div>
	</div>

    
    
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script  src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
    <script src="<c:url value="/resources/js/custom.js" />" ></script>
  </body>
</html>