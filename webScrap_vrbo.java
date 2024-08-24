package Hotel_Price_Analysis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class webScrap_vrbo {

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		PrintWriter pw = new PrintWriter("Vrbo_JSONoutput.json");

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("disable-infobars");
		opt.addArguments("--disable-extensions");
		// opt.addArguments("--headless");
		//opt.addArguments("window-size=1920,1080");
		// opt.addArguments("--test-type");
		// opt.addArguments("--disable-gpu");
		// opt.addArguments("--no-first-run");
		// opt.addArguments("--no-default-browser-check");
		//opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://vrbo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("close"))).click();
		// Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[data-stid='destination_form_field-menu-trigger']")))
		.isDisplayed();
		//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//		FileUtils.copyFile(scrFile, new File("/Users/shivamaniarunachalam/Documents/demo/screenshot.png"));
		// driver.findElement(By.xpath("//button[@data-stid='destination_form_field-menu-trigger']")).sendKeys("Toronto");
		// Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector("button[data-stid='destination_form_field-menu-trigger']")))
		.click(driver.findElement(By.cssSelector("button[data-stid='destination_form_field-menu-trigger']")))
		.sendKeys("toronto").sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.cssSelector("button[data-stid='uitk-date-selector-input1-default']"))));
		// Thread.sleep(1000);

		driver.findElement(By.cssSelector("button[data-stid='uitk-date-selector-input1-default']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.cssSelector("span[class='uitk-align-center uitk-month-label']"))));
		String monthyear = "March 2024";
		int day = 31;
		while (true) {
			// Thread.sleep(3000);
			String monthyearcomp = driver
					.findElement(By.cssSelector("span[class='uitk-align-center uitk-month-label']")).getText();
			// driver.findElement(By.className("Heading_heading__xct3h
			// Heading_h-s___YnjF.mx-3.pb-3.font-bold")).getText();
			if (monthyearcomp.equalsIgnoreCase(monthyear)) {
				break;
			} else {
				// Thread.sleep(3000);
				// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']"))));
				driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']"))
				.click();

			}

		}
		// Thread.sleep(5000);

		// driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
//		LocalDate currentDate = LocalDate.now();
//		int dayOfMonth = currentDate.getDayOfMonth();
//		if(dayOfMonth==day)
//		{
//			if(dayOfMonth==31)
//			{
//				day=1;
//				driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']")).click();
//				wait.until(ExpectedConditions
//						.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))));
//
//				act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")))
//				.click(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))).build().perform();
//			}
//			else
//			{
//				day++;
//				wait.until(ExpectedConditions
//						.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))));
//
//				act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")))
//				.click(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))).build().perform();
//			}
//			
//		}
//		else
//		{
//			wait.until(ExpectedConditions
//					.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))));
//
//			act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")))
//			.click(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))).build().perform();
//		}
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))));

		act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")))
		.click(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))).build().perform();
		
		//driver.findElement(By.xpath("//div[text()='"+day+"']")).click();		
		// check out

		String monthyear1 = "April 2024";
		String day1 = "18";
		// This is from date picker table

		while (true) {
			String monthyearcomp1 = driver
					.findElement(By.cssSelector("span[class='uitk-align-center uitk-month-label']")).getText();
			// driver.findElement(By.className("Heading_heading__xct3h
			// Heading_h-s___YnjF.mx-3.pb-3.font-bold")).getText();
			if (monthyearcomp1.equalsIgnoreCase(monthyear1)) {
				break;
			} else {
				driver.findElement(By.cssSelector("button[data-stid='uitk-calendar-navigation-controls-next-button']"))
				.click();

			}

		}
		// Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]"))));

		act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'" + day1 + "')]")))
		.click(driver.findElement(By.xpath("//div[contains(text(),'" + day1 + "')]"))).build().perform();
		// driver.findElement(By.xpath("//div[text()='"+day1+"']")).click();
		driver.findElement(By.xpath("//button[@data-stid='apply-date-selector']")).click();

		driver.findElement(By.xpath("//button[@data-stid='open-room-picker']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[@data-stid='open-room-picker']")).isEnabled());
		
		// Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[2]"))));
		int adults = 4, Child = 1;
		if (adults > 2) {
			for (int i = 2; i < adults; i++) {
				driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[2]")).click();
			}
		} else if (adults < 2) {
			if(adults==1) {
				driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[1]")).click();
			}
			else
			{
				System.out.println("exceeding less than one occupant in adult");
			}
				
		}
		if (Child != 0) {
			if (Child > 0) {
				for (int i = 0; i < Child; i++) {
					driver.findElement(By.xpath("(//span[@class='uitk-step-input-button'])[4]")).click();
					Select childCount = new Select(
							driver.findElement(By.id("age-traveler_selector_children_age_selector-" + i + "")));
					childCount.selectByVisibleText("10");
				}
			} else if (Child < 1) {

				
				System.out.println("exceeding less than one occupant in child");
			}
		}

		driver.findElement(By.id("traveler_selector_done_button")).click();
		// search button
		driver.findElement(By.id("search_button")).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("div[data-stid='lodging-card-responsive']"))))
		.isEnabled();

		List<WebElement> card = driver.findElements(By.cssSelector("div[data-stid='lodging-card-responsive']"));
		for (WebElement as : card) {
			String name = as.findElement(By.cssSelector(
					"div[class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-layout-flex-gap-two']"))
					.getText();
			String price = as
					.findElement(By.cssSelector(
							"div[class='uitk-text uitk-type-500 uitk-type-medium uitk-text-emphasis-theme']"))
					.getText();
			String link = as.findElement(By.cssSelector("a[data-stid='open-hotel-information']")).getAttribute("href");
			obj.put("Name", name);
			obj.put("Price", price);
			obj.put("URL", link);
			pw.write(obj.toJSONString());
			System.out.println(name);
			System.out.println(price);
			System.out.println(link);
		}
		driver.close();

	}

}
