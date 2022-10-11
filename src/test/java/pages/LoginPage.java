package pages;

import com.microsoft.playwright.Page;
import screens.Login;

public class LoginPage {

    Page page;
    Login login;

    public LoginPage(Page page) {
        this.page = page;
        this.login = new Login();
    }

    public String getLoginPageTitle() {
        String title = page.title();
        System.out.println("Page title: " + title);
        return page.title();
    }

    public String getLoginPageUrl() {
        String url = page.url();
        System.out.println("Page Url: " + url);
        return page.url();
    }

    public void enterEmailId(String emailId) {
        page.fill(login.EMAIL_TEXT_FIELD, emailId);
    }

    public void enterPassword(String password) {
        page.fill(login.PASSWORD_FIELD, password);
    }

    public void clickOnLoginBtn() {
        page.click(login.LOGIN_BTN);
    }
}
