package stellarburgers.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.CoreMatchers.equalTo;

public class MainPage {

    // Верхний заголовок - ссылка "Личный кабинет"
    @FindBy(xpath = "//div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement headerLinkPersonalCabinet;


    // Кнопка "Войти в аккаунт"/"Оформить заказ"
    @FindBy(xpath = "//div/main/section[2]/div/button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement buttonEntrance;

    // Надпись "Соберите бургер"
    @FindBy(how = How.XPATH, using = "//div/main/section[1]/h1[text()='Соберите бургер']")
    private SelenideElement titleGetBurger;

    // Ссылка "Булки"
    @FindBy(how = How.XPATH,
            using = "//div/main/section[1]/div[1]/div[1]/span[text()='Булки']")
    private SelenideElement linkBuns;

    // Ссылка "Начинки"
    @FindBy(how = How.XPATH,
            using = "//div/main/section[1]/div[1]/div[3]/span[text()='Начинки']")
    private SelenideElement linkToppings;

    // Ссылка "Соусы"
    @FindBy(how = How.XPATH,
            using = "//div/main/section[1]/div[1]/div[2]/span[text()='Соусы']")
    private SelenideElement linkSauces;

    // Активная ссылка "Начинки"
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]" +
                    "[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement activeLinkToppings;

    // Активная ссылка "Соусы"
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]" +
                    "[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement activeLinkSauces;

    // Активная ссылка "Булки"
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]" +
                    "[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement activeLinkBuns;

    // Ссылка на первый вариант начинки
    @FindBy(how = How.XPATH,
            using = "//div/main/section[1]/div[2]/ul[3]/a[1]/p[text() ='Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement firstTopping;

    // Нажать кнопку "Войти в аккаунт"/"Оформить заказ"
    public void buttonEntranceClick() {
        buttonEntrance.click();
    }

    // Нажать ссылку "Личный кабинет", перейти на форму авторизации
    @Step("Нажать ссылку \"Личный кабинет\" на главной странице")
    public LoginPage headerLinkPersonalCabinetClickWithountAuthorization() {
        // Нажать кнопку "Личный кабинет"
        headerLinkPersonalCabinet.click();
        LoginPage loginPage = Selenide.page(LoginPage.class);
        return loginPage;
    }

    // Нажать кнопку "Войти в аккаунт" на главной странцие
    // Перейти на форму профиля
    @Step("Нажать кнопку \"Войти в аккаунт\" на главной странице. Пользователь авторизирован")
    public ProfilePage headerLinkPersonalCabinetClickForAuthorizedUser() {
        // Нажать кнопку "Личный кабинет"
        headerLinkPersonalCabinet.click();
        // Создать PO для ProfilePage
        ProfilePage profilePage = Selenide.page(ProfilePage.class);
        return profilePage;
    }

    // Нажать кнопку "Войти в аккаунт" на главной странице
    // Перейти на форму авторизации
    @Step("Нажать кнопку \"Войти в аккаунт\" на главной странице. Пользователь неавторизирован")
    public LoginPage headerLinkPersonalCabinetClickForUserWithoutAuthorization() {
        // Нажать кнопку "Войти в аккаунт"
        buttonEntrance.click();
        // Создать PO для LogimPage
        LoginPage loginPage = Selenide.page(LoginPage.class);
        // Убедиться, что открылась форме входа - есть надпись "Вход"
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
        return loginPage;
    }

    @Step("Нажать ссылку \"Личный кабинет\" на главной странице")
    public void headerLinkPersonalCabinetClick() {
        headerLinkPersonalCabinet.click();
    }

    public SelenideElement getHeaderLinkPersonalCabinet() {
        return headerLinkPersonalCabinet;
    }

    public void setHeaderLinkPersonalCabinet(SelenideElement headerLinkPersonalCabinet) {
        this.headerLinkPersonalCabinet = headerLinkPersonalCabinet;
    }

    public SelenideElement getButtonEntrance() {
        return buttonEntrance;
    }

    public void setButtonEntrance(SelenideElement buttonEntrance) {
        this.buttonEntrance = buttonEntrance;
    }

    public SelenideElement getTitleGetBurger() {
        return titleGetBurger;
    }

    public void setTitleGetBurger(SelenideElement titleGetBurger) {
        this.titleGetBurger = titleGetBurger;
    }

    public SelenideElement getLinkBuns() {
        return linkBuns;
    }

    public void setLinkBuns(SelenideElement linkBuns) {
        this.linkBuns = linkBuns;
    }

    public SelenideElement getLinkToppings() {
        return linkToppings;
    }

    public void setLinkToppings(SelenideElement linkToppings) {
        this.linkToppings = linkToppings;
    }

    public SelenideElement getLinkSauces() {
        return linkSauces;
    }

    public void setLinkSauces(SelenideElement linkSauces) {
        this.linkSauces = linkSauces;
    }

    public SelenideElement getFirstTopping() {
        return firstTopping;
    }

    public void setFirstTopping(SelenideElement firstTopping) {
        this.firstTopping = firstTopping;
    }

    public SelenideElement getActiveLinkToppings() {
        return activeLinkToppings;
    }

    public void setActiveLinkToppings(SelenideElement activeLinkToppings) {
        this.activeLinkToppings = activeLinkToppings;
    }

    public SelenideElement getActiveLinkSauces() {
        return activeLinkSauces;
    }

    public void setActiveLinkSauces(SelenideElement activeLinkSauces) {
        this.activeLinkSauces = activeLinkSauces;
    }

    public SelenideElement getActiveLinkBuns() {
        return activeLinkBuns;
    }

    public void setActiveLinkBuns(SelenideElement activeLinkBuns) {
        this.activeLinkBuns = activeLinkBuns;
    }
}
