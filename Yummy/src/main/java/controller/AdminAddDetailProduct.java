package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Products;
import model.ProductsDetail;
import repository.ProductDetailBO;
import repository.ProductsBO;

/**
 * Servlet implementation class AdminAddDetailProduct
 */
@WebServlet(description = "AdminAddDetailProduct", urlPatterns = { "/admin/pages/detailproduct/add" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminAddDetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public AdminAddDetailProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id_sanpham = Long.valueOf(request.getParameter("id_sanpham"));
		request.setAttribute("id_sanpham", id_sanpham);
		ProductsBO product = new ProductsBO();
		Products p = product.getProductsByID(id_sanpham);
		request.setAttribute("product", p);
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin\\product\\productdetailadd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//System.out.println(request.getParameter("id_sanpham"));
		long id_sanpham = Long.valueOf(request.getParameter("id_sanpham"));
		ProductsDetail detail = new ProductsDetail();
		detail.setId_sanPham(id_sanpham);

		String empty = new String();

		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().trim();
		InputStream fileContent = filePart.getInputStream();

		if (!fileName.equals(empty)) {
			fileName = new Date().getTime() + fileName;

			// Đường dẫn tuyệt đối tới thư mục gốc của web app.
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');
			// Thư mục để save file tải lên.
			String fullSavePath = null;
			if (appPath.endsWith("/")) {
				fullSavePath = appPath + "assets/img/shop/DetailProduct/";
			} else {
				fullSavePath = appPath + "/" + "assets/img/shop/DetailProduct/";
			}

			File file = new File(fullSavePath, fileName);
			// System.out.println(file.getPath());

			try {
				Files.copy(fileContent, file.toPath());
			} catch (Exception e) {

			}
		}

		detail.setAnhChiTiet(fileName);
		ProductDetailBO detailControl = new ProductDetailBO();
		boolean check = detailControl.addDetailProducts(detail);
		if (check) {
			HttpSession session = request.getSession();
			session.setAttribute("Add", "Success");
			session.setMaxInactiveInterval(15);
			response.sendRedirect("AdminListDetailProduct?id="+id_sanpham);
		} else {

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminListDetailProduct?id="+id_sanpham);
		dispatcher.forward(request, response);
	}

}
