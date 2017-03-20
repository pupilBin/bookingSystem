package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import IOC.*;
import beans.*;
import java.util.Map;
import service.*;
/**
 * Created by pupil on 2017/3/15.
 */
public class judgeExist extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation){
        Map<String, Object> map=invocation.getInvocationContext().getParameters();
        user user=(user)factoryGetBeans.getBean("user");
        changeData changeData=(changeData) factoryGetBeans.getBean("changeData");
        //judge user'information is null or not
        if(((String[])map.get("account"))[0].equals("")||((String[])map.get("password"))[0].equals("")
                ||((String[])map.get("name"))[0].equals("")||(!(((String[])map.get("type"))[0].equals("老师"))
                &&!(((String[])map.get("type"))[0].equals("学生")))||((String[])map.get("phone"))[0].equals("")
                ||((String[])map.get("college"))[0].equals("")){
            return "input";
        }
        user.setAccount(((String[])map.get("account"))[0]);
        user.setPassword(((String[])map.get("password"))[0]);
        user.setName(((String[])map.get("name"))[0]);
        user.setType(((String[])map.get("type"))[0]);
        user.setPhone(((String[])map.get("phone"))[0]);
        user.setCollege(((String[])map.get("college"))[0]);
        //maybe the user's account is existed,so make a judge
        try {
            changeData.register(user);
            return invocation.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            return "input";
        }
    }
}
