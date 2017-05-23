var Customer={
	searchCustomer :function(data){
		  $("subViewDiv").hide();
		  $("#customerDueDetails").hide();
		$.ajax({
			   url: 'view_dues.htm',
			   data: {
			      customerId: data
			   },
			   error: function(dataError) {
			      $('#info').html('<p>An error has occurred</p>');
			   },
			   dataType: 'html',
			   success: function(data) {
				   $("#subViewDiv").html( data );
				   $("#subViewDiv").show();
				  
			   },
			   type: 'GET'
			});
	},

customerDueDetails :function(data){
	 $("#customerDueDetails").hide();
	$.ajax({
		   url: 'view_due_details.htm',
		   data: {
		      customerId: data
		   },
		   error: function(dataError) {
		      $('#info').html('<p>An error has occurred</p>');
		   },
		   dataType: 'html',
		   success: function(data) {
			   $("#customerDueDetails").html( data );
			   $("#customerDueDetails").show();
			   $('html,body').animate({scrollTop: document.body.scrollHeight},"slow");
		   },
		   type: 'GET'
		});
}
}