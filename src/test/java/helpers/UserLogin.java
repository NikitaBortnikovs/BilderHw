package helpers;

import pages.RegistrationPage;

import static helpers.TestUsers.passNbort1;
import static helpers.TestUsers.userNbort1;

public class UserLogin {
    RegistrationPage rp = new RegistrationPage();

    public void loginUser() {
        rp.typeEmail(userNbort1);
        rp.typePassword(passNbort1);
        rp.clickLoginButton();
    }
}