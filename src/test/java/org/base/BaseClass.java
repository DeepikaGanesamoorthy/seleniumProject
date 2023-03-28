package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public static void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
public static void launchUrl(String Url) {
	driver.get(Url);
}
public static void Windowmaximize() {
	driver.manage().window().maximize();
}
public static void GetTitle() {
String title = driver.getTitle();
System.out.println(title);
}
public static String PageUrl() {
String Url = driver.getCurrentUrl();
return Url;
}
public static void Passtext(String txt,WebElement ele) {
ele.sendKeys(txt);
}
public static void closeEntireBrowser() {
driver.quit(); 
}
public static void clickBtn(WebElement ele) {
ele.click();
}
public static void screenShot(String imageName)throws IOException {
TakesScreenshot ts=(TakesScreenshot)driver;
File screenshot = ts.getScreenshotAs(OutputType.FILE);
File f=new File("location+imageName.png");
FileUtils.copyFile(screenshot, f);
}
public static Actions a;
public static void MoveTheCursor(WebElement ele) {
 a.moveToElement(ele).perform();
}
public static void DragDrop(WebElement drag,WebElement drop) {
a.dragAndDrop(drag, drop).perform();
}
public static JavascriptExecutor js;
public static void ScrollThePage(WebElement ele) {
js.executeScript("arguments[0].scrollIntoView(false)", ele);
}
public static void Scroll(WebElement ele) {
js.executeScript("arguments[0].scrollIntoView(true)", ele);
}
public static void excelRead(String sheet,int rownum,int cellnum)throws IOException {
File f=new File("excel location.xlsx");
FileInputStream fi=new FileInputStream(f);
Workbook wb=new XSSFWorkbook(fi);
Sheet sh= wb.getSheet(sheet);
   Row ro = sh.getRow(rownum);
   Cell ce = ro.getCell(cellnum);
   int cellType = ce.getCellType();
   String value= "  ";
   if (cellType==1) {
	String stringCellValue = ce.getStringCellValue();
}
   else if (DateUtil.isCellDateFormatted(ce)) {
	Date dateCellValue = ce.getDateCellValue();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
	String format = sdf.format(dateCellValue);
}
   else {
	double numericCellValue = ce.getNumericCellValue();
	long l=(long)numericCellValue;
	String valueOf = String.valueOf(l);	
}
}
public static void createNewExcelFile(int rownum,int cellnum,String writedata)throws IOException{
	File f=new File("C:\\Users\\ADMIN\\eclipse-workspace\\sample\\excel//newfile.xlsx");
	Workbook wb=new XSSFWorkbook();
	Sheet sh= wb.createSheet("data");
	   Row ro = sh.createRow(rownum);
	   Cell ce = ro.createCell(cellnum);
	   ce.setCellValue(writedata);
	   FileOutputStream fio=new FileOutputStream(f);
	   wb.write(fio);		
}
public static void updateParticularCell(int getrow,int getcell,String exsistdata,String writenewdata) throws IOException {
	File f=new File(" C:\\Users\\ADMIN\\eclipse-workspace\\sample\\excel");
	FileInputStream fi=new FileInputStream(f);
	Workbook wb=new XSSFWorkbook(fi);
	Sheet sh= wb.getSheet("data");
	   Row ro = sh.getRow(getrow);
	   Cell ce = ro.getCell(getcell);
	   String stringCellValue = ce.getStringCellValue();
	   if (stringCellValue.equals(exsistdata)) {
		ce.setCellValue(writenewdata);
	}
	   FileOutputStream fio=new FileOutputStream(f);
	   wb.write(fio);
	   }
public static void createRow(int creRow,int crecell,String writenewdata) throws IOException {
	File f=new File("C:\\Users\\ADMIN\\eclipse-workspace\\sample\\excel\\newfile.xlsx");
	FileInputStream fis=new FileInputStream(f);
	Workbook wb=new XSSFWorkbook(fis);
	Sheet sh= wb.getSheet("data");
	   Row ro = sh.createRow(creRow);
	   Cell ce = ro.createCell(crecell);
	   ce.setCellValue(writenewdata);
	   FileOutputStream fio=new FileOutputStream(f);
	   wb.write(fio);		
}
public static void createCell(int rownum,int cellnum,String value ) throws IOException {
File f=new File("C:\\Users\\ADMIN\\eclipse-workspace\\sample\\excel\\newfile.xlsx");
FileInputStream fi=new FileInputStream(f); 
Workbook wb=new XSSFWorkbook(fi);
Sheet sh = wb.getSheet("data");
Row ro = sh.getRow(rownum);
Cell ce = ro.createCell(cellnum);
ce.setCellValue(value);
FileOutputStream fos=new FileOutputStream(f);
wb.write(fos);
}
}
