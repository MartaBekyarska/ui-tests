package dev.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private final Wait<WebDriver> wait;
    private final WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void clickForgotPasswordLink() {
        WebElement forgottenPasswordLinkElement = wait
            .until(
                ExpectedConditions
                    .elementToBeClickable(
                        By
                            .xpath("//a[contains(@class, 'btn-link')]")
                    )
            );
        forgottenPasswordLinkElement.click();
    }
    public WebElement emailInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-field")));
    }

    public void enterPassword() {
        WebElement passwordInput = driver.findElement(By.id("password-field"));
        passwordInput.sendKeys("password");
    }

    public void clickSignInButton() throws InterruptedException {
        WebElement signInButton = driver.findElement(By.id("log-in-button"));
        signInButton.isEnabled();
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        Thread.sleep(5000); // I know it's a bad practice but the sign in button is not active for a few seconds
        signInButton.click();
    }

    public void switchToiFrame() {
        wait
            .until(
                ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Verification challenge']")
                    )
            );
    }
}