package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Users;
import repository.UsersBO;

/**
 * Servlet implementation class UserEditAvata
 */
//@WebServlet("user-avatar")  
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UserEditAvata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserEditAvata() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
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
		/* check session đăng nhập */
		HttpSession session = request.getSession();
		if (session.getAttribute("uslogin") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		UsersBO us = new UsersBO();
		String user_name = request.getParameter("user-name");
		Part part = request.getPart("file");
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString().trim();

		// Ảnh củ
		String oldImg = us.getUsersByName(user_name).getAnhChinh();
		InputStream fileContent = part.getInputStream();

		fileName = new Date().getTime() + fileName;

		// Đường dẫn tuyệt đối tới thư mục gốc của web app.
		String appPath = request.getServletContext().getRealPath("");
		appPath = appPath.replace('\\', '/');

		// Thư mục để lưu ảnh tải lên.
		String fullSavePath = null;
		// Nếu cuối cùng không là / thì thêm vào
		if (appPath.endsWith("/")) {
			fullSavePath = appPath + "assets/img/testimonial/";
		} else {
			fullSavePath = appPath + "/" + "assets/img/testimonial/";
		}
		// Xóa đi file củ
		File oldFile = new File(fullSavePath, oldImg);
		if (oldFile.delete()) {

		}
		// sao chép hình ảnh vào thư mục dự án
		File file = new File(fullSavePath, fileName);
		try {
			Files.copy(fileContent, file.toPath());
		} catch (Exception e) {

		}
		// Cập nhật lại tài khoản và session user (dùng chung phương thức checklogin)
		Users user = new Users();
		user.setAnhChinh(fileName);
		user.setTenTaiKhoan(user_name);
		String mes;
		if (us.EditAvataAcount(user)) {
			user = us.getUsersByName(user_name);
			mes = "Cập nhật thành công thông ảnh đại diện.";
			session.setAttribute("uslogin", user);
			session.setAttribute("SussecfulEditAcc", mes);
			response.sendRedirect("user-profile.jsp");
		} else {
			mes = "Cập nhật thất bại.";
			session.setAttribute("SingupError", mes);
			response.sendRedirect("user-profile.jsp");
		}

	}

}
