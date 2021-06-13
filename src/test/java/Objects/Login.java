package Objects;

public class Login {
	private String userName;
	private String passWord;
	private String mesage;
	
	public Login(String userName, String passWord, String mesage) {
		this.userName = userName;
		this.passWord = passWord;
		this.mesage = mesage;
	}

	public Login() {
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

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
	
}
