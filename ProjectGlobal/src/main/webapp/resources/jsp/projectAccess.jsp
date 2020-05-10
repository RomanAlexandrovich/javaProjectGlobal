<%@ include file="./header.jsp"%>
<title>Project-User</title>
<body>
	<form:form method="GET" action="/projectAccess">
		<h2>List project</h2>
		<c:forEach var="project" items="${listProject}" varStatus="Count1">
			<p>${Count1.count}.
				<a href="/project-${project.idProject}-editAccess">${project.nameProject}</a>
				<a href="<c:url value="/projectDelete-${project.idProject}"/>">delete</a>
				<!--<c:forEach var="user" items="${project.listUsers}" varStatus="Count2">
				${Count1.count}. ${user.nameUser}
				</c:forEach>-->
			</p>
		</c:forEach>

	</form:form>
	<a href="<c:url value="/"/>">Back</a>

</body>
</html>