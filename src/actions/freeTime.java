package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by pupil on 2017/3/3.
 */
public class freeTime extends ActionSupport {
    private String teacherAccount;
    private String beginTime;
    private String endTime;

    public String getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
