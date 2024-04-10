package com.project.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper  {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isElementPresents(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());

        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public int sizeOfItemInShoppinCart() {
        if (isElementPresents(By.cssSelector(".quantity"))) {
            return driver.findElements(By.cssSelector(".quantity")).size();
        }
        return 0;
    }
    public void login() {
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.cssSelector("#Email"), "manuel1734usenko18@gmail.com");
        // enter password
        type(By.id("Password"), "Pochemu_to123");
        // click on login button
        click(By.cssSelector(".button-1.login-button"));
    }


}
