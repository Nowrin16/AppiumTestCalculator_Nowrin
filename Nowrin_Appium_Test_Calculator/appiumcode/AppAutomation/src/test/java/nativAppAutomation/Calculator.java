package nativAppAutomation;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

public class Calculator {

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
		dc.setCapability("appPackage","com.google.android.calculator");
		dc.setCapability("appActivity","com.android.calculator2.Calculator");
		
        //Server setup
		URL server= new URL("http://127.0.0.1:4723/wd/hub"); // aapium ip:host/webdriver/grid hub
		
		//AppiumDriver object creation & send DesiredCapabilities information & server details
		AppiumDriver MobileObj = new AppiumDriver(server,dc);
		
		//For verify
		System.out.println("App opening");
		
		// Target 2+6=8 & more click // button (Lookator Id and Xpath)
		
		//Object create for digit 2
		WebElement digit2 = MobileObj.findElement(By.id("com.google.android.calculator:id/digit_2"));
		
		//Object create for digit 6
		WebElement digit6 = MobileObj.findElement(By.id("com.google.android.calculator:id/digit_6"));
		
		//Object create for AddBtn
		WebElement addBtn = MobileObj.findElement(By.id("com.google.android.calculator:id/op_add"));
		
		//Object create for EqualBtn
		WebElement equBtn = MobileObj.findElement(By.id("com.google.android.calculator:id/eq"));
		
		// Action Place 
		digit2.click();
		addBtn.click();
		digit6.click();
		equBtn.click();
		
		// Result shown
		//Object create for Result
		WebElement resultShow = MobileObj.findElement(By.id("com.google.android.calculator:id/result_final"));		
		System.out.println("Addition is: "+resultShow.getText());
		
		//delay for 2 second
		//Thread.sleep(2000);
		
		//Object create for more options Btn
		WebElement moreOptionBtn = MobileObj.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
		moreOptionBtn.click();
		
		//History check After whole operation
		//Object create for History Btn
		WebElement historyBtn = MobileObj.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
		historyBtn.click();
		
	}
	

}
