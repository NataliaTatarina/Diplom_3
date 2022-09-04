package stellarburgers.test;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburger.proc.DeleteUserAPI;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainTest extends AbstractTest {

    // Открытие страницы перед проведением тестов
    @Before
    public void startMainPageAndCreateUser() {
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

    }

    @After
    public void closeDriverAndDeleteUser() {
        driver.quit();
    }

    // Проверка перехода в личный кабинет по ссылке в верхнем заголовке "Личный кабинет"
    // Пользователь не авторизирован - должны быть перенеправлены на форму авторизации
    @Test
    @DisplayName("Проверка перехода в личный кабинет по ссылке \"Личный кабинет\". Без авторизации")
    public void clickPersonalCabinetWithoutAuthorizationTest() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        // Нажать ссылку "Личный кабинет"
        loginPage = mainPage.headerLinkPersonalCabinetClickWithountAuthorization();
        // Убедиться, что открылась форма для регистрации - есть надпись "Вход"
        MatcherAssert.assertThat(
                "Mistake - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
    }

    // Проверка перехода в личный кабинет по ссылке в верхнем заголовке "Личный кабинет"
    // Пользователь авторизирован - должны быть перенаправлены на форму с профилем пользователя
    @Test
    @DisplayName("Проверка перехода в личный кабинет по ссылке \"Личный кабинет\". Пользователь авторизирован")
    public void clickPersonalCabinetWithAuthorizationTest() throws InterruptedException {
        // Авторизация - ввести корректные логин и пароль, нажать "Войти"
        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.fillFieldsAndClickButtonAuthorization(userEmail, userPassword);
        // Нажать ссылку "Личный кабинет"
        profilePage = mainPage.headerLinkPersonalCabinetClickForAuthorizedUser();
        // Убедиться, что открывается личный кабинет - есть ссылка "Профиль"
        MatcherAssert.assertThat(
                "There is no link Profile",
                profilePage.getLinkProfilePersonalCabinet().getText(),
                equalTo("Профиль"));
        // Разлогиниться - нажать ссылку "Выход" в личном кабинете
        profilePage.linkExitPersonalCabinetClick();
        // Удалить учетную запись пользователя
        DeleteUserAPI.deleteUserAPI(userEmail, userPassword);
    }


}
