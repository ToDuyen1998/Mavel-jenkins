package Objects;

public class Receipt {
	private String HoTen;
	private String Email;
	private String SDT;
	private String DiaChi;
	private String mesage;

	public Receipt(String hoTen, String email, String sDT, String diaChi, String mesage) {
		super();
		HoTen = hoTen;
		Email = email;
		SDT = sDT;
		DiaChi = diaChi;
		this.mesage = mesage;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}

}
