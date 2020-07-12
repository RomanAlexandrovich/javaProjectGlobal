<%@ include file="./header.jsp"%>
<title>Home</title>
<body>
	<div id="wrapper">
		<form:form action="/task-${task.idTask}" method="GET">


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
						<li class="Tel-email-status-user">Status:
							${task.taskStatus.nameStatusTask}</li>
						<li class="Tel-email-status-user">Priority:
							${task.urgencyTask.nameUrgency}</li>
						<li class="Tel-email-status-user">Create date:
							${task.timeTask}</li>
						<li class="Tel-email-status-user">auvtor:
							${task.taskUserManager.nameUser}</li>
						<li><a class="active-menu" href="/home"><i
								class="fa fa-dashboard fa-3x"></i>Home</a></li>
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
								class="btn btn-primary dropdown-toggle">${task.taskStatus.nameStatusTask}</button>
							<ul class="dropdown-menu">
								<form:form modelAttribute="statusTask">
									<c:forEach var="status" items="${listStatusTask}">
										<li value="${status.nameStatusTask}"><a
											href="/task-${task.idTask}/${status.nameStatusTask}">${status.nameStatusTask}</a></li>
									</c:forEach>
								</form:form>
							</ul>
						</div>
					</div>
					<!-- /. ROW  -->
					<div class="row">
						<div class="col-md-12">
							<h2>${task.nameTask}</h2>
							<h5>${taskUser.creationTaskProjectMain.keyNameProject}-${taskUser.idTask}</h5>
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
									<p class="text-muted">${task.descriptionsTask}</p>
								</div>
							</div>
						</div>
					</div>
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