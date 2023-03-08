
package model;

/**
 * @author MyPC
 *
 */
public class Quan_Huyen {
	private long ID, tinhThanhPhoId;
	private String tenQuanHuyen;

	/**
	 * @param id
	 * @param code
	 * @param id_tinhthanhpho
	 * @param ten
	 * @param tenkhongdau
	 * @param tendaydu
	 * @param donvi
	 * @param tenthuong
	 * @param tenhanhchinh
	 */
	public Quan_Huyen(long ID, long tinhThanhPhoId, String tenQuanHuyen) {
		super();
		this.ID = ID;
		this.tinhThanhPhoId = tinhThanhPhoId;
		this.tenQuanHuyen = tenQuanHuyen;
		
	}

	/**
	 * 
	 */
	public Quan_Huyen() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the id_tinhthanhpho
	 */
	public long getTinhThanhPhoId() {
		return tinhThanhPhoId;
	}

	/**
	 * @param id_tinhthanhpho
	 *            the id_tinhthanhpho to set
	 */
	public void setTinhThanhPhoId(long tinhThanhPhoId) {
		this.tinhThanhPhoId = tinhThanhPhoId;
	}

	/**
	 * @return the ten
	 */
	public String getTenQuanHuyen() {
		return tenQuanHuyen;
	}

	/**
	 * @param ten
	 *            the ten to set
	 */
	public void setTenQuanHuyen(String tenQuanHuyen) {
		this.tenQuanHuyen = tenQuanHuyen;
	}

}
