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
    	if ($("#monitorInfoClass :selected").val()=='empty'){
    		 $('.updateForm').css('display','none');
    	};
    	if ($("#monitorInfoClass :selected").val()=='FlightRegistrationInfo'){
    		fillFlightRegistrationInfoForm();
    	};
    	if ($("#monitorInfoClass :selected").val()=='TwoFlightsRegistrationInfo'){
    		fillTwoFlightsRegistrationInfoForm();
    	};    		 
    	if ($("#monitorInfoClass :selected").val()=='ImageInfo'){
    		fillMonitorInfoForm("ImageInfoForm");
//    		$('.updateForm').css('display','none');
//    		$('#ImageInfoForm').css('display','block');
    	};    			 

    });    	            
});

function fillMonitorInfoForm(mode){
	a = $.ajax({
		url     : "fill" + mode,
		dataType: 'html',
		success : function(response){
			$('#updateInfoForm').html(response);
			$('.updateForm').submit(function(event) {
				
				
				
				FlightRegistrationInfoAJAX();
				
				
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

//One flight form
function fillFlightRegistrationInfoForm(){
	console.log('fillFlightRegistrationInfoForm()');
	a = $.ajax({
		url     : "fillFlightRegistrationInfoForm",
		dataType: 'html',
		success : function(response){
			console.log('populate form FlightRegistrationInfoForm');
			$('#updateInfoForm').html(response);
			$('#FlightRegistrationInfoForm').submit(function(event) {
				FlightRegistrationInfoAJAX();
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

function FlightRegistrationInfoAJAX(){
	console.log('FlightRegistrationInfoAJAX()');
	var monitor = $('#monitorChangeName').text();
	var flightNumber = $('#flight').val();
	var flightClass = $('#flightClass').val();
	a = $.ajax({
		url     : "setFlightRegistrationInfo",
		dataType: 'json',
		data    : "monitor=" + monitor + 
			"&flightNumber=" + flightNumber +
			"&flightClass="	 + flightClass,
		success : function(response){
			console.log('Update flightRegistrationInfo on '+response.monitor);
			$('#'+response.monitor).text(response.flightNumber+' ('+
					response.destination+') '+
					response.company+' - '+
					response.flightClass);
		},
		error   : function (response,status,e){
			console.log('error: '+e);
			console.log('response: '+response);
			console.log('status: '+status);
		}
	});
};

//Two flight form
function fillTwoFlightsRegistrationInfoForm(){
	console.log('fillTwoFlightsRegistrationInfoForm()');
	a = $.ajax({
		url     : "fillTwoFlightsRegistrationInfoForm",
		dataType: 'html',
		success : function(response){
			console.log('populate form TwoFlightsRegistrationInfoForm');
			$('#updateInfoForm').html(response);
			$('#TwoFlightsRegistrationInfoForm').submit(function(event) {
				TwoFlightsRegistrationInfoAJAX();
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

function TwoFlightsRegistrationInfoAJAX(){
	console.log('TwoFlightsRegistrationInfoAJAX()');
	var monitor = $('#monitorChangeName').text();
	var flight1 = $('#flight1').val();
	var flight2 = $('#flight2').val();	
	a = $.ajax({
		url     : "setTwoFlightsRegistrationInfo",
		dataType: 'json',
		data    : "monitor=" + monitor + 
			"&flight1=" + flight1 +
			"&flight2="	 + flight2,
		success : function(response){
			console.log('Update TwoFlightsRegistrationInfo on '+ response.monitor);
			$('#'+response.monitor).text(response.flightNumber1+' ('+
					response.destination1+') - '+
					response.company1+"; "+
					response.flightNumber2+' ('+
					response.destination2+') - '+
					response.company2+".");
		},
		error   : function (response,status,e){
			console.log('error: '+e);
			console.log('response: '+response);
			console.log('status: '+status);
		}
	});
};
