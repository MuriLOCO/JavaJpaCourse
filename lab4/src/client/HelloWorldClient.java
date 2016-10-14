package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HibernateUtil;

public class HelloWorldClient {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();

			/*Message message = new Message( "Hello World Jose2" );	        
    		session.save(message);    		*/
			// Finding objects
			
			/* Message msg = (Message) session.get(Message.class, 2L);*/
			 

			// Updating objects
			
			  /*Message msg = (Message) session.get(Message.class, 2L);
			  msg.setText("Hello Automatic Dirty Checking");*/
			 

			// Deleting objects
			
			  Message msg = (Message) session.get(Message.class, 2L);
			  session.delete(msg);
			 

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
