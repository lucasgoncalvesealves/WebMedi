package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtils {  
	  
    public static final SessionFactory sessionFactory;  
    public static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();  
  
    public HibernateUtils() {  
    }  
  
    static {  
        try {  
        	Configuration configuration = new Configuration();
		    configuration.configure();
		    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {          
             System.err.println("-----------------------------Erro SessionFactory---------------------------------");  
             System.err.println("Initial SessionFactory creation failed." + ex);    
             System.err.println("-----------------------------Fim SessionFactory---------------------------------");  
             throw new ExceptionInInitializerError(ex);    
          }  
    }  
  
    public static Session getInstance() {  
        Session session = (Session) threadLocal.get();  
        if (session == null) {  
            session = sessionFactory.openSession();  
            threadLocal.set(session);  
        }  
        return session;  
    }  
}  
