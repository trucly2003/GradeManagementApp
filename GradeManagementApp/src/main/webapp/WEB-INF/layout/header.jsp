<%-- 
    Document   : header
    Created on : Aug 15, 2024, 9:22:34 AM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>



<nav class="navbar navbar-expand-sm bg-light navbar-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value='/'/>">GradeManagement Admin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/user?role=lecturer'/>">Quản lý giảng viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/user?role=student'/>">Quản lý sinh viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/course'/>">Quản lý môn học</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/enrollments'/>">Quản lý đăng ký môn học và điểm số</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/semester'/>">Quản lý học kỳ</a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">

                <s:authorize access="!isAuthenticated()">
                    <div class="d-flex">
                        <li class="nav-item d-flex align-items-center">
                            <a class="nav-link btn btn-link px-3 me-2" href="<c:url value='/login'/>">Đăng nhập</a>
                        </li>
                    </div>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <div class="d-flex ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" >Welcome Admin</a>
                        </li>
                        <li class="nav-item">
                            <a type="button" class="nav-link btn btn-outline-secondary px-3 me-2" href="<c:url value='/logout'/>">Đăng xuất</a>
                        </li>   
                    </div>
                </s:authorize>

            </ul>
        </div>
    </div>
</nav>
