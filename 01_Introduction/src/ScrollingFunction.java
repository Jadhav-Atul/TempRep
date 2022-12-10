import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingFunction {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//To scroll JavascriptExecutor is required and the driver needs to be casted in JavascriptExecutor type.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//elements in a table
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int total=0;
		for(int i=0; i<values.size();i++)
		{
			System.out.println(Integer.parseInt(values.get(i).getText()));
			total = total + Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println("Total = " +total);
		
		int Tval = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(total, Tval);
		
		//Assignment
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Scrolling down the webpage just for visibility
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(1000);
		System.out.println("Number of Columns: " + driver.findElements(By.cssSelector("table[name='courses'] th")).size()); //Number of columns
		System.out.println("Number of Rows: " + driver.findElements(By.cssSelector("table[name='courses'] tr")).size());	//Number of Rows
		//Printing the second row
		System.out.println(driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(3)")).getText()); 			//Printing the second line
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-650)");
		Thread.sleep(1000);
		//Auto Suggestive dropdown
		driver.findElement(By.id("autocomplete")).sendKeys("Aus");
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item"));
		
		for(WebElement option : options)
		{
			if(option.getText().equals("Australia"))
			{
				option.click();
				break;
			}
		}
		*/
		
		
	}

}
