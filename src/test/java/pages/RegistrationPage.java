package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

   private final SelenideElement maleRadio = $("#field-id_gender_1");
    public void selectMale() {maleRadio.click();}

    private final SelenideElement firstNameField = $("#field-firstname");
    public void typeFirstName(String firstName) {firstNameField.setValue(firstName);}

    private final SelenideElement lastNameField = $("#field-lastname");
    public void typeLastName(String lastName) {lastNameField.setValue(lastName);}

    private final SelenideElement emailField = $("#field-email");
    public void typeEmail(String email) {emailField.setValue(email);}


    private final SelenideElement passwordField = $("#field-password");
    public void typePassword(String password) {passwordField.setValue(password);}

    private final SelenideElement progress = $(".progress-bar.bg-success");
    public void checkProgress() {
        Selenide.sleep(5000);
        progress.scrollIntoCenter();
        progress.shouldBe(visible, Duration.ofSeconds(15000));}

    private final SelenideElement createAccountButt = $(".btn.btn-outline-primary");
    public void clickCreateAccountButt() {createAccountButt.click();}


    private final SelenideElement privacyCheckbox = $("#field-customer_privacy");
    public void checkPrivacyCheckbox() {
        Selenide.sleep(5000);
        privacyCheckbox.scrollIntoCenter();
        Selenide.sleep(1000);
        privacyCheckbox.click();}



    private final SelenideElement gdprCheckbox = $(".form-check-label.required");
    public void checkGdprCheckbox() {
        Selenide.sleep(5000);
        gdprCheckbox.scrollIntoCenter();
        Selenide.sleep(1000);
        gdprCheckbox.click();}



    public final SelenideElement createAccountFinalButt = $(".btn.btn-primary.form-control-submit");
    public void clickCreateAccount() {
        createAccountFinalButt.click();}

    private final SelenideElement loginButton = $("#submit-login");
    public void clickLoginButton() {loginButton.click();}












}
