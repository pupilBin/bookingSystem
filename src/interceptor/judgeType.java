package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by pupil on 2017/3/6.
 */
public class judgeType extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> map=invocation.getInvocationContext().getParameters();
        String type=((String[])map.get("type"))[0];
        if(type.equals("老师"))
            return "teacher";
        else if(type.equals("学生"))
            return invocation.invoke();
        else
            return "input";
    }
}
