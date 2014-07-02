$(document).ready(function() {
    $("#test").click(function (event_test) {
        //$(this).slideUp();
        //alert(" ALERT ! ");
        console.log('$("#test").click(function ()');
        AJAX();
        event_test.preventDefault();
	});
    
    var autoRefresh = setInterval(function(){
    		console.log('autoRefresh, AJAX()');
    		AJAX();
    	},1000)
});

function AJAX() {
	var monitor = $('#monitor').text();
	var url = "show?monitorName="+monitor;
	console.log("AJAX() "+url);
	
	var pageContent = "";
		
	void function(pageContent) {
		a = $.ajax({
			url     : url,
			dataType: 'html',
			success : function(response){
				if (response.replace(/(\r\n|\n|\r)/gm,"") != $('#monitorInfo').html().replace(/(\r\n|\n|\r)/gm,"")){
					console.log('Data changed, update now!');
					$('#monitorInfo').html(response);
					pageContent = response;
				}else{
					//no update needed
					console.log('Data not changed, no update.');
				}
			},
			error   : function (response,status,e){
				console.log('error: '+e);
				console.log('response: '+response);
				console.log('status: '+status);
			}
		});
	}
}

