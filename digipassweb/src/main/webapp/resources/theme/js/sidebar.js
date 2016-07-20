/**
 * @author Adeptpros
 */
// $(".menu-items").on('click', function () {
		// $('.menu-items').next().slideUp("fast");
	// $(this).next().toggleClass('cmn-sub-menu');
   // });




// $(".menu-items").on('click', function () {	
	// $('.menu-items').next().removeClass("cmn-sub-mnu");
	// //console.log(r);
	// //alert("hi");
	// // var img_link = $(this).parent().prev().children('img').attr("src");
	// //$('.menu-items').parent().find('.cmn-sub-mnu').removeClass( "cmn-sub-menu" );
	// //$(this).next().addClass("cmn-sub-mnu");
	 // $(this).next().toggleClass('cmn-sub-menu').slideToggle("fast");
	 // // alert(img_link);
    // // $("#reports-sub-menu").slideToggle('fast'); 
    // // $(this).find('.cmn-sub-mnu').addClass('raghu');       
     // $(this).find('i').toggleClass('fa-chevron-down fa-chevron-up');
  // });


$("#report-drpdwn").on('click', function () {	
    $("#reports-sub-menu").slideToggle('fast');        
    $(this).find('i').toggleClass('fa-chevron-down fa-chevron-up');
  });
      
$("#Contents-drpdwn").on('click', function () {	
    $("#Contents-sub-menu").slideToggle('fast');       
    $(this).find('i').toggleClass('fa-chevron-down fa-chevron-up');
  });
      
$("#Campaigns-drpdwn").on('click', function () {
    $("#Campaigns-sub-menu").slideToggle('fast');       
    $(this).find('i').toggleClass('fa-chevron-down fa-chevron-up');
  });
  
if($('#reports-sub-menu').css('display') == 'block'){		  	
	 $("#report-drpdwn").find('i').toggleClass('fa-chevron-down fa-chevron-up');
}
if($('#Contents-sub-menu').css('display') == 'block'){		  	
	 $("#Contents-drpdwn").find('i').toggleClass('fa-chevron-down fa-chevron-up');
}
if($('#Campaigns-sub-menu').css('display') == 'block'){		  	
	 $("#Campaigns-drpdwn").find('i').toggleClass('fa-chevron-down fa-chevron-up');
}