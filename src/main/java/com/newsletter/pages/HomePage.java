package com.newsletter.pages;

import com.newsletter.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(className = "submit-btn")
    private WebElement subscribeButton;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(tagName = "h1")
    private WebElement heading;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void clickSubscribe() {
        click(subscribeButton);
    }

    public boolean isErrorVisible() {
        return isElementDisplayed(errorMessage);
    }

    public String getErrorText() {
        return getText(errorMessage);
    }

    public void hoverOverSubscribe() {
        hover(subscribeButton);
    }

    public String getSubscribeButtonBackgroundColor() {
        return getCssValue(subscribeButton, "background-color");
    }

    public boolean isOnHomePage() {
        return getText(heading).contains("Stay updated!");
    }

}
