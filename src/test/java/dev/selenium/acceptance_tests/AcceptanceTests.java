package dev.selenium.acceptance_tests;

import dev.selenium.pageobjects.ForgottenPasswordPage;
import dev.selenium.pageobjects.HomePage;
import dev.selenium.pageobjects.SignInPage;
import dev.selenium.pageobjects.VerificationChallengeIframePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Objects;

public class AcceptanceTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.zilch.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testNavigationBarOptions() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();

        homePage.hoverOverMenuItem(3);

        assert homePage.getPayOver6WeeksElement().isDisplayed();
        assert homePage.getPayOver3MonthsElement().isDisplayed();
        assert homePage.getPayNowElement().isDisplayed();

        homePage.getPayOver6WeeksElement().click();

        String currentUrl = driver.getCurrentUrl();
        assert Objects.equals(currentUrl, "https://www.zilch.com/uk/pay-over-6-weeks/");
    }

    @Test
    public void testSignInForm() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
        VerificationChallengeIframePage verificationChallengeIframePage = new VerificationChallengeIframePage(driver);
        homePage.acceptCookies();
        homePage.signIn();

        signInPage.clickForgotPasswordLink();

        String currentUrl = driver.getCurrentUrl();
        assert currentUrl != null;
        assert currentUrl.matches("https://customers\\.payzilch\\.com/forgot_password\\?cookie=.*");

        forgottenPasswordPage.clickBackToSignInLink();
        signInPage.emailInput().sendKeys("hello@yahoo.com");
        signInPage.enterPassword();
        signInPage.clickSignInButton();

        // switch to iframe
        signInPage.switchToiFrame();

        verificationChallengeIframePage.verificationChallengeCloseButton();

        // switch back to main content
        driver.switchTo().defaultContent();

        assert signInPage.emailInput().isDisplayed();
    }
}