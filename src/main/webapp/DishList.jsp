<%--
  Created by IntelliJ IDEA.
  User: asaku
  Date: 01.02.2020
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu Application</title>
</head>
<body>
<center>
    <h1>Books Management</h1>
    <h2>
        <a href="/lab_kurator_1_0_SNAPSHOT_war/new">Add New Dish</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/lab_kurator_1_0_SNAPSHOT_war/list">List All Dishes</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Menu</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="dish" items="${listDish}">
            <tr>
                <td><c:out value="${dish.id}" /></td>
                <td><c:out value="${dish.name}" /></td>
                <td><c:out value="${dish.category}" /></td>
                <td><c:out value="${dish.price}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${dish.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${dish.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

