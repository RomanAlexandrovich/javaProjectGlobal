<%@ include file="./header.jsp"%>
<body>
	<div id="wrapper">
		<form:form action="/task-${project.idProject}" method="GET">

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
					<a href=<c:url value="/logout"/>
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
							src="${contextPath}/resources/static/image/project/${project.imageAvatarProject.urlImageProject}"></li>
						<li class="Tel-email-status-user">Status:
							${project.statusProject.nameStatusProject}</li>
						<li class="Tel-email-status-user">Key:
							${project.keyNameProject}</li>
						<li class="Tel-email-status-user">Manager:
							${project.managerUser.nameUser} ${project.managerUser.lastnameUser}</li>
						<li><a href="/home"><i
								class="fa fa-dashboard fa-3x"></i>Home</a></li>
						<li><a href="/task_all"><i
								class="fa fa-desktop fa-3x"></i>Tasks</a></li>
					</ul>

				</div>

			</nav>
			<!-- /. NAV SIDE  -->
			<div id="page-wrapper">
				<div id="page-inner">
					<!-- /. ROW  -->
					<hr />
					<div class="row">
						<div style="margin: 5px; margin-left: 25px;" class="btn-group">
							<button data-toggle="dropdown"
								class="btn btn-primary dropdown-toggle">${project.statusProject.nameStatusProject}</button>
							<ul class="dropdown-menu">
								<form:form modelAttribute="statusProject">
									<c:forEach var="status" items="${listStatusProject}">
										<li value="${status.nameStatusProject}"><a
											href="/project-${project.idProject}/${status.nameStatusProject}">${status.nameStatusProject}</a></li>
									</c:forEach>
								</form:form>
							</ul>
						</div>
					</div>
					<!-- /. ROW  -->
					<div class="row">
						<div class="col-md-12">
							<h2>${project.nameProject}</h2>
							
						</div>
					</div>
					
					<hr />
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-back noti-box">
								<span class="icon-box bg-color-green set-icon"> <i
									class="fa fa-bars"></i>
								</span>
								<div class="text-box">
									<p class="main-text">DESCRIPTION</p>
									<p class="text-muted">${project.descriptionsProject}</p>
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
													<th>Number</th>
													<th>Key-Task</th>
													<th>Name</th>
													<th>Description</th>
													<th>Status</th>
													<th>Priority</th>
													<th>Project</th>
													<th>Date create</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="taskIdProject" items="${listTaskIdProject}"
													varStatus="Count">
													<tr>
														<td><c:choose>
																<c:when test="${taskIdProject.urgencyTask.idUrgency == 1}">
																	<span class="label label-danger">${Count.count}</span>
																</c:when>
																<c:otherwise>
															${Count.count}
															</c:otherwise>
															</c:choose></td><td>${taskIdProject.creationTaskProjectMain.keyNameProject}-${taskIdProject.idTask}</td>
														<td><a href="/task-${taskIdProject.idTask}">${taskIdProject.nameTask}</a></td>
														<td><a href="/task-${taskIdProject.idTask}">${taskIdProject.descriptionsTask}</a></td>
														<td><c:choose>
																<c:when test="${taskIdProject.taskStatus.idStatusTask == 1}">
																	<span class="label label-yellow">${taskIdProject.taskStatus.nameStatusTask}</span>
																</c:when>
																<c:when test="${taskIdProject.taskStatus.idStatusTask == 2}">
																	<span class="label label-success">${taskIdProject.taskStatus.nameStatusTask}</span>
																</c:when>
																<c:when test="${taskIdProject.taskStatus.idStatusTask == 3}">
																	<span class="label label-primary">${taskIdProject.taskStatus.nameStatusTask}</span>
																</c:when>
																<c:when test="${taskIdProject.taskStatus.idStatusTask == 4}">
																	<span class="label label-default">${taskIdProject.taskStatus.nameStatusTask}</span>
																</c:when>
															</c:choose></td>
														<td><c:choose>
																<c:when test="${taskIdProject.urgencyTask.idUrgency == 1}">
																	<span class="label label-danger">${taskIdProject.urgencyTask.nameUrgency}</span>
																</c:when>
																<c:when test="${taskIdProject.urgencyTask.idUrgency == 2}">
																	<span class="label label-warning">${taskIdProject.urgencyTask.nameUrgency}</span>
																</c:when>
																<c:when test="${taskIdProject.urgencyTask.idUrgency == 3}">
																	<span class="label label-info">${taskIdProject.urgencyTask.nameUrgency}</span>
																</c:when>
																<c:when test="${taskIdProject.urgencyTask.idUrgency == 4}">
																	<span class="label label-default">${taskIdProject.urgencyTask.nameUrgency}</span>
																</c:when>
															</c:choose></td>
														<td>${taskIdProject.creationTaskProjectMain.nameProject}</td>
														<td>${taskIdProject.timeTask}</td>
														 
														<td><a href="/delete-${taskIdProject.idTask}"><i class="fa fa-trash" aria-hidden="true"></i></a>
														</td>
													</tr>

												</c:forEach>
											</tbody>
										</table>

									</div>
								</div>
							</div>

						</div>
					</div>
					<hr />
					<div class="row"></div>
					<!-- /. ROW  -->

					<!-- /. PAGE INNER  -->
				</div>
				<!-- /. PAGE WRAPPER  -->
			</div>
		</form:form>
	</div>


	<%@ include file="./footer.jsp"%>