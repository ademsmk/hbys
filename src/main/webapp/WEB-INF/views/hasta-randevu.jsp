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
<c:forEach items="${hastalar}" var="hasta" >
       <p class="bg-primary"><c:out value="${hasta.adisoyadi}" /> Adlı Hasta Randevu & Muayene Sayfası <br> DOSYA NUMARASI : ${hasta.dosya_no} </p>
  </c:forEach>
  

  
  
<%-- ?dosya_no=${dosya_no} --%>
   <form:form action="../randevu" id="hellojs" method="post" commandName="randevuForm" class="form-inline" >
                    	
					
  						<div class="form-group"><form:input class="form-control" id="book-id" type="hidden" placeholder="id" value="${dosya_no}" path="randevu_no"></form:input></div>
	                    <div class="form-group"><form:input class="form-control" id="add-bookName" type="text" placeholder="Randevu Tarihi" path="randevu_tarihi" /></div>     
	                    <div class="form-group"><form:input class="form-control" id="add-pageNumber" type="text"  placeholder="Randevu Saati" path="randevu_saati"></form:input></div>
	                  
	                    <input class="btn btn-default" type="submit" value="Add"  >
<!-- 						<a href="#" class="btn btn-info" role="button">Link Button</a> -->
                    
                </form:form>
                
                
                

   <c:if test="${!empty hastalar}">
   
        <table class="table table-bordered">

	            <tr>
	                <th>Randevu Tarihi</th>
	                <th>Randevu Saati</th>
	                               
	            </tr>
            <c:forEach items="${hastalar}" var="hasta" >
     
           <c:if test="${!empty hasta.randevular}">
   <c:forEach items="${hasta.randevular}" var="randevu">
   
  
   <tr>
    <td style="width:600px"><c:out value="${randevu.randevu_tarihi}" /></td>
    <td style="width:220px"><c:out value="${randevu.randevu_saati}" /></td>
    <td><a href="../book/edit?bookid=${book.id}&authorid=${author.id}">Edit</a></td>
    <td><a href="../book/delete?bookid=${book.id}&authorid=${author.id}">Delete</a></td>
    <td><a href="../randevu/randevudetay?id=${randevu.randevu_no}&dosya_no=${hasta.dosya_no}" class="btn btn-info" role="button">Muayene Bilgisi</a></td>
   
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