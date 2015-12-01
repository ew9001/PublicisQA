package brand.preference;

import io.netty.handler.codec.EncoderException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DesktopPreferenceCenter  {
	
	private static WebDriver driver;
	 
	 public static final String USERNAME = "zaqwsx1";
	  public static final String AUTOMATE_KEY = "Fs54nwmULt7BaSTosZxi";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	  public String name,id,actual;
	  public String ActualText;
	 
	  public String browser_type;
	  public String fail,error,url,rotate;
	  
	  SoftAssert soft_assert = new SoftAssert();
	
	    int counter=1;
		String local=(new java.io.File("").getAbsolutePath());
		String data="" + local + "/" + "homepage.csv";	
		String data2="" + local + "/" + "homepage.csv";	
		String myTitle,screenshot;
		String csvFileToRead;
		String urlCheck = "http://author.swiffer.pgsitecore.com/en-us";
	
		String slide1 = "Today's Fresh Fish";
	
		
		
	static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	
	@BeforeClass

	public void beforeClass(){

		System.out.println("Initialize Selenium for Preference Center");
		
		
	}

	@Test(priority=1)
	
	public void beforeMethod01() throws InterruptedException {

		System.out.println("Test 1 I want to test using browser Chrome ");
		System.out.println("Let me run in Chrome 45 MAC OS ");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Chrome");
		 caps.setCapability("browser_version", "46.0");
		 caps.setCapability("os", "OS X");
		 caps.setCapability("os_version", "Yosemite");
		 caps.setCapability("browserstack.local", "true");
		 caps.setCapability("resolution", "1024x768");
			
		 caps.setCapability("acceptSslCerts", "true");
		    try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      System.out.println("Let me run Chrome 46 on Windows");
	  	browser_type="swiffer";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://www.google.com");
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      System.out.println(data);
			Thread.sleep(100); 
	}
	
	
	@Test(priority=2)
	public  void testBlankLogin02() throws IOException, InterruptedException {

			System.out.println("Inside Test 2 - Blank Login");
			System.out.println("---------------------------");
			driver.get(urlCheck);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.className("event_profile_login")).click();
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("phdesktopbody_0_submit")).click();
			
			//Assert that the error message is present
			
			
			
			id="phdesktopbody_0_requiredfieldvalidatorusername";
			actual="This is a mandatory field.";
			checkText(id,actual);
		    
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 
		    
			id="phdesktopbody_0_Message";
			actual="Fields marked with * are mandatory. Please complete all mandatory fields and re-submit.";
			checkText(id,actual);
			
		    //Take a picture
		     
			 System.out.println("I want to take a picture of the blank username & password");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			String name=""+ browser_type+"/"+ counter + "_" + "Blank_login.png";
	       
	        System.out.println("Image Name " +name);
	        
	        try {
				takeScreenPortrait(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				
				Thread.sleep(100); 

	}
	
	@Test(priority=3)
	 public void testWrongLogin03() throws IOException, InterruptedException {
		 
			System.out.println("Inside Test 3 - Wrong Login / Password");
			System.out.println("---------------------------");
			driver.findElement(By.id("phdesktopbody_0_username")).clear();
		      driver.findElement(By.id("phdesktopbody_0_username")).sendKeys("albert.golubev@pkt.com");
		      driver.findElement(By.id("phdesktopbody_0_password")).clear();
		      driver.findElement(By.id("phdesktopbody_0_password")).sendKeys("zaq12wsx1234");
		      driver.findElement(By.id("phdesktopbody_0_submit")).click();
		      
		      System.out.println("I want to take a picture of the Wrong Login");
		      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				error =
			    
				id="phdesktopbody_0_Message";
				actual="The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.";
				checkText(id,actual);
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				name=""+ browser_type+"/"+ counter + "_" + "Wrong_login.png";
		        try {
					takeScreenPortrait(name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println("Image Name " +name);
		        
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
				Thread.sleep(100); 
	}

	

	@Test(priority=4)
	public void testValidLogin4() throws IOException, InterruptedException{

			System.out.println("Inside Test 4 - Right Login");
			System.out.println("---------------------------");
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("phdesktopbody_0_username")).clear();
		      driver.findElement(By.id("phdesktopbody_0_username")).sendKeys("albert.golubev@pkt.com");
		      driver.findElement(By.id("phdesktopbody_0_password")).clear();
		      driver.findElement(By.id("phdesktopbody_0_password")).sendKeys("zaq12wsx");
		      driver.findElement(By.id("phdesktopbody_0_submit")).click();
		    
		      System.out.println("I want to take a picture of the Valid Login");
		      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				error ="Your Profile";
				
				id="phdesktopbody_0_TitleText";
				actual="Your Profile";
				checkText(id,actual);
				
			   // checkText(error);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				name=""+ browser_type+"/"+ counter + "_" + "Valid_login.png";
		        takeScreenPortrait(name);
		        System.out.println("Image Name " +name);
		        
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
				Thread.sleep(100); 
	}


	@Test(priority=5)
	public void testResetPassword5() throws IOException, InterruptedException{

			System.out.println("Inside Test 5 - Reset Password\n");
			System.out.println("---------------------------------");
			 driver.findElement(By.id("phdesktopbody_0_HlinkEdit")).click();
			 	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 	error ="Your Basic Information";
			   // checkText(error);
			     driver.findElement(By.id("phdesktopbody_0_HlinkReset")).click();
			     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			 	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				Thread.sleep(100); 
				//error ="Reset Password";
				
				id="phdesktopbody_0_TitleText";
				actual="Reset Password";
				checkText(id,actual);
				
			   // checkText(error);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				name=""+ browser_type+"/"+ counter + "_" + "Get_To_login.png";
			    
		        takeScreenPortrait(name);
		        System.out.println("Image Name " +name);
		    
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
				Thread.sleep(100); 
	}
	@Test(priority=6)
	public void testSetBlankPassword6() throws IOException, InterruptedException{

			System.out.println("Inside Test 6 - Reset Password");
			System.out.println("---------------------------");
			driver.findElement(By.id("phdesktopbody_0_LoginSubmitBtn")).click();
		   	
		      driver.manage().timeouts().implicitlyWait(450, TimeUnit.SECONDS);
			     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 
			   //  driver.findElement(By.id("phdesktopbody_0_HlinkReset")).click();
			     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			 	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				
			   // checkText(error);
				id="phdesktopbody_0_Message";
				actual="Fields marked with * are mandatory. Please complete all mandatory fields and re-submit.";
				checkText(id,actual);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				id="phdesktopbody_0_ctl02";
				actual="This is a mandatory field.";
				checkText(id,actual);
			   // checkText(error);
				Thread.sleep(100); 
			
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				name=""+ browser_type+"/"+ counter + "_" + "No email or password.png";
		        takeScreenPortrait(name);
		        System.out.println("Image Name " +name);
		        
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=7)
	
	public void testSetWrongPassword7() throws IOException, InterruptedException{

			System.out.println("Inside Test 7 - Wrong Email & Zipcode");
			System.out.println("-------------------------------------");
		   	
		      driver.manage().timeouts().implicitlyWait(450, TimeUnit.SECONDS);
			     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 
			     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			     driver.findElement(By.id("phdesktopbody_0_username")).sendKeys("aik1771#yasasf.com");
			     driver.findElement(By.id("phdesktopbody_0_zipcode")).sendKeys("11235");
			     driver.findElement(By.id("phdesktopbody_0_LoginSubmitBtn")).click();
			     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  	
			  	
			     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			 	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
			
			   // checkText(error);
				
				id="phdesktopbody_0_Message";
				actual ="We could not find an account with that Email address and Birthday/ZIP code.";
				checkText(id,actual);
			    
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				name=""+ browser_type+"/"+ counter + "_" + "Wrong email and zipcode.png";
		        takeScreenPortrait(name);
		        System.out.println("Image Name " +name);
		        
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		     
		     driver.findElement(By.id("phdesktopbody_0_username")).clear();
		     driver.findElement(By.id("phdesktopbody_0_zipcode")).clear();
		
	}
	
@Test(priority=8)
	
	public void testSetRightPassword8() throws IOException, InterruptedException{
			
			System.out.println("Inside Test 8 - Right Email & Zipcode");
			System.out.println("-------------------------------------");
		   	
		      driver.manage().timeouts().implicitlyWait(450, TimeUnit.SECONDS);
			     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			     driver.manage().timeouts().implicitlyWait(450, TimeUnit.SECONDS);
			     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			     
			     driver.findElement(By.id("phdesktopbody_0_username")).clear();
			     driver.findElement(By.id("phdesktopbody_0_zipcode")).clear();
			     
			     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			     driver.findElement(By.id("phdesktopbody_0_username")).clear();
			     driver.findElement(By.id("phdesktopbody_0_username")).sendKeys("albert.golubev@pkt.com");
			     driver.findElement(By.id("phdesktopbody_0_zipcode")).clear();
			     driver.findElement(By.id("phdesktopbody_0_zipcode")).sendKeys("11235");
			     driver.findElement(By.id("phdesktopbody_0_LoginSubmitBtn")).click();
			     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  	
			  	
			     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			 	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				error ="Set Password";
			   // checkText(error);
			    
				id="phdesktopbody_0_TitleText";
				actual="Set Password";
				checkText(id,actual);
				
				
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				name=""+ browser_type+"/"+ counter + "_" + "Right email and zipcode.png";
		        takeScreenPortrait(name);
		        System.out.println("Image Name " +name);
		        
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		
	}


@Test(priority=9)

public void testShortPassword9() throws IOException, InterruptedException{

		System.out.println("Inside Test 9 - Set Short Password");
		System.out.println("-------------------------------------");
	   	
	      driver.manage().timeouts().implicitlyWait(450, TimeUnit.SECONDS);
	      Thread.sleep(200); 
		     driver.findElement(By.id("phdesktopbody_0_password")).sendKeys("aik1");
		     driver.findElement(By.id("showpassword")).click();
		      driver.findElement(By.id("phdesktopbody_0_ResetSubmitBtn")).click();
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     
		   
		    // checkText(error);
		     
		 	id="phdesktopbody_0_Message";
		 	 actual ="The password must be minimum 8 characters, including at least 1 letter and 1 number.";
			checkText(id,actual);
			
			
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			name=""+ browser_type+"/"+ counter + "_" + "Short Password.png";
	        takeScreenPortrait(name);
	        System.out.println("Image Name " +name);
	        
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
	
}

@Test(priority=10)

public void testAllChar10() throws IOException, InterruptedException{

		System.out.println("Inside Test 10 - Set password to ABCabcDEF");
		System.out.println("-------------------------------------");
	   	
	      driver.manage().timeouts().implicitlyWait(450, TimeUnit.SECONDS);
	      Thread.sleep(200);
	      driver.findElement(By.id("phdesktopbody_0_password")).clear();
		     driver.findElement(By.id("phdesktopbody_0_password")).sendKeys("ABCabcDEF");
		     driver.findElement(By.id("showpassword")).click();
		      driver.findElement(By.id("phdesktopbody_0_ResetSubmitBtn")).click();
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     
		    actual ="The password must be minimum 8 characters, including at least 1 letter and 1 number";
		     
		  	id="phdesktopbody_0_Message";
		 	 
			checkText(id,actual);
			
		    // checkText(error);
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			name=""+ browser_type+"/"+ counter + "_" + "Password all characters.png";
	        takeScreenPortrait(name);
	        System.out.println("Image Name " +name);
	        
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
	
}


@Test(priority=11)

public void testValidPassword11() throws IOException, InterruptedException{

		System.out.println("Inside Test 11 - Set password to original");
		System.out.println("-------------------------------------");
	   	
	      Thread.sleep(200);
	      driver.findElement(By.id("phdesktopbody_0_password")).clear();
		     driver.findElement(By.id("phdesktopbody_0_password")).sendKeys("zaq12wsx");
		     driver.findElement(By.id("showpassword")).click();
		      driver.findElement(By.id("phdesktopbody_0_ResetSubmitBtn")).click();
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		     
		    
		    // checkText(error);
		     
		     
		     
		     actual ="Don't have an account yet?";
		     
			  	id="phdesktopbody_0_labeloptionalcreateprofile";
			 	 
				checkText(id,actual);
				
		     
		     
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			name=""+ browser_type+"/"+ counter + "_" + "Changed Password.png";
	        takeScreenPortrait(name);
	        System.out.println("Image Name " +name);
	        
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
	
}

@Test(priority=12)

public void testValidLogout12() throws IOException, InterruptedException{

		System.out.println("Inside Test 12 - Set password to original");
		System.out.println("-------------------------------------");
	   	
	      driver.manage().timeouts().implicitlyWait(450, TimeUnit.SECONDS);
	      driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("phdesktopbody_0_username")).clear();
		      driver.findElement(By.id("phdesktopbody_0_username")).sendKeys("albert.golubev@pkt.com");
		      driver.findElement(By.id("phdesktopbody_0_password")).clear();
		      driver.findElement(By.id("phdesktopbody_0_password")).sendKeys("zaq12wsx");
		      driver.findElement(By.id("phdesktopbody_0_submit")).click();
		      System.out.println("--------------------------------------------");
		      System.out.println("I want to take a picture of the Valid Login");
		      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				error ="Your Profile";
			   // checkText(error);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				name=""+ browser_type+"/"+ counter + "_" + "Valid_login.png";
		        takeScreenPortrait(name);
		        System.out.println("Image Name " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
	     
	     
	     driver.findElement(By.className("logoutbtn")).click();
		   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
			name=""+ browser_type+"/"+ counter + "_" + "Logout_Popup.png";
	        takeScreenPortrait(name);
	        System.out.println("Image Name " +name);
	        
   
   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
   
   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		   
		   
		   
		
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		 
		 name=""+ browser_type+"/"+ counter + "_" + "Continue_Button_Click.png";
	        takeScreenPortrait(name);
	        System.out.println("Image Name " +name);
	        
	      
		   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
			
			id="phdesktopheader_0_phdesktopheadertop_2_anchrContinue";
			actual="LOG OUT";
			checkText(id,actual);
	
			   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 
			
			driver.findElement(By.id("phdesktopheader_0_phdesktopheadertop_2_anchrContinue")).click();
	     
	
}
	
	
	
	
	@AfterClass
	public void afterClass(){
		System.out.println("Clothing the browser");
	    driver.quit();
	}
	
	@Test
	//This function will check the assertion on the page
	public String checkText(String id, String actual) throws IOException
	 {
			
		  ActualText = driver.findElement(By.id(id)).getText();
		  
		  
	
		 
		  System.out.println("I just tested Assertion for text " +actual);
		   System.out.println("The text that I was expected to see was " +ActualText);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			soft_assert.assertAll();
		    
			try
			{
				 soft_assert.assertEquals(ActualText, actual,"Failed Asserting for text " +actual);

			} catch (EncoderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				name="Failed"+ browser_type+"/"+ counter + "_" + "Failed Assertion" +".png";
		        takeScreenPortrait(name);
		        System.out.println("Image Name " +name);
			}
			
			return ActualText;
	     
		 }
		    
	 
	 public WebDriver browserChrome() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run mobileGalaxyS3");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Chrome");
		 caps.setCapability("browser_version", "39.0");
		 caps.setCapability("os", "OS X");
		 caps.setCapability("os_version", "Mountain Lion");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("acceptSslCerts", "true");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Chrome 39 MAC OS");
	      browser_type="browserChrome39";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://google.com");
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      System.out.println(data);
	      return driver;
	   
	    
	      
	 }
	 
	 public WebDriver browserFirefox() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run in Firefox");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Firefox");
		 caps.setCapability("browser_version", "39.0");
		 caps.setCapability("os", "OS X");
		 caps.setCapability("os_version", "Mavericks");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
			
		 caps.setCapability("acceptSslCerts", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Firefox  39 MAC OS");
	      browser_type=" browserFirefox";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://google.com");
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      System.out.println(data);
	      return driver;
	   
	    
	      
	 }
	 
	 public WebDriver browserAndroidTablet() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run Galaxy Tablet");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "android");
		 caps.setCapability("platform", "ANDROID");
		 caps.setCapability("device", "Samsung Galaxy Note 10.1");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
			
		 caps.setCapability("acceptSslCerts", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Firefox  39 MAC OS");
	      browser_type="browserChrome39";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://google.com");
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      System.out.println(data);
	      return driver;
	   
	    
	      
	 }
	 
	 public WebDriver browserIE10() throws MalformedURLException  
	 {  
		 browser_type="browserIE10";
		 System.out.println("Let me run in IE10");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "IE");
		 caps.setCapability("browser_version", "10.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
			
		 caps.setCapability("acceptSslCerts", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Firefox  39 MAC OS");
	      browser_type="browserChrome39";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://google.com");
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      System.out.println(data);
	      return driver;
	   
	    
	      
	 }
	 
	 
	 public WebDriver chrome() throws MalformedURLException  
	 {  
		 browser_type="chrome";
		 System.out.println("Let me run in Chrome");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Chrome");
		 caps.setCapability("browser_version", "46.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
			
		 caps.setCapability("acceptSslCerts", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Firefox  39 MAC OS");
	      browser_type="browserChrome39";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://google.com");
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      System.out.println(data);
	      return driver;
	   
	    
	      
	 }
	 
	 
	 
	 

	 
	 
	 
	 public WebDriver browserSafari() throws MalformedURLException  
	 {  
	  
		 browser_type="safari";
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Safari");
		 caps.setCapability("browser_version", "8.0");
		 caps.setCapability("os", "OS X");
		 caps.setCapability("os_version", "Yosemite");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("acceptSslCerts", "true");
		 caps.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Safari");
	      driver.manage().window().maximize();
	      driver.get("https://google.com");
	      driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    //assign key board object
		    //   Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
		       //enter a key
		     //  keyboard.pressKey(Keys.ENTER);
	     /* 
		    try 
		    {
		        //Handle the alert pop-up using seithTO alert statement
		        Alert alert = driver.switchTo().alert();

		        //Print alert is present
		        System.out.println("Alert is present");

		        //get the message which is present on pop-up
		        String message = alert.getText();

		        //print the pop-up message
		        System.out.println(message);

		        alert.sendKeys("");
		        //Click on OK button on pop-up
		        alert.accept();
		    } 
		    catch (NoAlertPresentException e) 
		    {
		        //if alert is not present print message
		        System.out.println("alert is not present");
		    }*/
	      return driver;
	   
	    
	 }
	    



	 public WebDriver takeScreenPortrait(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshot " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     System.out.println("I want to rotate");
	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		  
		    myTitle = driver.getTitle();
		    
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    FileUtils.copyFile(screenshot, new File(name));
		    counter+=1;
		    
		    return driver;
	 }
}

