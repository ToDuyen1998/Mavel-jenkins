package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.DeleteAccountPage;
import pages.LoginPage;

public class autoTestXoaTaiKhoan extends BaseTest{
	LoginPage loginPg;
	DeleteAccountPage deleteAccountPg;
	@Test
	public void testXoaTaiKhoan() {
		loginPg = new LoginPage(driver);
		deleteAccountPg = new DeleteAccountPage(driver);
		
		loginPg.login("admin", "123456");
		
		loginPg.moveToTaiKhoan();
		loginPg.moveToQuanLy();
		loginPg.moveToThanhVien();
		
		deleteAccountPg.XoaTaiKhoan(4);
		deleteAccountPg.checkXoa();
	}   
}
