<%-- 
    Document   : index
    Created on : Aug 12, 2024, 4:37:07 PM
    Author     : Ly Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <table class="table">
        <thead class="table-dark">
            <tr>
                <th>Catalog</th>
                <th></th>
            </tr>
        </thead>
        <tbody >
            <tr>
                <td>Semester</td>
                <td class="d-flex" style="justify-content: end">
                    <a href="<c:url value='/semester'/>" class="btn"><i class="bi bi-pencil-square"></i></a>
                </td>
            </tr>
            <tr>
                <td>Course</td>
                <td class="d-flex" style="justify-content: end">
                    <a href="<c:url value='/course'/>" class="btn"><i class="bi bi-pencil-square"></i></a>

                </td>
            </tr>
            <tr>
                <td>Enrollment</td>
                <td class="d-flex" style="justify-content: end">
                    <a href="<c:url value='/enrollments'/>" class="btn"><i class="bi bi-pencil-square"></i></a>
                </td>
            </tr>
             <tr>
                <td>Lecturer</td>
                <td class="d-flex" style="justify-content: end">
                    <a href="<c:url value='/user?role=lecturer'/>" class="btn"><i class="bi bi-pencil-square"></i></a>
                </td>
            </tr>
             <tr>
                <td>Student</td>
                <td class="d-flex" style="justify-content: end">
                    <a href="<c:url value='/user?role=student'/>" class="btn"><i class="bi bi-pencil-square"></i></a>
                </td>
            </tr>
        </tbody>
    </table>
</div>