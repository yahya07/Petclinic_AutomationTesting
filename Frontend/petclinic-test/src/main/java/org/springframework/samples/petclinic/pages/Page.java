package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Page {

    private static final WebDriver driver = new ChromeDriver();
    private String title;
    private static final String pageHeaderXpath = "/html/body/app-root/app-pet-add/div/div/h2";


    protected Page(String title) {
        this.title = title;
    }


    public boolean isCurrent() {
        return title.equals(driver.findElement(By.xpath(pageHeaderXpath)).getText()); }

    protected void goTo(String url) {
        driver.get(url);
    }

    protected void cssClick(String path) {
        driver.findElement(By.cssSelector(path)).click();
    }

    protected String getText(String cssPath) {
        return driver.findElement(By.xpath(cssPath)).getText();
    }

    protected List<WebElement> getElements(String xPath){return driver.findElements(By.xpath(xPath));}

    protected void fill(String id, String value) {
        final WebElement element = waitFor(id);
        element.clear();
        element.sendKeys(value);
    }

    protected void cssFill(String cssPath, String value) {
        final WebElement element = cssWaitFor(cssPath);
        element.clear();
        element.sendKeys(value);
    }

    protected void selectFirst(String id) {
        new Select(driver.findElement(By.id(id))).selectByIndex(1);
    }


    protected void select(String id , int i) {
        new Select(driver.findElement(By.id(id))).selectByIndex(i-1);
    }

    protected void click(String id) {
        waitFor(id).click();
    }

    private WebElement waitFor(String id) {
        return waitFor(id, 5);
    }

    private WebElement waitFor(String id, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    private WebElement cssWaitFor(String cssPath) {
        return cssWaitFor(cssPath, 5);
    }

    private WebElement cssWaitFor(String cssPath, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssPath)));
    }

    protected void implicitlyWait(int sec){
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS) ;
    }

    protected boolean exists(String id) {
        return driver.findElement(By.id(id)) != null;
    }
}
