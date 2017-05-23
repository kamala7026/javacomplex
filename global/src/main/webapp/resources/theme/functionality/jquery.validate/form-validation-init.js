!function($) {
    "use strict";

    var FormValidator = function() {
        this.$addCustomer = $("#addCustomer");
        this.$addStock = $("#addStock");
        this.$addCash = $("#addCash");
        this.$printCustomerDetails = $("#printCustomerDetails");
        this.$showProfitLoss = $("#showProfitLoss");
    };

    FormValidator.prototype.init = function() {
        $.validator.setDefaults({
            submitHandler: function() { 
            this.$addCustomer.submit(); 
            this.$addStock.submit(); 
            this.$addCash.submit(); 
            this.$printCustomerDetails.submit(); 
            this.$showProfitLoss.submit(); 
            }
        });

        this.$printCustomerDetails.validate({
            rules: {
            	startDate: {
                    required: true,
                },
                endDate: {
                    required: true,
                }
            },
            messages: {
            	startDate: {
                    required: "Please select start Date",
                },
                endDate: {
                    required: "Please select end Date",
                }
            }
        });
        this.$showProfitLoss.validate({
            rules: {
            	startDate: {
                    required: true,
                },
                endDate: {
                    required: true,
                }
            },
            messages: {
            	startDate: {
                    required: "Please select start Date",
                },
                endDate: {
                    required: "Please select end Date",
                }
            }
        });
        this.$addCustomer.validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2
                },
                gnumber: {
                    required: true,
                },
                mobile: {
                    required: true,
                    number: true,
                    minlength: 10,
                    maxlength:10
                }
               
                
            },
            messages: {
            	name: {
                    required: "Please enter a name",
                    minlength: "Your username must consist of at least 2 characters"
                },
                gnumber: {
                    required: "Please enter a Godown number",
                },
                mobile: {
                    required: "Please enter a valid mobile number",
                    minlength: "Mobile number must consist of 10 characters",
                    maxlength: "Mobile number must consist of 10 characters"

                }
            }
        });
        this.$addStock.validate({
            rules: {
            	productName: {
                    required: true,
                    minlength: 2
                },
                quantity: {
                    required: true,
                },
                purchasePrice: {
                	   required: true,
                },
                purchaseVat: {
             	   required: true,
             },
            },
            messages: {
            	productName: {
                    required: "Please enter a ProductName",
                    minlength: "Your ProductName must consist of at least 2 characters"
                },
                quantity: {
                    required: "Please enter a qunatity",
                },
                purchasePrice: {
                	 required: "Please enter a purchase price",
                },
                purchaseVat: {
               	 required: "Please enter a purchase vat",
               },

            }
        });
        this.$addCash.validate({
            rules: {
            	customerId: {
                    required: true,
                    minlength: 2
                },
                amount: {
                    required: true,
                },
                typeOfTransact: {
                	   required: true,
                },
            },
            messages: {
            	customerId: {
                    required: "Please select a customer",
                    minlength: "Your customer name must consist of at least 2 characters"
                },
                amount: {
                    required: "Please enter a Amount",
                },
                typeOfTransact: {
                	 required: "Please select a payment type",
                },

            }
        });
        $( "#dob" ).datepicker({
			inline: true
		});
    },
    //init
    $.FormValidator = new FormValidator, $.FormValidator.Constructor = FormValidator
}(window.jQuery),



//initializing 
function($) {
    "use strict";
    $.FormValidator.init()
}(window.jQuery);