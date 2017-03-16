package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by pupil on 2017/3/8.
 */
public class informationAction extends ActionSupport {

    private String string="So,are you great?";
    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String getString() {
        return string;
    }
}
