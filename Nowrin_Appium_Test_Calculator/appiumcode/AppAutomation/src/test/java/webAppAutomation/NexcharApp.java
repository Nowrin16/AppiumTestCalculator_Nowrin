package webAppAutomation;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

public class NexcharApp {

	public static void main(String[] args) throws Exception {
		
		//DesiredCapabilities Object create
				DesiredCapabilities dc=new DesiredCapabilities();
				
				//Mobile details
				dc.setCapability("deviceName","Redmi Note 7");
				dc.setCapability("udid","6a1ccc2d");
				//dc.setCapability("udid","192.168.0.100:5555");
				dc.setCapability("platformName","Android");
				dc.setCapability("platformVersion","10");
				
				//App details
				dc.setCapability("appPackage","com.pointofsale.nexchar");
				dc.setCapability("appActivity","com.pointofsale.nexchar.MainActivity");
				
		        //Server setup
				URL server= new URL("http://127.0.0.1:4723/wd/hub"); // aapium ip:host/webdriver/grid hub
				
				//AppiumDriver object creation & send DesiredCapabilities information & server details
				AppiumDriver MobileObj = new AppiumDriver(server,dc);
				
				//For verify
				System.out.println("App opening");
				
				//Target give user name and password, sign in homepage // button (Lookator Id and Xpath)
				
				//Object create for username
				WebElement username = MobileObj.findElement(By.id("com.pointofsale.nexchar:id/user_name"));
				
				//Object create for password
				WebElement password = MobileObj.findElement(By.id("com.pointofsale.nexchar:id/password"));
				
				//Object create for signInBtn
				WebElement signInBtn = MobileObj.findElement(By.id("com.pointofsale.nexchar:id/email_sign_in_button"));
				
				// Action Place 
				username.sendKeys("gift_shop");
				password.sendKeys("12345");
				signInBtn.click();
			
		
	}

}
