import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FiltersUsingJavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Table sorting using JAVA Streams
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				//Open the site
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
				driver.findElement(By.id("search-field")).sendKeys("Rice");
				List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
				List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
				Assert.assertEquals(veggies.size(), filteredList.size());
				

	}

}
