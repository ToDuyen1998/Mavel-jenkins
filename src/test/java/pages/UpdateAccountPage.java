package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Objects.Account_SignUp;

public class UpdateAccountPage {
	WebDriver driver;
	public String alertMessage;
	
	@FindBy(id = "hoten")
	WebElement hoten;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "sodienthoai")
	WebElement sdt;
	
	@FindBy(css = "a[href='#collapseExample']")
	WebElement BtnThayDoiMatKhau;

	@FindBy(id = "matkhau")
	WebElement matkhau;
	
	@FindBy(name = "ok")
	WebElement BtnSuaThongTin;


	public UpdateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void UpdateAccount(Account_SignUp taikhoan) {
		hoten.clear();
		email.clear();
		sdt.clear();
		
		hoten.sendKeys(taikhoan.getUserName());
		email.sendKeys(taikhoan.getEmail());
		sdt.sendKeys(taikhoan.getSDT());
		BtnThayDoiMatKhau.click();
		matkhau.clear();
		matkhau.sendKeys(taikhoan.getPassWord());
		BtnSuaThongTin.click();
		
		Alert alert = driver.switchTo().alert();
		alertMessage = alert.getText();
		alert.accept();
		
		hoten.clear();
		email.clear();
		sdt.clear();
	}
	
}
