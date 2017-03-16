package service;
import beans.*;
import IOC.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by pupil on 2017/3/14.
 */
public class changeData {

    public void register(user user) throws Exception{
        Session session= factoryGetSession.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
