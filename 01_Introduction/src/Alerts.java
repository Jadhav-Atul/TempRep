import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait function
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String text = "Atul Jadhav";
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println("This is added from User1");
		System.out.println("This is also added from User1");
		System.out.println("This is added from User1");
		//System.out.println("This is also added from User1");
		//System.out.println("Testing ");
		//System.out.println("Testing ");
		//System.out.println("10-12-2022 Testing ");
		//System.out.println("User2 Raj ");
		//System.out.println("User2 Rahul ");
		System.out.print("Hello, this is Raj again");
		System.out.print("Hello, this is User2 again");

	}

}
