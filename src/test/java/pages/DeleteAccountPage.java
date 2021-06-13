package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {
	WebDriver driver;

	@FindBy(xpath = "//table/tbody/tr/td[1]")
	public List<WebElement> rows;
	public int count_rows;

	public DeleteAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void XoaTaiKhoan(int row) {
		String before_XPath = "//table/tbody/tr[";
		String after_XPath = "]/td[7]/a[2]";
		String FinalXPath = before_XPath + row + after_XPath;

		driver.findElement(By.xpath(FinalXPath)).click();
		driver.switchTo().alert().accept();
	}

	public void checkXoa() {
		List row_final = driver.findElements(By.xpath("/html/body/div/div/div[2]/div/div/table/tbody/tr/td[1]"));
		System.out.println("Row final sau khi xóa : " + row_final.size());
		
		if ((count_rows - 1) == row_final.size()) {
			System.out.println("Xóa Thành công!");
		}
	}
	
	public boolean checkHienThi(String keyword) {
		for(int i = 0 ; i < rows.size() ; i++) {
			String tenDangKi = rows.get(i).getText().toLowerCase();
			//System.out.println(tenDangKi);
			if((tenDangKi.contains(keyword.toLowerCase()))){
				return true;
			}
		}
		return false;
	}
}
