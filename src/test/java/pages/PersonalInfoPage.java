package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersonalInfoPage {


    private final SelenideElement addressField = $("#field-address1");
    public void addressFieldInput() {
        addressField.scrollIntoCenter();
        addressField.setValue("Test Street 25");
    }

    private final SelenideElement postCode = $("#field-postcode");
    public void postCodeInput() {
        postCode.scrollIntoCenter();
        postCode.setValue("12345");
    }

    private final SelenideElement cityInput = $("#field-city");
    public void cityInput() {
        cityInput.scrollIntoCenter();
        cityInput.setValue("Paris");
    }

    private final ElementsCollection continueButt = $$(".btn.btn-primary");
    public void clickContinueButton () {

        Selenide.sleep(1000);
        continueButt.findBy(text("Continue")).scrollIntoCenter();
        Selenide.sleep(1000);
        continueButt.findBy(text("Continue")).scrollIntoCenter();
        continueButt.findBy(text("Continue")).click();
    }

    private final SelenideElement deviveryOption2 = $("#delivery_option_2");
    public void selectDeliveryOption2() {
        deviveryOption2.shouldBe(visible, Duration.ofSeconds(10)).click();
    }


    private final SelenideElement continueToPayment = $(".btn.btn-primary.w-100.w-md-auto");
    public void clickContinueToPayment() {

        Selenide.sleep(1000);
        continueToPayment.scrollIntoCenter();
        Selenide.sleep(1000);
        continueToPayment.scrollIntoCenter();
        continueToPayment.click();
    }

    private final ElementsCollection payOptions = $$(".payment-option__label.form-check-label");
    public void selectPayOptionChck () {payOptions.findBy(text("Pay by Check")).click();

    }

        private final SelenideElement termsAndConditions = $(".js-terms.form-check-label");
    public void checkTermsAndConditions() {
        Selenide.sleep(1000);
        termsAndConditions.scrollIntoCenter();
        Selenide.sleep(1000);
        termsAndConditions.scrollIntoCenter();
        termsAndConditions.click();
    }

    private final ElementsCollection placeOrderButt = $$(".btn.btn-primary");
    public void clickPlaceOrderButt (){
        placeOrderButt.findBy(text("Place order")).scrollIntoCenter();
        placeOrderButt.findBy(text("Place order")).scrollIntoCenter();
        placeOrderButt.findBy(text("Place order")).click();
    }


    String sumFinal = "€113.40";
    private final SelenideElement sumFinalCheck = $(".cart-summary__value");
    public void checkSummFinalCheck () {
        sumFinalCheck.shouldBe(visible);
        sumFinalCheck.shouldHave(exactText(sumFinal));
        System.out.println("Summ: " + sumFinalCheck.getText());

    }

    private final SelenideElement orderSuccessTitle = $(".page-title-section");
    private final SelenideElement payByCheckCheck = $(".h3.card-subtitle.text-secondary.mb-3");
    private final SelenideElement finalPaidSum = $(".order-confirmation__line-value");

    public void checkOrderSuccess() {
        orderSuccessTitle.shouldHave(text("Your order is confirmed"));
        payByCheckCheck.shouldBe(visible);
        finalPaidSum.scrollIntoCenter();
        finalPaidSum.shouldHave(text(sumFinal));
    }


    private final SelenideElement nameTitleHeader = $(".header-block__title.d-lg-inline.d-none");
    private final SelenideElement dropDownOptionsSignout = $$(".dropdown-item").get(5);

    public void clickSignOut() {
        nameTitleHeader.click();
        dropDownOptionsSignout.click();
    }
}
