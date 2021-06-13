package tests;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.Receipt;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.ReceiptPage;
import utilities.ReadExcel;

public class autoTestMuaHang extends BaseTest{
	LoginPage loginPg;
	ReceiptPage receiptPg;
	
	String mang[];
	ReadExcel testcase = new ReadExcel();
	
	@Test
	public void testMuaHang() {
		loginPg = new LoginPage(driver);
		receiptPg = new ReceiptPage(driver);
		
		loginPg.login("duyen", "123");
		
		loginPg.moveToMuaHang();
		
		String fileName = "data.xlsx";
		String sheetName = "MuaHang";
		
		mang = testcase.readExcel(fileName, sheetName);
		
		for(int i=0;i<mang.length;i++) {
			String hoTen="", email="", sdt="", diachi="", message="";
			String item[] = mang[i].split("#");
			
			if(item[0].trim().equals("null"))
				hoTen = "";
			else
				hoTen = item[0].trim();
			
			if(item[1].trim().equals("null"))
				email = "";
			else
				email = item[1].trim();
			
			if(item[2].trim().equals("null"))
				sdt = "";
			else
				sdt = item[2].trim();
			
			if(item[3].trim().equals("null"))
				diachi = "";
			else
				diachi = item[3].trim();
			
			if(item[4].trim().equals("null"))
				message = "";
			else
				message = item[4].trim();
			
			Receipt receipt = new Receipt(hoTen, email, sdt, diachi, message);
			System.out.println(receipt.getHoTen());
			System.out.println(receipt.getEmail());
			System.out.println(receipt.getSDT());
			System.out.println(receipt.getDiaChi());
			System.out.println(receipt.getMesage());
			
			MuaHang(receipt,i);
			System.out.println("Testcase "+(i+1)+" đã chạy xong");
			System.out.println("-------------------");		
		}
	}
	
	private void MuaHang(Receipt taiKhoanMua, int i) {
		receiptPg.MuaHang(taiKhoanMua);
		
		if(taiKhoanMua.getMesage().equals(receiptPg.alertMessage)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Failed");
		}
		
		if(receiptPg.alertMessage.equals("Đặt hàng thành công!")) {
			loginPg.moveToTrangChu();
			
			
			
			loginPg.moveToMuaHang();
			
		}	
	}

}
