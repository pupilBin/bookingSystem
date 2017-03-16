package beans;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pupil on 2017/3/10.
 */
public class user {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String account;
    private String password;
    private String name;
    private String type;
    private String phone;
    private String college;
    private Set<arrangement> arrangement=new HashSet<arrangement>();
    private Set<arrangement> arrangement0=new HashSet<arrangement>();
    private Set<freeTime> freeTime=new HashSet<freeTime>();

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Set<beans.arrangement> getArrangement() {
        return arrangement;
    }

    public void setArrangement(Set<beans.arrangement> arrangement) {
        this.arrangement = arrangement;
    }

    public Set<beans.freeTime> getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(Set<beans.freeTime> freeTime) {
        this.freeTime = freeTime;
    }

    public Set<beans.arrangement> getArrangement0() {
        return arrangement0;
    }

    public void setArrangement0(Set<beans.arrangement> arrangement0) {
        this.arrangement0 = arrangement0;
    }
}
