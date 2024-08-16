<%-- 
    Document   : users
    Created on : Aug 15, 2024, 9:40:50 PM
    Author     : Ly Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary mt-1">DANH SÁCH ${role == 'lecturer' ? 'GIẢNG VIÊN' : 'SINH VIÊN'}</h1>

<table class="table">
    <thead class="table-dark">
        <tr>
            <th></th>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td><img src="${user.avatar}" alt="Avatar" width="50" height="50"/></td>
                <td>${u.userId}</td>
                <td>${u.firstName}</td>
                <td>${u.lastName}</td>
                <td>${u.email}</td>
                <td class="d-flex" style="justify-content: end">
                    <a href="#" class="btn btn-info">&Sqrt;</a> 
                    <button class="btn btn-danger">&times;</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a class="btn btn-info mb-3" href="<c:url value='/user/add'/>">Thêm</a>



