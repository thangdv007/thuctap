package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductsDetail;
import repository.ProductDetailBO;

/**
 * Servlet implementation class AdminDeleteDetailProduct
 */
public class AdminDeleteDetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDeleteDetailProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.valueOf(request.getParameter("id"));
		ProductDetailBO detailControl = new ProductDetailBO();
		ProductsDetail detail = detailControl.getDetailproductByID(id);

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

		String fileName = detail.getAnhChiTiet();
		long id_sanpham = detail.getId_sanPham();
		File file = new File(fullSavePath, fileName);

		boolean check = detailControl.deleteDetailProduct(id);
		if (check) {
			HttpSession session = request.getSession();
			session.setAttribute("Delete", "Success");
			session.setMaxInactiveInterval(15);
			if (file.delete()) {
				// System.out.println("đã xóa file: " + file.getName());
			} else {
				// System.out.println("Xóa file thất bại.");
			}
			response.sendRedirect("AdminListDetailProduct?id=" + id_sanpham);
		} else {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
