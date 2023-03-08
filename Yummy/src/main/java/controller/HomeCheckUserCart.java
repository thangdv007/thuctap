package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.BillsBO;
import repository.ProductsBO;
import repository.UsersBO;



/**
 * Servlet implementation class Admin
 */
public class HomeCheckUserCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeCheckUserCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		long sumUser = new UsersBO().getListUsers().size();
		request.setAttribute("sumUser", sumUser);
		

		HttpSession session = request.getSession();

		if (session.getAttribute("uslogin") != null) {
			if (session.getAttribute("admin") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminListProducts");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("checkout.jsp");
			}
		} else {
			String cartlogin= new String("Đăng nhập tài khoản để mua hàng hoặc đăng ký tài khoản mới");
			session.setAttribute("errorlogin", cartlogin);
			response.sendRedirect("login.jsp");
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
