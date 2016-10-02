<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> List of users </h1>
        <ul>
<c:forEach var="user" items="${sessionScope.users}">
    <li>${user.login}</li>
</c:forEach>
        </ul>
    </body>
</html>
