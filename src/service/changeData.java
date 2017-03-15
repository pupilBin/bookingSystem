package service;
import beans.*;
import IOC.*;
import org.hibernate.Query;
/**
 * Created by pupil on 2017/3/14.
 */
public class changeData {

    public boolean regist(user user){
        boolean exist=true;
        //The way of binding parameters will precompile in mysql.
        Query query=factoryGetSession.getSession().createSQLQuery("insert into user (account,password,name,type,phone,college) VALUES (?,?,?,?,?,?)");
        try {
            query.setString(1,user.getAccount());
            query.setString(2,user.getPassword());
            query.setString(3,user.getName());
            query.setString(4,user.getType());
            query.setString(5,user.getPhone());
            query.setString(6,user.getCollege());
            return exist;
        } catch (Exception e){
            exist=false;
            return exist;
        }
    }
}
