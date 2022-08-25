package stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    // Верхнее меню - логотип
    @FindBy(how = How.XPATH, using = "//div/header/nav/div/a[@href='/']")
    private SelenideElement stellarBurgersLogo;

    // Верхний заголовок - ссылка "Личный кабинет"
    @FindBy(xpath = "//div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement headerLinkPersonalCabinet;

    // Форма регистрации - надпись "Регистрация"
    @FindBy(xpath = "//div/main/div/h2[text()='Регистрация']")
    private SelenideElement titleRegistration;

    // Форма регистрации - поле для ввода имени
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input[@name = 'name']")
    private SelenideElement fieldName;

    // Форма регистрации - поле для ввода email
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[2]/div/div/input[@name = 'name']")
    private SelenideElement fieldEmail;

    // Форма регистрации - поле для ввода пароля
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[3]/div/div/input[@name = 'Пароль']")
    private SelenideElement fieldPassword;

    // Форма регистрации - кнопка "Зарегистрироваться"
    @FindBy(xpath = "/html/body/div/div/main/div/form/button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement buttonRegister;

    // Форма регистрации - сообщение "Некорректный пароль"
    @FindBy(xpath = "//div/main/div/form/fieldset[3]/div/p[@class='input__error text_type_main-default']")
    private SelenideElement wrongPasswordErrorMessage;

    // Нижный залоговок - ссылка "Войти"
    @FindBy(xpath = "//div/main/div/div/p/a[@href='/login']")
    private SelenideElement linkEnter;

    // Заполнить поля формы регистрации и нажать кнопку "Зарегистрироваться"
    public void fillFieldsAndButtonClickRegistration(String userName, String userEmail, String userPassword) {
        fieldName.setValue(userName);
        fieldEmail.setValue(userEmail);
        fieldPassword.setValue(userPassword);
        buttonRegister.click();
    }

    // Нажать на ссылку "Личный кабинет"
    public void headerLinkPersonalCabinetClick() {
        headerLinkPersonalCabinet.click();
    }

    // Нажать на логотип StellarBurgers
    public void stellarBurgersLogoClick() {
        stellarBurgersLogo.click();
    }

    // Нажать ссылку "Войти"
    public void linkEnterClick() { linkEnter.click();
    }

    public SelenideElement getTitleRegistration() {
        return titleRegistration;
    }

    public void setTitleRegistration(SelenideElement titleRegistration) {
        this.titleRegistration = titleRegistration;
    }

    public SelenideElement getFieldName() {
        return fieldName;
    }

    public void setFieldName(SelenideElement fieldName) {
        this.fieldName = fieldName;
    }

    public SelenideElement getFieldEmail() {
        return fieldEmail;
    }

    public void setFieldEmail(SelenideElement fieldEmail) {
        this.fieldEmail = fieldEmail;
    }

    public SelenideElement getFieldPassword() {
        return fieldPassword;
    }

    public void setFieldPassword(SelenideElement fieldPassword) {
        this.fieldPassword = fieldPassword;
    }

    public SelenideElement getButtonRegister() {
        return buttonRegister;
    }

    public void setButtonRegister(SelenideElement buttonRegister) {
        this.buttonRegister = buttonRegister;
    }

    public SelenideElement getWrongPasswordErrorMessage() {
        return wrongPasswordErrorMessage;
    }

    public void setWrongPasswordErrorMessage(SelenideElement wrongPasswordErrorMessage) {
        this.wrongPasswordErrorMessage = wrongPasswordErrorMessage;
    }

    public SelenideElement getStellarBurgersLogo() {
        return stellarBurgersLogo;
    }

    public void setStellarBurgersLogo(SelenideElement stellarBurgersLogo) {
        this.stellarBurgersLogo = stellarBurgersLogo;
    }

    public SelenideElement getHeaderLinkPersonalCabinet() {
        return headerLinkPersonalCabinet;
    }

    public void setHeaderLinkPersonalCabinet(SelenideElement headerLinkPersonalCabinet) {
        this.headerLinkPersonalCabinet = headerLinkPersonalCabinet;
    }

    public SelenideElement getLinkEnter() {
        return linkEnter;
    }

    public void setLinkEnter(SelenideElement linkEnter) {
        this.linkEnter = linkEnter;
    }
}
