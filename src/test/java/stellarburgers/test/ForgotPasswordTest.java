package stellarburgers.test;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.Matchers.equalTo;

public class ForgotPasswordTest extends AbstractTest {
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
    }

    @After
    public void closeDriverAndDeleteUser() {
       driver.quit();
    }

    // Авторизация по кнопке "Войти в аккаунт" на главной форме
    @Test
    public void getToForgotPasswordPageFromLoginTest() {
        // Нажать кнопку "Войти в аккаунт"
        loginPage = mainPage.buttonEntranceClickReturnLoginPage();
        // Нажать ссылку "Восстановаить пароль"
        forgotPasswordPage = loginPage.linkRestorePasswordClick();
        // Убедиться, что открылась страница с восстановлением пароля
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not restore password form",
                forgotPasswordPage.getTitleRestorePassword().getText(),
                equalTo("Восстановление пароля"));
    }

}
