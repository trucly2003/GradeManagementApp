<%-- 
    Document   : addCourses
    Created on : Aug 19, 2024, 3:07:54 PM
    Author     : Ly Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<h1 class="text-center text-primary mt-1">
    <c:choose>
        <c:when test="${course.courseId != null}">CHỈNH SỬA KHÓA HỌC</c:when>
        <c:otherwise>THÊM KHÓA HỌC</c:otherwise>
    </c:choose>
</h1>

<c:url value="/course/add" var="action"/>
<form:form modelAttribute="course" method="post" action="${action}">
    <div class="form-outline" data-mdb-input-init>
        <label class="form-label" for="name">Tên khóa học:</label>
        <form:input type="text" id="firstName" class="form-control" path="name" />
        <form:errors path="name" cssClass="text-danger form-text" element="div"/>
    </div>
    <div class="form-outline" data-mdb-input-init>
        <label for="semester" class="form-label">Học kỳ</label>
        <form:select path="semesterId.semesterId" class="form-select" id="semester">
            <form:options items="${semesters}" itemValue="semesterId" itemLabel="name" />
        </form:select>

    </div>
    <div class="form-outline" data-mdb-input-init>
        <label for="lecturer" class="form-label">Giảng viên</label>
       <form:select path="lecturerId.userId" class="form-select" id="lecturer">
        <c:forEach items="${lecturers}" var="lecturer">
                <option value="${lecturer.userId}"
                    <c:if test="${lecturer.userId == course.lecturerId.userId}">selected</c:if>
                >
                    ${lecturer.firstName} ${lecturer.lastName}
                </option>
            </c:forEach>
    </form:select>
    </div>
    <div class="form-outline" data-mdb-input-init>
        <label class="form-label" for="credits">Tín chỉ:</label>
        <form:input type="number" id="credits" class="form-control" path="credits" />
    </div>
        <form:errors path="credits" cssClass="text-danger form-text" element="div" />
    <div>
        <label for="description" class="form-label">Mô tả:</label>
        <form:textarea path="description" class="form-control" id="description" rows="3" />
    </div>
        <form:errors path="description" cssClass="text-danger form-text" element="div" />
    <div>
        <form:hidden path="courseId" />
                     
        <button type="submit" class="btn btn-outline-primary mt-3 mb-3">
              <c:choose>
                <c:when test="${course.courseId != null}">Cập Nhật</c:when>
                <c:otherwise>Thêm</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
