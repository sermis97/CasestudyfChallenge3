package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class  BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//form[contains(@class,'air-cart__line-quantity air-cart-controller air-js-dg-controller')]")
    public WebElement addcart;

    @FindBy(xpath = "//form[@class='air-cart__line-quantity air-cart-controller air-js-poe-controller']//input[@name='add']")
    public WebElement poePlusButton;

    @FindBy(xpath ="//form[@class='air-cart__line-quantity air-cart-controller air-js-dg-controller']//input[@name='add']")
    public WebElement plusButton;

    @FindBy(xpath = "//form[contains(@class,'air-cart__line-quantity air-cart-controller air-js-poe-controller')]//input[contains(@name,'submit')]")
    public WebElement poeAddCart;


    @FindBy(xpath ="//input[@value='Update']")
    public WebElement updateButton;

    @FindBy(xpath =" //div[@data-air-test='total_cost']")
    public WebElement totalCost;

    @FindBy(css = ".air-cart__line-title.js-product-title")
    public WebElement productTitleinTheCart;

    @FindBy(xpath = "//div[@class='air-cart__line-subtotal']")
    public WebElement subtotal;

    @FindBy(xpath = "//span[normalize-space()='Buy now']")
    public WebElement buyNow;






}
