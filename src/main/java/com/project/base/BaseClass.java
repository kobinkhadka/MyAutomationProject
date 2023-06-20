package com.project.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import com.automation.utils.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })

	public void loadPropertiesFile() {

		prop = new Properties();

		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\project\\config\\config.properties");

		try {

			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);

			fis.close();

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public static WebDriver getDriver() {

		return driver.get();
	}

	public void initializeBrowserAndRun(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			driver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();

			driver.set(new EdgeDriver());

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver.set(new FirefoxDriver());

		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_LOAD_TIME));

		getDriver().get(prop.getProperty("url"));

	}
	
	
	
	public static void  unloadDriver() {

		driver.remove();
	}
	
	

	
	
	

}
