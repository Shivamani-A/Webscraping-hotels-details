package Hotel_Price_Analysis;

import java.time.Duration;
import java.util.List;

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

public class webScrap_Expedia {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.expedia.com");
		driver.manage().window().maximize();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("disable-infobars");
		opt.addArguments("--disable-extensions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[data-stid='destination_form_field-menu-trigger']"))));
		//driver.findElement(By.xpath("//button[@data-stid='destination_form_field-menu-trigger']")).sendKeys("Toronto");
		//Thread.sleep(1000);
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector("button[data-stid='destination_form_field-menu-trigger']"))).click(driver.findElement(By.cssSelector("button[data-stid='destination_form_field-menu-trigger']"))).sendKeys("toronto").sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[data-stid='uitk-date-selector-input1-default']"))));
		//Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.cssSelector("button[data-stid='uitk-date-selector-input1-default']"))).click(driver.findElement(By.cssSelector("button[data-stid='uitk-date-selector-input1-default']"))).build().perform();
		//driver.findElement(By.cssSelector("button[data-stid='uitk-date-selector-input1-default']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("span[class='uitk-align-center uitk-month-label']"))));
		String monthyear = "March 2024";
		String day = "20";
		while (true) {
			//Thread.sleep(3000);
			String monthyearcomp = driver.findElement(By.cssSelector("span[class='uitk-align-center uitk-month-label']")).getText();
			//driver.findElement(By.className("Heading_heading__xct3h Heading_h-s___YnjF.mx-3.pb-3.font-bold")).getText();
			if (monthyearcomp.equalsIgnoreCase(monthyear)) {
				break;
			} else {
				//Thread.sleep(3000);
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']"))));
				act.moveToElement(driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']"))).click(driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']"))).build().perform();
				//driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']")).click();

			}

		}
		//Thread.sleep(5000);

		//driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'"+day+"')]"))));
		act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'"+day+"')]"))).click(driver.findElement(By.xpath("//div[contains(text(),'"+day+"')]"))).build().perform();
		
		//check out
		
				String monthyear1 = "April 2024";
				String day1 = "10";
				// This is from date picker table

				while (true) {
					String monthyearcomp1 = driver.findElement(By.cssSelector("span[class='uitk-align-center uitk-month-label']")).getText();
					//driver.findElement(By.className("Heading_heading__xct3h Heading_h-s___YnjF.mx-3.pb-3.font-bold")).getText();
					if (monthyearcomp1.equalsIgnoreCase(monthyear1)) {
						break;
					} else {
						act.moveToElement(driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']"))).click(driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']"))).build().perform();
						//driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']")).click();

					}

				}
				//Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'"+day+"')]"))));
				act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'"+day1+"')]"))).click(driver.findElement(By.xpath("//div[contains(text(),'"+day1+"')]"))).build().perform();
				act.moveToElement(driver.findElement(By.xpath("//button[@data-stid='apply-date-selector']"))).click(driver.findElement(By.xpath("//button[@data-stid='apply-date-selector']"))).build().perform();
				//driver.findElement(By.xpath("//button[@data-stid='apply-date-selector']")).click();
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@data-stid='open-room-picker']"))));
				//act.moveToElement(driver.findElement(By.xpath("//button[@data-stid='open-room-picker']"))).click(driver.findElement(By.xpath("//button[@data-stid='open-room-picker']"))).build().perform();
				driver.findElement(By.xpath("//button[@data-stid='open-room-picker']")).click();
				Assert.assertTrue(driver.findElement(By.xpath("//button[@data-stid='open-room-picker']")).isEnabled());
				int rooms=2;
				Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[2]"))));
				if(rooms>=1)  //need to figure out logic for adding children age.
				{
					
					if(rooms==1)
					{
						int adults=4,Child=0;
						if(adults>2)
						{
							for(int i=2;i<adults;i++)
							{
								act.moveToElement(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[2]"))).click(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[2]"))).build().perform();
								//driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[2]")).click();
							}
						}
						else if(adults<2)
						{
							driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[1]")).click();
							if(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[1]")).getAttribute("button").contains("disabled"))
								System.out.println("exceeding less than one occupant in adult");
						}
						if(Child!=0)
						{
							if(Child>0)
							{
								for(int i=0;i<Child;i++)
								{
									driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[4]")).click();
								}
							}
							else if(Child<1)
							{

								Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[3]")).getAttribute("button").contains("disabled"));
								System.out.println("exceeding less than one occupant in child");
							}
						}
					}
					else
					{
						int rac=2;
						int rcc=2;
					
						int adults=4,Child=0;
						if(adults>2)//for first room
						{
							for(int i=2;i<adults;i++)
							{
								driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[2]")).click();
							}
						}
						else if(adults<2)
						{
							driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[1]")).click();
							if(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[1]")).getAttribute("button").contains("disabled"))
								System.out.println("exceeding less than one occupant in adult");
							if(Child!=0)
							{
								if(Child>0)
								{
									for(int i=0;i<Child;i++)
									{
										driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[4]")).click();
									}
								}
								else if(Child<1)
								{

									Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[3]")).getAttribute("button").contains("disabled"));
									System.out.println("exceeding less than one occupant in child");
								}
							}
						}
						for(int j=1;j<rooms-1;j++)
						{
						driver.findElement(By.id("traveler_selector_add_room")).click();
						
						adults=4;
						Child=2;

					if(adults>1)
					{
						for(int i=1;i<adults;i++)
						{
							driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])["+(4+rac)+"]")).click();
						}
					}
					else if(adults<2)
					{
						driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])["+(3+rac)+"]")).click();
						if(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])["+(3+rac)+"]")).getAttribute("button").contains("disabled"))
							System.out.println("exceeding less than one occupant in adult");
						break;
					}
					if(Child!=0)
					{
						if(Child>0)
						{
							for(int i=0;i<Child;i++)
							{
								driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])["+(6+rcc)+"]")).click();
							}
						}
						else if(Child<1)
						{

							Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])["+(5+rcc)+"]")).getAttribute("button").contains("disabled"));
							System.out.println("exceeding less than one occupant in child");
							break;
						}
					}
					
					rac+=2;
					rcc+=2;
					}
					}
				}
				else
					System.out.println("invalid room count");
				
				act.moveToElement(driver.findElement(By.id("traveler_selector_done_button"))).click(driver.findElement(By.id("traveler_selector_done_button"))).build().perform();
				//driver.findElement(By.id("traveler_selector_done_button")).click();
				//search button
				act.moveToElement(driver.findElement(By.id("search_button"))).click(driver.findElement(By.id("search_button"))).build().perform();
				driver.findElement(By.id("search_button")).click();
				Thread.sleep(2000);
				
				
				
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[data-stid='lodging-card-responsive']")))).isEnabled();
				
				 List<WebElement> card=driver.findElements(By.cssSelector("div[data-stid='lodging-card-responsive']"));
				 for(WebElement as:card)
				 {
					 String name=as.findElement(By.cssSelector("div[class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-layout-flex-gap-two']")).getText();
					 String price=as.findElement(By.cssSelector("div[class='uitk-text uitk-type-500 uitk-type-medium uitk-text-emphasis-theme']")).getText();
					 String link = as.findElement(By.cssSelector("a[data-stid='open-hotel-information']")).getAttribute("href");
					 System.out.println(name);
					 System.out.println(price);
					 System.out.println(link);
				 }
				 driver.close();


	}

}
