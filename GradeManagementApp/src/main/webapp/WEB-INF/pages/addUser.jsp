<%-- 
    Document   : addUser
    Created on : Aug 16, 2024, 5:01:40 PM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 class="text-center text-primary mt-1">THÊM GIẢNG VIÊN</h1>

<form:form method="POST" modelAttribute="user" enctype="multipart/form-data">
    <div class="form-outline" data-mdb-input-init>
        <label class="form-label" for="firstName">First Name:</label>
        <form:input type="text" id="firstName" class="form-control" path="firstName" />
    </div>

    <div class="form-outline" data-mdb-input-init>
        <label class="form-label" for="lastName">Last Name:</label>
        <form:input type="text" id="lastName" class="form-control" path="lastName" />
    </div>

    <div class="form-outline" data-mdb-input-init>
        <label class="form-label" for="username">Username:</label>
        <form:input type="text" id="username" class="form-control" path="username"/>
    </div>

    <div class="form-outline" data-mdb-input-init>
        <label class="form-label" for="password">Password:</label>
        <form:input type="password" id="password" class="form-control" path="password"/>
    </div>

    <div class="form-outline" data-mdb-input-init>
        <label class="form-label" for="email">Email:</label>
        <form:input type="text" id="email" class="form-control" path="email"/>
    </div>

    <div class="form-outline" data-mdb-input-init>
        <label class="form-label" for="avatar">Avatar</label>
        <form:input id="imageId" path="avatar" type="file" />
        <input type="submit" value="upload" />
    </div>

    <div class="text-center mt-3">
        <button type="submit" class="btn btn-primary mb-3">Add Lecturer</button>
    </div>
</form:form>

