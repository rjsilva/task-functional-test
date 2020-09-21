package br.com.web.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddTasksTest {
	
	private WebDriver driver;
	
	public WebDriver acessarAplicacao() {
		  System.setProperty("webdriver.chrome.driver","/Users/rjsilva/Downloads/chromedriver");
		  driver = new ChromeDriver();
		  driver.navigate().to("http://localhost:8001/tasks/add");
		  return driver;
	}
	
	@Test
	public void shouldSaveTask() {
		
		try {
			  driver = acessarAplicacao();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.findElement(By.id("task")).sendKeys("Selenium");
			  driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			  driver.findElement(By.id("saveButton")).click();
			  String msg = driver.findElement(By.id("message")).getText();
			  org.junit.Assert.assertEquals("Sucess!", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			  driver.quit();
		}

	}
	
	@Test
	public void shouldNotSaveTaskWithoutDescription() {
		
		try {
			  driver = acessarAplicacao();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  //driver.findElement(By.id("task")).sendKeys("Selenium");
			  driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			  driver.findElement(By.id("saveButton")).click();
			  String msg = driver.findElement(By.id("message")).getText();
			  org.junit.Assert.assertEquals("Fill the task description", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			  driver.quit();
		}

	}

	@Test
	public void shouldNotSaveTaskWithoutDate() {
		
		try {
			  driver = acessarAplicacao();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.findElement(By.id("task")).sendKeys("Selenium");
			  //driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			  driver.findElement(By.id("saveButton")).click();
			  String msg = driver.findElement(By.id("message")).getText();
			  org.junit.Assert.assertEquals("Fill the due date", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			  driver.quit();
		}

	}
	
	@Test
	public void shouldNotSaveTaskWithPastDate() {
		
		try {
			  driver = acessarAplicacao();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.findElement(By.id("task")).sendKeys("Selenium");
			  driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
			  driver.findElement(By.id("saveButton")).click();
			  String msg = driver.findElement(By.id("message")).getText();
			  org.junit.Assert.assertEquals("Due date must not be in past", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			  driver.quit();
		}

	}
}
