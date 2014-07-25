$(document).ready(function() {
    $("#test").click(function (event_test) {
        console.log('$("#test").click(function ()');
        AJAX();
        event_test.preventDefault();
	});
    
    $( ".btn" ).click(function() {
    	//alert( "Handler for .click() called. "+$(this).data("monitor"));
    	$('#monitorChangeName').text($(this).data("monitor"));
    	$('#monitorChangeData').modal();

    });

    $('#monitorInfoClass').change(function(){
    	var populateForm = $("#monitorInfoClass :selected").val();
    	fillMonitorInfoForm(populateForm);
    });    	            
});

function fillMonitorInfoForm(mode){
	if (mode == 'empty'){
		$('.updateForm').html('');
		return;
	}
	a = $.ajax({
		url     : mode,
		dataType: 'html',
		success : function(response){
			$('#updateInfoForm').html(response);
			$('.updateForm').submit(function(event) {
				var mode = $("#monitorInfoClass :selected").val();
				ChangeMonitorInfoAjax(mode);
				$('#monitorChangeData').modal('hide');
				event.preventDefault();
			});    
		},
		error   : function (response,status,e){
			console.log('error: '+e);
			console.log('response: '+response);
			console.log('status: '+status);
		}
	});
};

function ChangeMonitorInfoAjax(mode){
	var monitor = $('#monitorChangeName').text();
	var requestData;
	if (mode == 'FlightRegistrationInfo'){
		var flightNumber = $('#flight').val();
		var flightClass = $('#flightClass').val();
		requestData = "monitor=" + monitor + 
			"&flightNumber=" + flightNumber +
			"&flightClass="	 + flightClass;
	}else if (mode == 'TwoFlightsRegistrationInfo'){
		var flight1 = $('#flight1').val();
		var flight2 = $('#flight2').val();
		requestData = "monitor=" + monitor + 
			"&flight1=" + flight1 +
			"&flight2="	 + flight2;
	}else if (mode == 'ImageInfo'){
		var image = $('#image').val();
		requestData = "monitor=" + monitor + 
		"&image=" + image;		
	}else{
		console.log('Unknown mode '+response.monitor);
	}	
	a = $.ajax({
		url     : "set"+mode,
		dataType: 'json',
		data    : requestData,
		success : function(response){
			console.log('Update' + +response.monitor);
			$('#'+response.monitor).text(response.MonitorInfoString);
		},
		error   : function (response,status,e){
			console.log('error: '+e+'status: '+status+ 'response: '+response);
		}
	});	
};

