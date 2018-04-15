package br.com.newsletter.oglobo.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.newsletter.oglobo.factory.DriverFactory;

public class SeleniumRobot {
	
    private static long timeout = 10;
	private static WebDriverWait waitDriver() {
		return new WebDriverWait(DriverFactory.getDriver(), 10);
	}


	public static void implicitlyWait(WebElement element) {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		waitDriver().until(ExpectedConditions.visibilityOf(element));
	}

	
	public static void explicitWait(WebElement element) {
		waitDriver().until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void scroll(int rolagem) {
		JavascriptExecutor jse = (JavascriptExecutor)DriverFactory.getDriver();
		jse.executeScript("window.scrollBy(0,"+rolagem+")", "");
	}

}
