//import javax.security.auth.login.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import javax.imageio.spi.ServiceRegistry;

public class hibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    public static void configure(){
        Configuration config = new Configuration();
        System.out.println("eork");

        config.configure("hibernate.cfg.xml");

        config.addAnnotatedClass(pojo.class);
        ServiceRegistry sro = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(sro);
    }
    public void createSession(){
        if(session!=null && session.isOpen()){
            return;
        }
        session = sessionFactory.openSession();
    }
    public void closeSession(){
        if(session!=null) {
            session.close();
        }
    }

    public Session getSession(){
        return session;
    }

    public void beginTrans(){
        transaction = session.beginTransaction();
    }
    public void commitTrans(){
        if(transaction!=null) {
            transaction.commit();
        }
    }
}
