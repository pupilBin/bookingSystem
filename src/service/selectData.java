package service;

import IOC.*;
import net.sf.json.JSONArray;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import beans.*;
import java.util.List;

/**
 * Created by pupil on 2017/3/16.
 */
public class selectData {
    //return all teacher's information.
    public JSONArray getTeacherInformationJsonArrayByType(){
        JSONArray teacherInformationList=new JSONArray();
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
            teacherInformationList.add(user);
        }
        return teacherInformationList;
    }

    //return user's information by account.
    public user getUserInformationByAccount(String account){
        user user=(user)factoryGetBeans.getBean("user");

        Session session= factoryGetSession.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select name,type,phone,college from user where account=?");
        query.setString(0,account);
        List<Object []> list = query.list();
        transaction.commit();
        session.close();

        user.setName((String)list.get(0)[0]);
        user.setType((String)list.get(0)[1]);
        user.setPhone((String)list.get(0)[2]);
        user.setCollege((String)list.get(0)[3]);
        return user;
    }

    //return user's freeTime by account.
    public JSONArray getFreeTimeInformationJsonArrayByAccount(String teacherAccount){
        JSONArray freeTimeJsonArray=new JSONArray();
        freeTime freeTime=(freeTime)factoryGetBeans.getBean("freeTime");

        Session session= factoryGetSession.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select beginTime,endTime from freeTime where teacherAccount=?");
        query.setString(0,teacherAccount);
        List<Object []> list = query.list();
        transaction.commit();
        session.close();

        for(Object[] obj:list){
            freeTime.setBeginTime((String)obj[0]);
            freeTime.setEndTime((String)obj[1]);
            freeTimeJsonArray.add(freeTime);
        }
        return freeTimeJsonArray;
    }

    //return user's arrangements by account.
    public JSONArray getArrangementsInformationJsonArrayByAccount(String account,String type){
        JSONArray arrangementJsonArray=new JSONArray();
        arrangement arrangement=(arrangement)factoryGetBeans.getBean("arrangement");
        List<Object []> list;
        if(type.equals("学生")){
            Session session= factoryGetSession.getSession();
            Transaction transaction=session.beginTransaction();
            Query query=session.createQuery("select teacherAccount,bookingTime,status,title,description,teacherName,studentName from arrangement where studentAccount=?");
            query.setString(0,account);
            list = query.list();
            transaction.commit();
            session.close();
            for(Object[] obj:list){
                arrangement.setTeacherAccount((String)obj[0]);
                arrangement.setBookingTime((String)obj[1]);
                arrangement.setStatus((int)obj[2]);
                arrangement.setTitle((String)obj[3]);
                arrangement.setDescription((String)obj[4]);
                arrangement.setTeacherName((String)obj[5]);
                arrangement.setStudentName((String)obj[6]);
                arrangementJsonArray.add(arrangement);
            }
        } else{
            Session session= factoryGetSession.getSession();
            Transaction transaction=session.beginTransaction();
            Query query=session.createQuery("select studentAccount,bookingTime,status,title,description,teacherName,studentName from arrangement where teacherAccount=?");
            query.setString(0,account);
            list = query.list();
            transaction.commit();
            session.close();
            for(Object[] obj:list){
                arrangement.setStudentAccount((String)obj[0]);
                arrangement.setBookingTime((String)obj[1]);
                arrangement.setStatus((int)obj[2]);
                arrangement.setTitle((String)obj[3]);
                arrangement.setDescription((String)obj[4]);
                arrangement.setTeacherName((String)obj[5]);
                arrangement.setStudentName((String)obj[6]);
                arrangementJsonArray.add(arrangement);
            }
        }
        return arrangementJsonArray;
    }

    public boolean judgePassword(String account,String password){
        Session session= factoryGetSession.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select password from user where account=?");
        query.setString(0,account);
        List<Object []> list = query.list();
        transaction.commit();
        session.close();
        //有疑问。。。也不知道他娘的可不可以运行（23333，反正登录要是通不过这里可以换一下，fuc*
        return list.get(0)[0].equals(password);
    }
}
