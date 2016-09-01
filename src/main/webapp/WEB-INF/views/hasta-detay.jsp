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

</head>
<body>

<div class="container" style="border:1px solid#000; padding-bottom: 20px;">
<div  align = left style="padding-top: 20px;">


                

   <c:if test="${not empty HastaDetay}">
       

	         
           <table class="table">
          	  <tr class="success"><td style="width: 216px;">Dosya Numarası</td><td style="padding-left: 50px;">: ${HastaDetay.dosya_no}</td></tr>
              <tr class="success"><td style="width: 216px;">İsim Soyisim</td><td style="padding-left: 50px;">: ${HastaDetay.adisoyadi}</td></tr>
              <tr class="success"><td style="width: 216px;">TC Kimlik Numarası</td><td style="padding-left: 50px;">: ${HastaDetay.tckimlik_no}</td></tr>
              <tr class="success"><td style="width: 216px;">Doğum Tarihi</td><td style="padding-left: 50px;">: ${HastaDetay.dogum_tarihi}</td></tr>
              <tr class="success"><td style="width: 216px;">Doğum Yeri</td><td style="padding-left: 50px;">: ${HastaDetay.dogum_yeri}</td></tr>
              <tr class="success"><td style="width: 216px;">Baba Adı</td><td style="padding-left: 50px;">: ${HastaDetay.baba_adi}</td></tr>
              <tr class="success"><td style="width: 216px;">Anne Adı</td><td style="padding-left: 50px;">: ${HastaDetay.anne_adi}</td></tr>
              <tr class="success"><td style="width: 216px;">Adres</td><td style="padding-left: 50px;">: ${HastaDetay.adres}</td></tr>
              <tr class="success"><td style="width: 216px;">Şehir</td><td style="padding-left: 50px;">: ${HastaDetay.sehirler.sehiradi}</td></tr>
              <tr class="success"><td style="width: 216px;">Telefon Numarası</td><td style="padding-left: 50px;">: ${HastaDetay.telefon_no}</td></tr>
              <tr class="success"><td style="width: 216px;">Cinsiyet</td><td style="padding-left: 50px;">: ${HastaDetay.cinsiyet}</td></tr>
              <tr class="success"><td style="width: 216px;">Medeni Hal</td><td style="padding-left: 50px;">: ${HastaDetay.medeni_hal}</td></tr>
              </table>      
                
  

       
    </c:if>
    

    
</div>
   

          
            
</body>
</html>