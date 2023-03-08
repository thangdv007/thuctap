
package repository;

import java.util.ArrayList;

import dao.AddressDAO;
import model.Quan_Huyen;
import model.Tinh_ThanhPho;
import model.Xa_Phuong;

/**
 * @author MyPC
 *
 */
public class AddressBO {
	//
	AddressDAO s = new AddressDAO();

	// Lấy toàn bộ tỉnh thành phố
	public ArrayList<Tinh_ThanhPho> getTinhThanhPhoId(){
		return s.getTinhThanhPho();
	}
	// Lấy toàn bộ quận/ huyện theo id tỉnh
	public ArrayList<Quan_Huyen> getQuanHuyenById(long tinhThanhPhoId) {
		return s.getQuanHuyenById(tinhThanhPhoId);
	}

	// Lấy toàn bộ xã phường theo id huyện
	public ArrayList<Xa_Phuong> getXaPhuongById(long quanHuyenId){
		return s.getXaPhuongById(quanHuyenId);
	}

}
