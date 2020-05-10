<%@ include file="./header.jsp"%>
<title>Global-task</title>
<body>
	<form:form action="/home" method="GET" modelAttribute="user">

		<div>
			<div>
				<h1>${user.nameUser}${user.lastnameUser}</h1>
				<div>
					<h4>
						<a href="${contextPath}/task">Create task</a>
					</h4>
					<br>
				</div>
				<c:forEach var="role" items="${user.rolesUser}">
					<c:if test="${role.idRole == 1}">
						<div>
							<a href="${contextPath}/admin">Setting administration</a>
						</div>
					</c:if>

				</c:forEach>
				<br>
			</div>

			<div>
				<a href="/image"><img class="avatar"
					alt="avatar User ${user.nameUser}"
					src="${contextPath}/resources/static/image/avatar/${user.avatarImageUser.urlImageUser}"></a><br>
				<p>Telefon : ${user.telefonUser}</p>
				<p>Email : ${user.emailUser}</p>
				<p>Status : ${user.statusUser.nameStatusUser}</p>
				<p>Total tasks: ${totalTasks}</p>
				<p>- task (ToDo): ${listTaskToDo}</p>
				<p>- task (In Process): ${listTaskInProcess}</p>
				<p>- task (Done): ${listTaskDone}</p>
				<p>- task (Close): ${listTaskClose}</p>
			</div>
			<h1>Task list ${user.nameUser}</h1>
			<br>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>Number</th>
					<th>Key-Task</th>
					<th>Name</th>
					<th>Task description</th>
					<th>Status</th>
					<th>Priority</th>
					<th>Project</th>
					<th>Date create</th>
				</tr>
				<c:forEach var="taskUser" items="${listTaskUser}" varStatus="Count">
					<tr>
						<td>${Count.count}</td>
						<td>${taskUser.creationTaskProjectMain.keyNameProject}-
							${taskUser.idTask}</td>
						<td><a href="/task-${taskUser.idTask}">${taskUser.nameTask}</a></td>
						<td><a href="/task-${taskUser.idTask}">${taskUser.descriptionsTask}</a></td>
						<td>${taskUser.taskStatus.nameStatusTask}</td>
						<td>${taskUser.urgencyTask.nameUrgency}</td>
						<td>${taskUser.creationTaskProjectMain.nameProject}</td>
						<td>${taskUser.timeTask}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<h1>Project list</h1>
		<br>
		<table border="1">
			<tr>
				<th>***</th>
				<th>Name</th>
				<th>Status</th>
			</tr>

			<c:forEach var="project" items="${listProject}" varStatus="Count">
				<tr>
					<td>${Count.count})<img class="project"
						alt="image project ${project.nameProject}"
						src="${contextPath}/resources/static/image/project/${project.imageAvatarProject.urlImageProject}"></td>
					<td><a href="/project-${project.idProject}">${project.nameProject}</a></td>
					<td>${project.statusProject.nameStatusProject}</td>
				</tr>

			</c:forEach>
		</table>

		<a href="<c:url value="/logout"/>">Logout</a>
	</form:form>


</body>
</html>