<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Shift Allocator - Create User</title>
<!-- Bootstrap -->
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon"
	href="<c:url value="/resources/images/favicon.ico" />"
	type="image/x-icon">
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />"
	type="image/x-icon">
<script type="text/javascript"
	src="<c:url value='/resources/js/user.js'/>"></script>
<script>
	function preventBack() {
		window.history.forward();
	}
	setTimeout("preventBack()", 0);
	window.onunload = function() {
		null
	};

	function remErrors(text) {
		document.getElementById(text + 'Err').innerHTML = '';
	}
</script>
</head>
<body>

	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<img src="<c:url value="/resources/images/logo.png" />" alt="" />
				</div>
				<div class="col-md-7">
					<ul class="header_nav">
						<li><a href="<c:url value="/get-plan-shifts-page" />">PlanShift</a></li>
						<li><a href="<c:url value="/get-planned-shifts-page" />">Planned
								Shifts</a></li>
						<li><a href="<c:url value="/user/createUser" />"
							class="header_nav_active">Create User</a></li>
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
		<div class="col-md-12">

			<div class="alert alert-danger" id="errorStatusDiv"
				style="display: none;">
				<i class="fa fa-times-circle-o"></i> <span id="msg"></span>
			</div>
			
			
			<c:if test="${usersuccessmsg ne null}">
				<div class="alert alert-success" id="createUser">
				
					<i class="fa fa-times-circle-o"></i> <span id="msg">${usersuccessmsg}</span>
				</div>

			</c:if>
			
			
			<c:if test="${userexistsmsg ne null}">
				<div class="alert alert-success" id="userNameErr">
					<i class="fa fa-times-circle-o"></i> <span id="msg">${userexistsmsg}</span>
				</div>

			</c:if>
			
			<c:if test="${empidexistsmsg ne null}">
				<div class="alert alert-success" id="empIdErr">
					<i class="fa fa-times-circle-o"></i> <span id="msg">${empidexistsmsg}</span>
				</div>

			</c:if>

			<form class="form-horizontal" action="/ShiftAllocator/user/add"
				role="form" method="post" autocomplete="off">

				<!--  <div class="alert alert-success">
        	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        	<i class="fa fa-check-circle-o fa-lg"></i> <strong>If user created this will be displayed.</strong>
        	</div>
            
            <div class="alert alert-danger">
        	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        	<i class="fa fa-times-circle-o fa-lg"></i> <strong>If error, this will be displayed.</strong>
        	</div> -->

				<!--row start-->
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-6 control-label">Username <span
								class="error-label">*</span></label>
							<div class="col-sm-6">

								<input type="text" name="userName" id="userName"
									class="form-control" placeholder="Username"
									onkeypress="remErrors(this.id)"> <span
									class="error-label" id="userNameErr"></span>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-6 control-label">Emp Id <span
								class="error-label">*</span></label>
							<div class="col-sm-6">
								<input type="text" name="empId" id="empId" class="form-control"
									placeholder="empId" onkeypress="remErrors(this.id)">
								<span class="error-label" id="empIdErr"></span>
							</div>
						</div>
					</div>
				</div>
				<!--row end-->
				<!--row start-->
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-6 control-label">Password <span
								class="error-label">*</span></label>
							<div class="col-sm-6">

								<input type="password" name="password" id="password"
									class="form-control" placeholder="Password"
									onkeypress="remErrors(this.id)"> <span
									class="error-label" id="passwordErr"></span>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-6 control-label">Email <span
								class="error-label">*</span></label>
							<div class="col-sm-6">

								<input type="email" name="email" id="email" class="form-control"
									placeholder="Email" onkeypress="remErrors(this.id)"> <span
									class="error-label" id="emailErr"></span>
							</div>
						</div>
					</div>


				</div>
				<!--row end-->
				<!--row start-->
				<div class="row">
				




					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-6 control-label">Re-type Password <span
								class="error-label">*</span></label>
							<div class="col-sm-6">

								<input type="password" name="reTypePassword" id="reTypePassword"
									class="form-control" placeholder="Retype Password"
									onkeypress="remErrors(this.id)"> <span
									class="error-label" id="reTypePasswordErr"></span>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-6 control-label">User Type <span
								class="error-label">*</span></label>
							<div class="col-md-6">

								<select class="form-control" name="userType" id="userType"
									onchange="remErrors(this.id)">
									<option value="other" selected="true">-- Select User type --</option>
									<option value="ProjectManager">ProjectManager</option>
									<option value="TeamLeader">TeamLeader</option>
									<option value="Employee">Employee</option>
								</select> <span class="error-label" id="userTypeErr"></span>
							</div>
						</div>
					</div>


				</div>
				<!--row end-->

				<div class="center">
					<button type="submit" class="btn btn-primary bold"
						onclick="return validateAdminCreateUserForm('form');" id="createUser">Create
						User</button>
					<button type="reset" class="btn btn-default bold"
						onclick="clearChangeProfileForm();">Clear</button>
				</div>



			</form>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/custom.js" />"></script>
</body>
</html>