<%@ include file="./header.jsp"%>
<body>
	<div id="wrapper">
		<form:form action="/project_all_user" method="GET">
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
							alt="avatar Project ${user.nameUser}"
							src="${contextPath}/resources/static/image/project/icon_project.png"></li>
						<li class="Project-status">List of user projects: 
							${countProjectList}</li>
						<li class="Project-status">
									Active:
							${active}</li>
						<li class="Project-status">
									 Close :
							${close}</li>
						<li class="Project-status">
									Archive:
							${archive}</li>
							<li class="Project-status">

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
								<div class="panel-heading">List project</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="dataTables-example">
											<thead>
												<tr>
													<th>Number</th>
													<th>Key-Project</th>
													<th>Name</th>
													<th>Description</th>
													<th>Status</th>
													<th>Manager</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="project" items="${listProject}"
													varStatus="Count">
													<tr>
														<td>${Count.count})<img class="project"
															alt="image project ${project.nameProject}"
															src="${contextPath}/resources/static/image/project/${project.imageAvatarProject.urlImageProject}"></td>
																														
															<td>${project.keyNameProject}-${project.idProject}</td>
														<td><a href="/project-${project.idProject}">${project.nameProject}</a></td>
														<td>${project.descriptionsProject}</td>											
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
														<td>${project.managerUser.nameUser} ${project.managerUser.lastnameUser}</td>
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