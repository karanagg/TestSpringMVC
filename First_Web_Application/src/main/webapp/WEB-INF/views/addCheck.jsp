<%@ include file="commons/header.jspf" %>
<%@ include file="commons/navigation.jspf" %>
<body>
<h1>Please add another Check</h1>
<div class="container">
<form:form method="post" commandName="checkList">
  <fieldset class="form-group">
   <form:label path="user">Name</form:label> 
    <form:input path="user" type="text" class="form-control" required="required"/>
</fieldset>
  <fieldset class="form-group">
   <form:label path="desc">Description</form:label>
   <form:input path="desc" type="text" class="form-control" required="required"/><br>
   <form:errors path="desc" cssClass="text-warning" />
   </fieldset>
  <fieldset class="form-group">
   <form:label path="targetDate">Target Date</form:label>
   <form:input path="targetDate" type="text" class="form-control" required="required"/><br>
   <form:errors path="targetDate" cssClass="text-warning" />
  </fieldset>
   <input class="btn btn-success" type="submit" value="Add another"/>
    <input class="btn btn-success" type="submit" value="Update"/>
</form:form>
</div>
 <%@ include file="commons/footer.jspf" %>
    </body>
    </html>