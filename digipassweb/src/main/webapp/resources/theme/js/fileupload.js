 $(document).ready(function() {
			 
		$("#uploadImg").on("click", function() {
     	 $("#upload-file").trigger("click");
    //  document.getElementById("fileupload").click();
    });
    
		  });
		  
		  
		function PreviewImage() {
    	//alert("hi");
            var oFReader = new FileReader();
            oFReader.readAsDataURL(document.getElementById("upload-file").files[0]);
            oFReader.onload = function (oFREvent) {
                var sizef = document.getElementById('upload-file').files[0].size;
                //alert(sizef+ "kb");
                var imgUrl = $('#uploadImg').val();
                //console.log(oFREvent.target.result);
                document.getElementById("uploadImg").src = oFREvent.target.result;
               
               //  document.getElementById("uploadImageValue").value = oFREvent.target.result; 
            };
        };
        
// 
// function Upload() {
            // var fileUpload = document.getElementById("fileUpload");
            // if (typeof (fileUpload.files) != "undefined") {
                // var size = parseFloat(fileUpload.files[0].size / 1024).toFixed(2);
                // alert(size + " KB.");
            // } else {
                // alert("This browser does not support HTML5.");
            // }
        // }