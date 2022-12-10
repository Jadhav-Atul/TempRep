import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		//Invoke browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait function
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //Open the site
		driver.findElement(By.id("inputUsername")).sendKeys("rahul"); //Find user name field and enter User Name
		
		driver.findElement(By.name("inputPassword")).sendKeys("rahul"); //Find password field and enter password - rahulshettyacademy
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Atul");
		driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("atul.j@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type= 'text']:nth-child(3)")).sendKeys("atul.j1@gmail.com");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567891");
		driver.findElement(By.cssSelector(" .reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

	}

}
