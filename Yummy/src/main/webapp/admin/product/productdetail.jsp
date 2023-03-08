<%@page import="model.Category"%>
<%@page import="model.Products"%>
<%@page import="model.ProductsDetail" %>
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
		Products product = (Products) request.getAttribute("product");
	%>
	
			<jsp:include page="../include/header.jsp"></jsp:include>
		
		<!-- End Navbar -->
		
		<div class="content">
			<div class="animated fadeIn">
				<div class="row">

					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong class="card-title">Danh sách</strong>
								<%
											ArrayList<ProductsDetail> check = (ArrayList<ProductsDetail>) request.getAttribute("lstProductDetail");
											if(check.size()<4){
										%>
								 <a	class="btn btn-primary float-right"
									href="AdminAddDetailProduct?id_sanpham=<%=product.getId()%>"><span><i
										class="fa fa-plus-square"></i></span> Thêm</a>
										<%}else{ %>
										<button type="submit" class="btn btn-danger float-right"name="huy" onclick="history.go(-1);">Trở về</button>
										<%} %>
							</div>
							<div class="card-body">
								<table id="bootstrap-data-table"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>ID</th>
											<th>Hình ảnh chi tiết</th>
											<th>Sửa</th>
											<th>Xóa</th>
										</tr>
									</thead>
									<tbody>
										<%
											ArrayList<ProductsDetail> list = (ArrayList<ProductsDetail>) request.getAttribute("lstProductDetail");
											for (ProductsDetail l : list) {
										%>
										<tr>
											<td><%=l.getId()%></td>
											<td><img alt=""
												src="admin/../assets/img/shop/DetailProduct/<%=l.getAnhChiTiet()%>"
												style="width: 70%; display: block; margin-left: auto; margin-right: auto;">
											</td>
											<td><a class="btn btn-success btn-block"
												href="AdminEditDetailProduct?id=<%=l.getId()%>"><span><i
														class="fa fa-edit"></i></span> Sửa</a></td>
											<td><button class="btn btn-secondary btn-block"
													onclick="Delete(<%=l.getId()%>)">
													<span><i class="fa fa-trash-o"></i></span> Xóa
												</button></td>
										</tr>
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
	
		
	
	<script src="admin/lib/bower_components/jquery/dist/jquery.min.js"></script>
	<script src="admin/lib/js/popper.min.js"></script>
	<script
		src="admin/lib/bower_components/bootstrap4.1/dist/js/bootstrap.js"></script>
	<script src="admin/lib/js/jquery.matchHeight.min.js"></script>
	<script src="admin/lib/assets/js/main.js"></script>
	<script
		src="admin/lib/bower_components/sweetalert2/dist/sweetalert2.js"></script>
	<script src="admin/lib/bower_components/jquery/dist/jquery.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#bootstrap-data-table-export').DataTable();
		});
	</script>
	<%
		if ((String) session.getAttribute("Edit") == "Success") {
	%>
	<script>
		swal('Sửa dữ liệu thành công');
	</script>
	<%
		session.removeAttribute("Edit");
		}
	%>

	<%
		if ((String) session.getAttribute("Add") == "Success") {
	%>
	<script>
		swal('Thêm dữ liệu thành công');
	</script>
	<%
		session.removeAttribute("Add");
		}
	%>

	<%
		if ((String) session.getAttribute("Delete") == "Success") {
	%>
	<script>
		swal('Xóa dữ liệu thành công');
	</script>
	<%
		session.removeAttribute("Delete");
		}
	%>

	<script>
    function Delete(id) {
    	swal({
  		  title: "Bạn có chắc chắn muốn xóa dữ liệu?",
  		  text: "Sau khi xóa, bạn sẽ không thể phục hồi dữ liệu này!",
  		  type: 'warning',
  		  showCancelButton: true,
  		  confirmButtonColor: '#3085d6',
  		  cancelButtonColor: '#d33',
  		  confirmButtonText: 'Yes'
  		}).then((result) => {
  		  if (result.value) {
  			  window.location.href = "AdminDeleteDetailProduct?id=" + id;
  		  } else {
  			  swal("Dữ liệu của bạn không thay đổi!");
  		  }
  		});
    }
  </script>

</body>

</html>