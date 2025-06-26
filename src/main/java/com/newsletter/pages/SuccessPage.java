package com.newsletter.pages;

import com.newsletter.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage extends BasePage {

    @FindBy(className = "dismiss-btn")
    private WebElement dismissButton;

    public SuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return isElementDisplayed(dismissButton);
    }

    public void clickDismiss() {
        click(dismissButton);
    }

    public void hoverOverDismiss() {
        hover(dismissButton);
    }

    public String getDismissButtonBackgroundColor() {
        return getCssValue(dismissButton, "background-color");
    }
}
