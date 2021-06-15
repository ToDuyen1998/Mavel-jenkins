package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteReceiptPage {
	WebDriver driver;

	@FindBy(xpath = "//table/tbody/tr/td[1]")
	public List<WebElement> rows;
	public int count_rows;

	public DeleteReceiptPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void XoaHoaDon(int row) {
//		tr:nth-child(3) > td:nth-child(8) > a.btn.btn-danger
//		tr:nth-child(4) > td:nth-child(8) > a
		String before_CSS = "tr:nth-child(";
		String after_CSS = ") > td:nth-child(8) > a.btn.btn-danger";
		
		String FinalXPath = before_CSS + row + after_CSS;

		count_rows = rows.size();
		System.out.println("Row trước khi xóa : " + count_rows);
		
		driver.findElement(By.cssSelector(FinalXPath)).click();
		driver.switchTo().alert().accept();
	}

	public void checkXoa() {
		int row_final = rows.size();
		System.out.println("Row final sau khi xóa : " + row_final);
		
		if ((count_rows - 1) == row_final) {
			System.out.println("Xóa Thành công!");
		}
	}
}
