package wordpress;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.ExcelDataConfig;

public class WordpressLogin 
{
	
	@Test(dataProvider="Wordpressdata")
	public void loginToWordpress(String username,String password) throws InterruptedException
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\jars\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@DataProvider(name="Wordpressdata")
	public Object[][] passData()     // 2D OBJECT ARRAY     //String and Int cannot be used for username/pwd so we will be using Object   
	{
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\ajinkya.bh\\workspace\\DataDrivenFramework\\TestData\\Test.xlsx");
		
		int row = config.getrowcount(0);
		
		Object[][] data= new Object[row][2];
		
		for(int i=0;i<row;i++)
		{
			data[i][0]=config.getdata(0, i , 0);
			data[i][1]=config.getdata(0, i , 1);
		}
		
		return data;
		
	}
	
	
	
	

}
