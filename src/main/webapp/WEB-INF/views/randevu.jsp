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
<div  align = center style="padding-top: 20px;">


    <c:if test="${!empty hastalar}">
        <table class="table table-bordered">

	            <tr>
	                <th>Dosya Numarası</th>
	                <th>Adı Soyadı</th>
	                <th>TC Kimlik No</th>
	                <th>Randevu Tarihi</th>
	                <th>Randevu Saati</th>
	                <th>Detay</th>
	            </tr>
            <c:forEach items="${hastalar}" var="hasta" >
           
           <c:if test="${!empty hasta.randevular}">
   <c:forEach items="${hasta.randevular}" var="randevu">
   <tr>
   	<td><c:out value="${hasta.dosya_no}" /></td>
   	<td><c:out value="${hasta.adisoyadi}" /></td>
   	<td><c:out value="${hasta.tckimlik_no}" /></td>
    <td><c:out value="${randevu.randevu_tarihi}" /></td>
     <td><c:out value="${randevu.randevu_saati}" /></td>

    <td><a href="book/delete?bookid=${book.id}&authorid=${author.id}">Detay</a></td>
    
   </tr>
   </c:forEach>
  </c:if>

            </c:forEach>
            <tr>
            </tr>
        </table>
    </c:if>

          
            
</body>
</html>