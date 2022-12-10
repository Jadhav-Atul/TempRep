import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;


public class ScreenshotsTutorial {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Atul\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Atul\\Documents\\MyTempDoc\\TestAutomationJava\\abc.jpeg"));
		/*
		//Broken Links for a working link
		String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		
		HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
		
		//Broken Links for a working link
		String url1 = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection conn1 =(HttpURLConnection)new URL(url1).openConnection();
		conn1.setRequestMethod("HEAD");
		conn1.connect();
		int respCode1 = conn1.getResponseCode();
		System.out.println(respCode1);
		*/
		//Broken links on a webpage
		//css -li[class='gf-li'] a
		SoftAssert a = new SoftAssert();
		List<WebElement> links =driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link : links) 
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with text:= "+link.getText() + " is broken With code:= "+respCode);
			
		}
		
		a.assertAll();
		
		//Streams basics
		Stream.of("MSD","Rohit","Virat","Pandya","Rahul").filter(s->s.endsWith("t")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		

	}

}
