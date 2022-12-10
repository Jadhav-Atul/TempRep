import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddingItemsToCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait function
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Explicit wait function
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		//Array of items needed
		String[] itemsNeeded = {"Cucumber", "Brocolli", "Banana", "Beans"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//Thread.sleep(3000);
		addItemsToCart(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));	//Explicit wait
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));	//Explicit wait
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
	
	public static void addItemsToCart(WebDriver driver, String[] itemsNeeded)
	{

		int j =0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
				
		for(int i=0; i<products.size();i++)
		{
			//we are getting vegetable's name as 'Banana - 1 Kg' but we need only 'Banana'. That is why the split function is used here
			String[] name = products.get(i).getText().split("-"); //As the split returns an array of strings 'name' is declared as an array.
			String formattedName = name[0].trim(); //trim removes the white space after 'Banana '
			
			//Convert array of itemsNeeded into list for easy search
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				//Click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeeded.length)
					break;
			}
			
		}
	}

}
