import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		//Below code was used to learn the static drop down
		/*
		 * //###################	Static drop-=down starts here #################################
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait function
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Open the site
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); 
		
		WebElement staticdropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropDown = new Select(staticdropDown);
		dropDown.selectByIndex(3);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByVisibleText("INR");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByValue("AED");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		*/
		//###################	Static drop-=down ends here #################################
		
		//Below code was used to learn dynamic drop down
		//###################	Dynamic drop-=down starts here #################################
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait function
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Open the site
	    //driver.get("https://www.goindigo.in/");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Static drop downs tutorial
		/* Below code was used for https://www.goindigo.in/ site  
		//Select the number of passenger
		driver.findElement(By.xpath("//input[@name='passenger']")).click();
		Thread.sleep(5000);
		
		String count = driver.findElement(By.xpath("//input[@name='passenger']")).getText();
		//Multiple passengers using loop
		System.out.println("Before loop: "+ count);
		int i=0;
		while(i<4)
		{
			driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[2]/ul/li[1]/div[1]/button[2]")).click();
			Thread.sleep(1000);
			i++;
		}
		driver.findElement(By.cssSelector(".btn.btn-primary.pax-done.btn-pad-y")).click();
		Thread.sleep(5000);
		String count1 = driver.findElement(By.xpath("//input[@name='passenger']")).getText();
		System.out.println("After Loop: "+count1);
		System.out.println("hello");
		*/
		//Dynamic drop down tutorial
		//Below code was used for https://rahulshettyacademy.com/dropdownsPractise site
		/*
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
		
		//Calendar tutorial is merged with dynamic drop down tutorial. same site was used that is rahulshetty site.
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		//Click the redio button for round trip
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) 
		{
			System.out.println("It's enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		*/
		
		//###########################Auto suggestive #########################################
		//Auto suggestive drop down tutorial
		//Below code was used for https://rahulshettyacademy.com/dropdownsPractise site
	/*	driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option : options) 
		{
			if(option.getText().equals("India"))
			{
				option.click();
				break;
			}
		}  
		//##########################Auto suggestive drop-down ends here##########################################
		*/
//		##########################Check-boxes starts here###########################################################
		//This part is used for check-boxes and the site used was https://rahulshettyacademy.com/dropdownsPractise/
		/*
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		//System.out.println("Checkbox selected" + driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
		//System.out.println("Checkbox selected" + driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		System.out.println("The total checkboxes on this site are: " +driver.findElements(By.cssSelector("input[type=checkbox]")).size());
		Assert.assertEquals(6, driver.findElements(By.cssSelector("input[type=checkbox]")).size());
//		############################Check-box exercise ends here..#################################################
		*/
		
		//Clubbing almost all concepts here to book a ticket from BLR to GOA
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();	//Select departure location
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();	//Select destination location
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();	//Select current date as traveling date
		//Select the INR as currency 
		WebElement staticdropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown = new Select(staticdropDown);
		dropDown.selectByVisibleText("INR");
		//Check-box
		driver.findElement(By.cssSelector("input[id*=StudentDiscount]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(3000);
		
		
	}

}
