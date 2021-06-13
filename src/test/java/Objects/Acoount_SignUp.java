package Objects;

public class Acoount_SignUp {
	private String userName;
	private String passWord;
	private String email;
	private String SDT;
	private String mesage;

	public Acoount_SignUp(String userName, String passWord, String email, String sDT, String mesage) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.SDT = sDT;
		this.mesage = mesage;
	}

	public Acoount_SignUp() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
}
