package stellarburgers.test;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburger.proc.DeleteUserAPI;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ProfileTest extends AbstractTest {
    // Открытие страницы перед проведением тестов
    @Before
    public void startMainPageAndCreateUser() throws InterruptedException {
        // Выбор браузера
        if (useYandex) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yandexdriver\\yandexdriver.exe");
        }
        driver = new ChromeDriver();
        setWebDriver(driver);
        // Отрытие главной страницы
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        // Создать учетную запись пользователя
        loginPage = mainPage.headerLinkPersonalCabinetClickForUserWithoutAuthorization();
        registerPage = loginPage.linkGoToRegistrationClick();
        registerPage.fillFieldsAndButtonClickRegistration(userName, userEmail, userPassword);
        // Авторизация - ввести корректные логин и пароль, нажать "Войти"
        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.fillFieldsAndClickButtonAuthorization(userEmail, userPassword);
    }

    // Закрыть приложение
    // Удалить учетную запись пользователя
    @After
    public void closeDriverAndDeleteUser() {
        driver.quit();
        // Удалить учетную запись пользователя
        DeleteUserAPI.deleteUserAPI(userEmail, userPassword);
    }

    // Выход из аккаунта по ссылке "Выход" в "Личном кабинете"
    @Test
    @DisplayName("Выход из аккаунта по ссылке \"Выход\" в \"Личном кабинете\"")
    public void linkExitClickTest() {
        // Нажать ссылку "Личный кабинет"
        profilePage = mainPage.headerLinkPersonalCabinetClickForAuthorizedUser();
        // Разлогиниться - нажать ссылку "Выход" в личном кабинете
        profilePage.linkExitPersonalCabinetClick();
        // Проверить, что вернулись на форму входа - есть надпись "Вход" - регистрация успешна
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                Matchers.equalTo("Вход"));
    }

    // Переход из "Личного кабинета" в "Конструктор" по клику на логотип
    @Test
    @DisplayName("Переход из \"Личного кабинета\" в \"Конструктор\" по клику на логотип")
    public void linkLogoClickTest() {
        // Нажать ссылку "Личный кабинет"
        profilePage = mainPage.headerLinkPersonalCabinetClickForAuthorizedUser();
        // Нажать логотип в личном кабинете
        profilePage.stellarBurgersLogoClick();
        // Проверить, что перешли в "Конструктор" - есть надпись "Соберите бургер"
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not main form",
                mainPage.getTitleGetBurger().getText(),
                Matchers.equalTo("Соберите бургер"));
    }

    // Переход из "Личного кабинета" в "Конструктор" по клику на ссылку "Конструкктор"
    @Test
    @DisplayName("Переход из \"Личного кабинета\" в \"Конструктор\" по клику на ссылку \"Конструкктор\"")
    public void linkConstructorClickTest() {
        // Нажать ссылку "Личный кабинет"
        profilePage = mainPage.headerLinkPersonalCabinetClickForAuthorizedUser();
        // Нажать ссылку "Конструктор" в личном кабинете
        profilePage.linkConstructorClick();
        // Проверить, что перешли в "Конструктор" - есть надпись "Соберите бургер"
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not main form",
                mainPage.getTitleGetBurger().getText(),
                Matchers.equalTo("Соберите бургер"));
    }


}
