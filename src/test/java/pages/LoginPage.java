package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	WebDriver driver;
	public String alertMessage;
	
	@FindBy(name = "tendangnhap")
    List<WebElement> tenDangNhaps;
	
	@FindBy(name = "matkhau")
    List<WebElement> matKhaus;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/form/div[3]/button")
    WebElement BtnDangNhap;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String name, String pass) {
		WebElement tendangnhap = tenDangNhaps.get(1);
		tendangnhap.sendKeys(name);
		
		WebElement matkhau = matKhaus.get(1);
		matkhau.sendKeys(pass);
		
		BtnDangNhap.click();
		
		Alert alert = driver.switchTo().alert();
		alertMessage = alert.getText();
		alert.accept();
    }
	
	public void logout() {
		moveToTaiKhoan();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

    	moveToDangXuat();

    	System.out.println("Đã đăng xuất!");
	}
	
}
