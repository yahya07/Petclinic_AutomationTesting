package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.Keys.chord;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public abstract class Page {

    protected WebDriver driver;
    private final String TITLE_TAG = "h2";
    private final String title;
    private WebDriverWait wait;


    protected Page(String title, WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        this.title = title;
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public boolean isCurrentUrl(String url) {
        return url.equals(driver.getCurrentUrl());
    }

    public boolean isElementEnabled(String cssPath) {
        return driver.findElement(cssSelector(cssPath)).isEnabled();

    }

    public boolean isCurrent() {
        return title.equals(waitFor(tagName(TITLE_TAG)));
    }

    public boolean isCurrent(String cssPath,String title) {
        return title.equals(waitFor(cssSelector(cssPath)));
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
        driver.findElement(cssSelector(cssPath)).sendKeys(chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    protected void selectFirst(String id) {
        new Select(driver.findElement(id(id))).selectByIndex(1);
    }


    protected void select(String id, int i) {
        new Select(driver.findElement(id(id))).selectByIndex(i - 1);
    }

    protected List<WebElement> getElements(String xPath) {
        implicitlyWait(10);
        return driver.findElements(xpath(xPath));
    }

    protected void click(String id) {
        waitFor(id).click();
    }

    private WebElement waitFor(String id) {
        return waitFor(id, 5);
    }

    @SuppressWarnings("SameParameterValue")
    private WebElement waitFor(String id, int waitInterval) {
        return wait.until(visibilityOfElementLocated(id(id)));
    }

    private String waitFor(By by) {

        String title = null;

        do {
            try {
                title = wait.until(presenceOfElementLocated(by)).getText();
            } catch (Exception e) {
                // ignore
            }
        } while (title == null);

        return title;
    }

    protected void clearFieldForMac(String cssPath) {
        driver.findElement(cssSelector(cssPath)).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        driver.findElement(cssSelector(cssPath)).sendKeys(Keys.chord(Keys.BACK_SPACE));
    }



    private WebElement cssWaitFor(String cssPath) {
        return wait.until(presenceOfElementLocated(cssSelector(cssPath)));
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

    public boolean isErrorShowing(String className, String errorMsg) {
        return errorMsg.equals(driver.findElement(By.className(className)).getText());
    }


}

