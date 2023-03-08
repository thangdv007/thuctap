<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login And Registration Form</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="hero">
		<div class="form-box">
			<div class="button-box">
				<div id="btn"></div>
				<button type="button" class="toggle-btn" onclick="login()">Log
					In</button>
				<button type="button" class="toggle-btn" onclick="register()">Register</button>
			</div>
			<div class="social-icons">
				<img src="images/fb.png"> <img src="images/tw.png"> <img
					src="images/gp.png">
			</div>
			<form action="UsersLoginServlet" method="post" id="login"
				class="input-group">
				<input type="text" class="input-field" name="user-name"
					placeholder="Tên đăng nhập hoặc email" required> <input
					type="text" class="input-field" name="user-password"
					placeholder="Nhập mật khẩu" required>
				<%
									if (session.getAttribute("errorlogin") != null) {
								%>
				<div class="alert alert-danger">
					<center><%=session.getAttribute("errorlogin")%></center>
				</div>
				<%
									session.removeAttribute("errorlogin");
									}
								%>
				<input name="link-back" hidden
					value="<%=request.getHeader("referer")%>">
				<button type="submit" class="submit-btn">Đăng nhập</button>
				<br>
											<a href="Home">quay lại trang chủ</a>
				
			</form>
			
			<form action="UsersRegisterServlet" method="post" id="register"
				class="input-group">
					<%
									if (session.getAttribute("SingupError") != null) {
								%>
								<div class="alert alert-danger"><%=session.getAttribute("SingupError")%></div>
								<%
									session.removeAttribute("SingupError");
									}
								%>

								<%
									if (session.getAttribute("move") != null) {
										String[] value = (String[]) session.getAttribute("move");
								%>
				<input name="user-name" type="text" class="input-field" placeholder="Tên đăng nhập"
					required value="<%=value[0]%>"> 
<%
									if (session.getAttribute("acc0") != null) {
								%>
								<p class="alert-danger"><%=session.getAttribute("acc0")%></p>
								<%
									session.removeAttribute("acc0");
										}
								%>

				
				<input name="user-password" type="password" class="input-field" placeholder="Nhập mật khẩu"
					required value="<%=value[1]%>">
				
<%
									if (session.getAttribute("acc1") != null) {
								%>
								<p class="alert-danger"><%=session.getAttribute("acc1")%></p>
								<%
									session.removeAttribute("acc1");
										}
								%>

				<input name="user-passwordcf" type="password" class="input-field"
					placeholder="Nhập lại mật khẩu" required value="<%=value[2]%>">
				
										<%
									if (session.getAttribute("acc2") != null) {
								%>

								<p class="alert-danger"><%=session.getAttribute("acc2")%></p>
								<%
									session.removeAttribute("acc2");
										}
								%>
				<input name="user-email" type="email" class="input-field" placeholder="Email" required
					value="<%=value[3]%>">

				<input name="user-showname" type="text" class="input-field" placeholder="Tên đăng nhập"
					required value="<%=value[4]%>">

				<%
									if (session.getAttribute("acc4") != null) {
								%>
								<p class="alert-danger"><%=session.getAttribute("acc4")%></p>
								<%
									session.removeAttribute("acc4");
										}
								%>

								<%
									session.removeAttribute("move");
									}

									else {
								%>
								<input name="user-name" placeholder="Tên tài khoản *"
									type="text" class="input-field" required value=""> <input
									name="user-password" class="input-field" placeholder="Mật khẩu *" type="password"
									required> <input class="input-field" name="user-passwordcf"
									placeholder="Nhập lại mật khẩu *"  type="password" required>

								<input class="input-field" name="user-email" placeholder="Email *" type="email"
									required>  <input class="input-field" name="user-showname"
									placeholder="Tên hiển thị *" type="text" required>
								<%
									}
								%>

								<%
									if (session.getAttribute("AcccExists") != null) {
								%>
								<div class="alert alert-danger"><%=session.getAttribute("AcccExists")%></div>
								<%
									session.removeAttribute("AcccExists");
									}
								%>
	
				<button type="submit" class="submit-btn">Đăng ký</button>
				<br>
											<a href="Home" >quay lại trang chủ</a>
				
			</form>
			<br>
			
		</div>
	</div>

	<script>
		var x = document.getElementById('login');
		var y = document.getElementById('register');
		var z = document.getElementById('btn');

		function register() {
			x.style.left = "-400px";
			y.style.left = "50px";
			z.style.left = "110px";
		}
		function login() {
			x.style.left = "50px";
			y.style.left = "450px";
			z.style.left = "0px";
		}
	</script>

</body>
</html>