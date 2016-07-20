var newHostFormReset;
var editHostFormReset;

$(document).on("click", "#checkboxall", function() {	   
 var checkallstatus = $('#checkboxall').is(":checked");
	 if(checkallstatus){
	 	 $(".check").prop('checked', true);
	 	   var invite_access=$("#invite_access");
		   var grant_access=$("#grant_access");
		   var cancel_access=$("#cancel_access");
		   var delete_access=$("#delete_access");
		   
		   invite_access.parent().removeClass("disabled");
		   grant_access.parent().removeClass("disabled");
		   cancel_access.parent().removeClass("disabled");
		   delete_access.parent().removeClass("disabled");
	 }else{
	 	 $(".check").prop('checked', false);
	 }
});
$(document).on("click", ".check", function(val) {
	 var tablerowlen = ($("#userList").find("tr").length) - 1;
	 var that = $(this);
	 setTimeout(function() {
		if(that.attr("id") !== "checkboxall") {
			   var invite_access=$("#invite_access");
			   var grant_access=$("#grant_access");
			   var cancel_access=$("#cancel_access");
			   var delete_access=$("#delete_access");
			   
			   invite_access.parent().removeClass("disabled");
			   grant_access.parent().removeClass("disabled");
			   cancel_access.parent().removeClass("disabled");
			   delete_access.parent().removeClass("disabled");			   
			   $("#checkboxall").prop('checked', false);
			   var totalchecked1 = $('input[type=checkbox]:checked').size();
			   
		   if(totalchecked1==1){
			   var status=$("#"+that.val()).val();			   
			   if(status=="Added"){
				  // invite_access.parent().addClass("disabled");
				   grant_access.parent().addClass("disabled");
				   cancel_access.parent().addClass("disabled");
				   delete_access.parent().addClass("disabled");
			   }else if(status=="Invited"){
				   invite_access.parent().addClass("disabled");
				   grant_access.parent().addClass("disabled");
				   cancel_access.parent().addClass("disabled");
				   //delete_access.parent().addClass("disabled");
			   }else if(status=="Activated"){
				   invite_access.parent().addClass("disabled");
				   grant_access.parent().addClass("disabled");
				   //cancel_access.parent().addClass("disabled");
				   //delete_access.parent().addClass("disabled");
			   }else if(status=="Deactivated"){
				   invite_access.parent().addClass("disabled");
				   //grant_access.parent().addClass("disabled");
				   cancel_access.parent().addClass("disabled");
				   //delete_access.parent().addClass("disabled");
			   }else if(status=="Disabled"){
				   invite_access.parent().addClass("disabled");
				   //grant_access.parent().addClass("disabled");
				   cancel_access.parent().addClass("disabled");
				   delete_access.parent().addClass("disabled");
			   }
		   }else{
			   
		   }
		} 
		var valueMem;
	    var totalchecked = $('input[type=checkbox]:checked').size();
	    if(tablerowlen == totalchecked) {
			  $("#checkboxall").prop('checked', true);			} 
		if(totalchecked > 0) {
			$(".checkshow").css("display", "inline");
		}else {
			$(".checkshow").css("display", "none");
		}
    });
});
$(document).ready(function() {
	$("#manage-host-modal-upload-form").validate({
		rules: {
			hostFile: {
				required: true
			}
		},
		messages: {
			hostFile: {
				required: "This filed is required"
			}
		}
		
		
	});
});
$(document).ready(function() {

	// validate signup form on keyup and submit
	editHostFormReset=$("#editHostForm").validate({
		rules: {
			firstName: "required",
			lastName: "required",
			department:"required",
			userType: "required",
			buidingNo: "required",
			email1:{
				required: true,
				email: true
			},
			email2:{
				email: true
			},
			phoneNo1:{
				required: true,
				maxlength: 10,
				minlength:10,
				number: true
			},
			phoneNo2:{				
				maxlength: 10,
				minlength:10,
				number: true
			},
			addressLine1:"required",
			city:"required",
			state:"required",
			pincode:"required",
			expiredDate:"required",	
			expiredTime:"required"
			
			
		},
		messages: {
			firstName: "Please enter First name",
			lastName: "Please enter Last Name",
			department:"Please enter department",
			userType: "Please enter user type",
			buidingNo: "Please enter Buidling Name/Number",
			email1: {
				required:"Please enter Email",
				email:"Enter valid Email Address"
			},
			email2: {				
				email:"Enter valid Email Address"
			},
			phoneNo1:{
				required:"Please enter Phone Number",
				number:"Enter valid Phone Number",
				maxlength:"Enter valid Phone Number",
				minlength:"Enter valid Phone Number"
			},
			phoneNo2:{				
				number:"Enter valid Phone Number",
				maxlength:"Enter valid Phone Number",
				minlength:"Enter valid Phone Number"
			},
			addressLine1:"Please enter Address",
			city:"Please enter City",
			state:"Please enter State",
			pincode:"Please enter Pincode",
			expiredDate:"Please enter Expiry Date",	
			expiredTime:"Please enter Expiry Time"
			
			/*username: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address",
			agree: "Please accept our policy",
			topic: "Please select at least 2 topics"*/
		}
		
		
	});
});

