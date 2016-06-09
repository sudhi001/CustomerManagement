<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Authorization</title>
		<link rel="stylesheet" type="text/css" href='<c:url value="web/css/styles.css"/>'/>
	</head>

	<body>
		<h1>Do you allow the application "${client.clientId}" to access your private data?</h1>
		
		<c:url value="/oauth/authorize" var="authorizeUrl"/>
	
	    <form:form action="${authorizeUrl}" method="post">
	        <input name="user_oauth_approval" value="true" type="hidden"/>
	        <ul>
		        <c:forEach items="${scopes}" var="scope">		      		       
		        	<li>${scope.key}: <input type="radio" name="${scope.key}" value="true" checked> Approve</input>
		        	                  <input type="radio" name="${scope.key}" value="false">Deny</input>
		        	</li>
		        	 
		        </c:forEach>
	        </ul>
	        <label><input name="authorize" value="Submit" type="submit"></label>
	      </form:form>				 	
	</body>
</html>