package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pupil on 2017/3/9.
 */
public class factoryGetBeans {
    private static final ApplicationContext content;
    static {
        content=new ClassPathXmlApplicationContext("bean.xml");
    }
    public Object getBean(String objectName){
        Object object=content.getBean(objectName);
        return object;
    }
}
