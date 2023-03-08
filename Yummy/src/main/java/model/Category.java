
package model;

/**
 * @author MyPC
 *
 */
public class Category {
	private long id;
	private String tenLoaiSanPham;

	/**
	 * 
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param tenLoaiSanPham
	 */
	public Category(long id, String tenLoaiSanPham) {
		super();
		this.id = id;
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the tenLoaiSanPham
	 */
	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}

	/**
	 * @param tenLoaiSanPham
	 *            the tenLoaiSanPham to set
	 */
	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

}
