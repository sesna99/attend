package trycatch.yj.sj.attend.model;

/**
 * Created by trycatch on 2017. 9. 19..
 */

public class LoginInfoEvent {
    private boolean result;
    private LoginInfo loginInfo;

    public LoginInfoEvent(boolean result, LoginInfo loginInfo) {
        this.result = result;
        this.loginInfo = loginInfo;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }
}
