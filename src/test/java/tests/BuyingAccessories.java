package tests;

import com.codeborne.selenide.Selenide;
import helpers.TestHelpers;
import helpers.UserLogin;
import helpers.UserRegistration;
import org.junit.jupiter.api.Test;
import pages.AccessoriesPage;
import pages.FrontPage;
import pages.PersonalInfoPage;
import pages.RegistrationPage;
import static helpers.TestHelpers.BASE_URL;
import static com.codeborne.selenide.Selenide.*;


public class BuyingAccessories {
        @Test
        public void testBuyAccessories() {
            FrontPage fp = new FrontPage();
            RegistrationPage rp = new RegistrationPage();
            AccessoriesPage ap = new AccessoriesPage();
            TestHelpers th = new TestHelpers();
            UserRegistration ur = new UserRegistration();
            UserLogin ul = new UserLogin();
            PersonalInfoPage pi = new PersonalInfoPage();

            open(BASE_URL);
            fp.switchToMainFrame();
            fp.clickSignInButton();
            rp.clickCreateAccountButt();
            ur.registerUser();
            fp.checkUserTestInitials();
            ap.clickAccessoriesTab();
            ap.clickAccessoriesArrow();
            ap.clickHomeAccessories();
            ap.clickPriceArrow();
            ap.moveRightRoll(-144);
            ap.moveLeftRoll(32);
            ap.checkFilterResults();
            Selenide.sleep(3000);
            ap.checkPrices();
            ap.scrollToProduct();
            ap.addSomeRandomItems();
            ap.clickAddToCartButton();
            ap.checkQuantity();
            ap.clickContinueShopping();
            ap.addSomeRandomItems();
            ap.clickAddToCartButton();
            ap.checkPrice();
            ap.clickProceedModule();
            ap.assertSummarySumm();
            ap.clickProceedToCheckOut();
            pi.addressFieldInput();
            pi.postCodeInput();
            pi.cityInput();
            pi.clickContinueButton();
            pi.selectDeliveryOption2();
            pi.clickContinueToPayment();
            pi.selectPayOptionChck();
            pi.checkTermsAndConditions();
            pi.checkSummFinalCheck();
            pi.clickPlaceOrderButt();
            pi.checkOrderSuccess();
            pi.clickSignOut();
            fp.clickSignInButton();
        }

    }

