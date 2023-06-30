package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Prashant\\ChromeDriver\\chromedriver_win32\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String password= Locators2.getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("PrashantSingh@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		System.out.println("Logged in");
		Thread.sleep(1000);
		System.out.println("On Login Page");
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.logout-btn")).click(); // //button[text()='Log Out']
		//driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.xpath("//form/p")).getText();
	String passwordArray[]= passwordText.split("'");
//		String passwordArray2[] = passwordArray[1].split("'");
//		passwordArray2[0]
	String password =passwordArray[1].split("'")[0];
	return password;
	}
}
