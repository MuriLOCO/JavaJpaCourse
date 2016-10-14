package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Customer;
import entity.Passport;
import util.HibernateUtil;

public class Client extends HibernateUtil {

	public static void main(String[] args) {
		
	final Session session = getCurrentSession();
	final Transaction transaction = session.getTransaction();
	
	try{
		
		transaction.begin();
		
		session.persist(new Customer("Jose Mendes", new Passport("JSHSJH8772", "Brazil")));
		
		transaction.commit();
		
	}catch(Exception e){
		e.printStackTrace();
		if (transaction != null) {
			transaction.rollback();	
		}
	}finally{
		if (session != null) {
			session.close();
		}	
	}
	

	}
}
