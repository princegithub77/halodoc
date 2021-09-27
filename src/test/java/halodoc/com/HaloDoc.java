package halodoc.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HaloDoc {
	
	//@Test
	//public void lunchURL() {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prince.kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.busonlineticket.com/booking/bus-tickets.aspx");
	    driver.findElement(By.id("txtOriginGeneral")).click();
	    driver.findElement(By.id("txtOriginGeneral")).clear();
	    driver.findElement(By.id("txtOriginGeneral")).sendKeys("Cameron Highlands");
	    driver.findElement(By.xpath("(//ul[@class='select2-result-sub'])[1]")).click();
	    driver.findElement(By.id("txtDestinationGeneral")).click();
	    driver.findElement(By.id("txtDestinationGeneral")).clear();
	    driver.findElement(By.id("txtDestinationGeneral")).sendKeys("Kuala Lumpur");
	    driver.findElement(By.xpath("(//ul[@class='select2-result-sub'])[1]")).click();
	    driver.findElement(By.id("txtDepartDateBooking")).click();
	    WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
	    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        List<WebElement> rows = dateWidget.findElements(By.tagName("tr"));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        for (WebElement cell : columns) {
            //Select 20th Date
            if (cell.getText().equals("20")) {
                cell.findElement(By.linkText("20")).click();
                break;
            }
        } 
	    driver.findElement(By.id("btnBusSearchNewGeneral")).click();
	    driver.findElement(By.id("cheapest")).click();
	    driver.findElement(By.xpath("//div[@id='subtab1']//table//tbody//tr[1]//td[6]//a[@class='btn btn-orange selectseatbutton']")).click();
	    List<WebElement> seats=driver.findElements(By.xpath("//div[@class='seat_available']"));
	    
	    if(seats.size()>6) {
	    	for (WebElement seatSelection : seats) {
	    		seatSelection.click();
	    		int seatQuanity=Integer.parseInt(driver.findElement(By.xpath("//span[@class='seat_qty']")).getText().toString());
	    		if (seatQuanity==6) {
					break;
				}
	    		//break;
			}
	    }else {
	    	for (WebElement seatSelection : seats) {
	    		seatSelection.click();
			}
	    }
	    driver.findElement(By.xpath("//input[@class='seatproceed']")).click();
	    driver.findElement(By.id("ContentPlaceHolder1_txtName")).sendKeys("Abc");
	    driver.findElement(By.id("ContentPlaceHolder1_txtPhone")).sendKeys("1234567890");
	    driver.findElement(By.id("ContentPlaceHolder1_txtEmail")).sendKeys("abc123@gmail.com");
	    driver.findElement(By.id("ContentPlaceHolder1_txtEmail1")).sendKeys("abc123@gmail.com");
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("ContentPlaceHolder1_btnProceedPayment")));
	    
	    driver.findElement(By.id("ContentPlaceHolder1_btnProceedPayment")).click();
	   
	    WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
		webDriverWait.until(ExpectedConditions.alertIsPresent());
	    Alert alertDialog = driver.switchTo().alert();
	    Assert.assertEquals(alertDialog.getText().toString(), "Please select a payment method");
	    alertDialog.accept();
	    driver.close();
	    // need to modify more 
		/*
		 * HashMap<String, String> map=new HashMap<String,String>(); // List<WebElement>
		 * businfo=driver.findElements(By.xpath(
		 * "//div[@id='subtab1']//table//tbody//tr//td[1]//br")); List<WebElement>
		 * businfo=driver.findElements(By.xpath("//div[@id='subtab1']//table//tbody//tr"
		 * )); List<WebElement> businfoname; for(int i=0;i<businfo.size();i++) {
		 * System.out.println(businfo.get(i).getText()); } ArrayList<Float> busFare=new
		 * ArrayList<Float>(); List<WebElement> allBusFare=driver.findElements(By.xpath(
		 * "//div[@id='subtab1']//table//tbody//tr//td[5]//div//b")); for(int
		 * i=0;i<allBusFare.size();i++) { String
		 * busfare=allBusFare.get(i).getText().toString(); System.out.println(busfare);
		 * Float busfarevalue=Float.parseFloat(busfare.substring(3).toString());
		 * System.out.println(busfarevalue);
		 * 
		 * busFare.add(busfarevalue); } System.out.println(busFare);
		 * System.out.println("Least Fare = "+ Collections.min(busFare)); for (Float
		 * fare : busFare) { if(fare.equals(Collections.min(busFare))) {
		 * driver.findElement(By.xpath("//div[@id='subtab1']//table//tbody//tr//td[6]"))
		 * ; } }
		 */
	}

}
