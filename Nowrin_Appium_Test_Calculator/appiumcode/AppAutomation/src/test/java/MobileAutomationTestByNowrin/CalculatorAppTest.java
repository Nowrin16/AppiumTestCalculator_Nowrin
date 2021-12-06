package MobileAutomationTestByNowrin;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

public class CalculatorAppTest {

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
				
				// Target [(5+2)-{1*7}]/2=3.5 & more click 
				
				//Object create 
				WebElement digit5 = MobileObj.findElement(By.id("com.google.android.calculator:id/digit_5"));
				WebElement digit2 = MobileObj.findElement(By.id("com.google.android.calculator:id/digit_2"));
				WebElement digit1 = MobileObj.findElement(By.id("com.google.android.calculator:id/digit_1"));
				WebElement digit7 = MobileObj.findElement(By.id("com.google.android.calculator:id/digit_7"));
				
				WebElement fstBkt = MobileObj.findElement(By.id("com.google.android.calculator:id/parens"));
				WebElement addBtn = MobileObj.findElement(By.id("com.google.android.calculator:id/op_add"));
				WebElement subBtn = MobileObj.findElement(By.id("com.google.android.calculator:id/op_sub"));
				WebElement mulBtn = MobileObj.findElement(By.id("com.google.android.calculator:id/op_mul"));
				WebElement divBtn = MobileObj.findElement(By.id("com.google.android.calculator:id/op_div"));
				
				WebElement equBtn = MobileObj.findElement(By.id("com.google.android.calculator:id/eq"));
				
				// Action Place 
				fstBkt.click();
				fstBkt.click();
				digit5.click();
				addBtn.click();
				digit2.click();
				fstBkt.click();
				subBtn.click();
				fstBkt.click();
				digit1.click();
				mulBtn.click();
				digit7.click();
				fstBkt.click();
				fstBkt.click();
				divBtn.click();
				digit2.click();
				equBtn.click();
				
				// Result shown
				//Object create for Result [(5+2)-{1*7}]/2=3.5
				WebElement resultShow = MobileObj.findElement(By.id("com.google.android.calculator:id/result_final"));	
				System.out.println("The equation is: "+"[("+digit5.getText()+addBtn.getText()+digit2.getText()+")"+subBtn.getText()+"{"+digit1.getText()+mulBtn.getText()+digit7.getText()+"}]"+divBtn.getText()+digit2.getText());
				System.out.println("The solution of the equation is: "+resultShow.getText());
				
				//Object create for more options Btn
				WebElement moreOptionBtn = MobileObj.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
				moreOptionBtn.click();
				
				//History check After whole operation
				//Object create for History Btn
				WebElement historyBtn = MobileObj.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
			    historyBtn.click();

	}

}

