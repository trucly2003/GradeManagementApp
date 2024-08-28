<%-- 
    Document   : course
    Created on : Aug 15, 2024, 9:54:34 AM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib   prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<div class="container mt-5">
    <h1 class="text-center text-primary mt-1">DANH SÁCH CÁC KHÓA HỌC</h1>



<table class="table">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Tên Khóa Học</th>
            <th>Mô Tả</th>
            <th>Số Tín Chỉ</th>
            <th>Học Kỳ</th>
            <th>Giảng Viên</th>
            <th>Thao Tác</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${courses}" var="course">
            <tr id="course${course.courseId}">
                <td>${course.courseId}</td>
                <td>${course.name}</td>
                <td>${course.description}</td>
                <td>${course.credits}</td>
                <td>${course.semesterId.name}</td>
                <td>${course.lecturerId.firstName} ${course.lecturerId.lastName}</td>
                <td>
                    <c:url value="/course/edit/${course.courseId}" var="editUrl" />
                    <a href="${editUrl}" class="btn btn-success"><i class="bi bi-pencil-square"></i></a>
                </td>
                <td>
                    <c:url value="/api/course/${course.courseId}" var="endpoint" />
                    <button onclick="deleteCourse('${endpoint}', ${course.courseId})" class="btn btn-success"><i class="bi bi-trash3"></i></button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/course/add" class="btn btn-primary mb-3">Thêm Khóa Học Mới</a>
</div>
