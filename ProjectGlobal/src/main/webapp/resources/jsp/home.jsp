<%@ include file="./header.jsp"%>
<title>Home</title>
<body>
	<form:form action="/home" method="GET" modelAttribute="user">

		<div id="wrapper">
			<nav class="navbar navbar-default navbar-cls-top " role="navigation"
				style="margin-bottom: 0">
				<div class="navbar-header">
					<!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button> -->
					<a class="navbar-brand" href="/home">${user.nameUser}${user.lastnameUser}</a>
				</div>
				<div
					style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
					Last access : 30 May 2014 &nbsp; <a href="#"
						class="btn btn-danger square-btn-adjust">Logout</a>
				</div>
			</nav>
			<!-- /. NAV TOP  -->
			<nav class="navbar-default navbar-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav" id="main-menu">
						<li class="text-center"><img class="avatar"
							alt="avatar User ${user.nameUser}"
							src="${contextPath}/resources/static/image/avatar/${user.avatarImageUser.urlImageUser}"></li>
						<li><a class="active-menu" href="/home"><i
								class="fa fa-dashboard fa-3x"></i>Home</a></li>
						<li><a href="/tasks"><i class="fa fa-desktop fa-3x"></i>
								Tasks</a></li>
						<li><a href="/project"><i class="fa fa-qrcode fa-3x"></i>Projects</a></li>
						<li><c:forEach var="role" items="${user.rolesUser}">
								<c:if test="${role.idRole == 1}">
									<div>
										<a href="${contextPath}/admin"><i
											class="fa fa-bar-chart-o fa-3x"></i>Setting administration</a>
									</div>
								</c:if>

							</c:forEach></li>
					</ul>

				</div>

			</nav>
			<div>
				<h4>
					<a href="${contextPath}/task">Create task</a>
				</h4>
			</div>

			<div>
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
		</div>
	</form:form>


</body>
</html>