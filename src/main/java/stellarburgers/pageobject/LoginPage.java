package stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginPage {
    // Форма авторизации - ссылка "Зарегистрироваться"
    @FindBy(xpath = "//div/main/div/div/p[1]/a[@href='/register']")
    private SelenideElement linkGoToRegistration;


    // Форма авторизации - надпись "Вход"
    @FindBy(xpath = "//div/main/div/h2[text()='Вход']")
    private SelenideElement titleEntrance;

    // Форма авторизации - поле для ввода email
    @FindBy(xpath = "//div/main/div/form/fieldset[1]/div/div/input[@type='text']")
    private SelenideElement fieldEmailAuthorization;

    // Форма авторизации - поле для ввода пароля
    @FindBy(xpath = "//div/main/div/form/fieldset[2]/div/div/input[@name = 'Пароль']")
    private SelenideElement fieldPasswordAuthorization;

    // Форма авторизации - кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//div/main/div/form/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement buttonAuthorization;

    // Форма авторизации - ссылка "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//div/main/div/div/p[2]/a[text()='Восстановить пароль']")
    private SelenideElement linkRestorePassword;

    // Заполнить поля Email и Пароль на форме авторизации
    // Нажать кнопку "Войти" на форме авторизации
   @Step("Заполнить поля Email и Пароль на форме авторизации и нажать кнопку \"Войти\"")
    public void fillFieldsAndClickButtonAuthorization(String userEmail, String userPassword) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        fieldEmailAuthorization.setValue(userEmail);
        fieldPasswordAuthorization.setValue(userPassword);
        linkRestorePassword.scrollIntoView(true);
        buttonAuthorization.scrollIntoView(true);
        buttonAuthorization.click();
    }

    // Нажать сслыку "Восстановить пароль"
    // Перейти на форму восстановления пароля
    @Step("Нажать сслыку \"Восстановить пароль\" на форме авторизации")
    public ForgotPasswordPage linkRestorePasswordClick() {
        linkRestorePassword.scrollIntoView(true);
        linkRestorePassword.shouldBe(Condition.interactable);
        linkRestorePassword.click();
        ForgotPasswordPage forgotPasswordPage = Selenide.page(ForgotPasswordPage.class);
        return forgotPasswordPage;
    }

    // Нажать ссылку "Зарегистироваться" в нижнем меню формы входа в профиль
    // Перейти на форму регистрации
    @Step("Нажать сслыку \"Зарегистироваться\" на форме авторизации")
    public RegisterPage linkGoToRegistrationClick() {
        linkGoToRegistration.click();
        // Создать PO для RegisterPage
        RegisterPage registerPage = Selenide.page(RegisterPage.class);
        // Убедиться, что открылась форме регистрации - есть надпись "Регистрация"
        MatcherAssert.assertThat(
                "Mistake opening registration form",
                registerPage.getTitleRegistration().getText(),
                equalTo("Регистрация"));
        return registerPage;
    }

    public SelenideElement getTitleEntrance() {
        return titleEntrance;
    }

    public void setTitleEntrance(SelenideElement titleEntrance) {
        this.titleEntrance = titleEntrance;
    }

    public SelenideElement getFieldEmailAuthorization() {
        return fieldEmailAuthorization;
    }

    public void setFieldEmailAuthorization(SelenideElement fieldEmailAuthorization) {
        this.fieldEmailAuthorization = fieldEmailAuthorization;
    }

    public SelenideElement getFieldPasswordAuthorization() {
        return fieldPasswordAuthorization;
    }

    public void setFieldPasswordAuthorization(SelenideElement fieldPasswordAuthorization) {
        this.fieldPasswordAuthorization = fieldPasswordAuthorization;
    }

    public SelenideElement getButtonAuthorization() {
        return buttonAuthorization;
    }

    public void setButtonAuthorization(SelenideElement buttonAuthorization) {
        this.buttonAuthorization = buttonAuthorization;
    }

    public SelenideElement getLinkGoToRegistration() {
        return linkGoToRegistration;
    }

    public void setLinkGoToRegistration(SelenideElement linkGoToRegistration) {
        this.linkGoToRegistration = linkGoToRegistration;
    }

    public SelenideElement getLinkRestorePassword() {
        return linkRestorePassword;
    }

    public void setLinkRestorePassword(SelenideElement linkRestorePassword) {
        this.linkRestorePassword = linkRestorePassword;
    }
}
