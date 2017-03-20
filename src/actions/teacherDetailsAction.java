package actions;

/**
 * Created by pupil on 2017/3/18.
 */
import com.opensymphony.xwork2.ActionSupport;
import IOC.*;
import net.sf.json.JSONArray;
import service.selectData;

public class teacherDetailsAction extends ActionSupport {
    private JSONArray teacherArrangements;
    private JSONArray freeTime;
    private String account;
    @Override
    public String execute() throws Exception {
        selectData selectData=(selectData) factoryGetBeans.getBean("selectData");
        setTeacherArrangements(selectData.getTeacherDetails(account));
        setFreeTime(selectData.getFreeTime(account));
        return super.execute();
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public JSONArray getTeacherArrangements() {
        return teacherArrangements;
    }

    public void setTeacherArrangements(JSONArray teacherArrangements) {
        this.teacherArrangements = teacherArrangements;
    }

    public JSONArray getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(JSONArray freeTime) {
        this.freeTime = freeTime;
    }
}
