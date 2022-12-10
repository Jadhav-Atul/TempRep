import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String name = "Rahul";
		//Invoke browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait function
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String passWord = GetPassword(driver);		
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //Open the site
		driver.findElement(By.id("inputUsername")).sendKeys(name); //Find user name field and enter User Name
		
		driver.findElement(By.name("inputPassword")).sendKeys(passWord); //Find password field and enter password - rahulshettyacademy
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();
	}
	
	public static String GetPassword(WebDriver driver) throws InterruptedException 
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //Open the site
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);	
		driver.findElement(By.cssSelector(" .reset-pwd-btn")).click();
		String newPass = driver.findElement(By.cssSelector("form p")).getText();
		String[] PassArray = newPass.split("'");
		String password = PassArray[1].split("'")[0];
		return password;
		
	}

}
