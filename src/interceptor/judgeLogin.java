package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import IOC.*;
import service.*;
import java.util.Map;

/**
 * Created by pupil on 2017/3/17.
 */
public class judgeLogin extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        selectData selectData=(selectData)factoryGetBeans.getBean("selectData");
        Map<String, Object> map=invocation.getInvocationContext().getParameters();
        String account=((String[])map.get("account"))[0];
        String password=((String[])map.get("password"))[0];
        if(selectData.judgePassword(account,password)){
            return invocation.invoke();
        } else {
            return "input";
        }
    }
}
