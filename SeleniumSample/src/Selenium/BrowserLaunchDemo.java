package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserLaunchDemo 
{

	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver","D:\\Prashant\\ChromeDriver\\chromedriver_win32\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("inputUsername")).sendKeys("Prashant Singh");
		driver.findElement(By.name("inputPassword")).sendKeys("prashant singh");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//System.out.println(driver.findElement(By.cssSelector("input[]")).getText());
		
		String str = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(str);
		driver.findElement(By.id("inputUsername")).sendKeys("Prashant Singh");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		// Filling Login Details to setup the password
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Prashant Singh");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("123@rinku");
		// //form/input[3] --> xpath
		
		driver.findElement(By.xpath("//div/button[2]")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		String password = driver.findElement(By.cssSelector("form p")).getText();
		
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Prashant Singh");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("rahulshettyacademy");
		System.out.println("Checkbox Selected");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println("Login Successfull");
		//Thread.sleep(1000);
		//driver.findElement(By.className("logout-btn")).click();
	}

}
