import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		//Invoking browser
		//Chrome driver path 
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//webdriver object
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit(); */

		//For Edge browser
		//Invoking browser
		//Chrome driver path
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Atul\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		//webdriver object
		WebDriver msdriver = new EdgeDriver();
		msdriver.get("https://www.youtube.com/");
		System.out.println(msdriver.getTitle());
		System.out.println(msdriver.getCurrentUrl());
		msdriver.quit();


	}

}