$(document).ready(function() {
	
	// validate signup form on keyup and submit
	newHostFormReset=$("#newHostForm").validate({
		rules: {
			firstName: "required",
			lastName: "required",
			department:"required",
			userType: "required",
			buidingNo: "required",
			email1:{
				required: true,
				email: true
			},
			email2:{
				email: true
			},
			phoneNo1:{
				required: true,
				maxlength: 10,
				minlength:10,
				number: true
			},
			phoneNo2:{				
				maxlength: 10,
				minlength:10,
				number: true
			},
			addressLine1:"required",
			city:"required",
			state:"required",
			pincode:"required",
			expiredDate:"required",	
			expiredTime:"required"
			
			
		},
		messages: {
			firstName: "Please enter First name",
			lastName: "Please enter Last Name",
			department:"Please enter department",
			userType: "Please enter user type",
			buidingNo: "Please enter Buidling Name/Number",
			email1: {
				required:"Please enter Email",
				email:"Enter valid Email Address"
			},
			email2: {				
				email:"Enter valid Email Address"
			},
			phoneNo1:{
				required:"Please enter Phone Number",
				number:"Enter valid Phone Number",
				maxlength:"Enter valid Phone Number",
				minlength:"Enter valid Phone Number"
			},
			phoneNo2:{				
				number:"Enter valid Phone Number",
				maxlength:"Enter valid Phone Number",
				minlength:"Enter valid Phone Number"
			},
			addressLine1:"Please enter Address",
			city:"Please enter City",
			state:"Please enter State",
			pincode:"Please enter Pincode",
			expiredDate:"Please enter Expiry Date",	
			expiredTime:"Please enter Expiry Time"
			
			/*username: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address",
			agree: "Please accept our policy",
			topic: "Please select at least 2 topics"*/
		}
		
		
	});
	
	/*$(document).ready(function() {

		// validate signup form on keyup and submit
		$("#editHostForm").validate({
			rules: {
				firstName: "required",
				lastName: "required",
				userType: "required",
				buidingNo: "required",
				email1:{
					required: true,
					email: true
				},
				email2:{
					email: true
				},
				phoneNo1:{
					required: true,
					maxlength: 10,
					minlength:10,
					number: true
				},
				phoneNo2:{				
					maxlength: 10,
					minlength:10,
					number: true
				},
				addressLine1:"required",
				city:"required",
				state:"required",
				pincode:"required",
				expiredDate:"required",	
				expiredTime:"required"
				
				username: {
					required: true,
					minlength: 2
				},
				password: {
					required: true,
					minlength: 5
				},
				confirm_password: {
					required: true,
					minlength: 5,
					equalTo: "#password"
				},
				email: {
					required: true,
					email: true
				},
				topic: {
					required: "#newsletter:checked",
					minlength: 2
				},
				agree: "required"
			},
			messages: {
				firstName: "Please enter firstname",
				lastName: "Please enter lastname",
				userType: "Please enter user type",
				buidingNo: "Please enter Buidling No/Flat No",
				email1: {
					required:"Please enter Email",
					email:"Enter valid Email Address"
				},
				email2: {				
					email:"Enter valid Email Address"
				},
				phoneNo1:{
					required:"Please enter Phone Number",
					number:"Enter valid Phone Number",
					maxlength:"Enter valid Phone Number",
					minlength:"Enter valid Phone Number"
				},
				phoneNo2:{				
					number:"Enter valid Phone Number",
					maxlength:"Enter valid Phone Number",
					minlength:"Enter valid Phone Number"
				},
				addressLine1:"Please enter Address",
				city:"Please enter City",
				state:"Please enter State",
				pincode:"Please enter Pincode",
				expiredDate:"Please enter Expiry Date",	
				expiredTime:"Please enter Expiry Time"
				
				username: {
					required: "Please enter a username",
					minlength: "Your username must consist of at least 2 characters"
				},
				password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 5 characters long"
				},
				confirm_password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 5 characters long",
					equalTo: "Please enter the same password as above"
				},
				email: "Please enter a valid email address",
				agree: "Please accept our policy",
				topic: "Please select at least 2 topics"
			}
		});*/
	
	    $('#delete_access').click(function(){
	    	if($('#delete_access').parent().attr("class")!=="disabled"){
	    		$('#delete_confirm') .modal({ backdrop: 'static', keyboard: false }).one('click', '#delete', function (e) {
		        	$("#action_type").val("DELETE");
		            $('#form_access').submit();
		        });
	    	}else {
	    		return false;
	    	}		    
		});
	    $('#invite_access').click(function(){
	    	if($('#invite_access').parent().attr("class")!=="disabled"){
	    		 $('#invite_confirm') .modal({ backdrop: 'static', keyboard: false }).one('click', '#invite', function (e) {
	 	        	$("#action_type").val("INVITED");
	 	            $('#form_access').submit();
	 	        });
	    	}else{
	    		return false;
	    	}
		   
		});
	    $('#grant_access').click(function(){
	    	if($('#grant_access').parent().attr("class")!=="disabled"){
	    		 $('#grant_confirm') .modal({ backdrop: 'static', keyboard: false }).one('click', '#grant', function (e) {
	 	        	$("#action_type").val("GRANTACCESS");
	 	            $('#form_access').submit();
	 	        });
	    	}else{
	    		return false;
	    	}
		   
		});
	    $('#cancel_access').click(function(){
	    	if($('#cancel_access').parent().attr("class")!=="disabled"){
	    		$('#cancel_confirm') .modal({ backdrop: 'static', keyboard: false }).one('click', '#cancel', function (e) {
		        	$("#action_type").val("CANCEL");
		            $('#form_access').submit();
		        });
	    	}else{
	    		return false;
	    	}
		    
		});
	    
	    $(".cancel").click(function() {
	    	
			newHostFormReset.resetForm();
			editHostFormReset.resetForm();
		});
});

	$(document).ready(function() {
	    $('#userList').DataTable({
	    	"bSort": false
	    });
	    $('#adduser_btn').click(function(){
	    	newHostFormReset.resetForm();
			editHostFormReset.resetForm();
			$('#addUser').modal('show');
	    });
	   
	    $('#uploadUsers').click(function(){
		    $('#excelupload').modal('show');
		});
	});
	 var texts = $("td").map(function() {
		 if($(this).text()=="Added"){
             var green = $(this).addClass( "user-added" );                                         
             return $(this).text();
	     }else{
	             var green = $(this).removeClass( "user-added" );
	     }
		 if($(this).text()=="Invited"){
             var green = $(this).addClass( "user-invited" );                                         
             return $(this).text();
	     }else{
	             var green = $(this).removeClass( "user-invited" );
	     }
		 
         if($(this).text()=="Activated"){
                 var green = $(this).addClass( "user-active" );                                         
                 return $(this).text();
         }else{
                 var green = $(this).removeClass( "user-active" );
         }
         if($(this).text()=="Deactivated"){
                 var red = $(this).addClass( "user-inactive" );                                         
                 return $(this).text();
         }else{
                 $(this).removeClass("user-inactive");
         }
         if($(this).text()=="Disabled"){
             var red = $(this).addClass( "user-inactive" );                                         
             return $(this).text();
	     }else{
	             $(this).removeClass("user-inactive");
	     }
	 });
	 
	 
	/* 
	 $(document).ready(function(){
		 $("#grand_access").click(function(){
			$("#action_type").val("GRANTACCESS");
			
		});
		 $("#delete_access").click(function(){
			$("#action_type").val("DELETE");
			
		}); 
		$("#cancel_access").click(function(){
			$("#action_type").val("CANCEL");
			
		});
	 }); */
	 
	 
	 $('#expirytime').timepicki({
		 orientation:true,
	    show_meridian:true,
	   /*  min_hour_value:0,
	    max_hour_value:23, */
	});
	$( "#expirydate" ).datepicker({
		format:"dd/mm/yyyy",
		startDate: new Date(),
	}).on('changeDate', function(ev){
	    $(this).datepicker('hide');
	});
	
	 $('#expirytime1').timepicki({
		    show_meridian:true,
		   /*  min_hour_value:0,
		    max_hour_value:23, */
		});
		$( "#expirydate1" ).datepicker({
			format:"dd/mm/yyyy",
			startDate: new Date()
		}).on('changeDate', function(ev){
		    $(this).datepicker('hide');
		});;

		function editHostAjax(hostId) {
			var data ="hostId="+hostId;
			
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url :editHostAction,
				data : data,
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					//alert(data.firstName+" "+data.lastName);
					//console.log("SUCCESS: ", data);
					$('#firstName1').val(data.firstName);
					$('#lastName1').val(data.lastName);
					$('#Type1').val(data.userType);
					$('#buidingNo1').val(data.buidingNo);
					$('#email11').val(data.email1);
					$('#email21').val(data.email2);
					$('#phoneNo11').val(data.phoneNo1);
					$('#phoneNo21').val(data.phoneNo2);
					$('#addressLine11').val(data.addressLine1);
					$('#addressLine21').val(data.addressLine2);
					$('#city1').val(data.city);
					$('#address1state1').val(data.state);
					$('#pincode1').val(data.pincode);
					$('#expirydate1').val(data.expiredDate.substring(0,10));
					$('#expirytime1').val(data.expiredDate.substring(11,19));
					$('#hostUserId1').val(data.hostUserId);
					$('#department1').val(data.department);
					
					 $('#editUser').modal('show');
					
				},
				error : function(e) {
					console.log("ERROR: ", e);
					
				},
				done : function(e) {
					//console.log("DONE");
				}
			});
		}
		function duplicateCheck(action,value,element) {
			var data ="action="+action+"&value="+value;			
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url :duplicateCheckAction,
				data : data,
				dataType : 'json',
				timeout : 100000,
				success : function(data) {					
					var status=data.status;
					if(status=="DUPLICATE"){
						$("#"+element).after('<label id="email1-error" class="error" for="email1" style="display: inline-block;">Email ID already registered.</label>')
					}else if(status="NOTDUPLICATE"){
						$(".btn-popup").attr("disabled","false");
					}else if(status=="ERROR"){
						console.log("Error in server");
					}								
				},
				error : function(e) {
					console.log("ERROR: ", e);					
				},
				done : function(e) {
					//console.log("DONE");
				}
			});
		}
$(document).ready(function() {
	   
	    
	    $.widget("ui.tooltip", $.ui.tooltip, {
	        options: {
	            content: function () {
	                return $(this).prop('title');
	            }
	        }
	    });
	    $(function () {
	        $('.item').attr('title', function(){
	            return $(this).next('.statusRollup').remove().html()
	        })
	        $(document).tooltip();
	    });   
	});

$(document).ready(function() {
    $("#phoneNo1").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A, Command+A
            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    $("#phoneNo2").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A, Command+A
            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    $("#phoneNo11").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A, Command+A
            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    $("#phoneNo21").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A, Command+A
            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    $("#pincode1").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A, Command+A
            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    $("#pincode").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A, Command+A
            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
});


