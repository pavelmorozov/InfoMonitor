$(document).ready(function() {
    $("#test").click(function (event_test) {
        //$(this).slideUp();
        //alert(" ALERT ! ");
        console.log('$("#test").click(function ()');
        AJAX();
        event_test.preventDefault();
	});
});

function AJAX() {
	var monitor = $('#monitor').text();
	var url = "show?monitorName="+monitor;
	console.log("AJAX()");
	console.log(url);
}