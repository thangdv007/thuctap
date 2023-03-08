
package model;


public class Products {
	private long id;
	private long id_loaiSanPham;
	private String tenSanPham;
	private String moTa;
	private String anhChinh;
	private double giaGoc;
	private int khuyenMai;
	private int luotThich;
	private int tinhTrang;

	/**
	 * @param id
	 * @param id_loaiSanPham
	 * @param tenSanPham
	 * @param moTa
	 * @param anhChinh
	 * @param giaGoc
	 * @param khuyenMai
	 * @param luotThich
	 * @param tinhTrang
	 */
	public Products(long id, long id_loaiSanPham, String tenSanPham, String moTa, String anhChinh, double giaGoc,
			int khuyenMai, int luotThich, int tinhTrang) {
		super();
		this.id = id;
		this.id_loaiSanPham = id_loaiSanPham;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.anhChinh = anhChinh;
		this.giaGoc = giaGoc;
		this.khuyenMai = khuyenMai;
		this.luotThich = luotThich;
		this.tinhTrang = tinhTrang;
	}

	/**
	 * 
	 */
	public Products() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the id_loaiSanPham
	 */
	public long getId_loaiSanPham() {
		return id_loaiSanPham;
	}

	/**
	 * @param id_loaiSanPham
	 *            the id_loaiSanPham to set
	 */
	public void setId_loaiSanPham(long id_loaiSanPham) {
		this.id_loaiSanPham = id_loaiSanPham;
	}

	/**
	 * @return the tenSanPham
	 */
	public String getTenSanPham() {
		return tenSanPham;
	}

	/**
	 * @param tenSanPham
	 *            the tenSanPham to set
	 */
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	/**
	 * @return the moTa
	 */
	public String getMoTa() {
		return moTa;
	}

	/**
	 * @param moTa
	 *            the moTa to set
	 */
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	/**
	 * @return the anhChinh
	 */
	public String getAnhChinh() {
		return anhChinh;
	}

	/**
	 * @param anhChinh
	 *            the anhChinh to set
	 */
	public void setAnhChinh(String anhChinh) {
		this.anhChinh = anhChinh;
	}

	/**
	 * @return the giaGoc
	 */
	public double getGiaGoc() {
		return giaGoc;
	}

	/**
	 * @param giaGoc
	 *            the giaGoc to set
	 */
	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	/**
	 * @return the khuyenMai
	 */
	public int getKhuyenMai() {
		return khuyenMai;
	}

	/**
	 * @param khuyenMai
	 *            the khuyenMai to set
	 */
	public void setKhuyenMai(int khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	/**
	 * @return the luotThich
	 */
	public int getLuotThich() {
		return luotThich;
	}

	/**
	 * @param luotThich
	 *            the luotThich to set
	 */
	public void setLuotThich(int luotThich) {
		this.luotThich = luotThich;
	}

	/**
	 * @return the tinhTrang
	 */
	public int getTinhTrang() {
		return tinhTrang;
	}

	/**
	 * @param tinhTrang
	 *            the tinhTrang to set
	 */
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}
