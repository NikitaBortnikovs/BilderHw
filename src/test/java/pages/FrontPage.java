package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class FrontPage {


    private final SelenideElement signInButton = $(".d-none.d-md-inline.header-block__title");
    public void clickSignInButton() {
        signInButton.shouldHave(text("Sign in"));
        signInButton.shouldBe(visible).click();
    }


    private final SelenideElement mainFrame = $("#framelive");
    public void switchToMainFrame() {
        switchTo().frame(mainFrame);
    }

    private final SelenideElement User1Initials = $(".header-block__title.d-lg-inline.d-none");
    public void checkUser1Initials() {
        User1Initials.shouldHave(text("TEST TEST"));

    }
    private final SelenideElement UserTestInitials = $(".header-block__title.d-lg-inline.d-none");
    public void checkUserTestInitials() {
        User1Initials.shouldHave(text("Nikita TestUser"));

    }




}

