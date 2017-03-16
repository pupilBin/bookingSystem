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
//        String account=((String[])map.get("type"))[0];
        return invocation.invoke();
    }
}
