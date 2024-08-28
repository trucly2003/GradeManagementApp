<%-- 
    Document   : semesterCourses
    Created on : Aug 16, 2024, 8:58:10 PM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Học kỳ: ${semester.name}</h1>
<h1 class="text-center text-primary mt-1">DANH SÁCH MÔN HỌC</h1>
<table class="table">
    <thead class="table-dark">
        <tr>
            <th>Tên môn học</th>
            <th>Mã môn học</th>
            <th>Số tín chỉ</th>
             <th>Mô tả</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${courses}" var="c">
            <tr>
                <td>${c.name}</td>
                <td>${c.courseId}</td>
                <td>${c.credits}</td>
            <td>${c.description}</td>
            </tr>
        </c:forEach>
    </tbody>
    
</table>
<a class="btn btn-info mb-3" href="<c:url value='/course/add'/>?semesterId=${semester.semesterId}">Thêm khóa học</a>




