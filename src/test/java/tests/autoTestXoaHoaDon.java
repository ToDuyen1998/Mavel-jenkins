package tests;

import org.testng.annotations.Test;

import pages.DeleteReceiptPage;
import pages.LoginPage;

public class autoTestXoaHoaDon extends BaseTest {
	LoginPage loginPg;
	DeleteReceiptPage deleteReceiptPg;

	@Test
	public void testXoaHoaDon() {
		loginPg = new LoginPage(driver);
		deleteReceiptPg = new DeleteReceiptPage(driver);

		loginPg.login("admin", "123456");

		loginPg.moveToTaiKhoan();
		loginPg.moveToQuanLy();
		loginPg.moveToHoaDon();

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		deleteReceiptPg.XoaHoaDon(4);
		deleteReceiptPg.checkXoa();
	}
}
