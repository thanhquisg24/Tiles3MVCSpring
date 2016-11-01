<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div style="margin:10px;">
	<h1>INDEX PAGE</h1>
	<spring:eval expression="T(vn.vmall.Helper.Extra).h_getstatic_catgory()" var="data2" />
	${data2}
</div>