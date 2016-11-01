<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="list-group">
  <h4  class="list-group-item active">
    Catgory
  </h4>
  
  <c:forEach var="catgory_o" items="${listcatgory}" varStatus="loopCounter">
	<a href="${url_href_view_productlistby_catgory}/<c:out value="${catgory_o.id}" />" 
		class="list-group-item list-group-item-action 
					<c:if test="${catgory_o.id==PathVariablecatgoryid}">
							 group-active
					</c:if>">
	<c:out value="${catgory_o.name}" /></a>				
	</c:forEach>
  
  
</div>