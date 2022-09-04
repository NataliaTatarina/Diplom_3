package stellarburgers.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ConstructorTest extends AbstractTest {
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
    }

    @After
    public void closeDriverAndDeleteUser() {
        driver.quit();
    }

    // Проверка активизации ссылки "Начинки"
    @Test
    @DisplayName("Активизация ссыки \"Начинки\"")
    public void linkToppingsClickTest() throws InterruptedException {
        mainPage.getLinkToppings().click();
        Assert.assertTrue(
                "Mistake testing - link Toppings isn't active",
                mainPage.getActiveLinkToppings().exists());

    }

    // Проверка активизации ссылки "Соусы"
    @Test
    @DisplayName("Активизация ссылки \"Соусы\"")
    public void linkSaucesClickTest() {
        mainPage.getLinkSauces().click();
        Assert.assertTrue(
                "Mistake testing - link Sauces isn't active",
                mainPage.getActiveLinkSauces().exists());
    }

    // Проверка активизации ссылки "Булки"
    @Test
    @DisplayName("Активизация ссылки \"Булки\"")
    public void linkBunsClickTest() throws InterruptedException {
        mainPage.getLinkToppings().click();
        mainPage.getLinkBuns().click();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(
                "Mistake testing - link Buns isn't active",
                mainPage.getActiveLinkBuns().exists());
    }

}


