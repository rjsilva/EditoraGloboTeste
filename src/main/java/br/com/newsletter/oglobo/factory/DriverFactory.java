package br.com.newsletter.oglobo.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.com.newsletter.oglobo.utils.Browsers;

public class DriverFactory {

	private static String drivePath = "src/drivers/";
	private static WebDriver driver;

	public static WebDriver iniDriver(Browsers browser) throws IOException {

		switch (browser) {
		case Chrome:
			Map<String, Object> deviceMetrics = new HashMap<>();
			deviceMetrics.put("width", 360);
			deviceMetrics.put("height", 640);
			deviceMetrics.put("pixelRatio", 3.0);
			Map<String, Object> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceMetrics", deviceMetrics);
			mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			System.setProperty("webdriver.chrome.driver", drivePath + "chromedriver");
			return driver = new ChromeDriver(chromeOptions);
		default:
			break;
		}
		return null;

	}

	public static WebDriver getDriver() {
		return driver;
	}

}
