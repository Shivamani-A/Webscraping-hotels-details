package Hotel_Price_Analysis;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

public class WebScrap_hotwire {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hotwire.com/");
		//System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("disable-infobars");
		opt.addArguments("--disable-extensions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);


		//entering the place
		driver.findElement(By.xpath("//input[@data-bdd='farefinder-hotel-destination-input']")).sendKeys("Toronto");
		driver.findElement(By.cssSelector(".form")).submit();
//		Actions act= new Actions(driver);
//		act.click(driver.findElement(By.xpath("//input[@data-bdd='farefinder-hotel-destination-input']"))).sendKeys("toronto").build().perform();
//		act.sendKeys(Keys.TAB).build().perform();
		//jact.keyUp("enter").build().perform();
		//check in
		//driver.findElement(By.id("input1-farefinder-hotel-date")).click();
		String monthyear = "March 2024";
		String day = "20";
		// This is from date picker table

		while (true) {
			String monthyearcomp = driver.findElement(By.xpath("//h4[@class='align-center']/span")).getText();
			//driver.findElement(By.className("Heading_heading__xct3h Heading_h-s___YnjF.mx-3.pb-3.font-bold")).getText();
			if (monthyearcomp.equalsIgnoreCase(monthyear)) {
				break;
			} else {
				driver.findElement(By.className("cal-controls__button text-center cal-controls__button--middle cal-controls__button--next")).click();

			}

		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
		
		
		//check out
		
		//driver.findElement(By.id("input1-farefinder-hotel-date")).click();
		String monthyear1 = "April 2024";
		String day1 = "10";
		// This is from date picker table

		while (true) {
			String monthyearcomp = driver.findElement(By.xpath("//h4[@class='align-center']/span")).getText();
			//driver.findElement(By.className("Heading_heading__xct3h Heading_h-s___YnjF.mx-3.pb-3.font-bold")).getText();
			if (monthyearcomp.equalsIgnoreCase(monthyear1)) {
				break;
			} else {
				driver.findElement(By.xpath("//div[@class='cal-controls__button text-center cal-controls__button--middle cal-controls__button--next']")).click();

			}

		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[text()='"+day1+"']")).click();
		
		
		//occupants selector
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='picker__overlay picker__overlay--selectable'])[3]")).click();
		
		int adults=4,Child=0,rooms=1;
		Thread.sleep(1000);

		if(adults>2)
		{
			for(int i=2;i<adults;i++)
			{
				driver.findElement(By.xpath("//button[@data-bdd='farefinder-occupant-selector-hotel-adults-button-increase']")).click();
			}
		}
		else if(adults<2)
		{
			driver.findElement(By.xpath("//button[@data-bdd='farefinder-occupant-selector-hotel-adults-button-decrease']")).click();
			if(driver.findElement(By.xpath("//button[@data-bdd='farefinder-occupant-selector-hotel-adults-button-decrease']")).getAttribute("button").contains("disabled"))
				System.out.println("exceeding less than one occupant in adult");
		}
		if(Child!=0)
		{
			if(Child>0)
			{
				for(int i=0;i<Child;i++)
				{
					driver.findElement(By.xpath("//button[@data-bdd='farefinder-occupant-selector-hotel-children-button-increase']")).click();
				}
			}
			else if(Child<1)
			{

				Assert.assertTrue(driver.findElement(By.xpath("//button[@data-bdd='farefinder-occupant-selector-hotel-children-button-decrease']")).getAttribute("button").contains("disabled"));
				System.out.println("exceeding less than one occupant in child");
			}
		}
		if(rooms>1)
		{
			for(int i=1;i<rooms;i++)
			{
				driver.findElement(By.xpath("//button[@data-bdd='farefinder-occupant-selector-hotel-rooms-button-increase']")).click();
			}
		}
		else if(rooms<1)
		{

			if(driver.findElement(By.xpath("//button[@data-bdd='farefinder-occupant-selector-hotel-rooms-button-decrease']")).getAttribute("button").contains("disabled"))
				System.out.println("exceeding less than one occupant in adult");
		}
		
		driver.findElement(By.xpath("//button[@data-bdd='farefinder-hotel-donebutton']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();


	}

}
