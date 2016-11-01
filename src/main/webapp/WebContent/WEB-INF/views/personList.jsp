<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   <div class="row">
				<!-- left catgory-->
				<div class="col-md-4">
					<tiles:insertAttribute name="catgory" />
				</div>
				<!-- right product -->
				<div class="col-md-8">
					<div style="margin: 10px;">
						<h4>List of Persons</h4>
						<table style="width: 600px" class="reference">
							<tbody>
							<tr>
								<th>Sr. No.</th>
								<th>Name</th>
								<th>Age</th>
								<th>Email</th>
							</tr>
							<c:forEach var="person" items="${persons}"
								varStatus="loopCounter">
							<tr>
								<td><c:out value="${loopCounter.count}" /></td>
								<td><c:out value="${person.name}" /></td>
								<td><c:out value="${person.email}" /></td>
								<td><c:out value="${person.age}" /></td>
							</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
		</div>

