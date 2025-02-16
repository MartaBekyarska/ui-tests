package dev.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInForm {
    private final Wait<WebDriver> wait;
    private final WebDriver driver;

    public SignInForm(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        this.driver = driver;
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

    public void clickBackToSignInLink() {
        WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("forgot-password-login-link")));
        forgotPasswordLink.click();
    }


    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys(email);
    }
}