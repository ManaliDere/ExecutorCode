package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmail {

	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       /*driver.get("https://accounts.google.com/");
       driver.findElement(By.id("identifierId")).sendKeys("manalidere123");
       driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("mahendrasangita");
       driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
       System.out.println("Gmail started");*/
       
       
       driver.get("http://toolsqa.com/automation-practice-table/");
       WebElement ele = driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr/td[contains(text(),'Mecca')]"));
	   JavascriptExecutor js = (JavascriptExecutor) driver; 
	   js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
	   
	   WebElement ele1 = driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr/td[contains(text(),'601')]"));
	   JavascriptExecutor js1 = (JavascriptExecutor) driver; 
	   js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele1);
	   
	   driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr[2]/td[6]/a")).click();
	   
	   System.out.println("HIIIIII");
	   driver.close();

	} 
       


       	}


