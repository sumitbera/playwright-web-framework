package utility;

public interface AppLocators {

    interface LoginScreen {
        String emailTxtField = "//*[@type='text' and @placeholder='Email']";
        String passwordTxtField = "//*[@type='password' and @placeholder='Password']";
        String loginBtn = "button.el-button.el-button--primary.el-button--medium";
    }
}
