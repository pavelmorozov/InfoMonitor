$(document).ready(function() {
	$('#test').submit(function(event) {
		console.log("1000");
		//AJAX();
		event.preventDefault();
	});
});

//function AJAX() {
//	var monitor = $('#monitor').data(val());
//	var url = "show?monitorName="+monitor; 
//	
//	console.log(url);
//	
//	a = $.ajax({
//		url     : $("#fillUserAccount").attr("action"),
//		dataType: 'json',
//		data    : "account=" + account+ "&amount=" + amount,  
//		success : function(response){
//			//alert (response);
//			$('.hideAfterFill').css("display","none");
//			$('#fillResult').text(response.text);
//			$("#balance-"+account).text(response.balance);
//			setTimeout('$(\'#fillUserAccountPopUp\').css(\"display\",\"none\")',3000);
//		},
//		error   : function (response,status,e){
//			alert('error: '+e);
//		}
//	});
//};
