package dev.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerificationChallengeIframePage {
    private final Wait<WebDriver> wait;

    public VerificationChallengeIframePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void verificationChallengeCloseButton() {
        WebElement closeButton = wait
            .until(
                ExpectedConditions
                    .visibilityOfElementLocated(
                        By.cssSelector("button[aria-label='Close Arkose Labs Enforcement Challenge.']")
                    )
            );
        closeButton.click();
    }
}