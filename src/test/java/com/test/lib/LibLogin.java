package com.test.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LibLogin {
	WebDriver driver;

	public LibLogin(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 邮箱登录
	 */
	public void login(String username, String password) throws InterruptedException {
		// 跳转至登录页面
		this.driver.get("https://mail.163.com/");
//		this.driver.navigate().to("http://mail.163.com");
		// 隐式等待
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 点击选择邮箱账号登录
		this.driver.findElement(By.id("lbNormal")).click();

		Thread.sleep(1000);
		// 跳转表单
		this.driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='loginDiv']/iframe")));
		// 输入用户名
		this.driver.findElement(By.name("email")).sendKeys(username);
		// 输入密码
		this.driver.findElement(By.name("password")).sendKeys(password);
		// 点击登录
		this.driver.findElement(By.id("dologin")).click();

	}
}
