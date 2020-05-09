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

    protected final WebDriver driver;
    private String title;
    private final String TITLE_TAG = "h2";

    protected Page( String title) {
        this.driver = new ChromeDriver();
        this.title = title;
    }


    public void closeBrowser()
    {
        driver.close();
        driver.quit();
    }


    public boolean isCurrent() {
        return title.equals(driver.findElement(By.tagName(TITLE_TAG)).getText());
    }

    protected void goTo(String url) {
        driver.get(url);
    }

    protected void cssClick(String path) {
        driver.findElement(By.cssSelector(path)).click();
    }

    protected String getText(String cssPath) {
        return driver.findElement(By.xpath(cssPath)).getText();
    }

    protected void fill(String id, String value) {
        final WebElement element = waitFor(id);
        element.clear();
        element.sendKeys(value);
    }

    protected void selectFirst(String id) {

        new Select(driver.findElement(By.id(id))).selectByIndex(1);

    }

    protected List<WebElement> allTableElements(String xpath)
    {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
         List<WebElement> tableElements = driver.findElements(By.xpath(xpath));
         return tableElements;
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

    protected boolean exists(String id) {
        return driver.findElement(By.id(id)) != null;
    }

    public boolean isNotRedirected(String url)
    {

        return url.equals(driver.getCurrentUrl());
    }

    protected void refresh(){
        driver.navigate().refresh();
    }
    public boolean isErrorShowing(String className,String errorMsg)
    {
        return errorMsg.equals(driver.findElement(By.className(className)).getText());
    }


}
