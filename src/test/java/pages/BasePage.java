package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
	WebDriver driver;
	
	@FindBy(css = "a[href*='index.php']")
	WebElement BtnTrangChu;
	
	@FindBy(css = "a[href$='task=user']")
	WebElement BtnLoginOrSignIn;

	@FindBy(css = "a[href$='task=dangxuat']")
	WebElement BtnTaiKhoan;

	@FindBy(linkText = "Quản lý")
	WebElement BtnQuanLy;

	@FindBy(css = "a[href$='task=qltv']")
	WebElement BtnThanhVien;
	
	@FindBy(css = "a[href$='task=qlhd']")
	WebElement BtnHoaDon;
	
	@FindBy(id =  "dangxuat")
    WebElement BtndangXuat;

	@FindBy(linkText =  "Đặt hàng")
    WebElement BtnMuaHang;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void moveToTrangChu() {
        BtnTrangChu.click();
    }
	
	public void moveToLogInAndSignIn() {
        BtnLoginOrSignIn.click();
    }
	
	public void moveToTaiKhoan() {
        BtnTaiKhoan.click();
    }
	
	public void moveToQuanLy() {
        BtnQuanLy.click();
    }
	
	public void moveToThanhVien() {
        BtnThanhVien.click();
    }

	public void moveToHoaDon() {
        BtnHoaDon.click();
    }
	
	public void moveToDangXuat() {
        BtndangXuat.click();
    }
	
	public void moveToMuaHang() {
        BtnMuaHang.click();
    }
}
