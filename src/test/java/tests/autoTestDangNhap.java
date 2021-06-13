package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Objects.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.ReadExcel;
public class autoTestDangNhap extends BaseTest{
	String mang[];
	ReadExcel testcase = new ReadExcel();
	LoginPage loginPg;

	@Test
	public void testDangNhap(){
		loginPg = new LoginPage(driver);
		String fileName = "data.xlsx";
		String sheetName = "DangNhap";
		mang = testcase.readExcel(fileName, sheetName);
		
		for(int i=0;i<mang.length;i++) {
	        String userName="",passWord="",message="";            
            String item[] = mang[i].split("#");
            
            try {
                if(item[0].trim().equals("null"))
                	userName = "";	
                else
                    userName = item[0].trim();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            
            try {
                if(item[1].trim().equals("null"))
                    passWord = "";
                else
                    passWord = item[1].trim();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            
            try {
                if(item[2].trim().equals("null"))
                    message = "";
                else
                    message = item[2].trim();
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            
         // tiến hành kiểm thử
            Login lg = new Login(userName,passWord,message);

            DangNhap(lg,i);
            System.out.println("Test case "+(i+1)+" đã chạy xong");
            System.out.println("------------------"); 
		}
	}
	
	private void DangNhap(Login lg, int i) {	
		loginPg.login(lg.getUserName(), lg.getPassWord());

	    if (lg.getMesage().equals(loginPg.alertMessage))
        {
	    	System.out.println("Test Pass");
        } 
        else 
        {
            System.out.println("Test Failed");
        }
	    
	    if(loginPg.alertMessage.equals("Đăng nhập thành công!")) {
	    	loginPg.logout();  
	    	loginPg.moveToLogInAndSignIn();
	    }
	}
}