package Hotel_Price_Analysis;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WebScrap_bookingdotcom {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
		JSONObject obj= new JSONObject();
		PrintWriter pw=new PrintWriter("Booking_JSONoutput.json");
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("disable-infobars");
		opt.addArguments("--disable-extensions");
		//opt.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.booking.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Thread.sleep(2000);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='abcc616ec7 cc1b961f14 c180176d40 f11eccb5e8 ff74db973c']")))).click();
		//entering the place
		driver.findElement(By.xpath("//input[@name='ss']")).sendKeys("Toronto"); 
		driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']")).click();
		
		String monthyear = "March 2024";
		String day = "20";
		// This is from date picker table

		while (true) {
			String monthyearcomp = driver.findElement(By.xpath("//div[@class='d358556c65']/h3")).getText();
			if (monthyearcomp.equalsIgnoreCase(monthyear)) {
				break;
			} else {
				driver.findElement(By.xpath("//button[@type='button']/span[@class='eedba9e88a']")).click();

			}

		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='"+day+"']")).click();
		
		String monthyearto = "April 2024";
		String dayto = "22";
		// This is from date picker table

		while (true) {
			String monthyearcomp = driver.findElement(By.xpath("//div[@class='d358556c65']/h3")).getText();
			if (monthyearcomp.equalsIgnoreCase(monthyearto)) {
				break;
			} else {
				driver.findElement(By.xpath("//button[@type='button']/span[@class='eedba9e88a']")).click();

			}

		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='"+dayto+"']")).click();
		
		driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).isEnabled());
		
		int adults=1,Child=3,rooms=1;
		Thread.sleep(1000);

		if(adults>2)
		{
			for(int i=2;i<adults;i++)
			{
				driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 deab83296e bb803d8689 f4d78af12a'])[1]")).click();
			}
		}
		else if(adults<2)
		{
			if(adults==1) {
				driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 deab83296e bb803d8689 e91c91fa93'])[1]")).click();
			}
			else
			{
				System.out.println("exceeding less than one occupant in adult");
			}
			
//			if(driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 deab83296e bb803d8689 e91c91fa93'])[1]")).getTagName("button").contains("disabled"))
				
		}
		if(Child!=0)
		{
			if(Child>0)
			{
				for(int i=0;i<Child;i++)
				{
					driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 deab83296e bb803d8689 f4d78af12a'])[2]")).click();
//					Select childCount=new Select(driver.findElement(By.xpath("//select[@class='ebf4591c8e']")));
//					childCount.selectByValue("10");
				}
				List<WebElement> tccount=driver.findElements(By.xpath("//select[@class='ebf4591c8e']"));
				for(int k=0;k<tccount.size();k++)
				{
					//driver.findElements(By.xpath("//select[@class='ebf4591c8e']")).get(k).click();
					Select childCount=new Select(driver.findElements(By.xpath("//select[@class='ebf4591c8e']")).get(k));
					childCount.selectByValue("10");
					
				}
			}
			else if(Child<1)
			{

				Assert.assertTrue(driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 deab83296e bb803d8689 e91c91fa93'])[2]")).getAttribute("button").contains("disabled"));
				System.out.println("exceeding less than one occupant in child");
			}
		}
		if(rooms>1)
		{
			for(int i=1;i<rooms;i++)
			{
				driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 deab83296e bb803d8689 f4d78af12a'])[3]")).click();
			}
		}
		else if(rooms<1)
		{

			if(driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 deab83296e bb803d8689 e91c91fa93'])[3j]")).getAttribute("button").contains("disabled"))
				System.out.println("exceeding less than one occupant in adult");
		}
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("div[data-testid='property-card']"))));
		List<WebElement> property_card=driver.findElements(By.cssSelector("div[data-testid='property-card']"));
		//List<WebElement> hotel_name = driver.findElements(By.cssSelector("div[data-testid='title']"));
		//List<WebElement> hotel_price = driver.findElements(By.cssSelector("[data-testid='price-and-discounted-price']"));
		//List<WebElement> hotel_link=driver.findElement(By.cssSelector("a[data-testid=\"title-link\"]")).getAttribute("href");
		//obj.put("Website Crawled:", "https://www.booking.com/");
		for(WebElement we:property_card)
		{
			try {
				//String name=we.findElement(By.xpath("//div[@data-testid='title']")).getText();
				String name= we.findElement(By.cssSelector("div[data-testid='title']")).getText();
				//String price = we.findElement(By.xpath("//span[@data-testid='price-and-discounted-price']")).getText();
				String price=we.findElement(By.cssSelector("[data-testid='price-and-discounted-price']")).getText();
				//Thread.sleep(3000);
				//String link= we.findElement(By.xpath("//a[@data-testid='title-link']")).getAttribute("href").toString();
				String link = we.findElement(By.cssSelector("a[data-testid='title-link']")).getAttribute("href");
				obj.put("Name", name);
				obj.put("Price", price);
				obj.put("URL", link);
				pw.write(obj.toJSONString());
				System.out.println(name);
				System.out.println(price);
				System.out.println(link);
			}
//			catch (StaleElementReferenceException e) {
//				// TODO Auto-generated catch block
//				String link = we.findElement(By.cssSelector("a[data-testid='title-link']")).getAttribute("href");
//				String price=we.findElement(By.cssSelector("[data-testid='price-and-discounted-price']")).getText();
//				String name=we.findElement(By.xpath("//div[@data-testid='title']")).getText();
//				System.out.println(name);
//				System.out.println(price);
//				System.out.println(link);
//				//e.printStackTrace();
//			}
			catch (WebDriverException wee) {
				wee.printStackTrace();
				// TODO: handle exception
			}
			
//			if(driver.findElement(By.xpath("//button[@class='a83ed08757 c21c56c305 bf0537ecb5 f671049264 deab83296e af7297d90d']/span[@class='e4adce92df']")).isDisplayed())
//			{
//				driver.findElement(By.xpath("//button[@class='a83ed08757 c21c56c305 bf0537ecb5 f671049264 deab83296e af7297d90d']/span[@class='e4adce92df']")).click();
//			}
//			else
//				
//			{
//				continue;
//			}
			
		}
		pw.flush();
		pw.close();
//		for(WebElement i: hotel_name)
//		{
//			System.out.println(i.getText());
//		}
//		for(WebElement j:hotel_price)
//		{
//			System.out.println(j.getText());
//		}
		
		
		
		
		driver.quit();
		


	}

}
