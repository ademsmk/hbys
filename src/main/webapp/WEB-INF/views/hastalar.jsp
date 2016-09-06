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


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>


<title>Contact List Screen</title>

<jsp:include page="../views/header.jsp" />
	<div align="center">


<script type ="text/javascript">


$(document).ready(function(){
	

	yes_js_login = function(dosya_no) {
       
		
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
				    window.location.href = "../patient/delete?id="+dosya_no;
			     }, 2000); 
			    
			  } else {
			    swal("Cancelled", "Successfully cancelled", "error");
			    setTimeout(function () {
				    window.location.href = "../patient/kayitlihastalar";
			     }, 2000); 
			  }
			});

			
			return false;
			
			
   }


});


</script>

</head>
<body>

<div class="container" style="border:1px solid#000; padding-bottom: 20px;">
<div  align = center style="padding-top: 20px;">

<form:form action="../patient/search" id="hellojs" method="post" commandName="patientForm" class="form-inline" >

<div class="form-group"><form:input style="margin-left:15px; margin-top:5px;" class="form-control col-lg-12 col-md-12 col-sm-12" id="add-email" type="text" placeholder="Doğum Yeri" value="Ara" path="dosya_no"></form:input></div><br/>
<input class="btn btn-default" style="margin-left:15px; margin-top:5px; margin-bot:5px;" type="submit" value="Ara"  >
</form:form>

    <c:if test="${!empty HastaListesi}">
        <table class="table table-bordered">

	            <tr>
	                <th>Dosya Numarası</th>
	                <th>Adı Soyadı</th>
	                <th>TC Kimlik Numarası</th>
	               
	            </tr>
            <c:forEach items="${HastaListesi}" var="hastalar" >
           
                <tr id="${hastalar.dosya_no}">
             
                    <td id="Name" style="width: 150px" >${hastalar.dosya_no}</td>
                    <td id="Surname" style="width: 400px">${hastalar.adisoyadi}</td>
                    <td id="Surname" style="width: 250px">${hastalar.tckimlik_no}</td>
					 <td style="width: 118px">
					<a href="hastadetay?id=${hastalar.dosya_no}">Detay</a>
					</td>
					
					 <td style="width: 118px">
					<a href="randevular?id=${hastalar.dosya_no}">Randevular</a>
					</td>
					
					<td style="width: 118px">
						<a href="#" name=${author.id} class="delete" onclick="return yes_js_login(${hastalar.dosya_no});" >Delete</a> 
					</td>
                </tr>
			</c:forEach>
            <tr>
            </tr>
        </table>
    </c:if>
    
    
    
</div>
   

          
            
</body>
</html>