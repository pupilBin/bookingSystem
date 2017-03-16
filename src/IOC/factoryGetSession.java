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
    private static SessionFactory sessionFactory;

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
        return sessionFactory.openSession();
    }
}
