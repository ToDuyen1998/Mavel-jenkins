package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Objects.Receipt;

public class ReceiptPage {
	WebDriver driver;
	public String alertMessage;
	
	@FindBy(id = "hoten")
	WebElement hoten;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "sodienthoai")
	WebElement sdt;
	
	@FindBy(id = "diachi")
	WebElement diachi;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div[1]/form/button")
	WebElement BtnMuaHang;

	public ReceiptPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void MuaHang(Receipt taiKhoanMua) {
		hoten.sendKeys(taiKhoanMua.getHoTen());

		email.clear();
		email.sendKeys(taiKhoanMua.getEmail());

		sdt.clear();
		sdt.sendKeys(taiKhoanMua.getSDT());

		diachi.sendKeys(taiKhoanMua.getDiaChi());

		BtnMuaHang.click();
		
		Alert alert = driver.switchTo().alert();
		alertMessage = alert.getText();
		alert.accept();
		
		if(alertMessage.equals("Không đúng định dạng email!")) {
			hoten.clear();
			email.clear();
			sdt.clear();
			diachi.clear();
		}
	}
}
