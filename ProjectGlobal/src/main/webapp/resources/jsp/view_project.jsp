<%@ include file="./header.jsp"%>
<body>
	<div>
		<form:form method="GET" action="/project-${project.idProject}">

			<img class="view-element" alt="image Project"
				src="${contextPath}/resources/static/image/project/${project.imageAvatarProject.urlImageProject}">
			<h2>${project.nameProject}</h2>
			<div>
				<p>Key project: ${project.keyNameProject}</p>
				<p>Status project: ${project.statusProject.nameStatusProject}</p>
				<p>Manager project: ${project.managerUser.nameUser}</p>
				<p>Descriptions project: ${project.descriptionsProject}</p>
				List task project: ${Manager}
			</div>
			<div>
				<table border="1">
<tr>
					<th>Number</th>
					<th>Name</th>
					<th>Task description</th>
					<th>Status</th>
					<th>Priority</th>
					<th>Project</th>
					<th>Date create</th>
</tr>

					<c:forEach var="task" items="${listTask}">
					<tr>
						<c:if test="${task.creationTaskProjectMain.idProject == project.idProject}">
							<td>${task.creationTaskProjectMain.keyNameProject} - ${task.idTask}</td>
							<td>${task.nameTask}</td>
							<td>${task.descriptionsTask}</td>
							<td>${task.taskStatus.nameStatusTask}</td>
							<td>${task.urgencyTask.nameUrgency}</td>
							<td>${task.creationTaskProjectMain.nameProject}</td>
							<td>${task.timeTask}</td>
						</c:if>
						</tr>
					</c:forEach>

				</table>
			</div>

		</form:form>
		<a href="<c:url value="/"/>">Back</a>
	</div>
</body>
</html>