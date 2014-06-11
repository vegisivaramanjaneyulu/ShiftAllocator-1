var urlHolder = new Object();
function getShiftData(){

	debugger;
	$.post(urlHolder.month, {
		month: $('#month-form').val(),
		userName: $('#empName').val(),
		userType: $('#empType').val(),
		
	}, 
	function(response) {
		
		if(response == "null"){
			alert("Shifts Not Planned For Specified Month!!");
		}
		else {
			var obj = JSON.parse(response);
			//alert(obj.userShiftData.length);
			var userShift = obj.userShiftData;
			$('#weekOne tr:not(:first)').remove();
			$('#weekTwo tr:not(:first)').remove();
			$('#weekThree tr:not(:first)').remove();
			$('#weekFour tr:not(:first)').remove();
			$('#selectMonth').hide();
			$('#search').hide();
			$('#viewBy').hide();
			$('#formData').show();
			
			for(var i=0;i<userShift.length;i++){
				//alert(userShift[i].name+" "+userShift[i].shifts.week1+" "+userShift[i].weekOff.week1);
				
				var weekOne = '<tr>';
				weekOne += '<td width="50%" height="40">' + userShift[i].name + '</td>';
				weekOne += '<td width="30%" height="40">' + userShift[i].shifts.week1+ '</td>';
				weekOne += '<td width="30%" height="40">' + userShift[i].weekOff.week1 + '</td>';
				weekOne += '</tr>';
				
				$('#weekOne').append(weekOne);
				
				
				var weekTwo = '<tr>';
				weekTwo += '<td width="50%" height="40">' + userShift[i].name + '</td>';
				weekTwo += '<td width="30%" height="40">' + userShift[i].shifts.week2+ '</td>';
				weekTwo += '<td width="30%" height="40">' + userShift[i].weekOff.week2 + '</td>';
				weekTwo += '</tr>';
				
				$('#weekTwo').append(weekTwo);
				
				var weekThree = '<tr>';
				weekThree += '<td width="50%" height="40">' + userShift[i].name + '</td>';
				weekThree += '<td width="30%" height="40">' + userShift[i].shifts.week3+ '</td>';
				weekThree += '<td width="30%" height="40">' + userShift[i].weekOff.week3 + '</td>';
				weekThree += '</tr>';
			
				
				$('#weekThree').append(weekThree);
					
				var weekFour = '<tr>';
				weekFour += '<td width="50%" height="40">' + userShift[i].name + '</td>';
				weekFour += '<td width="30%" height="40">' + userShift[i].shifts.week4+ '</td>';
				weekFour += '<td width="30%" height="40">' + userShift[i].weekOff.week4 + '</td>';
				weekFour += '</tr>';
				
				$('#weekFour').append(weekFour);
					
			}
			
			
		} 
	}
);	

}
