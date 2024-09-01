<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="container mt-4">
    <h1>Chi tiết khóa học: ${course.name}</h1>
    <h3>Giảng viên: ${course.lecturerId.lastName} ${course.lecturerId.firstName}</h3>
    <h3 class="text-primary text-center">Danh sách học sinh</h3>
    <table class="table table-bordered mt-3">
        <thead class="table-dark">
            <tr>
                <th>Tên học sinh</th>
                <th>Email</th>
                <th>MSSV</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="enrollment" items="${enrollments}">
                <tr>
                    <td>${enrollment.studentId.lastName} ${enrollment.studentId.firstName}</td>
                    <td>${enrollment.studentId.email}</td>
                    <td>${enrollment.studentId.userId}</td>
                    <td>
                        <a href="<c:url value='/enrollments/${enrollment.enrollmentId}/score' />" class="btn btn-info">Xem chi tiết điểm</a>
                    </td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/enrollments' />" class="btn btn-secondary mb-3">Quay lại</a>
</div>

