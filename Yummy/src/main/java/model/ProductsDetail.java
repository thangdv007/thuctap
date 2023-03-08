
package model;

/**
 * @author MyPC
 *
 */
public class ProductsDetail {
	/**
	 * 
	 */
	public ProductsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param id_sanPham
	 * @param anhChiTiet
	 */
	public ProductsDetail(long id, long id_sanPham, String anhChiTiet) {
		super();
		this.id = id;
		this.id_sanPham = id_sanPham;
		this.anhChiTiet = anhChiTiet;
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
	 * @return the id_sanPham
	 */
	public long getId_sanPham() {
		return id_sanPham;
	}

	/**
	 * @param id_sanPham
	 *            the id_sanPham to set
	 */
	public void setId_sanPham(long id_sanPham) {
		this.id_sanPham = id_sanPham;
	}

	/**
	 * @return the anhChiTiet
	 */
	public String getAnhChiTiet() {
		return anhChiTiet;
	}

	/**
	 * @param anhChiTiet
	 *            the anhChiTiet to set
	 */
	public void setAnhChiTiet(String anhChiTiet) {
		this.anhChiTiet = anhChiTiet;
	}

	private long id;
	private long id_sanPham;
	private String anhChiTiet;

}
