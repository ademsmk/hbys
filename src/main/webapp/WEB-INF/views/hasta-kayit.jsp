<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>

    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.3.1/jquery.maskedinput.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.3.1/jquery.maskedinput.min.js"></script>


<title>Contact List Screen</title>

	<div align="center">
<jsp:include page="../views/header.jsp" />

<script type ="text/javascript">


$(document).ready(function(){
	

	 
	yes_js_login = function(personid) {
       
		
		swal({
			  title: "Are you sure?",
			  text: "You will not be able to recover it!",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-danger",
			  confirmButtonText: "Yes, delete it!",
			  cancelButtonText: "No, cancel!",
			  closeOnConfirm: false,
			  closeOnCancel: false
			},
			function(isConfirm) {
			  if (isConfirm) {
			    swal("Deleted!", "Successfully deleted.", "success");
			    setTimeout(function () {
				    window.location.href = "person/delete?id="+personid;
			     }, 2000); 
			    
			  } else {
			    swal("Cancelled", "Successfully cancelled", "error");
			    setTimeout(function () {
				    window.location.href = "person";
			     }, 2000); 
			  }
			});

			
			return false;
			
			
   }
	
	$("#tel-no").keydown(function (e) {
		var key = e.charCode || e.keyCode || 0;
		$phone = $(this);

		// Auto-format- do not expose the mask as the user begins to type
		if (key !== 8 && key !== 9) {
			if ($phone.val().length === 4) {
				$phone.val($phone.val() + ')');
			}
			if ($phone.val().length === 5) {
				$phone.val($phone.val() + ' ');
			}			
			if ($phone.val().length === 9) {
				$phone.val($phone.val() + '-');
			}
		}

		// Allow numeric (and tab, backspace, delete) keys only
		return (key == 8 || 
				key == 9 ||
				key == 46 ||
				(key >= 48 && key <= 57) ||
				(key >= 96 && key <= 105));	
	});
	
	$('#tel-no').bind('focus click', function () {
		$phone = $(this);
		
		if ($phone.val().length === 0) {
			$phone.val('(');
		}
		else {
			var val = $phone.val();
			$phone.val('').val(val); // Ensure cursor remains at the end
		}
	});
			
	$('#tel-no').blur(function () {
		$phone = $(this);
		
		if ($phone.val() === '(') {
			$phone.val('');
		}
	});
		
		
		
	$("#hellojs").submit(function() {
		
		var tckimlik_no = $("#tckimlik_no").val();
		
		if($("#tckimlik_no").val().length != 11){
			event.preventDefault();
			swal(
					
					  'Uyarı!',
					  'TC Kimlik Numarası 11 haneli olmak zorunda!',
					  'error'
					
					)
			
		}
		else{
			swal(
					  'Good job!',
					  'Hasta Eklendi!',
					  'success'
				)
				
				event.preventDefault();
			
			setTimeout( function () { 
	        hellojs.submit();
	    }, 1500);
		}
		
		
	})
	
	$("#tckimlik_no").keypress(function (e) {
		  
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {  
	         return false;
	              
	    }
	   });
	

});



</script>


</head>
<body>

