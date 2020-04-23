<%--
  Created by IntelliJ IDEA.
  User: thearaseng
  Date: 4/12/20
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head></head>
<body>
<h1>Login</h1>
<form name='f' action="<c:url value='/login'/>" method='POST'>
    <table>
        <tr>
            <td><label for="email">Email:</label></td>
            <td><input id="email" type='text' name='email' value=''></td>
        </tr>
        <tr>
            <td><label for="password">Password:</label></td>
            <td><input id="password" type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>
