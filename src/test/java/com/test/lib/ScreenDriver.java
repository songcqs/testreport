package com.test.lib;

//这个类可有可无!
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenDriver {
	WebDriver driver;

	/*
	 * 截图方法
	 */
	public void takeScreenShot() {
		// 获取截图时间
		long date = System.currentTimeMillis();
		// 转换成字符串形式
		String path = String.valueOf(date);
		String curPath = System.getProperty("user.dir");
		path = path + ".png";
		String screenPath = curPath + "/" + path;
		// 进行截图操作
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 自动截图
	 */
//	public void takeScreenShot() {
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//		Calendar cal = Calendar.getInstance();
//		Date date = cal.getTime();
//		String dateStr = sf.format(date);
//		String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
//		takeScreenShot((TakesScreenshot) this.getDriver(), path);
//		// takeScreenShot((TakesScreenshot) driver, path);
//	}

	/**
	 * 传入参数截图
	 */
	public void takeScreenShot(TakesScreenshot drivername, String path) {
		String currentPath = System.getProperty("user.dir"); // get current work
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("截图成功");
		}
	}
}
