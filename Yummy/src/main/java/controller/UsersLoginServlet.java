package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;
import repository.UsersBO;

/**
 * Servlet implementation class UsersLoginServlet
 */
public class UsersLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersLoginServlet() {
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
		String user_name = request.getParameter("user-name");
		String user_pass = request.getParameter("user-password");
		UsersBO u = new UsersBO();
		HttpSession session = request.getSession();
		if (u.checkLogin(user_name, user_pass) != null) {
			Users us = u.checkLogin(user_name, user_pass);
			session.setAttribute("uslogin", us);
			// phân quyền để chuyển trang
			if (us.getPhanQuyen().equals("0")) {
				response.sendRedirect("Home");
			}
			if (us.getPhanQuyen().equals("1")) {
				session.setAttribute("admin", "admin");
				response.sendRedirect("Admin");
			}
		} else {
			String error = "Tài khoản hoặc mật khẩu không đúng,vui lòng kiểm tra lại.";
			session.setAttribute("errorlogin", error);
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
