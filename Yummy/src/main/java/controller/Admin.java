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
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin() {
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

		long countDatHang = new BillsBO().getSelectDatHang().size();
		request.setAttribute("countDatHang", countDatHang);
		long countDangShip = new BillsBO().getSelectDangShip().size();
		request.setAttribute("countDangShip", countDangShip);
		long sumUser = new UsersBO().getListUsers().size();
		request.setAttribute("sumUser", sumUser);
		long sumProduct = new ProductsBO().getListProducts().size();
		request.setAttribute("sumProduct", sumProduct);

		// Lấy ngày hiện tại
		/*LocalDate now = LocalDate.now();
		// Lấy ngày cách đây 30 ngày
		LocalDate last30Days = now.minusDays(30);

		String[] dataChart = new BillsBO().SelectDB30Days(last30Days.toString(), now.toString());

		request.setAttribute("valueNgay", dataChart[0]);
		request.setAttribute("valueTongTien", dataChart[1]);*/

		HttpSession session = request.getSession();

		if (session.getAttribute("uslogin") != null) {
			if (session.getAttribute("admin") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminListProducts");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
			}
		} else {
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
