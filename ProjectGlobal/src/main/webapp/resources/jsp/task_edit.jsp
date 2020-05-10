<%@ include file="./header.jsp"%>
<title>${task.idTask}</title>
<body>
	<div>
		<form:form action="/task-${task.idTask}" method="POST"
			modelAttribute="Task">
			
				<h1>${task.nameTask}</h1>
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
			
						
			
			<a href="<c:url value="/"/>">Back</a>
		</form:form>
	</div>
</body>
</html>