package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory buildSessionFactory() {
        try {        	
        	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");     
            return configuration.buildSessionFactory( new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() ).build() );
        }  catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }        
       
	}		
	 
	 public static Session getCurrentSession(){
		 Session session = null;		 
			try {
				session = buildSessionFactory().getCurrentSession();				
			}
			catch(Exception e){
				session = buildSessionFactory().openSession();			
			}
			return session;
	 }
	 

}
