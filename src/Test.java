import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test {
	
	private DesiredCapabilities m_desired;
	private AndroidDriver m_driver;
	
	public Test(){
		this.m_desired = new DesiredCapabilities();
		this.m_desired.setCapability("device", "Android");
		this.m_desired.setCapability("platformName", "Android");
	}
	
	/**
	 * Method that configures the desired_capabilities, the android driver and runs the app
	 * @param a_deviceName
	 * @param a_appPackage
	 * @param a_appActivity
	 * @throws MalformedURLException
	 */
	public void f_test1(String a_deviceName,String a_appPackage,String a_appActivity) throws MalformedURLException{
		this.m_desired.setCapability("deviceName", a_deviceName);
		this.m_desired.setCapability("appPackage", a_appPackage);
		this.m_desired.setCapability("appActivity", a_appActivity);
		
		/*new Url contains the appium hub*/
		this.m_driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), this.m_desired);
		
		f_runApp(this.m_driver);
	}

	private void f_runApp(AndroidDriver a_driver) {
		f_firstActivity(a_driver);
		f_secondActivity(a_driver);
		f_third_Activity(a_driver);
		
	}

	/**
	 * Method that finds and uses the elements of the current activity
	 * @param a_driver
	 */
	private void f_firstActivity(AndroidDriver a_driver) {
		a_driver.findElement(By.id("nameEditText")).click();
		a_driver.findElement(By.id("nameEditText")).sendKeys("John Smith"); 
		((AndroidDriver)a_driver).hideKeyboard();
		
		a_driver.findElement(By.id("nextActivityButton")).click();
		
	}
	
	/**
	 * Method that finds and uses the elements of the current activity
	 * @param a_driver
	 */
	private void f_secondActivity(AndroidDriver a_driver) {
		a_driver.findElement(By.id("farewellRadioButton")).click();
		
		TouchAction t_seekBarTouch = new TouchAction(a_driver);
		/*get X and get Y of seekBar element*/
		int start = a_driver.findElement(By.id("ageSeekBar")).getLocation().getX();
		int y = a_driver.findElement(By.id("ageSeekBar")).getLocation().getY();
		int end = a_driver.findElement(By.id("ageSeekBar")).getSize().getWidth();
		/* age between 16-60, maybe sometimes the age can be incorrect by the press method*/
		t_seekBarTouch.press(start,y).moveTo((end/2), y).release().perform();
		
		a_driver.findElement(By.id("nextActivityButton")).click();
		
	}

	/**
	 * Method that finds and uses the elements of the current activity
	 * @param a_driver
	 */
	private void f_third_Activity(AndroidDriver a_driver) {
		a_driver.findElement(By.id("runButton")).click();
		
	}
}
