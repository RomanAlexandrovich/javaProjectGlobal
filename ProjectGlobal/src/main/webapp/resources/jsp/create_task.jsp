<%@ include file="./header.jsp"%>
<body>
	<div>
		<form:form method="POST" modelAttribute="formTask">
			<h2>Create task</h2>
			<div>
				<form:input name="task_name" type="text" path="nameTask"
					placeholder="name"></form:input>
			</div>
			<div>
				<form:input type="text" path="attachmentTask"
					placeholder="Attachment Task"></form:input>
			</div>
			<div>
				<form:input type="text" path="descriptionsTask"
					placeholder="Description task"></form:input>
			</div>
			<div>
				<form:select path="taskStatus">
					<c:forEach var="status" items="${listStatusTask}">
						<option value="${status.idStatusTask}">${status.nameStatusTask}</option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:select path="creationTaskProjectMain">
					<c:forEach var="taskProject" items="${listProject}">
						<option value="${taskProject.idProject}">${taskProject.nameProject}</option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				Task user:
				<form:select path="taskUser">
					<c:forEach var="userTask" items="${listUser}">
						<option value="${userTask.idUser}">${userTask.nameUser}</option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				Urgency:
				<form:select path="urgencyTask">
					<c:forEach var="urgency" items="${listUrgency}">
						<option value="${urgency.idUrgency}">${urgency.nameUrgency}</option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				Manager project:
				<form:select path="taskUserManager">
					<c:forEach var="userManager" items="${listUser}">
						<option value="${userManager.idUser}">${userManager.nameUser}</option>
					</c:forEach>
				</form:select>
			</div>
			<button type="submit">create</button>
		</form:form>


	</div>
</body>
</html>