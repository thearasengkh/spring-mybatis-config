<%--
  Created by IntelliJ IDEA.
  User: thearaseng
  Date: 4/10/20
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <p>Message got from message source</p>
    <p><spring:message code="hello_x_how_are_you" arguments="${arg}" /></p>
</body>
</html>
