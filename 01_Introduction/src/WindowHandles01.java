import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait function
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Launch the web-site
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); //[parentID, childID, sub-childID]
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split(" ")[1];
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		/*
		//########################	Assignment starts here	###################################
		driver.get("https://the-internet.herokuapp.com/");	
		driver.findElement(By.xpath("//a[normalize-space()='Multiple Windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentID = itr.next();
		String childID = itr.next();
			
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
		*/
		//######################## Assignment Ends here	##################################
		
		

	}

}
