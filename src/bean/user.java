package bean;

/**
 * Created by pupil on 2017/3/3.
 */
public class user {
    private String account;
    private String password;
    private String name;
    private int type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public bean.arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(bean.arrangement arrangement) {
        this.arrangement = arrangement;
    }
}
