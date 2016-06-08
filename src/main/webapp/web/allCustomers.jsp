<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<title>All Customers</title>
		<link rel="stylesheet" type="text/css" href='<c:url value="web/css/styles.css"/>'/>
	</head>

	<body>
		<h1>CRM System - All Customers</h1>
		<table>
			<tr>
				<th>Id</th>
				<th>Company</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.cid}</td>
					<td>${customer.company}</td>
					<td>${customer.email}</td>
					<td>${customer.telephone}</td>
				</tr>
			</c:forEach>
			<table>
	</body>

</html>