<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>



<% int value = (Integer) request.getAttribute("timeout");%>

<p id="demo"></p>

<script>
//Place here the total of seconds you receive on your JSP code. ie: var initialTime = <? echo $remaining; ?>;


var initialTime = '${value}';

var seconds = initialTime;
function timer() {
    var days = Math.floor(seconds/24/60/60);
    var hoursLeft = Math.floor((seconds) - (days*86400));
    var hours = Math.floor(hoursLeft/3600);
    var minutesLeft = Math.floor((hoursLeft) - (hours*3600));
    var minutes     = Math.floor(minutesLeft/60);
    var remainingSeconds = seconds % 60;
    if (remainingSeconds < 10) {
        remainingSeconds = "0" + remainingSeconds; 
        
    }
    
    document.getElementById('demo').innerHTML = days + "day " + hours + "hrs " + minutes + "minute " + remainingSeconds+ "seconds";
    if (seconds == 900) {
        //clearInterval(countdownTimer);
        window.alert("You have only 15 Seconds Leftout!You need to renew your Ticket ");
        //document.getElementById('demo').innerHTML = "Completed";
    }if(seconds == 0){
    	window.alert("Your Time is UP!!!!!!!!!!!! ");
    	clearInterval(countdownTimer);
    }
    else {
        seconds--;
    }
}
var countdownTimer = setInterval('timer()', 1000);

</script>

</head>

<body>
     
   <c:forEach items="${arr}" var="arr">
    <tr>
       <td>"${arr}"</td>
              
     </tr>       
    </c:forEach>
  


<%
if(session.getAttribute("username")==null){
	
	request.getRequestDispatcher("/Login.jsp").forward(request, response);	
}
%>

   Welcome ${username}
  
    
   <form method="get" action="Logout">
   <table>
   <tr>
          <td></td>
          <td><input type="submit" value="Logout"> </td>
     </tr>
   </table>
   </form>
   
   <form method="post" action="TicketDetails">
   <table>
   <tr>
          <td></td>
          <td><input type="submit" value="Ticket"> </td>
     </tr>
   </table>
   </form>
   
   <form method="post" action="AvailableParking">
   <table>
   <tr>
          <td></td>
          <td><input type="submit" value="Available Slots"> </td>
     </tr>
   </table>
   </form>
   
  
<form method="post" action="GetTicket">
  <h2>Registration</h2>
    

<table>
</table>

<p style ="color:Red"> Message: ${message}</p> 

 <table>
          
      <tr>
          <td> </td><td></td> <td></td> <td></td> <td></td> <td></td><td>
          <td><input type="button" value="Parking Details"> </td>
    
 <td></td> <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
          <td> </td>
          <td><input type="button" value="Available Slots"> </td>
          
          </tr>
             <tr>
          <td></td> <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
          <td> </td>
          <td><input type="submit" value="Get Ticket"> </td>
           </tr>
                                 
           <tr>
          <td>Minute </td>
          <td><input type="text" name="Minute"> </td>
     </tr>
       <tr>
          <td>RegistrationID </td>
          <td><input type="text" name="RegID"> </td>
     </tr>
                  
           
           </table>
</form>

</body>
</html>