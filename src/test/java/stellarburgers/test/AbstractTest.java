package stellarburgers.test;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import stellarburgers.pageobject.*;

public class AbstractTest
{
    protected final Boolean useYandex = true;
    protected WebDriver driver;
    protected MainPage mainPage;
    protected ProfilePage profilePage;

    protected LoginPage loginPage;

    protected RegisterPage registerPage;

    protected ForgotPasswordPage forgotPasswordPage;
    protected String userEmail = RandomStringUtils.randomAlphabetic(5) + "@yandex.ru";
    protected String userPassword = RandomStringUtils.randomAlphabetic(5)+"TestPassword";
    protected String userName = RandomStringUtils.randomAlphabetic(5) + "TestName";


}
