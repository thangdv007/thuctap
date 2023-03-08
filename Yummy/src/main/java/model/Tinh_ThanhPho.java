
package model;


public class Tinh_ThanhPho {
	private long ID, quocGiaId;
	private String tenTinhThanhPho;

	/**
	 * @param id
	 * @param code
	 * @param ten
	 * @param tenkhongdau
	 * @param donvi
	 * @param tendaydu
	 */
	public Tinh_ThanhPho(long ID, long quocGiaId, String tenTinhThanhPho) {
		super();
		this.ID = ID;
		this.quocGiaId = quocGiaId;
		this.tenTinhThanhPho = tenTinhThanhPho;
		
	}

	/**
	 * 
	 */
	public Tinh_ThanhPho() {
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
	 * @return the code
	 */
	public long getQuocGiaId() {
		return quocGiaId;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setQuocGiaId(long quocGiaId) {
		this.quocGiaId = quocGiaId;
	}

	/**
	 * @return the ten
	 */
	public String getTenTinhThanhPho() {
		return tenTinhThanhPho;
	}

	/**
	 * @param ten
	 *            the ten to set
	 */
	public void setTenTinhThanhPho(String tenTinhThanhPho) {
		this.tenTinhThanhPho = tenTinhThanhPho;
	}

}
