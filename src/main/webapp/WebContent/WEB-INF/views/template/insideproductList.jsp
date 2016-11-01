<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${not empty catgoryoject.name}">
<h4 class="list-group-item active">
    <c:out value="${catgoryoject.name}" />
  </h4>
 </c:if>    
<c:if test="${fn:length(listproduct) > 0 }">
<ul class="thumbnail-list">
    		<c:forEach var="product_o" items="${listproduct}" varStatus="loopCounter">
                <li> <a href="#" class="">
                <img src="image/product/<c:out value="${product_o.img}" />" class=""></a>
                    <h4 class=""><c:out value="${product_o.name}" /></h4>
                        <div class="product-price">
                         <span class="normal-price"><c:out value="${product_o.price}" /></span>

                        </div>
                       
                </li>
              </c:forEach>  
        </ul>
        
   </c:if>     