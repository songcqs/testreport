package com.test.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LibLogout {
	WebDriver driver;

	public LibLogout(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 退出登录
	 * 
	 * @throws InterruptedException
	 */
	public void logout() throws InterruptedException {
		this.driver.findElement(By.xpath("//a[text()='退出']")).click();
		Thread.sleep(2000);
	}
}
