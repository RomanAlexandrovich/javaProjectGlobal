<%@ include file="./header.jsp"%>
<body>
	<div id="wrapper">
		<form:form action="/task_all" method="GET">


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
							src="${contextPath}/resources/static/image/task/task_icon.png"></li>
						<li class="Tel-email-status-user">Count all Task: 
							${countTaskUser}</li>
						<li class="Tel-email-status-user">	<i class="fa fa-thumb-tack" aria-hidden="true"></i>
									ToDO:
							${ToDo}</li>
						<li class="Tel-email-status-user"><i class="fa fa-thumb-tack" aria-hidden="true"></i>
									 Process :
							${Process}</li>
						<li class="Tel-email-status-user"><i class="fa fa-thumb-tack" aria-hidden="true"></i>
									Done:
							${Done}</li>
							<li class="Tel-email-status-user">	<i class="fa fa-thumb-tack" aria-hidden="true"></i>
									Close:
							${Close}</li>
						<li><a href="/home"><i
								class="fa fa-dashboard fa-3x"></i>Home</a></li>
					</ul>

				</div>

			</nav>
			<!-- /. NAV SIDE  -->
			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row"></div>

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
												<c:forEach var="taskUser" items="${listTaskUser}"
													varStatus="Count">
													<tr>
														<td><c:choose>
																<c:when test="${taskUser.urgencyTask.idUrgency == 1}">
																	<span class="label label-danger">${Count.count}</span>
																</c:when>
																<c:otherwise>
															${Count.count}
															</c:otherwise>
															</c:choose></td><td>${taskUser.creationTaskProjectMain.keyNameProject}-${taskUser.idTask}</td>
														<td><a href="/task-${taskUser.idTask}">${taskUser.nameTask}</a></td>
														<td><a href="/task-${taskUser.idTask}">${taskUser.descriptionsTask}</a></td>
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
														 
														<td><a href="/delete-${taskUser.idTask}"><i class="fa fa-trash" aria-hidden="true"></i></a>
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
					<!-- /. ROW  -->
					<hr />

					<!-- /. ROW  -->
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