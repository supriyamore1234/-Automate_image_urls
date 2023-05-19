package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
///
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    // book my show
    public void testCase05() throws InterruptedException {

        // go to book my show
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // find list web element for recommended movie limks Using Locator "XPath"
        // div[@class='sc-lnhrs7-2 eQezya']/div/a

        Thread.sleep(5000);
        List<WebElement> recommendedMovieList = driver
                .findElements(By.xpath("//div[contains(@class,'sc-lnhrs7-2 eQezya')]//img"));
        Thread.sleep(4000);

        System.out.println("List Size is :" + recommendedMovieList.size());
        List<String> ss = new ArrayList<>();
        // use for each loop for web elements above list
        for (WebElement iterable_element : recommendedMovieList) {
            String aa = iterable_element.getAttribute("src").toString();
            ss.add(aa);

        }
        for (int i = 0; i < ss.size(); i++) {
            System.out.println("Print urls" + ss.get(i));
        }
        Thread.sleep(3000);
        // Print Name & Language of the 2nd item in the “Premiere” list
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        // js.executeSc.ript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> premiersmovielist = driver.findElements(
                By.xpath("//div[@class='sc-lnhrs7-2 iHQrlw']//div[contains(@class,'sc-7o7nez-0 fyTNyu')]"));
        Thread.sleep(5000);
        String Secondpremiermovie = premiersmovielist.get(1).getText();
        System.out.println("Name of Second Premium Movie is :" + Secondpremiermovie);

        List<WebElement> language = driver.findElements(
                By.xpath("//div[@class='sc-lnhrs7-2 iHQrlw']//div[contains(@class,'sc-7o7nez-0 eeVqLW')]"));
        String lanuageMovie = language.get(1).getText();
        System.out.println("Language for econd premier movie is :" + lanuageMovie);
    }

    public void testCase06() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftframe = driver.findElement(By.xpath("//body"));
        System.out.println("Print left frame : " + leftframe.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleframe = driver.findElement(By.tagName("body"));
        System.out.println("Print middle frame name : " + middleframe.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightframe = driver.findElement(By.tagName("body"));
        System.out.println("Print Right frame : " + rightframe);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomframe = driver.findElement(By.tagName("body"));
        System.out.println("Print botto frame : " + bottomframe.getText());
    }
}
