<%@ include file="./header.jsp"%>
<title>Login</title>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img
						src="${contextPath}/resources/static/image/home_image/img-01.png"
						alt="IMG">
				</div>
				<div class="col">
					<form method="POST" action="${contextPath}/login"
						class="login100-form validate-form">
						<span class="login100-form-title"> REGISTRATION </span>

						<div class="wrap-input100 validate-input">

							<input class="input100" type="text" name="username"
								placeholder="Username"> <span class="focus-input100"></span>
							<span class="symbol-input100"> </span>
						</div>

						<div class="wrap-input100 validate-input">
							<input class="input100" type="password" name="password"
								placeholder="Password"> <span class="focus-input100"></span>
							<span class="symbol-input100"> </span> <input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}" /><br>
						</div>
						<div class="container-login100-form-btn">
							<button class="login100-form-btn">Login</button>
						</div>
						<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
							
						</span>
						
					</div>

					<div class="text-center p-t-136">
						
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="./footer.jsp"%>