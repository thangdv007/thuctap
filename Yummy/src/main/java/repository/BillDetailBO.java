package repository;

import java.util.ArrayList;

import dao.BillsDetailDAO;
import model.BillDetailsFull;

public class BillDetailBO {
	BillsDetailDAO s = new BillsDetailDAO();
	// get chi tiết hóa đơn theo mã hóa đơn

	public ArrayList<BillDetailsFull> getBillDetailFullById(long idHoaDon) {
		return s.getBillDetailFullById(idHoaDon);
	}
}
