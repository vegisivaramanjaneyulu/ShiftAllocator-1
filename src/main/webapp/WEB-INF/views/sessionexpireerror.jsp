
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
            	<div class="col-md-4"><img src="<c:url value="/resources/images/logo.png" />" alt=""/></div>
                <div class="col-md-7">
                    <ul class="header_nav">
                      
                      <li><a href="<c:url value="/" />" class="header_nav_active">Home</a></li>
                    
                    </ul>
                </div>
                
            </div>
        </div>
    </div> 
	
	
	<div class="alert alert-info full-height">
			Your session has expired. Please login again.
        </div>


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

