$( document ).ready(function() {
	
	jQuery.validator.addMethod("strongPassword", function(value, element) {
  // allow any non-whitespace characters as the host part
  return this.optional( element ) || /^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])/.test( value );
}, 'Passsword must be more than 6 characters and should contain one uppercase, one digit and one special character.');
	
	
	jQuery.validator.addMethod("strongemail", function(value, element) {
  // allow any non-whitespace characters as the host part
  return this.optional( element ) || /^\w+[\+\.\w-]*@(?=[a-z0-9](?=[a-z0-9-][a-z0-9])?\.)+[a-z0-9](?=[a-z0-9-]*[a-z0-9])?/.test( value );
}, 'done.');

	jQuery.validator.addMethod("raghu", function(value, element) {
  // allow any non-whitespace characters as the host part
  return this.optional( element ) || /^([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\.[A-Za-z]{2,4})/.test( value );
}, 'error.');
	
	//[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@
//(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?
	
	//^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-][a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/
	$("#location-form").validate({
	rules:{
		commName:{
			required:true,
	},
	commAddress:{
		required:true,
	},
	commPhNo:{
		required:true,
	},
	commEmail:{
		required:true,
		//raghu:true,
	},
	commPricRange:{
		required:true,
	},
	AssignBuilder:{
		required:true,
	},
	phone:{
		required:true,
	},
	commSocialRange:{
		required:true,
	}
	},
	/*messages: {
     enquiryType: {
      required: "Please select an option from the list."
     },
     about: {
      required: "Please select an option from the list."
     }
    }*/
}); // end of index page form validation



});