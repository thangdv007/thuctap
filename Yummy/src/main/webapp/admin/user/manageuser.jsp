<!--
=========================================================
Material Dashboard - v2.1.2
=========================================================

Product Page: https://www.creative-tim.com/product/material-dashboard
Copyright 2020 Creative Tim (https://www.creative-tim.com)
Coded by Creative Tim

=========================================================
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->
<%@page import="model.Users"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - QLUser</title>
<meta name="description" content="Admin - Bán hàng">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="../include/css.jsp"></jsp:include>
</head>

<body class="">
	<jsp:include page="../include/header.jsp"></jsp:include>

	<!-- End Navbar -->
	<div class="content">
		<div class="animated fadeIn">
			<div class="row">

				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Danh sách</strong>
							<!-- 								<a class="btn btn-primary float-right" href="add"><span><i class="fa fa-plus-square"></i></span> Thêm</a> -->
						</div>
						<div class="card-body">
							<table id="bootstrap-data-table"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên tài khoản</th>
										<th>Email</th>
										<th>Tên hiển thị</th>
										<th>Hình đại diện</th>
										<th>Phân quyền</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<%
											ArrayList<Users> list = (ArrayList<Users>) request.getAttribute("lstUser");
											for (Users l : list) {
										%>
									<tr>
										<td><%=l.getId()%></td>
										<td><%=l.getTenTaiKhoan()%></td>
										<td><%=l.getEmail()%></td>
										<td><%=l.getTenHienThi()%></td>
										<td style="max-width: 50px;">
											<%
													if (l.getAnhChinh() != "") {
												%> <a
											href="admin/../assets/img/testimonial/<%=l.getAnhChinh()%>">
												<img alt=""
												src="admin/../assets/img/testimonial/<%=l.getAnhChinh()%>"
												style="width: 100%">
										</a> <%
 										} else {
 										%> <img alt="" src="https://placehold.it/270x270" style="width: 100%">
											<%
 									}
															 %>
										</td>
										<%
												if (l.getPhanQuyen().equals("1")) {
											%>
										<td><button class="btn btn-warning"
												id="trangthai<%=l.getId()%>">Admin</button></td>
										
										<%
												} else {
											%>
										<td><button class="btn btn-primary"
												onclick="swal('Vui lòng chọn quyền User');"
												id="trangthai<%=l.getId()%>">User</button></td>
												<td>
										<a class="btn btn-secondary"
											href="AdminDeleteUser?id=<%=l.getId()%>"> <span><i
													class="fa fa-trash-o"></i></span> Xóa
										</a></td>
										<%
												}
											%>
										<%
											}
										%>
									
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- .animated -->
	</div>
	<!-- .content -->
	<div class="clearfix"></div>
	</div>
	<!-- /#right-panel -->

	<!-- Right Panel -->

	<!-- Scripts -->

	<jsp:include page="../include/js.jsp"></jsp:include>


	<script src="admin/lib/bower_components/alertifyjs/alertify.js"></script>
	<script>
	
</body>
</html>
</html>