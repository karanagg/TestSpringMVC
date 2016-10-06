<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
Hi ${name}<br>
<table>
    <caption>Yout CheckList</caption>
    		<thead>
				<tr>
				    <th>ID</th>
					<th>Description</th>
					<th>Date</th>
					<th>Completed</th>
				</tr>
			</thead>

<c:forEach items="${checkList}" var="checkList">
<tr><td>${checkList.id}</td><td> ${checkList.desc}</td><td> ${checkList.targetDate}</td><td> ${checkList.done}</td></tr>
</c:forEach>
</table>
<h1>Add a Check</h1>

 <br></br>
 <a class="button" href="/add-check">Add</a>
</body>
</html>