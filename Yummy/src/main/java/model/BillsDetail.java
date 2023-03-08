
package model;

public class BillsDetail {
	/**
	 * 
	 */
	public BillsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param id_hoaDon
	 * @param id_sanPham
	 * @param soLuong
	 */
	public BillsDetail(long id, long id_hoaDon, long id_sanPham, int soLuong) {
		super();
		this.id = id;
		this.id_hoaDon = id_hoaDon;
		this.id_sanPham = id_sanPham;
		this.soLuong = soLuong;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the id_hoaDon
	 */
	public long getId_hoaDon() {
		return id_hoaDon;
	}
	/**
	 * @param id_hoaDon the id_hoaDon to set
	 */
	public void setId_hoaDon(long id_hoaDon) {
		this.id_hoaDon = id_hoaDon;
	}
	/**
	 * @return the id_sanPham
	 */
	public long getId_sanPham() {
		return id_sanPham;
	}
	/**
	 * @param id_sanPham the id_sanPham to set
	 */
	public void setId_sanPham(long id_sanPham) {
		this.id_sanPham = id_sanPham;
	}
	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}
	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	private long id;
	private long id_hoaDon;
	private long id_sanPham;
	private int soLuong;

}
