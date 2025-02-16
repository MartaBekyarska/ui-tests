package dev.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgottenPasswordPage {
    private final Wait<WebDriver> wait;

    public ForgottenPasswordPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void clickBackToSignInLink() {
        WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("forgot-password-login-link")));
        forgotPasswordLink.click();
    }
}