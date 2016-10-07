
<%@ include file="commons/header.jspf" %>
<%@ include file="commons/navigation.jspf" %>
<body>
	<div class="container">
		<table class="table table-striped">
    <caption>Your CheckList ${name}</caption>
    		<thead>
				<tr>
				    <th>ID</th>
					<th>Description</th>
					<th>Date</th>
					<th>Completed</th>
				</tr>
			</thead>

<c:forEach items="${checkList}" var="checkList">
<tr><td>${checkList.id}</td>
<td> ${checkList.desc}</td>
<td> ${checkList.targetDate}</td>
<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${checkList.targetDate}"/></td>
<td> ${checkList.done}</td>
<td><a class="btn btn-success" href="/updateCheck?id=${checkList.id}">Update</a><td>
<td><a class="btn btn-warning" href="/deleteCheck?id=${checkList.id}">Delete</a><td>
</tr>
</c:forEach>
</table>
<div>
 <a class="btn btn-success" href="/add-check">Add</a>
 </div> 
 </div>
 <%@ include file="commons/footer.jspf" %>
</body>
</html>