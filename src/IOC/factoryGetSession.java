package IOC;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by pupil on 2017/3/14.
 */
public class factoryGetSession {
    static SessionFactory sessionFactory =null;
    static Session session=null;

    static {
        final StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
    }

    public static Session getSession(){
        session=sessionFactory.openSession();
        return session;
    }
}
