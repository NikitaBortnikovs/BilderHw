package helpers;

import pages.RegistrationPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static java.lang.Thread.sleep;

public class UserRegistration {
    RegistrationPage rp = new RegistrationPage();
    public void registerUser() {
        rp.selectMale();
        rp.typeFirstName("Nikita");
        rp.typeLastName("TestUser");
        rp.typeEmail(TestHelpers.generateEmail());
        rp.typePassword("AKDJFWFM4215!");
        rp.checkProgress();
        rp.createAccountFinalButt.scrollIntoCenter();
        rp.checkGdprCheckbox();
        rp.checkPrivacyCheckbox();
        rp.clickCreateAccount();
    }

}
