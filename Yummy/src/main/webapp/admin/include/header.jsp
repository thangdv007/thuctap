<%@page import="model.Users"%>
<%@page import="org.apache.tomcat.jni.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Header-->
 <%
     Users user = new Users();
     user = (Users) session.getAttribute("uslogin");
		// Giá trị session tồn tại 2 giờ
	session.setMaxInactiveInterval(2 * 60 * 60);

 %>
	<div class="wrapper ">
		<div class="sidebar" data-color="purple" data-background-color="white"
			data-image="../assets/img/sidebar-1.jpg">

			<div class="logo">
				<a href="#"
					class="simple-text logo-normal"> ADMIN : <%=user.getTenHienThi()%></a>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link"
						href="AdminListProducts"> <i class="material-icons">content_paste</i>
							<p>Quản lý sản phẩm</p>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="AdminListUser"> <i class="material-icons">content_paste</i>
							<p>Quản lý User</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<!-- Navbar -->
			<nav
				class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
				<div class="container-fluid">
					<div class="navbar-wrapper">
						<a class="navbar-brand" href="javascript:;">Danh sách</a>
					</div>
					<div class="collapse navbar-collapse justify-content-end">
						<form class="navbar-form">
							<div class="input-group no-border">
								<input type="text" value="" class="form-control"
									placeholder="Search...">
								<button type="submit"
									class="btn btn-white btn-round btn-just-icon">
									<i class="material-icons">search</i>
									<div class="ripple-container"></div>
								</button>
							</div>
						</form>
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="javascript:;">
									<i class="material-icons">dashboard</i>
									<p class="d-lg-none d-md-block">Stats</p>
							</a></li>
							<li class="nav-item dropdown"><a class="nav-link"
								href="javascript:;" id="navbarDropdownProfile"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i class="material-icons">person</i>
									<p class="d-lg-none d-md-block">Account</p>
							</a>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="navbarDropdownProfile">
									<a class="dropdown-item" href="AdminProfileUser?id=<%=user.getId()%>">Tài Khoản</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="UsersLogoutServlet">Đăng xuất</a>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>