var Stock={
	searchProductDetails :function(productId){
		  $("subViewDiv").hide();
		$.ajax({
			   url: 'view_stock_details.htm',
			   data: {
			      productId: productId,
			   
			   },
			   error: function(dataError) {
			      $('#info').html('<p>An error has occurred</p>');
			   },
			   dataType: 'html',
			   success: function(data) {
				   $("#subViewDiv").html( data );
				   $("subViewDiv").show();
				  
			   },
			   type: 'GET'
			});
	},
	fetchProductDetails :function(productId){
		  $("subViewDiv").hide();
		$.ajax({
			   url: 'fetch_stock_details_for_edit.htm',
			   data: {
			      productId: productId,
			   
			   },
			   error: function(dataError) {
			      $('#info').html('<p>An error has occurred</p>');
			   },
			   dataType: 'html',
			   success: function(data) {
				   $("#subViewDiv").html( data );
				   $("subViewDiv").show();
				   $('html,body').animate({scrollTop: document.body.scrollHeight},"slow");
			   },
			   type: 'GET'
			});
	}
}