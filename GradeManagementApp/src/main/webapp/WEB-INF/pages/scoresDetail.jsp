<%-- 
    Document   : scoresDetail
    Created on : Aug 31, 2024, 10:07:35 PM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<body>
    <div class="container">
        <h1>Chi tiết điểm của học sinh: ${enrollment.studentId.lastName} ${enrollment.studentId.firstName}</h1>
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th>Loại điểm</th>
                    <th>Điểm</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${scores}" var="score">
                    <tr>
                        <td>Điểm giữa kỳ</td>
                        <td>${score.midterm}</td>
                    </tr>
                    <tr>
                        <td>Điểm cuối kỳ</td>
                        <td>${score.final1}</td>
                    </tr>
                    <c:if test="${score.otherGrade != null}">
                        <tr>
                            <td>Điểm khác</td>
                            <td>${score.otherGrade}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
