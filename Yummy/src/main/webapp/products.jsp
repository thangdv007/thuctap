<%@page import="repository.*"%>
<%@page import="model.Products"%>
<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="java.text.DecimalFormat"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sản phẩm</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- icon hiển thị -->
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<!-- Toàn bộ css -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/magnific-popup.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="lib/css/nivo-slider.css" type="text/css" />
<link rel="stylesheet" href="lib/css/preview.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="assets/css/animate.css">
<link rel="stylesheet" href="assets/css/jquery-ui.css">
<link rel="stylesheet" href="assets/css/meanmenu.min.css">
<link rel="stylesheet" href="assets/css/bundle.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/responsive.css">
<script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>

	<!-- Thêm phần tiêu đề trang -->
	<jsp:include page="layout/header.jsp"></jsp:include>
	<!-- Xong phần tiêu đề trang -->

	<!-- Bắt đầu tiêu đề trang con -->
	<div class="breadcrumbs-area breadcrumb-bg ptb-100">
		<div class="container">
			<div class="breadcrumbs text-center">
				<h2 class="breadcrumb-title">DANH MỤC SẢN PHẨM</h2>
				<ul>
					<li><a class="active" href="index.jsp">Trang chủ</a></li>
					<li>Sản phẩm</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- Xong tiêu đề trang con -->
	<!-- Bắt đầu nội dung trang danh sách sản phẩm -->
	<div class="shop-page-area ptb-100">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="blog-sidebar">
						<div class="single-sidebar">
							<h3 class="sidebar-title">Các sản phẩm chỉ với giá</h3>
							<div class="price-filter">
								<div id="slider-range"></div>
								<div class="price-slider-amount">
									<input type="text" id="amount" name="price" />
								</div>
							</div>
						</div>
						<div class="single-sidebar">
							<h3 class="sidebar-title">Loại sản phẩm</h3>
							<div class="sidebar-list">
								<ul>
									<%
										ArrayList<Category> category =(ArrayList<Category>)request.getAttribute("lstCategory");
										for (Category ls : category) {
									%>
									<li><input type="checkbox"> <a
										href="HomeProductsServlet?id_category=<%=ls.getId()%>"><%=ls.getTenLoaiSanPham()%></a></li>
									<%
										}
									%>
								</ul>
							</div>
						</div>
						<div class="single-sidebar">
							<h3 class="sidebar-title">Lựa chọn theo màu</h3>
							<div class="sidebar-list">
								<ul>
									<li><input type="checkbox"> <a href="#">Màu
											hồng (8)</a></li>
									<li><input type="checkbox"> <a href="#">Màu
											xanh (5)</a></li>
									<li><input type="checkbox"> <a href="#">Màu
											vàng (2)</a></li>
									<li><input type="checkbox"> <a href="#">Màu
											cam (6)</a></li>
									<li><input type="checkbox"> <a href="#">Màu
											trắng (7)</a></li>
								</ul>
							</div>
						</div>
						
					</div>
				</div>
				<div class="col-md-9">
					<div class="blog-wrapper shop-page-mrg">
						<div class="tab-menu-product">
							<div class="tab-menu-sort">
								<div class="tab-menu">
									<ul role="tablist">
										<li class="active"><a href="#grid" data-toggle="tab">
												<i class="fa fa-th-large"></i> Danh mục
										</a></li>
									</ul>
								</div>
								<div class="tab-sort">
									<label>Sắp xếp : </label> <select>
										<option value="">Mới nhất</option>
										<option value="">Củ hơn</option>
										<option value="">Giá rẻ</option>
										<option value="">Chất lượng</option>
									</select>
								</div>
							</div>
							<!-- Thông báo đặt hàng -->
						<%-- 	<%							
									if(session.getAttribute("paid") != null){
							%>
							<div class="alert alert-info">
								<center>									
									<strong><%out.print("Đặt hàng thành công, mời bạn tiếp tục mua sắm!"); %></strong> 
								</center>
							</div>
							<%
								}
							%> --%>
							<!-- Thông báo đặt hàng -->
							
							<div class="tab-product">
								<div class="tab-content">
									<div class="tab-pane active" id="grid">
										<div class="row">
										<%
											
												DecimalFormat numformat = new DecimalFormat("#,###,###");
												//Lấy ra danh sách sản phẩm
												//ArrayList<Products> list = s.getAllProDuctsLimit(first, last);
												ArrayList<Products> list = (ArrayList<Products>) request.getAttribute("lstProducts");

												for (Products ls : list) {
											%>									
											<div class="col-md-6 col-lg-4 col-sm-6">
												<div class="single-shop mb-40">
													<div class="shop-img" style="100%;height: 400px;">
														<a href="#" data-toggle="modal"
																data-target="#quick-view<%=ls.getId()%>"
																title="Quick View">
															<img style="width: 100%;height: 300px;"
															src="assets/img/shop/product/<%=ls.getAnhChinh()%>"
															alt="" /></a>
														<%
															if (ls.getTinhTrang() == 1) {
																		if (ls.getKhuyenMai() > 0) {
														%>
														<div class="price-up-down">
															<span class="sale-new">Giảm <%=ls.getKhuyenMai()%>%
															</span>
														</div>
														<%
															}
																	} else {
														%>
														<div class="price-up-down">
															<span class="sale-new">Hot </span>
														</div>
														<%
															}
														%>
														<div class="button-group">
															<a href="HomeCartServlet?status=add&id_product=<%=ls.getId()%>" title="Add to Cart"> <i class="pe-7s-cart"></i>
															</a> <a class="wishlist" href="#" title="Wishlist"> <i
																class="pe-7s-like"></i>
															</a> <a href="#" data-toggle="modal"
																data-target="#quick-view<%=ls.getId()%>"
																title="Quick View"> <i class="pe-7s-look"></i>
															</a>
														</div>
													</div>
													<div class="shop-text-all">
														<div class="title-color fix">
															<div class="shop-title f-left">
																<h3>
																	<a href="#"><%=ls.getTenSanPham()%></a>
																</h3>
															</div>
															<%
																double price = ls.getGiaGoc();
																		int sale = ls.getKhuyenMai();
																		price = price - (price * sale / 100);
																		String price_nb = numformat.format(price);
															%>
															<div class="price f-right">
																<span class="new"><%=price_nb%> đ</span>
															</div>
														</div>
													</div>
												</div>
											</div>
											<%
												}											
											%>																					
										</div>									
									</div>
									
									<!-- phân trang -->
									
									<div class="page-pagination text-center">
									<ul>
											<li><a class="active" href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#"><i class="fa fa-angle-double-right"></i></a></li>
										</ul>
							
										
									</div>
									
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Xong nội dung trang danh sách sản phẩm -->
		<!-- Bắt đầu xem nhanh chi tiết -->
	<jsp:include page="layout/detail_product.jsp"></jsp:include>
	<!-- Xong xem nhanh chi tiết -->
	
	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->
 

	<!-- Toàn bộ js -->
	<script src="assets/js/vendor/jquery-1.12.0.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.meanmenu.js"></script>
	<script src="assets/js/jquery.magnific-popup.min.js"></script>
	<script src="assets/js/isotope.pkgd.min.js"></script>
	<script src="assets/js/imagesloaded.pkgd.min.js"></script>
	<script src="assets/js/jquery.validate.min.js"></script>
	<script src="assets/js/owl.carousel.min.js"></script>
	<script src="lib/js/jquery.nivo.slider.js"></script>
	<script src="lib/home.js"></script>
	<script src="assets/js/plugins.js"></script>
	<script src="assets/js/main.js"></script>
</body>


</html>