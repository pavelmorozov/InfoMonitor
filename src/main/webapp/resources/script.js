$(document).ready(function() {
    var autoRefresh = setInterval(function(){
    		//console.log('autoRefresh, AJAX()');
    		AJAX();
    	},1000);
});

function AJAX() {
	var monitor = $('#monitor').text();
	var url = "show?monitorName="+monitor;
	//console.log("AJAX() "+url);
		a = $.ajax({
			url     : url,
			dataType: 'html',
			success : function(response){
				if (response != pageContent){
					//console.log('Data changed, update now!');
					$('#monitorInfo').html(response);
					$('.carousel').carousel({
						interval: 10000
					});
					pageContent = response;
				}else{
					//no update needed
					//console.log('Data not changed, no update.');
				}
			},
			error   : function (response,status,e){
//				console.log('error: '+e);
//				console.log('response: '+response);
//				console.log('status: '+status);
			}
		});
}

var pageContent = "";