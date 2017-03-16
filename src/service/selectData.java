package service;

import IOC.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import beans.user;
import java.util.List;

/**
 * Created by pupil on 2017/3/16.
 */
public class selectData {
    public JSONArray getTeacherInformationByType(){
        JSONArray teacherInformation=new JSONArray();
        user user=(user)factoryGetBeans.getBean("user");

        Session session= factoryGetSession.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select account,name,phone,college from user where type=?");
        query.setString(0,"老师");
        List<Object []> list = query.list();
        transaction.commit();
        session.close();

        for(Object[] obj:list){
            user.setAccount((String)obj[0]);
            user.setName((String)obj[1]);
            user.setPhone((String)obj[2]);
            user.setCollege((String)obj[3]);
            teacherInformation.add(user);
        }
        return teacherInformation;
    }

    public user getUserInformationByAccount(String account){
        user user=(user)factoryGetBeans.getBean("user");

        Session session= factoryGetSession.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select name,phone,college from user where account=?");
        query.setString(0,account);
        List<Object []> list = query.list();
        transaction.commit();
        session.close();
        user.setName((String)list.get(0)[0]);
        user.setPhone((String)list.get(0)[1]);
        user.setCollege((String)list.get(0)[2]);

        return user;
    }
}
