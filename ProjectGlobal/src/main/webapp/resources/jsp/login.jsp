<%@ include file="./header.jsp"%>
<title>Log in with your account</title>

<body>
	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<form method="POST" action="${contextPath}/login"
					class="form-signin">
					<h2>Log in</h2>

					<div class="form-group ${error != null ? 'has-error' : ''}">
						<span>${message}</span> 
						<input name="username" type="text"
							placeholder="Username" /><br> 
							<input name="password"
							type="password" placeholder="Password" /><br>
							 <span>${error}</span>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /><br>

						<button type="submit">Log In</button>
					</div>
				</form>
			</div>

		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>