<%@ include file="./header.jsp"%>
<body>
	<div>
		<form:form method="POST" modelAttribute="addUser">
			<h2>Create user</h2>
			<div>
				<form:input type="text" path="nameUser" placeholder="name"></form:input>
			</div>
			<div>
				<form:input type="text" path="lastnameUser"
					placeholder="lastnameUser"></form:input>
			</div>
			<div>
				<form:input type="password" path="passwordUser"
					placeholder="password"></form:input>
			</div>
			<div>
				<form:input type="password" path="passwordConfirm"
					placeholder="Password Confirm"></form:input>
			</div>
			<div>
				<form:input type="text" path="emailUser" placeholder="Email"></form:input>
			</div>
			<div>
				<form:input type="text" path="telefonUser" placeholder="Telefon"></form:input>
			</div>
			<div>
				<form:select path="statusUser">
					<c:forEach var="status" items="${listStatus}">
						<option value="${status.idStatusUser}">${status.nameStatusUser}</option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:select path="positionUser">
					<c:forEach var="position" items="${listPositionUser}">
						<option value="${position.idPosition}">${position.namePosition}</option>
					</c:forEach>
				</form:select>
			</div>
				<div>
					<select name="levelRole">
						<option value="true" >ADMIN</option>
						<option value="false">USER</option>
					</select>
				</div>
				<form:select path="listProject" multiple="multiple">
			<c:forEach var="project" items="${listProjectAll}" >
				<option value="${project.idProject}">${project.nameProject}</option>
			</c:forEach>
		</form:select>

			<button type="submit">create</button>
		</form:form>


	</div>
</body>
</html>