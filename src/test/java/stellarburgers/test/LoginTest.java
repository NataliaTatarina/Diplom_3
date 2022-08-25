package stellarburgers.test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburger.proc.DeleteUserAPI;
import stellarburgers.pageobject.ForgotPasswordPage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends AbstractTest {
    //Открытие страницы перед проведением тестов
    @Before
    public void startMainPageAndCreateUser() {
        // Выбор браузера
        if (useYandex) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yandexdriver\\yandexdriver.exe");
        }
        driver = new ChromeDriver();
        setWebDriver(driver);
        // Отрытие главной страницы
        mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        // Создать учетную запись пользователя
        loginPage = mainPage.buttonEntranceClickReturnLoginPage();
        registerPage = loginPage.linkGoToRegistrationClick();
        registerPage.fillFieldsAndButtonClickRegistration(userName, userEmail, userPassword);
        registerPage.stellarBurgersLogoClick();
    }

    @After
    public void closeDriverAndDeleteUser() {
        loginPage.fillFieldsAndClickButtonAuthorization(userEmail, userPassword);
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not main form",
                mainPage.getButtonEntrance().getText(),
                equalTo("Оформить заказ"));
                driver.quit();
        // Удалить пользователя
        DeleteUserAPI.deleteUserAPI(userEmail, userPassword);
    }

    // Авторизация по кнопке "Войти в аккаунт" на главной форме
    @Test
    public void getToLoginPageFromMainPageByButtonEnterAccountTest() {
        // Нажать кнопку "Войти в аккаунт"
        mainPage.buttonEntranceClick();
        // Проверить, что текущая страница - форма авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not login form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
    }

    // Авторизация по кнопке "Личный кабинет" на главной форме
    @Test
    public void getToLoginPageFromMainPageByLinkPersonalAccountTest() {
        // Нажать кнопку "Личный кабинет"
        mainPage.headerLinkPersonalCabinetClick();
        // Проверить, что текущая страница - форма авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not login form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
    }

    // Авторизация по кнопке "Личный кабинет" на форме регистрации
    @Test
    public void getToLoginPageFromRegisterPageByLinkPersonalAccountTest() {
        // Открыть страницу регистрации
        RegisterPage registerTest = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        // Проверить, что перешли на страницу регистрации
        MatcherAssert.assertThat(
                "Mistake opening registration form",
                registerPage.getTitleRegistration().getText(),
                CoreMatchers.equalTo("Регистрация"));
        // Нажать ссылку "Личный кабинет" в верхнем заголовке на форме регистрации
        registerPage.headerLinkPersonalCabinetClick();
        // Проверить, что текущая страница - форма авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not login form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
    }

    // Авторизация по ссылке "Войти" на форме регистрации
    @Test
    public void getToLoginPageFromRegisterPageByLinkEnterTest() {
        // Открыть страницу регистрации
        RegisterPage registerTest = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        // Нажать ссылку "Войти" на форме регистрации
        registerPage.getLinkEnter().scrollIntoView(true);
        registerPage.linkEnterClick();
        // Проверить, что текущая страница - форма авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not login form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
    }

    // Авторизация по кнопке "Личный кабинет" на форме восстановления пароля
    @Test
    public void getToLoginPageFromForgotPasswordPageByLinkPersonalAccountTest() {
        // Открыть страницу регистрации
        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
        // Нажать ссылку "Личный кабинет" на форме восстановления пароля
        forgotPasswordPage.headerLinkPersonalCabinetClick();
        // Проверить, что текущая страница - форма авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not login form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
    }

    // Авторизация по ссылке "Войти" на форме восстановления пароля
    @Test
    public void getToLoginPageFromForgotPasswordPageByLinkEnterTest() {
        // Открыть страницу регистрации
        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
       // Нажать ссылку "Войти" на форме восстановления пароля
        forgotPasswordPage.linkEnterClick();

        // Проверить, что текущая страница - форма авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not login form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));

    }


}
