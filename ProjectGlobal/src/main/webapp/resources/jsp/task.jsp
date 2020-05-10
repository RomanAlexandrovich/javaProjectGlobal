<%@ include file="./header.jsp"%>
<title>${task.nameTask}</title>
<body>
	<div>
		<form:form action="/task-${task.idTask}" method="GET">
			<div>
				<h1>${task.nameTask}</h1>
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
						<tr>
							<td>${task.creationTaskProjectMain.keyNameProject} - ${task.idTask}</td>
							<td>${task.nameTask}</td>
							<td>${task.descriptionsTask}</td>
							<td>${task.taskStatus.nameStatusTask}</td>
							<td>${task.urgencyTask.nameUrgency}</td>
							<td>${task.creationTaskProjectMain.nameProject}</td>
							<td>${task.timeTask}</td>
						</tr>
				</table>
			</div>
			<a href="<c:url value="/"/>">Back</a>
		</form:form>
	</div>
</body>
</html>