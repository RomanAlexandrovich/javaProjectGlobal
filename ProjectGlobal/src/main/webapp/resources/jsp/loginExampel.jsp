<%@ include file="./header.jsp"%>
<title>Log in with your account</title>

<body>
<body style="background-color: #666666;">

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="POST"
					action="${contextPath}/login">
					<span class="login100-form-title p-b-43"> Login to continue
					</span>


					<div class="wrap-input100 validate-input"
						data-validate="Valid name is required: ${error != null ? 'has-error' : ''} ">
						<!-- <input class="input100" type="text" name="email"> -->
						<input class="input100" name="username" type="text"
							placeholder="Username" /> <span class="focus-input100"></span>
					</div>


					<div class="wrap-input100 validate-input" data-validate="${error}">
						<!-- <input class="input100" type="password" name="pass"> -->
						<input class="input100" name="password" type="password"
							placeholder="Password" /> <span class="focus-input100"></span> <span
							class="focus-input100"></span>
							<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /><br>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">Login</button>
					</div>

				</form>

				<div class="login100-more"
					style="background-image: url('${contextPath}/resources/static/image/fon/bg-01.jpg');">
				</div>
			</div>
		</div>
	</div>
<%@ include file="./footer.jsp"%>
