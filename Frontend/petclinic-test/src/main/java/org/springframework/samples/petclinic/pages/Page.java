package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;

public abstract class Page {

    protected WebDriver driver;
    private final String TITLE_TAG = "h2";
    private final String title;


    protected Page(String title, WebDriver driver) {
        this.driver = driver;
        this.title = title;
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public boolean isCurrentUrl(String url) {
        return url.equals(driver.getCurrentUrl());
    }


    public boolean isCurrent() {
        return title.equals(driver.findElement(tagName(TITLE_TAG)).getText());
    }

    protected void goTo(String url) {
        driver.get(url);
    }

    protected void cssClick(String path) {
        driver.findElement(cssSelector(path)).click();
    }

    protected String getText(String cssPath) {
        return driver.findElement(xpath(cssPath)).getText();
    }


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

    protected void clearField(String cssPath) {
        driver.findElement(cssSelector(cssPath)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    protected void selectFirst(String id) {
        new Select(driver.findElement(id(id))).selectByIndex(1);
    }


    protected void select(String id, int i) {
        new Select(driver.findElement(id(id))).selectByIndex(i - 1);
    }

    protected List<WebElement> getElements(String xPath) {
        implicitlyWait(2);
        return driver.findElements(xpath(xPath));
    }

    protected void click(String id) {
        waitFor(id).click();
    }

    private WebElement waitFor(String id) {
        return waitFor(id, 5);
    }

    private WebElement waitFor(String id, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(id(id)));
    }

    private WebElement cssWaitFor(String cssPath) {
        return cssWaitFor(cssPath, 5);
    }

    private WebElement cssWaitFor(String cssPath, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(cssSelector(cssPath)));
    }

    protected void implicitlyWait(int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    protected boolean exists(String id) {
        return driver.findElement(id(id)) != null;
    }

    protected void refresh() {
        driver.navigate().refresh();
    }

    public boolean isErrorShowing(String className,String errorMsg)
    {
        return errorMsg.equals(driver.findElement(className(className)).getText());
    }


}
