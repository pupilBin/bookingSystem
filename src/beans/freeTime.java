package beans;

/**
 * Created by pupil on 2017/3/10.
 */
public class freeTime {
    private int freeTimeId;
    private String teacherAccount;
    private String beginTime;
    private String endTime;
    public int getFreeTimeId() {
        return freeTimeId;
    }

    public void setFreeTimeId(int freeTimeId) {
        this.freeTimeId = freeTimeId;
    }

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
