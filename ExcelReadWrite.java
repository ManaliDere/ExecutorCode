package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;


public class ExcelReadWrite {

	public static void main(String[] args) throws IOException, InterruptedException,Throwable {
  
		FileInputStream file=new FileInputStream("C:\\Manali\\Java\\Practice_Projects\\Gmail\\TestData.xls");
		HSSFWorkbook wb= new HSSFWorkbook(file);
		HSSFSheet s1= wb.getSheetAt(0);
		int no=s1.getLastRowNum();
		System.out.println(no);
		HSSFCell  un,pwd,status;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com");
		Thread.sleep(2000);
		for(int i=1;i<=no;i++)
		{
			int j=0;
			un=s1.getRow(i).getCell(j);
			pwd=s1.getRow(i).getCell(j+1);
			status=s1.getRow(i).getCell(j+4);
			if(status.getStringCellValue().isEmpty())
			{
				driver.findElement(By.id("identifierId")).sendKeys(un.toString());
				driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
				driver.findElement(By.name("password")).sendKeys(pwd.toString());
				driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
				/*System.out.println(un);
				System.out.println(pwd);*/
			
				/*i=++i;
				System.out.println("value of i is: +i" );
				break;*/
                  
				   if(driver.getTitle().equals("Primary"));
				   {
					status=s1.getRow(i).getCell(j+4);
					status.setCellValue("Login Passed");
				   }
				  	
				
				   if (driver.getPageSource().contains("Wrong password. Try again or click Forgot password to reset it."))
				  {
					status=s1.getRow(i).getCell(j+4);
					status.setCellValue("Login Failed");
					}
		
		}
		int i = 0;
		int j = 0;
		status=s1.getRow(i).getCell(j+4);
		 if((status.getStringCellValue().equals("Login Passed"))) 
		 {
			
			/*un=s1.getRow(i).getCell(j);
			pwd=s1.getRow(i).getCell(j+1);
			driver.findElement(By.id("identifierId")).sendKeys(un.toString());
			driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
			driver.findElement(By.name("password")).sendKeys(pwd.toString());
			driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();*/			
				no=no++;
				
		 }
		
					FileOutputStream fos=new FileOutputStream("C:\\Manali\\Java\\Practice_Projects\\Gmail\\TestData.xls");
		            wb.write(fos);
	}
	
	}

 
