
package model;

public class Users {
	private long id;
	private String tenHienThi;
	private String anhChinh;
	private String tenTaiKhoan;
	private String matKhau;
	private String phanQuyen;
	private String email;

	/**
	 * @param id
	 * @param tenHienThi
	 * @param anhChinh
	 * @param tenTaiKhoan
	 * @param matKhau
	 * @param phanQuyen
	 * @param email
	 */
	public Users(long id, String tenHienThi, String anhChinh, String tenTaiKhoan, String matKhau, String phanQuyen,
			String email) {
		super();
		this.id = id;
		this.tenHienThi = tenHienThi;
		this.anhChinh = anhChinh;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
		this.email = email;
	}

	/**
	 * 
	 */
	public Users() {
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
	 * @return the tenHienThi
	 */
	public String getTenHienThi() {
		return tenHienThi;
	}

	/**
	 * @param tenHienThi
	 *            the tenHienThi to set
	 */
	public void setTenHienThi(String tenHienThi) {
		this.tenHienThi = tenHienThi;
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
	 * @return the tenTaiKhoan
	 */
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	/**
	 * @param tenTaiKhoan
	 *            the tenTaiKhoan to set
	 */
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	/**
	 * @return the matKhau
	 */
	public String getMatKhau() {
		return matKhau;
	}

	/**
	 * @param matKhau
	 *            the matKhau to set
	 */
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	/**
	 * @return the phanQuyen
	 */
	public String getPhanQuyen() {
		return phanQuyen;
	}

	/**
	 * @param phanQuyen
	 *            the phanQuyen to set
	 */
	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
