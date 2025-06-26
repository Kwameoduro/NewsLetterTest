package com.newsletter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.newsletter.pages.HomePage;
import com.newsletter.pages.SuccessPage;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NewsletterTest {

    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://kwamenewsletter.vercel.app/");
        homePage = new HomePage(driver);
    }

    @Test
    @Order(1)
    public void testValidEmailSubmissionAndDismissButton() {
        homePage.enterEmail("test@example.com");
        homePage.clickSubscribe();

        SuccessPage successPage = new SuccessPage(driver);
        Assertions.assertTrue(successPage.isLoaded(), "Success page should be visible.");

        // Test dismiss button returns to homepage
        successPage.clickDismiss();
        homePage = new HomePage(driver); //
        Assertions.assertTrue(homePage.isOnHomePage(), "Should return to homepage and see heading 'Stay updated!'");
    }

    @Test
    @Order(2)
    public void testInvalidEmailShowsError() {
        homePage.enterEmail("invalid-email");
        homePage.clickSubscribe();

        Assertions.assertTrue(homePage.isErrorVisible(), "Error message should appear.");
        Assertions.assertEquals("Valid email required", homePage.getErrorText());

    }

    @Test
    @Order(3)
    public void testSubscribeButtonHoverEffect() {
        String beforeHover = homePage.getSubscribeButtonBackgroundColor();
        homePage.hoverOverSubscribe();
        String afterHover = homePage.getSubscribeButtonBackgroundColor();

        Assertions.assertNotEquals(beforeHover, afterHover, "Subscribe button color should change on hover.");
    }

    @Test
    @Order(4)
    public void testDismissButtonHoverEffect() {
        homePage.enterEmail("test@example.com");
        homePage.clickSubscribe();

        SuccessPage successPage = new SuccessPage(driver);
        Assertions.assertTrue(successPage.isLoaded());

        String beforeHover = successPage.getDismissButtonBackgroundColor();
        successPage.hoverOverDismiss();
        String afterHover = successPage.getDismissButtonBackgroundColor();

        Assertions.assertNotEquals(beforeHover, afterHover, "Dismiss button color should change on hover.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}