package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccessoriesPage {

    private final SelenideElement accessoriesTab = $$(".ps-mainmenu__tree-link").findBy(exactText("Accessories"));
    public void clickAccessoriesTab() {accessoriesTab.shouldBe(visible).click();
    }

    private final SelenideElement accessoriesArrow = $$(".accordion-button.collapsed").get(1);
    public void clickAccessoriesArrow() {accessoriesArrow.shouldBe(visible).click();
    }

    private final SelenideElement priceArrow = $$(".accordion-button.collapsed").get(3);
    public void clickPriceArrow() {
        Selenide.sleep(2000);
        priceArrow.shouldBe(visible).click();
    }


    private final SelenideElement homeAccessories = $$(".category-tree__item-link").findBy(exactText("Home Accessories"));
    public void clickHomeAccessories() {homeAccessories.shouldBe(visible).click();
    }
    public void getToHomeAccessories() {
        clickAccessoriesTab();
        clickAccessoriesArrow();
        clickHomeAccessories();
    }

    private final SelenideElement leftPriceRoll = $(".noUi-handle.noUi-handle-lower");

    public void moveLeftRoll(int pixels) {
        Selenide.sleep(2000);

        actions().dragAndDropBy(leftPriceRoll, pixels, 0).perform();}

    private final SelenideElement rightPriceRoll = $(".noUi-handle.noUi-handle-upper");
    public void moveRightRoll(int pixels) {
        rightPriceRoll.scrollIntoCenter();
        Selenide.sleep(2000);
        actions().dragAndDropBy(rightPriceRoll, pixels, 0).perform();}

    public void setPriceRange() {
        Selenide.sleep(2000);
        priceArrow.shouldBe(visible).click();
        moveRightRoll(-144);
        moveLeftRoll(32);
        checkFilterResults();
        Selenide.sleep(3000);}

    private final SelenideElement filterResults = $(".search-filters__slider-values.js-faceted-values");
    public void checkFilterResults() {filterResults.shouldBe(visible).shouldHave(text("€18.05 - €23.76"));}

    private final ElementsCollection prices = $$(".product-miniature__price");

    public void checkPrices() {
        for (SelenideElement price : prices) {
            double value = Double.parseDouble(
                    price.getText()
                            .replace("€", "")
                            .replace(",", ".")
                            .trim());
            System.out.println(value);
            assertTrue(value > 18 && value < 24);
        }
    }

    int randomNumber = new Random().nextInt(3);
    private final SelenideElement randomAddAnotherItem = $$(".btn.increment.btn-square-icon.js-increment-button").get(randomNumber);
    public void addSomeRandomItems() {
        Selenide.sleep(3000);
        randomAddAnotherItem.click();
        randomAddAnotherItem.scrollIntoCenter();}



    private final SelenideElement addToCartButton = $$(".product-miniature__add.btn.btn-primary.btn-square-icon").get(randomNumber);
    public void clickAddToCartButton() {
        addToCartButton.scrollIntoCenter();
        addToCartButton.click();}

    private final SelenideElement price = $(".blockcart-modal__total.blockcart-modal__total--bold");
    public void checkPrice() {price.shouldHave(text("€113.40"));}

    private final SelenideElement addToCartButton1 = $$(".product-miniature__add.btn.btn-primary.btn-square-icon").get(0);
    public void scrollToProduct() {addToCartButton1.scrollIntoCenter();}

    private final SelenideElement quantity = $(".blockcart-modal__quantity.d-none.d-lg-block");
    public void checkQuantity() {quantity.shouldHave(text("2"));}

    private final SelenideElement continueShoppingButt = $(".btn.btn-outline-primary.btn-with-icon");
    public void clickContinueShopping() {continueShoppingButt.click();}

    private final SelenideElement proceedToCheckOut = $(".btn.btn-primary.btn-lg");
    public void clickProceedToCheckOut() {
        proceedToCheckOut.shouldBe(visible, Duration.ofSeconds(10)).shouldBe(enabled);
        proceedToCheckOut.click();}

    private final SelenideElement summarySumm = $(".cart-summary__value");
    public void assertSummarySumm() {
        double sum = Double.parseDouble(
                summarySumm.getText()
                        .replace("€", "")
                        .trim());
        System.out.println(sum);
        assertEquals(113.40, sum);
    }

    private final ElementsCollection proceedToCheckModuleButt = $$(".btn.btn-primary");
    public void clickProceedModule (){
        proceedToCheckModuleButt.findBy(text("Proceed to checkout")).click();
    }






}
