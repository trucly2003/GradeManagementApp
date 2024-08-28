<%-- 
    Document   : header
    Created on : Aug 15, 2024, 9:22:34 AM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a class="nav-link" href="<c:url value='/enrollment'/>">Quản lý đăng ký môn học</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Quản lý điểm số</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
