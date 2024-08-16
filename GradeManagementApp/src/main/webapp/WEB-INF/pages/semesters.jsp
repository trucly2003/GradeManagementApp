<%-- 
    Document   : semester
    Created on : Aug 16, 2024, 3:33:48 PM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-primary mt-1">CÁC HỌC KỲ</h1>
<div class="row gx-lg-5 mb-3">
    <c:forEach items="${semesters}" var="s">
        <div class="col-lg-6 mb-5 mb-lg-0">

            <div class="card mb-3" data-mdb-theme="light">
                <div class="card-body">
                    <h5 class="card-title">${s.name}</h5>
                    <a href="<c:url value='/semester/${s.semesterId}' />" class="btn btn-primary">Xem thêm</a>
                </div>
            </div>

        </div>
    </c:forEach>
</div>

