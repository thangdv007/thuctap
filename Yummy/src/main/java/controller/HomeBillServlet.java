package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bills;
import model.BillsDetail;
import model.Items;
import model.Users;
import dao.CartDAO;

/**
 * Servlet implementation class HomeBillServlet
 */
public class HomeBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		String status = request.getParameter("status");

		// Thông tin của hóa đơn
		Users user = (Users) session.getAttribute("uslogin");
		
		String user_name = request.getParameter("user-name"); 
		String town_ward = request.getParameter("town_ward");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String note = request.getParameter("note");

		CartDAO dao = new CartDAO();
		switch (status) {
		case "addbill":
			if(note == null) {
				note = "";
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date(); 
			Bills bill = new Bills();
			bill.setDiaChi(address);
			bill.setSoDienThoai(phone);
			bill.setEmail(email);
			bill.setGhiChu(note);
			bill.setHoTen(user_name);
			bill.setNgayDat(dateFormat.format(date));
			bill.setSoNha(town_ward);
			bill.setTrangThai(0);
			Long id_bill; 
			try {
				dao.addBill(bill);				
				if(dao.selectBills().size() != 0) {
					int max = dao.selectBills().size();
					id_bill =  dao.selectBills().get(max-1).getId(); 
				}
				else {
					id_bill = (long) 0; 
				}				
			CartDAO cart = (CartDAO) session.getAttribute("cart"); 
			for (Entry<Long, Items> list : cart.getCartItems().entrySet()) {
				BillsDetail billdetail = new BillsDetail();
				billdetail.setId_hoaDon(id_bill);
				billdetail.setId_sanPham(list.getValue().getProducts().getId());
				billdetail.setSoLuong(list.getValue().getQuantity());
				dao.addBillDetail(billdetail);
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//gọi phương thức gởi mail
			session.removeAttribute("cart"); 
			String tb ="Đặt hàng thành công, mời bạn tiếp tục mua sắm!";
			session.setAttribute("paid", tb);
			response.sendRedirect("cart.jsp"); 
			break;
		default:
			break;
		}  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
