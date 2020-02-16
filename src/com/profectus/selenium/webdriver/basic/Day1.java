package com.profectus.selenium.webdriver.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day1 {

    public Day1() {
        init();
    }

    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;

    private void init() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/jackyzhu/workspace/selenium/driver/chromedriver");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invokeBrowser() {

        driver.get("https://www.amazon.com.au/");

    }

    public void searchItem() {

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("nav-input")).click();
        javascriptExecutor = (JavascriptExecutor)driver;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        javascriptExecutor.executeScript("scroll(10,4000)");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[=(text(),'2')]"));

    }

    public void close() {
        driver.close();
    }

    public static void main(String[] args) {

        Day1 myObj = new Day1();
        myObj.invokeBrowser();
        myObj.searchItem();
        myObj.close();

    }

}
