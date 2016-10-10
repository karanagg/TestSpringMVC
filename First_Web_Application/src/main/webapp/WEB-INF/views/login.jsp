<%@ include file="commons/header.jspf" %>
<%@ include file="commons/navigation.jspf" %>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form:form action="/login" method="POST" commandName="Login">
    <fieldset class="form-group">
        <form:label path="user"> Name : </form:label>
        <form:input path="user" type="text" class="form-control" required="required"/>
      </fieldset>  
         <fieldset class="form-group">   
           <form:label path="password"> Password : </form:label>
           <form:input path="password" type="password" class="form-control" required="required"/> 
         </fieldset>
   <input class="btn btn-success" type="submit" value="LOGIN"/>
    </form:form>
     <%@ include file="commons/footer.jspf" %>
    </body>
    </html>