package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Objects.Acoount_SignUp;

public class SignUpPage {
	WebDriver driver;
	public String alertMessage;
	
	@FindBy(name = "tendangnhap")
	WebElement tenDangKi;

	@FindBy(name = "matkhau")
	WebElement matKhau;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "sodienthoai")
	WebElement sdt;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/form/button")
	WebElement BtnDangKi;

	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sign_up(Acoount_SignUp taiKhoan) {
		tenDangKi.sendKeys(taiKhoan.getUserName());
		matKhau.sendKeys(taiKhoan.getPassWord());
		email.sendKeys(taiKhoan.getEmail());
		sdt.sendKeys(taiKhoan.getSDT());
		BtnDangKi.click();
		
		Alert alert = driver.switchTo().alert();
		alertMessage = alert.getText();
		alert.accept();
		
		if(alertMessage.equals("Không đúng định dạng email!")) {
			tenDangKi.clear();
			matKhau.clear();
			email.clear();
			sdt.clear();
		}
	}
}
