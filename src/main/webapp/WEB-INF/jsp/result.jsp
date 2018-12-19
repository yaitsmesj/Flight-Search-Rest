<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
      <head>
      <%@ page isELIgnored="false" %>
            <title>Welcome</title>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
      </head>
      <body>
      <table border=1px; width="100%">
            <tr>
                  <td>Flight Number</td>
                  <td>Departure Location</td>
                  <td>Arrival Location</td>
                  <td>Valid Till</td>
                  <td>Flight Time</td>
                  <td>Flight Duration</td>
                  <td>Fare</td>
                  <td>Seat Availability</td>
                  <td>Class</td>
            </tr>
            <c:forEach items="${flightList}" var="flight">
                  <tr>

                        <td>${flight.FLIGHT_NO}</td>
                        <td>${flight.DEP_LOC}</td>
                        <td>${flight.ARR_LOC}</td>
                        <td>${userFlight.flightDate}</td>
                        <td>${flight.FLIGHT_TIME}</td>
                        <td>${flight.FLIGHT_DUR}</td>
                        <td>${flight.FARE}</td>
                        <td>${flight.SEAT_AVAILABILITY}</td>
                        <td>${userFlight.flightClass}</td>
                  </tr>
            </c:forEach>
      </table> 
      </body>
</html>
