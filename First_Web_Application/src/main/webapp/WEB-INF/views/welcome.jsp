<%@ include file="commons/header.jspf" %>
<%@ include file="commons/navigation.jspf" %>
<body>
<div class="container">
<spring:message code="welcome.message"/>${name}. 
You are now authenticated. <a href="/checkList?name=${name}">Manage Your Check List</a> to start maintaining your todo's.
</div>
 <%@ include file="commons/footer.jspf" %>
</body>
</html>