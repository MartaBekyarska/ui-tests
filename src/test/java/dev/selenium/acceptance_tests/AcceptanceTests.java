package dev.selenium.selenium_manager;

import dev.selenium.pageobjects.HomePage;
import dev.selenium.pageobjects.SignInForm;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Objects;

public class SeleniumManagerUsageTest {

    private WebDriver initializeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.zilch.com/");
        return driver;
    }

    @Test
    public void testNavigationBarOptions() {
        WebDriver driver = initializeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();

        homePage.hoverOverMenuItem(3);

        assert homePage.getPayOver6WeeksElement().isDisplayed();
        assert homePage.getPayOver3MonthsElement().isDisplayed();
        assert homePage.getPayNowElement().isDisplayed();

        homePage.getPayOver6WeeksElement().click();

        String currentUrl = driver.getCurrentUrl();
        assert Objects.equals(currentUrl, "https://www.zilch.com/uk/pay-over-6-weeks/");

        driver.quit();
    }

    @Test
    public void testSignInForm() {
        WebDriver driver = initializeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.signIn();

        SignInForm forgotPasswordPage = new SignInForm(driver);
        forgotPasswordPage.clickForgotPasswordLink();

        String currentUrl = driver.getCurrentUrl();
        assert currentUrl != null;
        assert currentUrl.matches("https://customers\\.payzilch\\.com/forgot_password\\?cookie=.*");

        driver.quit();
    }
}