<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<c:url value="/getMonthResults" var="monthUrl" />

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
	<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.11.0.js' />"></script>
	<script type="text/javascript"
	src="<c:url value='/resources/js/shift-allocator.js' />"></script>
    <script type="text/javascript">
	$(function() {
		// init
		urlHolder.month = '${monthUrl}';
		$('#formData').hide();

	});
	
</script>
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
	<div class="alert alert-success">
        	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        	<i class="fa fa-check-circle-o fa-lg"></i> <strong>${shiftPlanStatus}<a href="#" onClick="getShiftData()" id="viewShiftResponse"><c:if test="${status =='yes'}"> ... You can view Here!</c:if></a></strong>
      </div>
	
    <input type="hidden" value="${userName}" id="empName">
	<input type="hidden" value="${userType}" id="empType">
	<input type="hidden" value="${month}"    id="month-form">
	
    <!--content start-->
	<div class="container main_container">

		<div class="col-md-12" >
			<form class="form-horizontal" id="formData">
				<div class="row bottom-space" id="search">
					<div class="col-md-10">
						<input type="text"  placeholder="Search by Name or Shift.."
							class="form-control">
					</div>
					<button class="btn btn-primary bold col-md-2">
						<span class="glyphicon glyphicon-search"></span> Search
					</button>
				</div>
				<input type="hidden" value="${userName}" id="empName">
				<input type="hidden" value="${userType}" id="empType">
				<div class="row">
					<div class="col-md-8">
						<div class="form-group" id="selectMonth">
							<label class="col-md-3 control-label">Plan for Month</label>
							<div class="col-md-9">
								<select class="form-control" id="month-form" onchange="getShiftData()" >
									<option>-- Select --</option>
									<option value="01">January</option>
									<option value="02">February</option>
									<option value="03">March</option>
									<option value="04">April</option>
									<option value="05">May</option>
									<option value="06">June</option>
									<option value="07">July</option>
									<option value="08">August</option>
									<option value="09">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-4" id="viewBy">
						<div class="form-group">
							<label class="col-md-4 control-label">View By</label>
							<div class="col-md-8">
								<select class="form-control">
									<option>10</option>
									<option>20</option>
									<option>30</option>
									<option>40</option>
									<option>50</option>
									<option>75</option>
									<option>100</option>
								</select>
							</div>
						</div>
					</div>


				</div>
				<!-- Nav tabs -->
				<ul class="nav nav-tabs bottom-space">
					<li class="active"><a href="#weekOne" data-toggle="tab">Week
							1</a></li>
					<li><a href="#weekTwo" data-toggle="tab">Week 2</a></li>
					<li><a href="#weekThree" data-toggle="tab">Week 3</a></li>
					<li><a href="#weekFour" data-toggle="tab">Week 4</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">

					<div class="tab-pane active" id="weekOne">
						<!--week one start-->
						<table id='weekOne' class="table table-hover">
							<caption></caption>
							<thead>
								<tr class="active">
									<th></th>
									<th width="30%">Employee Name</th>
									<th width="30%">Shift</th>
									<th width="30%">WeekOff</th>
								</tr>
							</thead>
						</table>
						
					</div>
					<!--week one end-->
					<div class="tab-pane" id="weekTwo">
						<table id='weekTwo' class="table table-hover">
							<caption></caption>
							<thead>
								<tr class="active">
									<th></th>
									<th width="30%">Employee Name</th>
									<th width="30%">Shift</th>
									<th width="30%">WeekOff</th>
								</tr>
							</thead>
						</table>
						
					</div>
					<!--week Two end-->
					<div class="tab-pane" id="weekThree">
						<table id='weekThree' class="table table-hover">
							<caption></caption>
							<thead>
								<tr class="active">
									<th></th>
									<th width="30%">Employee Name</th>
									<th width="30%">Shift</th>
									<th width="30%">WeekOff</th>
								</tr>
							</thead>
						</table>
						
					</div>
					<!--week Three end-->
					<div class="tab-pane" id="weekFour">
						<table id='weekFour' class="table table-hover">
							<caption></caption>
							<thead>
								<tr class="active">
									<th></th>
									<th width="30%">Employee Name</th>
									<th width="30%">Shift</th>
									<th width="30%">WeekOff</th>
								</tr>
							</thead>
						</table>
						
					</div>
					<!--week Four end-->
					<div class="row">
							<div class="col-md-6">
								<button class="btn btn-primary bold">
									<i class="fa fa-print"></i> Print
								</button>
								<button class="btn btn-primary bold">
									<i class="fa fa-envelope-o"></i> Email
								</button>
							</div>
							<div class="col-md-6">
								<ul class="pagination no-top-bottom" style="float: right;">
									<li class="disabled"><a href="#">&laquo;</a></li>
									<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
									<li><a href="#">1 <span class="sr-only">(current)</span></a></li>
									<li><a href="#">2 <span class="sr-only">(current)</span></a></li>
									<li><a href="#">3 <span class="sr-only">(current)</span></a></li>
									<li><a href="#">4 <span class="sr-only">(current)</span></a></li>
									<li><a href="#">&raquo;</a></li>
								</ul>
							</div>

						</div>
					</div>
			</form>
		</div>
	</div>
	<!--content end-->     
   
            
         
  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script  src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
    <script src="<c:url value="/resources/js/custom.js" />" ></script>
  </body>
</html>