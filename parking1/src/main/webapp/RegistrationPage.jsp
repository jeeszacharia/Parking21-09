<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration </title>


</head>
<body>

<form method ="post" action="Registration">
 <br></br>
    <br></br>
    
    <h2>Registration</h2>
    
    <p style ="color:Green"> Message: ${message}</p>
 
<table>

 <tr>
          <td>Name: </td>
          <td><input type="text" name="name"> </td>
     </tr>
    
      <tr>
          <td>VechileNo: </td>
          <td><input type="text" name="vnumber"> </td>
     </tr>
     
      <tr>
          <td>MobileNo: </td>
          <td><input type="text" name="mobileno"> </td>
     </tr>
     
      <tr>
          <td>Password: </td>
          <td><input type="password" name="password"> </td>
     </tr>
     
     </table>
     <br></br>
 <table>
     
     
      <tr>
          <td> </td><td></td> <td></td> <td></td> <td></td> <td></td><td>
          <td><input type="submit" value="Register"> </td>
    
 <td></td> <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
          <td> </td>
          <td><input type="button" value="Clear"> </td>
           </tr>
           </table>
</form>

</body>
</html>