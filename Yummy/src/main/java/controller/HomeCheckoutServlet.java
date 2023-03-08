package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Quan_Huyen;
import model.Xa_Phuong;
import repository.AddressBO;

/**
 * Servlet implementation class HomeCheckoutServlet
 */
public class HomeCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeCheckoutServlet() {
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
		AddressBO a = new AddressBO();	
		String id_city=request.getParameter("tinhThanhPhoId");
		String id_dictricst = request.getParameter("quanHuyenId");
		String status = request.getParameter("status");
		switch (status) {
		case "district":
			if(id_city != null) {
				Long idCity = Long.parseLong(id_city); 
				String textdictics = "<select id=\"iddistrict\" onchange=\"load_town_ward(this.value);\" name=\"district\"> <option value=\"\"></option>"; 
				for (Quan_Huyen ls : a.getQuanHuyenById(idCity)) {
					textdictics += "<option value=\""+ls.getTenQuanHuyen()+"\">"+ls.getTenQuanHuyen()+"</option>";
				}
				textdictics += "</select>"; 
				response.getWriter().println(textdictics);  
			}
			break;
		case "town_ward":
			if(id_dictricst != null) {
				Long idDictricst = Long.parseLong(id_dictricst); 
				String text_town_ward = "<select id=\"idtown_ward\" onchange=\"showship();\" name=\"town_ward\"> <option value=\"\"></option>";
				for (Xa_Phuong ls : a.getXaPhuongById(idDictricst)) {
					text_town_ward += "<option value=\""+ls.getTenXaPhuong()+"\">"+ls.getTenXaPhuong()+"</option>";
				}
				text_town_ward += "</select>"; 
				response.getWriter().println(text_town_ward);  
			}
			break;
		default:
			break;
		}
		//RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
		//rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
