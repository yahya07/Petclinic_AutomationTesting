package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    private final WebDriver driver;
    private String title;

    protected Page(String title) {
        this.driver = new ChromeDriver();
        this.title = title;
    }


    public boolean isCurrent() {
        return title.equals(driver.getTitle());
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
}
