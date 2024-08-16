<%-- 
    Document   : course
    Created on : Aug 15, 2024, 9:54:34 AM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib   prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 class="text-center text-primary mt-1">DANH SÁCH CÁC KHÓA HỌC</h1>
<table border="1">
    <tr>
        <th>Tên khóa học</th>
        <th>Giảng viên</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.name}</td>
            <td>${course.lecturerId.name}</td>
        </tr>
    </c:forEach>
</table>
