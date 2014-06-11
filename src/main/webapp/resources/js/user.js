/* This function is used to validate the login form */

function loginFormvalidation(form) {

	var userName = jQuery.trim($("#userName").val());
	var password = jQuery.trim($("#password").val());
	var userType = jQuery.trim($("#userType").val());

	var userErrMsg = document.getElementById('userNameErr');
	var pswedErrMsg = document.getElementById('passwordErr');
	var userTypeErrmsg = document.getElementById('userTypeErr');

	var status = true;

	if (userName == '') {
		userNameErr.innerHTML = "Please Enter UserName";
		status = false;
	}

	if (password == '') {
		passwordErr.innerHTML = "Please Enter Password";
		status = false;
	}

	if (userType == 'other') {
		userTypeErr.innerHTML = "Please select any one User Type"
		status = false;
	}

	if (password != "" && password.length < 6) {

		passwordErr.innerHTML = "Password field should be of minimum 6 characters";

		status = false;
	}

	if (!status) {
		return false;
	}

}

/* This function is used to clear fields in change profile page */
function clearChangeProfileForm() {

	$('#name').val('');
	$('#userName').val('');
	$('#empId').val('');
	$('#email').val('');
	$('#password').val('');
	$('#reTypePassword').val('');
	$('#userType').val('');

}

function planshiftFormvalidation(form) {

	var dateStr = jQuery.trim($("#dateStr").val());

	var shiftCount = jQuery.trim($("#shiftCount").val());
	var shiftOneCount = jQuery.trim($("#shiftOneCount").val());
	var shiftTwoCount = jQuery.trim($("#shiftTwoCount").val());
	var shiftThreeCount = jQuery.trim($("#shiftThreeCount").val());

	var dateStrErrmsg = document.getElementById('dateStrErr');
	var shiftCountErrmsg = document.getElementById('shiftCountErr');
	var shiftOneCountErrmsg = document.getElementById('shiftOneCountErr');
	var shiftTwoCountErrmsg = document.getElementById('shiftTwoCountErr');
	var shiftThreeCountErrmsg = document.getElementById('shiftThreeCountErr');

	var status = true;

	var dateStr;

	if (dateStr == '') {

		dateStrErrmsg.innerHTML = "Please Select Date";
		status = false;
	}

	if (shiftCount == 0) {

		shiftCountErr.innerHTML = "Please Enter Number Of shifts";
		status = false;
	}

	if (shiftOneCount == 0) {

		shiftOneCountErrmsg.innerHTML = "Please Enter Number Of Employees per first shift";
		status = false;
	}
	if (shiftTwoCount == 0) {

		shiftTwoCountErrmsg.innerHTML = "Please Enter Number Of Employees per second shift";
		status = false;
	}
	if (shiftThreeCount == 0) {

		shiftThreeCountErrmsg.innerHTML = "Please Enter Number Of Employees per third shift";
		status = false;
	}

	if (!status) {
		return false;
	}

}

function validateAdminCreateUserForm(form) {

	var userName = jQuery.trim($("#userName").val());

	var userType = jQuery.trim($("#userType").val());

	var password = jQuery.trim($("#password").val());

	var reTypePassword = jQuery.trim($("#reTypePassword").val());

	var email = jQuery.trim($("#email").val());

	var empId = jQuery.trim($("#empId").val());

	var userNameErr = document.getElementById('userNameErr');

	var passwordErr = document.getElementById('passwordErr');

	var reTypePasswordErr = document.getElementById('reTypePasswordErr');

	var userTypeErr = document.getElementById('userTypeErr');
	var emailErr = document.getElementById('emailErr');
	var empIdErr = document.getElementById('empIdErr');

	var status = true;

	if (userName == '') {
		userNameErr.innerHTML = "Please Enter UserName";
		status = false;
	}

	if (password == '') {
		passwordErr.innerHTML = "Please Enter Password";
		status = false;
	}

	if (reTypePassword == '') {
		reTypePasswordErr.innerHTML = "Please Enter ReTypePassword";
		status = false;
	}

	if (email == '') {
		emailErr.innerHTML = "Please Enter Email";
		status = false;
	}

	if (userType == 'other') {
		userTypeErr.innerHTML = "Please select any one User Type"
		status = false;
	}

	if (empId == '') {
		empIdErr.innerHTML = "Please Enter EmployeeId"
		status = false;
	}

	if (password != "" && password.length < 6) {

		passwordErr.innerHTML = "Password field should be of minimum 6 characters";

		status = false;
	}

	if (password != "" && reTypePassword == "") {

		reTypePasswordErr.innerHTML = "ReTypPassword field is mandatory.";

		status = false;
	}

	if (reTypePassword != "" && reTypePassword.length < 6) {

		reTypePasswordErr.innerHTML = "Password field should be of minimum 6 characters";

		status = false;
	}

	if (password != reTypePassword) {

		reTypePasswordErr.innerHTML = "Password and ReTypPassword field values are not Same"

		status = false;

	}

	if (email != '') {
		var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		if (filter.test(email)) {
			status = true;
		} else {

			emailErr.innerHTML = "Invalid Email."

			status = false;
		}
	}

	if (!status) {
		return false;
	}

}

function login_onload() {

	$('#errorDiv').hide();
	$('#successDiv').hide();
}
