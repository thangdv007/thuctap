package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Quan_Huyen;
import model.Tinh_ThanhPho;
import model.Xa_Phuong;


/**
 * @author MyPC
 *
 */
public class AddressDAO {
	// Láº¥y toĂ n bá»™ tá»‰nh thĂ nh phá»‘
	public ArrayList<Tinh_ThanhPho> getTinhThanhPho(){
		DBConnect cs = new DBConnect();
		ArrayList<Tinh_ThanhPho> lst = new ArrayList<Tinh_ThanhPho>();
		try {
			cs.KetNoi();
			String sql = "Select * From TinhThanhPho";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Tinh_ThanhPho tinh_thanhpho = new Tinh_ThanhPho();
				tinh_thanhpho.setID(rs.getLong("ID")); 
				tinh_thanhpho.setQuocGiaId(rs.getLong("quocGiaId"));
				tinh_thanhpho.setTenTinhThanhPho(rs.getString("tenTinhThanhPho"));
				// ThĂªm vĂ o danh sĂ¡ch
				lst.add(tinh_thanhpho);								
			}
			rs.close();
			cs.cn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}
	// Láº¥y toĂ n bá»™ quáº­n/ huyá»‡n theo id tá»‰nh
	public ArrayList<Quan_Huyen> getQuanHuyenById(long tinhThanhPhoId){
		DBConnect cs = new DBConnect();
		ArrayList<Quan_Huyen> lst = new ArrayList<Quan_Huyen>();
		try {
			cs.KetNoi();
			String sql = "Select * From QuanHuyen Where tinhThanhPhoId=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, tinhThanhPhoId);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Quan_Huyen quan_huyen = new Quan_Huyen();
				quan_huyen.setTinhThanhPhoId(rs.getLong("tinhThanhPhoId"));
				quan_huyen.setID(rs.getLong("ID"));
				quan_huyen.setTenQuanHuyen(rs.getString("tenQuanHuyen"));
				lst.add(quan_huyen);								
			}
			rs.close();
			cs.cn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}
	// Láº¥y toĂ n bá»™ xĂ£ phÆ°á»�ng theo id huyá»‡n
	public ArrayList<Xa_Phuong> getXaPhuongById(long quanHuyenID){
		DBConnect cs = new DBConnect();
		ArrayList<Xa_Phuong> lst = new ArrayList<Xa_Phuong>();
		try {
			cs.KetNoi();
			String sql = "Select * From XaPhuong Where quanHuyenId=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, quanHuyenID);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Xa_Phuong xa_phuong = new Xa_Phuong();
				xa_phuong.setQuanHuyenId(rs.getLong("quanHuyenId"));
				xa_phuong.setID(rs.getLong("ID"));
				xa_phuong.setTenXaPhuong(rs.getString("tenXaPhuong"));
				// ThĂªm vĂ o danh sĂ¡ch
				lst.add(xa_phuong);			
			}
			rs.close();
			cs.cn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

}
