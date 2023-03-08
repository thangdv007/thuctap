package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import model.Items;
import model.Products;
import repository.ProductsBO;

/**
 * Servlet implementation class HomeCartServlet
 */

public class HomeCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductsBO p = new ProductsBO();
		HttpSession session = request.getSession();
		String status = request.getParameter("status");
		String id_product = request.getParameter("id_product");
		String quantity_string = request.getParameter("quantity");

		CartDAO cart = (CartDAO) session.getAttribute("cart");

		try {
			Long idProduct = Long.parseLong(id_product); // Chuyển mã từ request kiểu string sang long
			// Lấy ra thông tin của sản phẩm từ db theo mã sản phẩm
			Products product = p.getProductsByID(idProduct);
			// Viết menu xử lý các trạng thái
			switch (status) {
			case "add":
				if (cart.getCartItems().containsKey(idProduct)) {
					cart.insertToCart(idProduct, new Items(product, cart.getCartItems().get(idProduct).getQuantity()));
				} else {
					cart.insertToCart(idProduct, new Items(product, 1));
				}
				break;
			case "remove":
				cart.removeToCart(idProduct);
				break;
			case "edit":
				int quantity = Integer.parseInt(quantity_string);
				cart.updateToCart(idProduct, quantity,
						new Items(product, cart.getCartItems().get(idProduct).getQuantity()));
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// response.sendRedirect("Home");
		}
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getHeader("referer"));
		// RequestDispatcher rd = request.getRequestDispatcher("Home");
		// rd.forward(request, response);
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
