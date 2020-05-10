<%@ include file="./header.jsp"%>
<title>Project-User</title>
<body>
	<form:form method="POST" modelAttribute="project">
		<div>
			Name:
			<form:input type="text" path="nameProject" placeholder="Name"
				value="${projectEdit.nameProject}"></form:input>
		</div>
		<div>
			Key:
			<form:input type="text" path="keyNameProject" placeholder="Key"
				value="${projectEdit.keyNameProject}"></form:input>
		</div>
		<div>
			Descriptions:
			<form:textarea type="text" path="descriptionsProject"
				placeholder="Description task"
				value="${projectEdit.descriptionsProject}"></form:textarea>
		</div>
		<div>
			Manager:
			<form:select path="managerUser">
				<c:forEach var="manager" items="${listUser}">
					<option value="${manager.idUser}">${manager.nameUser}</option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<form:select path="imageAvatarProject">
				<c:forEach var="image" items="${listImage}">
					<option value="${image.idImageProject}">${image.urlImageProject}</option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<form:select path="statusProject">
				<c:forEach var="status" items="${listStatus}">
					<option value="${status.idStatusProject}">${status.nameStatusProject}</option>
				</c:forEach>
			</form:select>
		</div>
		<div>

			<form:select path="listUsers" multiple="multiple">
				<c:forEach var="user1" items="${projectEdit.listUsers}">
					<c:forEach var="user2" items="${listUsers}">
						<c:choose>
							<c:when test="${user1.idUser == user2.idUser}"><option value="${user2.idUser}" selected>${user2.nameUser}</option></c:when>
							<c:otherwise ><option value="${user2.idUser}">${user2.nameUser}</option></c:otherwise>
						</c:choose>
					</c:forEach>
				</c:forEach>
			</form:select>
		</div>

		<button type="submit">edit</button>
	</form:form>
	<a href="<c:url value="/"/>">Back</a>

</body>
</html>