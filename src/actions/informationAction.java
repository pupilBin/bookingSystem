package actions;

import com.opensymphony.xwork2.ActionSupport;
import IOC.*;
import net.sf.json.JSONArray;
import service.*;
import beans.*;

/**
 * Created by pupil on 2017/3/8.
 */
public class informationAction extends ActionSupport {
    private String account;
    private String password;
    private String name;
    private String type;
    private String phone;
    private String college;
    private JSONArray arrangements;
    private JSONArray freeTime;
    private JSONArray teacherInformationList;
    @Override
    public String execute() throws Exception {
        //这个地方有可能出错，这个equals有可能出现问题，没有初始化的String不晓得是null还是？
        //if this condition is true,the user must be logged in,then the method will search the information of the user.
        if(getName()==null){
            selectData selectData=(selectData) factoryGetBeans.getBean("selectData");
            user user=selectData.getUserInformationByAccount(getAccount());
            setName(user.getName());
            setType(user.getType());
            setPhone(user.getPhone());
            setCollege(user.getCollege());

        }
        selectData selectData=(selectData) factoryGetBeans.getBean("selectData");
        setArrangements(selectData.getArrangementsInformationJsonArrayByAccount(getAccount(),getType()));
        setFreeTime(selectData.getFreeTimeInformationJsonArrayByAccount(getAccount(),getType()));
        setTeacherInformationList(selectData.getTeacherInformationJsonArrayByType(getType()));
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

    public JSONArray getArrangements() {
        return arrangements;
    }

    public void setArrangements(JSONArray arrangements) {
        this.arrangements = arrangements;
    }

    public JSONArray getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(JSONArray freeTime) {
        this.freeTime = freeTime;
    }

    public JSONArray getTeacherInformationList() {
        return teacherInformationList;
    }

    public void setTeacherInformationList(JSONArray teacherInformationList) {
        this.teacherInformationList = teacherInformationList;
    }
}
