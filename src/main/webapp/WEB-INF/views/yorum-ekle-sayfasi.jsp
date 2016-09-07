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


	   			 <form:form action="yorumekle?hastaliktipiid=${hastaliktipiid}&randevu_no=${randevu_no}&icerik=${icerik}&bilgi_id=${bilgi_id}"  method="post" commandName="yorumForm" class="form-inline" >
                    	
	
	                    <div class="form-group"><form:input class="form-control" id="add-name" type="hidden" placeholder="Name" path="id" /></div>     
	                    <div class="form-group"><form:input class="form-control" id="add-surname" type="text"  placeholder="metin" path="yorum"></form:input></div>
	                     <div class="form-group"><form:input class="form-control" id="add-surname" type="hidden"   value ="${bilgi_id}" path="bilgigirisi.id"></form:input></div>
	                      <div class="form-group"><form:input class="form-control" id="add-surname" type="hidden"   value ="${randevu_no}" path="randevu.randevu_no"></form:input></div>
	                    

       
	                    <input class="btn btn-default" type="submit" value="Add"  >
                    
                </form:form>
                 


    <c:if test="${!empty yorumList}">
        <table class="table table-bordered">

	            <tr>
	                <th>Summary</th>
	                <th>Book Name</th>
	            </tr>
            <c:forEach items="${yorumList}" var="yorum" >
                <tr id="${yorum.id}">
             
                    <td id="Name" style="width: 378px" >${yorum.yorum}</td>
                    
                    
					
					
					 <td style="width: 118px">
					<a href="author/edit?id=${summary.book.id}">Edit</a>
					</td>
					
					<td style="width: 118px">
						<a href="#" name="{summary.id}" class="delete" onclick="return yes_js_login(${summary.id});" >Delete</a> 
					</td>
                </tr>

            </c:forEach>
            <tr>
            </tr>
        </table>
    </c:if>
    
  

          
            
</body>
</html>