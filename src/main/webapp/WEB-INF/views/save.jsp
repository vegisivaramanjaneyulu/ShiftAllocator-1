<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>shift Caluclator</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="main-container">
		<div class="innerdata">
			<form:form action="/shiftcaluclator/emp/add" method="post" commandName="emp">
				<div class="form-group">
					<label>UserName </label>
					<form:input path="name" />
				</div>

				<div class="form-group">
					<label>Password </label>
					<form:input path="password" />
				</div>

				<div class="form-group">
					<label>ReTypepassword </label>
					<form:input path="reTypePassword" />
				</div>

				<div class="form-group">
					<label>UserType </label>
					<form:input path="userType" />
				</div>

				<div class="form-group">
					<label>Email </label>
					<form:textarea path="email" />
				</div>
				 <div class="form-group">
        		<label> &nbsp;</label>
				<input type="submit" name="button" id="button"  class="btn green-bg" value="Submit" /></div>
			</form:form>
		</div>
	</div>
 

</body>
</html>