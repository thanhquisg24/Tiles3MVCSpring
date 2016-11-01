<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   <div class="row">
				<!-- left catgory-->
				<div class="col-md-4 col-lg-4 col-sm-4 col-xs-12">
					<tiles:insertAttribute name="catgory" />
				</div>
				<!-- right product -->
				<div class="col-md-8 col-lg-8 col-sm-8 col-xs-12">
					<tiles:insertAttribute name="insideproductList" />
					
					<tiles:insertAttribute name="Jpaggination" />
				</div>
		</div>

