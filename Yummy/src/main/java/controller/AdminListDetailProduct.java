package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Products;
import model.ProductsDetail;
import repository.ProductDetailBO;
import repository.ProductsBO;

/**
 * Servlet implementation class AdminListDetailProduct
 */
public class AdminListDetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListDetailProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		/* check session đăng nhập */
		HttpSession session = request.getSession();
		if (session.getAttribute("uslogin") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		/* kết thúc check session đăng nhập */
		long id =  Long.parseLong(request.getParameter("id"));
		ProductDetailBO productDetail = new ProductDetailBO();
		ProductsBO product = new ProductsBO();
		ArrayList<ProductsDetail> lstPd;
		Products p = product.getProductsByID(id);;
		lstPd = productDetail.getProductDetailByProductID(id);		
		request.setAttribute("lstProductDetail", lstPd);
		request.setAttribute("product", p);
		RequestDispatcher rd = request.getRequestDispatcher("admin\\product\\productdetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
