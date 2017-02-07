package org.com.gaurav.org.com.gaurav.version1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;

public class EbayTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "http://www.ebay.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEbay() throws Exception {
    driver.get(baseUrl);
    assertEquals("Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay", driver.getTitle());
    driver = new Augmenter().augment(driver);
	   File scrFile =  
	     ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   try {
		FileUtils.copyFile(scrFile, new File("c:\\gaurav\\screenshot.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
 
 
}
