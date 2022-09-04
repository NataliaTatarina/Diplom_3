package stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    // Личный кабинет - ссылка "Профиль"
    @FindBy(how = How.XPATH, using = "//div/main/div/nav/ul/li[1]/a[text()='Профиль']")
    private SelenideElement linkProfilePersonalCabinet;

    // Личный кабинет - ссылка "Выход"
    @FindBy(how = How.XPATH, using = "//div/main/div/nav/ul/li[3]/button[text()='Выход']")
    private SelenideElement linkExitPersonalCabinet;

    // Верхнее меню - логотип
    @FindBy(how = How.XPATH, using = "//div/header/nav/div/a[@href='/']")
    private SelenideElement stellarBurgersLogo;

    // Верхнее меню - ссылка "Конструктор"
    @FindBy(how = How.XPATH, using = "//div/header/nav/ul/li[1]/a/p[text()='Конструктор']")
    private SelenideElement linkConstructor;

    // Нажать ссылку "Выход" в личном кабинете
    @Step("Нажать ссылку \"Выход\" в личном кабинете")
    public void linkExitPersonalCabinetClick() {
        linkExitPersonalCabinet.click();
    }

    // Нажать на логотип StellarBurger в верхнем меню
    @Step("Нажать на логотип StellarBurger в личном кабинете")
    public void stellarBurgersLogoClick() {
        stellarBurgersLogo.click();
    }

    // Нажать на ссылку "Конструктор" в личном кабинете
    @Step("Нажать ссылку \"Конструктор\" в личном кабинете")
    public void linkConstructorClick() {
        linkConstructor.click();
    }

    public SelenideElement getLinkProfilePersonalCabinet() {
        return linkProfilePersonalCabinet;
    }

    public void setLinkProfilePersonalCabinet(SelenideElement linkProfilePersonalCabinet) {
        this.linkProfilePersonalCabinet = linkProfilePersonalCabinet;
    }

    public SelenideElement getLinkExitPersonalCabinet() {
        return linkExitPersonalCabinet;
    }

    public void setLinkExitPersonalCabinet(SelenideElement linkExitPersonalCabinet) {
        this.linkExitPersonalCabinet = linkExitPersonalCabinet;
    }

    public SelenideElement getStellarBurgersLogo() {
        return stellarBurgersLogo;
    }

    public void setStellarBurgersLogo(SelenideElement stellarBurgersLogo) {
        this.stellarBurgersLogo = stellarBurgersLogo;
    }

    public SelenideElement getLinkConstructor() {
        return linkConstructor;
    }

    public void setLinkConstructor(SelenideElement linkConstructor) {
        this.linkConstructor = linkConstructor;
    }
}
