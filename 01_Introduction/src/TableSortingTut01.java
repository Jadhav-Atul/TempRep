import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSortingTut01 {

	public static void main(String[] args) {
		// Table sorting using JAVA Streams
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Open the site
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click on Column
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		//Capture all elements into an list
		List<WebElement> ls = driver.findElements(By.xpath("//tr//td[1]"));
		//Capture text of all web-elements in new List (Original List)
		List<String> originalList = ls.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Sort the original List (Sorted List)
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList()); 
		//Compare the sorted list and the original List
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		//get the value of "Beans"
		do 
		{ 	List<WebElement> ls1 = driver.findElements(By.xpath("//tr//td[1]"));
			price =ls1.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceOfVeggie(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);

	}

	private static String getPriceOfVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String Pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return Pricevalue;
	}

}
