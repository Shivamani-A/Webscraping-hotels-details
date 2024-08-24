package Hotel_Price_Analysis;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebScrap_kayak {

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
		JSONObject obj= new JSONObject();
		PrintWriter pw=new PrintWriter("Kayak_JSONoutput.json");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.kayak.com/hotels");
		//System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("disable-infobars");
		opt.addArguments("--disable-extensions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[placeholder='Enter a city, hotel, airport or landmark']"))));
		//Actions act= new Actions(driver);
		//act.moveToElement(driver.findElement(By.cssSelector("input[placeholder='Enter a city, hotel, airport or landmark']"))).click(driver.findElement(By.cssSelector("input[placeholder='Enter a city, hotel, airport or landmark']"))).sendKeys("Toronto").sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.cssSelector("input[placeholder='Enter a city, hotel, airport or landmark']")).sendKeys("toronto");
		//act.click(driver.findElement(By.cssSelector("input[placeholder='Enter a city, hotel, airport or landmark']"))).sendKeys("toronto").build().perform();
		//act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='JONo-button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='JONo-button']")).isEnabled());
		//check in calendar
		String monthyear = "March 2024";
		String day = "25";
		// This is from date picker table
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("caption[class='w0lb w0lb-month-name w0lb-mod-align-center w0lb-mod-font-responsive-body-large']"))));
		while (true) {
			String monthyearcomp = driver.findElement(By.cssSelector("caption[class='w0lb w0lb-month-name w0lb-mod-align-center w0lb-mod-font-responsive-body-large']")).getText();
			//driver.findElement(By.className("Heading_heading__xct3h Heading_h-s___YnjF.mx-3.pb-3.font-bold")).getText();
			if (monthyearcomp.equalsIgnoreCase(monthyear)) {
				break;
			} else {
				driver.findElement(By.cssSelector("div[aria-label='Next Month']")).click();

			}

		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
		
		//check out calendar
		String monthyear1 = "April 2024";
		String day1 = "19";
		// This is from date picker table

		//driver.findElement(By.xpath("//div[@class='JONo-button'][@aria-label='End date']")).click();
		while (true) {
			String monthyearcomp = driver.findElement(By.cssSelector("caption[class='w0lb w0lb-month-name w0lb-mod-align-center w0lb-mod-font-responsive-body-large']")).getText();
			//driver.findElement(By.className("Heading_heading__xct3h Heading_h-s___YnjF.mx-3.pb-3.font-bold")).getText();
			if (monthyearcomp.equalsIgnoreCase(monthyear1)) {
				break;
			} else {
				driver.findElement(By.cssSelector("div[aria-label='Next Month']")).click();

			}

		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[text()='"+day1+"']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='c3JX7-displayContent']")).isEnabled());
		int adults=4,Child=0,rooms=1;
		Thread.sleep(1000);

		if(adults>2)
		{
			for(int i=2;i<adults;i++)
			{
				driver.findElement(By.xpath("(//button[@class='T_3c-button'])[4]")).click();
			}
		}
		else if(adults<2)
		{
			driver.findElement(By.xpath("(//button[@class='T_3c-button'])[3]")).click();
			if(driver.findElement(By.xpath("(//button[@class='T_3c-button'])[3]")).getAttribute("button").contains("disabled"))
				System.out.println("exceeding less than one occupant in adult");
		}
		if(Child!=0)
		{
			if(Child>0)
			{
				for(int i=0;i<Child;i++)
				{
					driver.findElement(By.xpath("(//button[@class='T_3c-button'])[6]")).click();
				}
			}
			else if(Child<1)
			{

				Assert.assertTrue(driver.findElement(By.xpath("//button[@data-testid='children-amount-minus-button']")).getAttribute("button").contains("disabled"));
				System.out.println("exceeding less than one occupant in child");
			}
		}
		if(rooms>1)
		{
			for(int i=1;i<rooms;i++)
			{
				driver.findElement(By.xpath("(//button[@class='T_3c-button'])[2]")).click();
			}
		}
		else if(rooms<1)
		{

			if(driver.findElement(By.xpath("(//button[@class='T_3c-button'])[1]")).getAttribute("button").contains("disabled"))
				System.out.println("exceeding less than one occupant in adult");
		}
		
		//selecting search based on the inputs entered.
		driver.findElement(By.xpath("//div[@class='a7Uc']")).click();	
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='FLpo-hotel-name']")))).isEnabled();
		
//		 List<WebElement> card=driver.findElements(By.xpath("//div[contains(@class,'-resultInner')]"));
//		 for(WebElement as:card)
//		 {
//			 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='FLpo-hotel-name']")))).isDisplayed();
//			 String name=as.findElement(By.xpath("//div[@class='FLpo-hotel-name']/a")).getText();
//			 String price=as.findElement(By.xpath("//div[@data-target='price']")).getText();
//			 String link = as.findElement(By.xpath("//a[@target='_blank'][@class='FLpo-big-name']")).getAttribute("href");
//			 System.out.println(name);
//			 System.out.println(price);
//			 System.out.println(link);
//		 }
		
		 List<WebElement> hotel_name_ele=driver.findElements(By.xpath("//div[@class='FLpo-hotel-name']/a")); 
		// List<String> hotel_name = new ArrayList<String>();
		  for(WebElement hre:hotel_name_ele) 
		  { 
			  obj.put("Name", hre.getText());
			  pw.write(obj.toJSONString());
			  System.out.println(hre.getText());

		  }
		  
		  List<WebElement> hotel_price_ele =driver.findElements(By.xpath("//div[@data-target='price']"));
		// List<String> hotel_price = new List<String>();
		  for(WebElement i:hotel_price_ele)
		  {
			  obj.put("Price", i.getText());
			  pw.write(obj.toJSONString());
			  System.out.println(i.getText());
			  
		  }
		  
		  List<WebElement> hotel_link_ele = driver.findElements(By.xpath("//a[@target='_blank'][@class='FLpo-big-name']"));
		  
		  for(WebElement a:hotel_link_ele)
		  {
			  obj.put("URL", a.getAttribute("href"));
			  pw.write(obj.toJSONString());
			  System.out.println(a.getAttribute("href"));
			  
		  }
		  pw.write(obj.toJSONString());
		  driver.close();


	}

}
