<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
      <head>
      <%@ page isELIgnored="false" %>         
          <title>Search Flights</title>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
      </head>
      <body>
          <div class="container">
              <h3 id="form_header" class="text-warning" align="center">Search Application</h3>
              <div> </div>
      
              <!-- User input form to validate a user -->
              <c:url var="searchUrl" value="/search" />
              <form:form id="user_form"  method="POST" modelAttribute="userInput" action="${searchUrl}">
                  <div class="form-group">
                      <form:label path="depLoc">Departure Location:</form:label>
                      <form:select class="form-control" path="depLoc">
                      <option value="DEL">DEL</option>
                       <option value="MUB">MUB</option>
                       <option value="BGR">BGR</option>
                      </form:select>
                  </div>
                  <div class="form-group">
                      <form:label path="arrLoc">Arrival Location:</form:label>
                      <form:select class="form-control" path="arrLoc">
                      <option value="DEL">DEL</option>
                       <option value="MUB">MUB</option>
                       <option value="BGR">BGR</option>
                      </form:select>
                  </div>
                  <div class="form-group">
                      <form:label path="flightDate">Flight Date:</form:label>
                      <form:input type="date" class="form-control"  placeholder="Enter Flight Date: dd-mm-yyyy" path="flightDate"/>
                  </div>
                  <div class="form-group">
                      <form:label path="flightClass">Class:</form:label>
                      <form:select class="form-control" path="flightClass" >
                       <option value="E">E</option>
                       <option value="EB">B</option>
                      </form:select>
                  </div>
                  <div class="form-group">
                      <form:label path="preference">Preference:</form:label>
                      <form:select class="form-control"  path="preference">
                      <option value="FARE">FARE</option>
                       <option value="DURATION">DURATION</option>
                      </form:select>
                  </div>
                  <button id="search" type="submit" class="btn btn-primary">Search</button>
              </form:form>
          </div>
      </body>
</html>
