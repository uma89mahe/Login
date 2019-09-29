package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static WebDriver driver;
	public String browser = "chrome";

	public BaseClass() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver.exe");
						
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\u.dayalamurthy\\Documents\\Uma\\Selenium\\chrome\\chromedriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		}
	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void setText(WebElement element, String name) {
		if (name != null) {
			element.click();
			element.clear();
			element.sendKeys(name);
		}
	}

	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}
	
	public String getTxt(WebElement element) {
		return element.getText();
	}

	public String selectFromDropDown(WebElement element, String option) {
		Select obj = new Select(element);
		obj.selectByVisibleText(option);
		return obj.getFirstSelectedOption().getText();
	}
	
	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void pageScroll(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
	
	public void mouseHover(WebElement element) {
		Actions ac= new Actions(driver);
		ac.moveToElement(element).build().perform();
	}
	

	public String getTitlte() {
		return driver.getTitle();
	}	
	
	public void quitDriver() {
		driver.quit();
	}

}
