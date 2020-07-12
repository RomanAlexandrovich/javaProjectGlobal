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
						class="btn btn-danger square-btn-adjust">Logout</a> <a
						href="${contextPath}/task"
						class="btn btn-danger-create square-btn-adjust">Create task</a>
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
						<li class="Tel-email-status-user"><i class="fa fa-mobile"></i>
							${user.telefonUser}</li>
						<li class="Tel-email-status-user"><i class="fa fa-envelope"></i>
							${user.emailUser}</li>
						<li class="Tel-email-status-user"><i class="fa fa-thumbs-up"></i>
							${user.statusUser.nameStatusUser}</li>
						<li><a href="/home"><i
								class="fa fa-dashboard fa-3x"></i>Home</a></li>
						<li><a href="/task_all"><i class="fa fa-desktop fa-3x"></i>
								Tasks</a></li>
						<li><a href="/project_all_user"><i class="fa fa-qrcode fa-3x"></i>Projects</a></li>
						<li><a href="/home"><i
								class="fa fa-bar-chart-o fa-3x"></i>Statistic</a></li>
						<c:forEach var="role" items="${user.rolesUser}">
							<c:if test="${role.idRole == 1}">
								<li><a href="${contextPath}/admin"><i
										class="fa fa-cog fa-spin fa-3x fa-fw"></i>Administration</a></li>
							</c:if>
						</c:forEach>
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
									<p class="main-text">${listTaskToDo}
										<i class="fa fa-thumb-tack" aria-hidden="true"></i>
									</p>
									<p class="text-muted">TO DO</p>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-green set-icon"> <i
									class="fa fa-rocket"></i>
								</span>
								<div class="text-box">
									<p class="main-text">${listTaskInProcess}
										<i class="fa fa-thumb-tack" aria-hidden="true"></i>
									</p>
									<p class="text-muted">Process</p>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-blue set-icon"> <i
									class="fa fa-bars"></i>
								</span>
								<div class="text-box">
									<p class="main-text">${listTaskDone}
										<i class="fa fa-thumb-tack" aria-hidden="true"></i>
									</p>
									<p class="text-muted">Done</p>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xs-6">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-brown set-icon"> <i
									class="fa fa-bars"></i>
								</span>
								<div class="text-box">
									<p class="main-text">${listTaskClose}
										<i class="fa fa-thumb-tack" aria-hidden="true"></i>
									</p>
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
										<table class="table table-striped table-bordered table-hover"
											id="dataTables-example">
											<thead>
												<tr>
													<th>Key-Task</th>
													<th>Name</th>
													<th>Status</th>
													<th>Priority</th>
													<th>Project</th>
													<th>Date create</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="taskUser" items="${listTaskUser}">
													<c:if test="${taskUser.urgencyTask.idUrgency == 1}">
													<c:if test="${taskUser.taskStatus.idStatusTask != 4 and taskUser.taskStatus.idStatusTask != 3}">

														<tr>
															<td><a href="/task-${taskUser.idTask}">${taskUser.creationTaskProjectMain.keyNameProject}-${taskUser.idTask}</a></td>
															<td><a href="/task-${taskUser.idTask}">${taskUser.nameTask}</a></td>
															<td><c:choose>
																	<c:when test="${taskUser.taskStatus.idStatusTask == 1}">
																		<span class="label label-yellow">${taskUser.taskStatus.nameStatusTask}</span>
																	</c:when>
																	<c:when test="${taskUser.taskStatus.idStatusTask == 2}">
																		<span class="label label-success">${taskUser.taskStatus.nameStatusTask}</span>
																	</c:when>
																	<c:when test="${taskUser.taskStatus.idStatusTask == 3}">
																		<span class="label label-primary">${taskUser.taskStatus.nameStatusTask}</span>
																	</c:when>
																	<c:when test="${taskUser.taskStatus.idStatusTask == 4}">
																		<span class="label label-default">${taskUser.taskStatus.nameStatusTask}</span>
																	</c:when>
																</c:choose></td>
															<td><c:choose>
																	<c:when test="${taskUser.urgencyTask.idUrgency == 1}">
																		<span class="label label-danger">${taskUser.urgencyTask.nameUrgency}</span>
																	</c:when>
																	<c:when test="${taskUser.urgencyTask.idUrgency == 2}">
																		<span class="label label-warning">${taskUser.urgencyTask.nameUrgency}</span>
																	</c:when>
																	<c:when test="${taskUser.urgencyTask.idUrgency == 3}">
																		<span class="label label-info">${taskUser.urgencyTask.nameUrgency}</span>
																	</c:when>
																	<c:when test="${taskUser.urgencyTask.idUrgency == 4}">
																		<span class="label label-default">${taskUser.urgencyTask.nameUrgency}</span>
																	</c:when>
																</c:choose></td>
															<td>${taskUser.creationTaskProjectMain.nameProject}</td>
															<td>${taskUser.timeTask}</td>
														</tr>
													</c:if>
													</c:if>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>
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
														<td><c:choose>
																<c:when
																	test="${project.statusProject.idStatusProject == 1}">
																	<span class="label label-success">${project.statusProject.nameStatusProject}</span>
																</c:when>
																<c:when
																	test="${project.statusProject.idStatusProject == 2}">
																	<span class="label label-primary">${project.statusProject.nameStatusProject}</span>
																</c:when>
																<c:when
																	test="${project.statusProject.idStatusProject == 3}">
																	<span class="label label-default">${project.statusProject.nameStatusProject}</span>
																</c:when>
															</c:choose></td>
													</tr>

												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>

					<!-- /. PAGE INNER  -->
				</div>
				<!-- /. PAGE WRAPPER  -->
			</div>
		</form:form>
	</div>


	<%@ include file="./footer.jsp"%>