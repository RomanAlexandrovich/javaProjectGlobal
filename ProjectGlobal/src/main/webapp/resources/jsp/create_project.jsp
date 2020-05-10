<%@ include file="./header.jsp"%>
<body>
	<div>
		<form:form method="POST" modelAttribute="formProject">
			<h2>Create project</h2>
			<div>
				Name:
				<form:input type="text" path="nameProject" placeholder="Name"></form:input>
			</div>
			<div>
				Key:
				<form:input type="text" path="keyNameProject" placeholder="Key"></form:input>
			</div>
			<div>
				Descriptions:
				<form:textarea type="text" path="descriptionsProject"
					placeholder="Description task"></form:textarea>
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
			<c:forEach var="user" items="${listUsers}" >
				<option value="${user.idUser}">${user.nameUser}</option>
			</c:forEach>
		</form:select>
			</div>

			<button type="submit">create</button>

		</form:form>	
	</div>
</body>
</html>