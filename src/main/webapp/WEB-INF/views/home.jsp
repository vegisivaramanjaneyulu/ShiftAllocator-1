<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />


<script type='text/javascript'>
	$(function() {
		
	

	});
	
	
	 

</script>

</head>

<body>


<h1 id='banner'>ShiftAllocator-->${month}</h1>


<!-- <div class="main-container">
	<div class="login">
		<form action="/emp/login" method="post">
        	<input name="uname" type="text" placeholder="Username" />
        	<input name="pwd" type="password" placeholder="Password" />
        	<input name="pwd" type="password" placeholder="Password" />
        	
      	<input type="submit" name="button" id="button" value="Login" />
    	</form>
    </div> -->
    
    
    	<div >
	 <form >
  			<fieldset>
				<legend>Create New User</legend>
				<label for='newUsername'>Username</label><input type='text' id='newUsername'/><br/>
				<label for='newPassword'>Password</label><input type='password' id='newPassword'/><br/>
				
				<label for='newRole'>Role</label>
					<select id='newRole'>
						<option value='Admin'>ProjectManager</option>
						<option value='TeamLeader'>ProjectTeamLead</option>
						<option value='other'>Employee</option>
						<option value='4' selected='selected'>Regular</option>
					</select>
  			</fieldset>
			<input type='button' value='Close' id='closeNewForm' />
			<input type='submit' value='Submit'/>
		</form>
		 
		
		
		<%-- 
        <form:form method="post" action="/shiftcaluclator/emp/login" commandName="document" enctype="multipart/form-data">
    	
    	<table border="1" width="750" bgcolor="#00FF00">
  
    	<tr>
                    <td><label for="uname">Username: </label></td>
                    <td><input type="text" name="uname"
                        id="unameInput" /></td>
                </tr>
            <tr>
    		<td><form:label path="pwd">Password</form:label></td>
    		<td><form:input path="pwd" /></td>
    	</tr>
    	<tr>
    		<td>
    		
             <ul>
             <form:select path="Role">  </td>
                <form:option value="Admin">ProjectManager</form:option>
                <form:option value="TeamLeader">TeamLeader</form:option>
                <form:option value="Employee">Employee</form:option> 
                <form:option selected="selected" value="htc">other</form:option>
                
           </form:select> </ul>  </td></tr>
    
    
 </table>    
</form:form>   --%>
    
 
    
    
</div>



</body>
</html>