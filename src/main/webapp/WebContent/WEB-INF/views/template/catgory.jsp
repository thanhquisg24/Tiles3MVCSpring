<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="list-group">
  <h4  class="list-group-item active">
    Catgory
  </h4>
  
  <spring:eval expression="T(vn.vmall.Helper.Extra).extra_list_catgory()" var="static_listcatgory" />
	
  <c:forEach var="catgory_o" items="${static_listcatgory}" varStatus="loopCounter">

	<a href="${pageContext.servletContext.contextPath}/xem-danh-muc/<c:out value="${catgory_o.id}" />" 
	
		class="list-group-item list-group-item-action 
					<c:if test="${catgory_o.id==PathVariablecatgoryid}">
							 group-active
					</c:if>">
	<c:out value="${catgory_o.name}" /></a>				
	</c:forEach>
  
  
</div>