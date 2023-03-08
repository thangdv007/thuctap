<%@page import="model.Category"%>
<%@page import="model.ProductsDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html class="no-js" lang="">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Trang quản lý</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<jsp:include page="../include/css.jsp"></jsp:include>

</head>

<body class="">
		<%
		ProductsDetail detail = (ProductsDetail) request.getAttribute("detail");
	%>
	
			<jsp:include page="../include/header.jsp"></jsp:include>
		
		<!-- End Navbar -->
		
			<div class="content">
			<div class="animated fadeIn">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong>Chỉnh sửa</strong>
							</div>
							<div class="card-body card-block">
								<form action="AdminEditDetailProduct" method="post" enctype="multipart/form-data"
									class="form-horizontal">
									<input type="hidden" class="form-control"
										value="<%=detail.getId()%>" name="id">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Chọn ảnh</label>
												<div>
													<input type="file" name="file" id="profile-img">
													<%
														if (detail.getAnhChiTiet() != "") {
													%>
													<img
														src="admin/../assets/img/shop/DetailProduct/<%=detail.getAnhChiTiet()%>"
														id="profile-img-tag" width="500px"
														style="display: block; margin-left: auto; margin-right: auto;" />
													<%
														} else {
													%>
													<img src="" id="profile-img-tag" width="500px"
														style="display: block; margin-left: auto; margin-right: auto;" />
													<%
														}
													%>

												</div>
											</div>
											<div class="form-actions form-group">
												<button type="submit" class="btn btn-success">Lưu
													lại</button>
												<button type="submit" class="btn btn-danger"name="huy" onclick="history.go(-1);">Hủy bỏ</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .animated -->
		</div>
		
	
	<script src="admin/lib/bower_components/jquery/dist/jquery.min.js"></script>
	<script src="admin/lib/js/popper.min.js"></script>
	<script
		src="admin/lib/bower_components/bootstrap4.1/dist/js/bootstrap.js"></script>
	<script src="admin/lib/js/jquery.matchHeight.min.js"></script>
	<script src="admin/lib/assets/js/main.js"></script>
	<script
		src="admin/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
	<script src="admin/lib/bower_components/jquery/dist/jquery.min.js"></script>
	<%
		if ((String) session.getAttribute("Add") == "Success") {
		%>
	<script>
			document.write("haha");
			swal('Thêm dữ liệu thành công');
		</script>
	<%
		session.removeAttribute("Add");
		}
		%>
<script>
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#profile-img-tag').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		$("#profile-img").change(function() {
			readURL(this);
		});
	</script>
</body>

</html>