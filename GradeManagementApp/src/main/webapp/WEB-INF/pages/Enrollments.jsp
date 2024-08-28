<%-- 
    Document   : Enrollments
    Created on : Aug 27, 2024, 9:52:32 PM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-primary">Danh Sách Đăng Ký</h1>

<table class="table table-bordered">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Khóa Học</th>
            <th>Học Sinh</th>
            <th>Ngày Đăng Ký</th>
            <th>Thao Tác</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${enrollments}" var="enrollment">
            <tr>
                <td>${enrollment.enrollmentId}</td>
                <td>${enrollment.course.name}</td>
                <td>${enrollment.student.firstName} ${enrollment.student.lastName}</td>
                <td>${enrollment.registrationDate}</td>
                <td>
                    <c:url value="/api/enrollments/${enrollment.id}" var="deleteUrl" />
                    <a href="javascript:void(0);" onclick="deleteEnrollment('${deleteUrl}', ${enrollment.id})" class="btn btn-danger">
                        <i class="bi bi-trash3"></i> Xóa
                    </a>
                    <!-- Thêm liên kết để sửa nếu cần -->
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/enrollment/add" class="btn btn-primary mb-3">Thêm Đăng Ký Mới</a>
