<%@ include file="./header.jsp"%>
<title>Home</title>
<body>
	<div id="wrapper">
		<form:form action="/home" method="GET" modelAttribute="user">


			<nav class="navbar navbar-default navbar-cls-top " role="navigation"
				style="margin-bottom: 0">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/home">${user.nameUser}
						${user.lastnameUser}</a>
				</div>
				<div
					style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
					Last access : ${localTime} &nbsp; <a href=<c:url value="/logout"/>
						class="btn btn-danger square-btn-adjust">Logout</a>
				</div>
				<div>
					style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
					<a href="${contextPath}/task"
						class="btn btn-danger square-btn-adjust">Create task</a>
				</div>
			</nav>
			<!-- /. NAV TOP  -->
			<nav class="navbar-default navbar-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav" id="main-menu">
						<li class="text-center"><img
							class="user-image img-responsive"
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
			<!-- /. NAV SIDE  -->
			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row">
						<div class="col-md-12">
							<h2>Dashboard</h2>
							<h5>Welcome ${user.nameUser} ${user.lastnameUser}, love to
								see you back.</h5>
						</div>
					</div>
					<!-- /. ROW  -->
					<hr />
					<div class="row">
						<div class="col-md-3 col-sm-6 col-xs-6">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-yellow set-icon"> <i
									class="fa fa-bell-o"></i>
								</span>
								<!-- fa fa-envelope-o-->
								<div class="text-box">
									<p class="main-text">${listTaskToDo}Tasks</p>
									<p class="text-muted">TO DO</p>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-green set-icon"> <i
									class="fa fa-bars"></i>
								</span>
								<div class="text-box">
									<p class="main-text">${listTaskInProcess}Task</p>
									<p class="text-muted">In Process</p>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-blue set-icon"> <i
									class="fa fa-bars"></i>
								</span>
								<div class="text-box">
									<p class="main-text">${listTaskDone}Task</p>
									<p class="text-muted">Done</p>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-brown set-icon"> <i
									class="fa fa-rocket"></i>
								</span>
								<div class="text-box">
									<p class="main-text">${listTaskClose}Task</p>
									<p class="text-muted">Close</p>
								</div>
							</div>
						</div>
					</div>
					<!-- /. ROW  -->
					<hr />
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-green set-icon"> <i
									class="fa fa-desktop"></i>
								</span>
								<div class="text-box">
									<p class="main-text">${totalTasks}Task</p>
									<p class="text-muted">Total number of tasks</p>
								</div>
							</div>
						</div>
					</div>
					<!-- /. ROW  -->
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-heading">Table task</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover">
											<thead>
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
											</thead>
											<tbody>
												<c:forEach var="taskUser" items="${listTaskUser}"
													varStatus="Count">
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
											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>
					<!-- /. ROW  -->
					<div class="row">
						<div class="col-md-9 col-sm-12 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-heading">Bar Chart Example</div>
								<div class="panel-body">
									<div id="morris-bar-chart"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- /. ROW  -->
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-heading">Project list</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>***</th>
													<th>Name</th>
													<th>Status</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="project" items="${listProject}"
													varStatus="Count">
													<tr>
														<td>${Count.count})<img class="project"
															alt="image project ${project.nameProject}"
															src="${contextPath}/resources/static/image/project/${project.imageAvatarProject.urlImageProject}"></td>
														<td><a href="/project-${project.idProject}">${project.nameProject}</a></td>
														<td>${project.statusProject.nameStatusProject}</td>
													</tr>

												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>


					<!-- /. ROW  -->
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-heading">Label Examples</div>
								<div class="panel-body">
									<span class="label label-default">Default</span> <span
										class="label label-primary">Primary</span> <span
										class="label label-success">Success</span> <span
										class="label label-info">Info</span> <span
										class="label label-warning">Warning</span> <span
										class="label label-danger">Danger</span>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading">Donut Chart Example</div>
								<div class="panel-body">
									<div id="morris-donut-chart"></div>
								</div>
							</div>

						</div>

						<!-- /. ROW  -->
					</div>
					<!-- /. PAGE INNER  -->
				</div>
				<!-- /. PAGE WRAPPER  -->
			</div>





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

			</div>
		</form:form>


		<%@ include file="./footer.jsp"%>