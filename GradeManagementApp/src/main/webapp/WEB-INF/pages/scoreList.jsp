<%-- 
    Document   : scoreList
    Created on : Aug 28, 2024, 10:05:44 AM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container mt-5">
    <h1 class="text-center text-primary mt-1">Danh Sách Điểm</h1>

    <table class="table">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Điểm Cuối Kỳ</th>
                <th>Điểm Giữa Kỳ</th>
                <th>Điểm Khác</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${scores}" var="score">
                <tr>
                    <td>${score.scoreId}</td>
                    <td>${score.final1}</td>
                    <td>${score.midterm}</td>
                    <td>${score.otherGrade}</td>
                    <td>
                        <c:url value="/score/details/${score.scoreId}" var="detailsUrl" />
                        <a href="${detailsUrl}" class="btn btn-info">Xem Chi Tiết</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/enrollment/list" class="btn btn-primary mb-3">Quay Lại Danh Sách Đăng Ký</a>

