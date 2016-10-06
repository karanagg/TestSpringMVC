<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Todos for ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
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
<td> ${checkList.done}</td>
<td><a class="btn btn-warning" href="/deleteCheck?id=${checkList.id}">Delete</a><td></tr>
</c:forEach>
</table>
<div>
 <a class="btn btn-success" href="/add-check">Add</a>
 </div>
 </div>
 	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>