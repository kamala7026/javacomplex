var Customer={
	searchCustomer :function(data){
		  $("subViewDiv").hide();
		  $("#customerDueDetails").hide();
		  $("#customerDueSearch").hide();
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
},
customerDueSearch:function(data){
	 ///$("#customerDueSearch").hide();
	// alert("customerDueSearch  "+$("#customerDueSearch").html());
		$.ajax({
			   url: 'customer_due_search.htm',
			   data: {
				   customerId: data
			   },
			   error: function(dataError) {
			      $('#info').html('<p>An error has occurred</p>');
			   },
			   dataType: 'html',
			   success: function(data) {
				   $("#customerDueSearch").html( data );
				   $("#customerDueSearch").show();
				   $( "#startDate" ).datepicker({
						format: "yyyy-mm-dd",
						inline: true,
						autoclose: true,
					});
					$( "#endDate" ).datepicker({
						format: "yyyy-mm-dd",
						inline: true,
						autoclose: true,
					});
				   //$("#customerDueSearch").show();
				   //alert("customerDueSearch  "+$("#customerDueSearch").html());

			   },
			   type: 'GET'
			});
}
}