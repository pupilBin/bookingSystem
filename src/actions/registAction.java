package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import bean.*;
/**
 * Created by pupil on 2017/3/5.
 */
public class registAction extends ActionSupport{
    ApplicationContext content=new ClassPathXmlApplicationContext("bean.xml");
    student student=(student)content.getBean("student");

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
