package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.project.base.BaseClass;

public class ExtentReporterClass extends BaseClass {

	// Creating extent report

	public static ExtentReports generateExtentReports() {

		ExtentReports extentReport = new ExtentReports();

		File extentReportFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("My Site Automation Result");
		sparkReporter.config().setDocumentTitle("Automation Result");

		
		
		extentReport.attachReporter(sparkReporter);

		Properties configProp = new Properties();

		File configPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\project\\config\\config.properties");

		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		} catch (Throwable e) {

			
			e.printStackTrace();
		}
	
		
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentReport.setSystemInfo("Email", configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReport;

	}

}
