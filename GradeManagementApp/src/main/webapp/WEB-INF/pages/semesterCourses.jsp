<%-- 
    Document   : semesterCourses
    Created on : Aug 16, 2024, 8:58:10 PM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Học kỳ: ${semester.name}</h1>
<h2>Danh sách các môn học</h2>
<table class="table">
    <thead>
        <tr>
            <th>Tên môn học</th>
            <th>Mã môn học</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${courses}" var="c">
            <tr>
                <td>${c.name}</td>
                <td>${c.courseId}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>



