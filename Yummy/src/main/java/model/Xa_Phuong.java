
package model;


public class Xa_Phuong {
	private long ID, quanHuyenId;
	private String tenXaPhuong;

	/**
	 * 
	 */
	public Xa_Phuong() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param code
	 * @param id_quanHuyen
	 * @param ten
	 * @param tenKhongDau
	 * @param tenDayDu
	 * @param donVi
	 * @param tenThuong
	 * @param tenHanhChinh
	 */
	public Xa_Phuong(long ID, long quanHuyenId, String tenXaPhuong) {
		super();
		this.ID = ID;
		this.quanHuyenId = quanHuyenId;
		this.tenXaPhuong = tenXaPhuong;
		
	}

	/**
	 * @return the id
	 */
	public long getID() {
		return ID;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setID(long ID) {
		this.ID = ID;
	}

	/**
	 * @return the quanHuyenId
	 */
	public long getQuanHuyenId() {
		return quanHuyenId;
	}

	/**
	 * @param code
	 *            the quanHuyenId to set
	 */
	public void setQuanHuyenId(long quanHuyenId) {
		this.quanHuyenId = quanHuyenId;
	}


	/**
	 * @return the tenXaPhuong
	 */
	public String getTenXaPhuong() {
		return tenXaPhuong;
	}

	/**
	 * @param tenXaPhuong
	 *            the tenXaPhuong to set
	 */
	public void setTenXaPhuong(String tenXaPhuong) {
		this.tenXaPhuong = tenXaPhuong;
	}

}
