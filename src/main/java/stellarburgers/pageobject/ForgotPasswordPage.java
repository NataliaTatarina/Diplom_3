package stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {
    // Верхний заголовок - ссылка "Личный кабинет"
    @FindBy(xpath = "//div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement headerLinkPersonalCabinet;

    // Нижниый заголовок - ссылка "Войти"
    @FindBy(xpath = "//div/main/div/div/p/a[@href='/login']")
    private SelenideElement linkEnter;

    // Надпись "Восстановление пароля"
    @FindBy(xpath = "//div/main/div/h2")
    private SelenideElement titleRestorePassword;

    @Step("Нажать ссылку \"Личный кабинет\" на форме восстановления пароля")
    public void headerLinkPersonalCabinetClick() {
        headerLinkPersonalCabinet.click();
    }

    @Step("Нажать ссылку \"Войти\" на форме восстановления пароля")
    public void linkEnterClick() {
        linkEnter.scrollIntoView(true);
        linkEnter.shouldBe(Condition.interactable);
        linkEnter.click();
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

    public SelenideElement getTitleRestorePassword() {
        return titleRestorePassword;
    }

    public void setTitleRestorePassword(SelenideElement titleRestorePassword) {
        this.titleRestorePassword = titleRestorePassword;
    }
}