<div class="container" style="border:1px solid#000; padding-bottom: 20px;">
<div align = left style="padding-top: 20px;">

		

	    <form:form action="patient" id="hellojs" method="post" commandName="patientForm" class="form-inline" >
               
	<div>
  <div class="col-lg-6 col-md-6 col-sm-6">
  			 <div class="col-lg-12 col-md-12 col-sm-12 ">Adı Soyadı</div><br/>
	 		 <div class="col-lg-12 col-md-12 col-sm-12"><div class="form-group"><form:input   class="form-control" id="add-name" type="text" placeholder="Adı Soyadı" path="adisoyadi" /></div></div>
 </div>
  
    <div class="col-lg-6 col-md-6 col-sm-6">
  			 <div class="col-lg-12 col-md-12 col-sm-6">TC Kimlik Numarası</div>
	 		 <div class="col-lg-12 col-md-12 col-sm-6"><div class="form-group"><form:input class="form-control" id="tckimlik_no" type="text" maxlength="11" placeholder="TC Kimlik Numarasi" path="tckimlik_no"></form:input></div></div>
	 		
  </div>
	</div>
	
	

   <div class="col-lg-6 col-md-6 col-sm-6">
   <br>		
		
			
			<div class="form-group" style="padding-left: 15px;">Doğum Tarihi </div><br/>
	   		<div class="form-group"><form:input  style="margin-left:15px;margin-top:5px;width: 196px;" class="form-control col-lg-12 col-md-12 col-sm-12"  id="datepicker" type="date" placeholder="Doğum Tarihi" path="dogum_tarihi"></form:input></div><br/>
	   		<div class="form-group"><form:input style="margin-left:15px; margin-top:5px;" class="form-control col-lg-12 col-md-12 col-sm-12" id="add-email" type="text" placeholder="Doğum Yeri" path="dogum_yeri"></form:input></div><br/>
	  		<div class="form-group"><form:input style="margin-left:15px; margin-top:5px;" class="form-control col-lg-12 col-md-12 col-sm-12"  id="add-number" type="text" placeholder="Baba Adı" path="baba_adi"></form:input></div><br/>
	    	<div class="form-group"><form:input style="margin-left:15px; margin-top:5px; margin-bot:5px;" class="form-control col-lg-12 col-md-12 col-sm-12"  id="add-number" type="text" placeholder="Anne Adı" path="anne_adi"></form:input></div><br/>
	    	<div class="form-group"><form:input style="margin-left:15px;margin-top:5px;margin-bot:5px;width: 526px;" class="form-control col-lg-12 col-md-12 col-sm-12"  id="add-number" type="text" placeholder="Adres" path="adres"></form:input></div>	<br/>
	    	<div class="form-group"><form:input style="margin-left:15px; margin-top:5px; margin-bot:5px;" class="form-control col-lg-12 col-md-12 col-sm-12"  id="tel-no" maxlength="14" type="text" placeholder="Telefon Numarası" path="telefon_no"></form:input></div>	<br/>	
	</div>
	
	<div class="col-lg-6 col-md-6 col-sm-6">
	<br>
	
	
	<div class="form-group">
	<form:select style="margin-left:15px; margin-top:5px; margin-bot:5px;" path="cinsiyet" class="form-control">
  <option value="Null">Cinsiyet</option>
  <option value="Erkek">Erkek</option>
  <option value="Kadin">Kadın</option>
	</form:select></div><br/>
	
	<div class="form-group"><form:select style="margin-left:15px; margin-top:5px; margin-bot:5px;" path="kan_grubu" class="form-control">
  <option value="Null">Kan Grubu</option>
  <option value="0+">0+</option>
  <option value="0-">0-</option>
  <option value="A+">A+</option>
  <option value="A-">A-</option>
  <option value="B+">B+</option>
  <option value="B-">B-</option>
  <option value="AB+">AB+</option>
  <option value="AB-">AB-</option>
	</form:select></div><br/>
	
	<div class="form-group"><form:select style="margin-left:15px; margin-top:5px; margin-bot:5px;" path="medeni_hal" class="form-control">
  <option value="Null">Medeni Hali</option>
  <option value="Evli">Evli</option>
  <option value="Bekar">Bekar</option>
	</form:select></div><br/>
	
	<div class="form-group"><form:select style="margin-left:15px; margin-top:5px; margin-bot:5px;" path="sehirler.sehirkodu" class="form-control">
	<option value="1">Şehir</option>
  <c:if test="${!empty SehirlerListesi}">
            		<c:forEach items="${SehirlerListesi}" var="sehirler" >
     
           		
    				<option value="${sehirler.sehirkodu}">${sehirler.sehiradi}</option>
  
  			</c:forEach>
  			</c:if>
	</form:select></div><br/>
	
	 
	
	<input class="btn btn-default" style="margin-left:15px; margin-top:5px; margin-bot:5px;" type="submit" value="Ekle"  >
	</div>
	
               
                </form:form>
             
</div>

 
            
</body>
</html>