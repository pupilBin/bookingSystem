package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by pupil on 2017/3/8.
 */
public class login extends ActionSupport {
    private String account;
    private String password;

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
