import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ScopeTutorial {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		//REQ-1:	Limiting the scope of WebDriver to the footer section
		WebElement myDriver01 = driver.findElement(By.id("gf-BIG"));		
		System.out.println(myDriver01.findElements(By.tagName("a")).size());
		//REQ-2:	Limiting the scope of WebDriver to the first column in footer section
		WebElement colmnDriver = myDriver01.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(colmnDriver.findElements(By.tagName("a")).size());
		
		//REQ-2:	Click on each link in the column and check if the pages are opening
		for(int i=1; i<colmnDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			colmnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000);
			
		}
		
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> itr = abc.iterator();
		
		while(itr.hasNext())
		{
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		/*
		//Assignment
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();
		String checkboxName = driver.findElement(By.id("checkBoxOption1")).getAttribute("name").split("x")[1];
		System.out.println(checkboxName);
		
		//dropdown
		WebElement dropdown01 =driver.findElement(By.id("dropdown-class-example"));
		Select opt = new Select(dropdown01);
		opt.selectByVisibleText(checkboxName);
		
		//filed
		driver.findElement(By.id("name")).sendKeys(checkboxName);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText.contains(checkboxName));
		*/
	}

}
