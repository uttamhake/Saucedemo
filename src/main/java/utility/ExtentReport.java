package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getReports() {
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Reported By","Uttam");
		extent.setSystemInfo("Testing type","Regression");
		
		return extent;
		
	}
}
