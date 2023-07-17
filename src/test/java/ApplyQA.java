import java.awt.Window;
import java.io.File;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyQA {
	WebDriver driver;

	@Test
	public void TestApply() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001");

		driver.findElement(By.name("name")).sendKeys("Mayank");
		driver.findElement(By.name("email")).sendKeys("mayankyadav.amt@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("7724875609");
		
		File file = new File("./src/test/resources/Data/MAYANK_AUTOMATION_TESTING_4+_YEARS_EXP  (1) (1) (1).pdf");
		String absolutepathOfResume = file.getAbsolutePath();
		driver.findElement(By.name("resume")).sendKeys(absolutepathOfResume);

		RemoteWebDriver remote = (RemoteWebDriver) driver;
	

		WebElement descript = driver.findElement(By.xpath("//textarea[@placeholder='Briefly Describe Yourself']"));
		int y = descript.getLocation().getY();
		remote.executeScript("window.scrollTo(0," + y + ")");
		descript.sendKeys("Hello I am MAYANK");

		 driver.findElement(By.xpath("//button[text()='APPLY NOW']")).click();

	}

}
