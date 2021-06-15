package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Objects.Account_SignUp;
import pages.DeleteAccountPage;
import pages.LoginPage;
import pages.SignUpPage;
import utilities.ReadExcel;

public class autoTestDangKi extends BaseTest {
	String mang[];
	
	ReadExcel testcase = new ReadExcel();
	SignUpPage signUpPg;
	LoginPage loginPg;
	DeleteAccountPage deleteAccountPg;

	@Test(priority = 1)
	public void testDangKi() {
		deleteAccountPg = new DeleteAccountPage(driver);
		loginPg = new LoginPage(driver);

		signUpPg = new SignUpPage(driver);
		String fileName = "data.xlsx";
		String sheetName = "DangKi";

		mang = testcase.readExcel(fileName, sheetName);

		for (int i = 0; i < mang.length; i++) {
			String userName = "", passWord = "", email = "", SDT = "", message = "";
			String item[] = mang[i].split("#");

			if (item[0].trim().equals("null"))
				userName = "";
			else
				userName = item[0].trim();

			if (item[1].trim().equals("null"))
				passWord = "";
			else
				passWord = item[1].trim();

			if (item[2].trim().equals("null"))
				email = "";
			else
				email = item[2].trim();

			if (item[3].trim().equals("null"))
				SDT = "";
			else
				SDT = item[3].trim();

			if (item[4].trim().equals("null"))
				message = "";
			else
				message = item[4].trim();

			Account_SignUp taiKhoan = new Account_SignUp(userName, passWord, email, SDT, message);
			System.out.println(taiKhoan.getUserName());
			System.out.println(taiKhoan.getPassWord());
			System.out.println(taiKhoan.getEmail());
			System.out.println(taiKhoan.getSDT());
			System.out.println(taiKhoan.getMesage());
			DangKi(taiKhoan, i);
			System.out.println("Testcase " + (i + 1) + " đã chạy xong");
			System.out.println("-------------");
		}
	}

	private void DangKi(Account_SignUp taiKhoan, int i) {
		signUpPg.sign_up(taiKhoan);

		if (taiKhoan.getMesage().equals(signUpPg.alertMessage)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Failed");
		}

		if (signUpPg.alertMessage.equals("Đăng kí thành công!")) {
			loginPg.moveToLogInAndSignIn();

			loginPg.login("admin", "123456");
			loginPg.moveToTaiKhoan();
			loginPg.moveToQuanLy();
			loginPg.moveToThanhVien();
			
			//Assert.assertTrue(deleteAccountPg.checkHienThi(taiKhoan.getUserName()));

			deleteAccountPg.count_rows = deleteAccountPg.rows.size();

			deleteAccountPg.XoaTaiKhoan(deleteAccountPg.count_rows);
			
			deleteAccountPg.checkXoa();
			
			loginPg.logout();
			
			loginPg.moveToLogInAndSignIn();
			
		}
	}
}
