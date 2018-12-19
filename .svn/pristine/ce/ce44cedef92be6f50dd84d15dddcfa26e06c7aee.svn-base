<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">


</head>
<body>
	<div class="container">
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Login</h3>
					</div>
					<div class="panel-body">
						<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="UserName" name="username"
										type="text" required="required">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" required="required">
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Login">
													<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<c:if test="${not empty error}">
		<table align="center">
			<tr>
				<td style="font-style: italic; color: red;">Invalid Credentials</td>
			</tr>
		</table>
	</c:if>
	
	
</body>
</html>