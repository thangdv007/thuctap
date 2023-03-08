
package model;

public class Bills {
	/**
	 * 
	 */
	public Bills() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param hoTen
	 * @param soNha
	 * @param diaChi
	 * @param soDienThoai
	 * @param email
	 * @param ghiChu
	 * @param ngayDat
	 * @param trangThai
	 */
	public Bills(long id, String hoTen, String soNha, String diaChi, String soDienThoai, String email, String ghiChu,
			String ngayDat, int trangThai) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.soNha = soNha;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.ghiChu = ghiChu;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
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
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}

	/**
	 * @param hoTen
	 *            the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	/**
	 * @return the soNha
	 */
	public String getSoNha() {
		return soNha;
	}

	/**
	 * @param soNha
	 *            the soNha to set
	 */
	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi
	 *            the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	/**
	 * @return the soDienThoai
	 */
	public String getSoDienThoai() {
		return soDienThoai;
	}

	/**
	 * @param soDienThoai
	 *            the soDienThoai to set
	 */
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
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

	/**
	 * @return the ghiChu
	 */
	public String getGhiChu() {
		return ghiChu;
	}

	/**
	 * @param ghiChu
	 *            the ghiChu to set
	 */
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	/**
	 * @return the ngayDat
	 */
	public String getNgayDat() {
		return ngayDat;
	}

	/**
	 * @param ngayDat
	 *            the ngayDat to set
	 */
	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}

	/**
	 * @return the trangThai
	 */
	public int getTrangThai() {
		return trangThai;
	}

	/**
	 * @param trangThai
	 *            the trangThai to set
	 */
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	private long id;
	private String hoTen;
	private String soNha;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String ghiChu;
	private String ngayDat;
	private int trangThai;

}
