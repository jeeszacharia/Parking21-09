<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ParkingDetails</title>
</head>
<body>

    
    
    <table>
  
   
   <c:forEach items="${arr}" var="arr">
    <tr>
       <td>"${arr}"</td>
              
     </tr>       
    </c:forEach>
  
</table>
    


<form method ="post" action="ParkingDetails">
 <br></br>
  
  
    <br></br>
    
    <h2>Parking Details</h2>
      
    
<table>



 <tr>
          <td>Date of parking: </td>
          <td><input type="text" name="name"> </td>
     </tr>
    
      <tr>
          <td>Time of parking: </td>
          <td><input type="text" name="vnumber"> </td>
     </tr>
     
      <tr>
          <td>Time left: </td>
          <td><input type="text" name="mobileno"> </td>
     </tr>
     
     
     
     </table>
     <br></br>
 <table>
     
     
     <tr>
          <td><input type="button" value="Back"> </td>
           </tr>
           </table>
     
     



</form>





</body>
</html>