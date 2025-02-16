package dev.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void acceptCookies() {
        WebElement button = wait
            .until(
                ExpectedConditions
                    .elementToBeClickable(
                        By
                            .cssSelector("button[data-cky-tag='accept-button']")
                    )
            );
        button.click();
    }

    public void signIn() {
        WebElement signInButton = driver.findElement(By.cssSelector("a[class='btn pz-direct signin']"));
        signInButton.click();
    }

    public void hoverOverMenuItem(int index) {
        WebElement listItem = driver.findElement(By.cssSelector("li.refresh-menu-item:nth-of-type(" + index + ")"));
        listItem.click();
    }

    public WebElement getPayOver6WeeksElement() {
        return wait
            .until(
                ExpectedConditions
                    .visibilityOfElementLocated(
                        By
                            .xpath("//li[@class='split-item' and text()='Pay over 6 weeks']")
                    )
            );
    }

    public WebElement getPayOver3MonthsElement() {
        return wait
            .until(
                ExpectedConditions
                    .visibilityOfElementLocated(
                        By.xpath("//li[@class='split-item' and text()='Pay over 3 months']")
                    )
            );
    }

    public WebElement getPayNowElement() {
        return wait
            .until(
                ExpectedConditions
                    .visibilityOfElementLocated(
                        By.xpath("//li[@class='split-item' and text()='Pay now']")
                    )
            );
    }
}