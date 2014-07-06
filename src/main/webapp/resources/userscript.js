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
    	//alert($("#monitorInfoClass :selected").val());
    	if ($("#monitorInfoClass :selected").val()=='empty'){
    		 $('.updateForm').css('display','none');
    	};
    	if ($("#monitorInfoClass :selected").val()=='FlightRegistrationInfo'){
    		fillFlightRegistrationInfoForm();
    	};
    	if ($("#monitorInfoClass :selected").val()=='TwoFlightsRegistrationInfo'){
    		$('.updateForm').css('display','none');
    		$('#TwoFlightsRegistrationInfoForm').css('display','block');
    	};    		 
    	if ($("#monitorInfoClass :selected").val()=='ImageInfo'){
    		$('.updateForm').css('display','none');
    		$('#ImageInfoForm').css('display','block');
    	};    			 

    });    	            
    
//    var autoRefresh = setInterval(function(){
//    		console.log('autoRefresh, AJAX()');
//    		AJAX();
//    	},1000)
});

function fillFlightRegistrationInfoForm(){
	console.log('fillFlightRegistrationInfoForm()');
	a = $.ajax({
		url     : "getFlights",
		dataType: 'html',
		success : function(response){
			console.log('Update flights list');
			$('#updateInfoForm').html(response);
    		$('.updateForm').css('display','none');
    		$('#FlightRegistrationInfoForm').css('display','block');			
		},
		error   : function (response,status,e){
			console.log('error: '+e);
			console.log('response: '+response);
			console.log('status: '+status);
		}
	});
}
