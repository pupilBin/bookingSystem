package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by pupil on 2017/3/3.
 */
public class student extends ActionSupport  {
    private String account;
    private String password;
    private String name;
    private String type;
    private int phone;
    private String college;
    private arrangement arrangement;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public actions.arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(actions.arrangement arrangement) {
        this.arrangement = arrangement;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(getName()+" name"+getType()+" type "+getPhone());
        return super.execute();
    }
}
