
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Shift Allocator - Login</title>
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
	
<script type="text/javascript" src="<c:url value='/resources/js/user.js'/>"></script>
<script type="text/javascript">
function validation(){
	var invalidcred='${invalid}';
	if(invalidcred !=null && invalidcred !=''){
		$("#errorDiv span#msg").html("Invalid credentials");
		$("#errorDiv").show(); 
		$("#successDiv").hide();		
		//return false;
	}
}
function remErrors(text){
	document.getElementById(text+'Err').innerHTML = '';
}
</script>
</head>
<body onload="validation();">

	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<img src="<c:url value="/resources/images/logo.png" />" alt="" />
				</div>
				
			</div>
		</div>
	</div>

	<!--content start-->
	<div class="container main_container">



		<div class="col-md-4 col-md-offset-4 col-lg-6 col-lg-offset-3">

		  <div class="login">	
		

			<!-- <div class="alert alert-danger" id="errorDiv">
				<i class="fa fa-times-circle-o"></i> <span id="msg"></span>
			</div> -->
			
			
			<c:if test="${invalid ne null}">
				<div class="alert alert-success" id="login">
					<i class="fa fa-times-circle-o"></i> <span id="msg">${invalid}</span>
				</div>

			</c:if>
			
			
			<c:if test="${logoutMsg ne null}">
				<div class="alert alert-success" id="login">
					<i class="fa fa-times-circle-o"></i> <span id="msg">${logoutMsg}</span>
				</div>

			</c:if>
			
			
			
			
			
				<form role="form" action="/ShiftAllocator/user/login" method="post" autocomplete="off">
					<div class="form-group">
						<label>Username</label>&nbsp <span style="color: red" id="userNameErr"> *</span> <input type="text" id="userName"
							name="userName" class="form-control" placeholder="Username" onkeypress="remErrors(this.id)">
							
							

					</div>
					<div class="form-group">
						<label>Password</label>&nbsp <span style="color: red" id="passwordErr"> *</span> <input type="password" id="password"
							name="password" class="form-control" placeholder="Password" onkeypress="remErrors(this.id)">

					</div>
					<div class="form-group">
						<label>User Type</label>&nbsp <span style="color: red" id="userTypeErr"> *</span> <select class="form-control"
							name="userType" id="userType"  onchange="remErrors(this.id)">
							<option value="ProjectManager">ProjectManager</option>
							<option value="TeamLeader">TeamLeader</option>
							<option value="Employee">Employee</option>
							<option  name="userType" value="other">other</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary btn-block bold"
						onclick="return loginFormvalidation('form');" id="login">Login</button>
				</form>
			</div>
			<div class="center bold">
				<a href="#">Forgot Password?</a>
			</div>
		</div>
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



	<script type="text/javascript">
		$(document).ready(function() {
			//setData(STATUSCODE, '${statusCode}');
	
			login_onload();
		});
	</script>



</body>
</html>