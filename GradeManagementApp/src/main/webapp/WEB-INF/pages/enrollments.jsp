<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



    <h1 class="text-center text-primary mt-1">DANH SÁCH ĐĂNG KÝ KHÓA HỌC</h1>

<div class="container">
    <div class="row gx-1 gy-2"> 
         
        
        <c:forEach items="${courses}" var="c">
                <div class="col-md-3"> 
                    <div class="card bg-white mb-3" style="max-width: 20rem;">
                        <div class="card-header">${c.semesterId.name}</div>
                        <div class="card-body">
                            <h4 class="card-title">${c.name}</h4>
                            <p class="card-text">
                                <ul>
                                    <li>
                                      GV:  ${c.lecturerId.lastName} ${c.lecturerId.firstName} 
                                    </li>
                                </ul>
                            </p>
                          <a href="<c:url value='/enrollments/detail/${c.courseId}' />" class="btn btn-info">Xem chi tiết</a>


                        </div>
                    </div>
                </div>
        </c:forEach>
    </div>
</div>




