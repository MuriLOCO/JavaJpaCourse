package client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;

public class Client extends HibernateUtil {

	public static void main(String[] args) {
		
		final Session session = getCurrentSession();
		final Transaction transaction = session.getTransaction();
		
		try{
			transaction.begin();
			
			final List<Guide> guides = new ArrayList<>();
			final Guide guide1 = new Guide("646HGDG","Guide 1", 55);
			final Guide guide2 = new Guide("455445","Guide 2", 43);
			final Guide guide3 = new Guide("LASKS892378","Guide 3", 13);
			final Guide guide4 = new Guide("FJJH","Guide 4", 55);
			final Guide guide5 = new Guide("646HGDG2222","Guide51", 10);
			
			guides.add(guide1);
			guides.add(guide2);
			guides.add(guide3);
			guides.add(guide4);
			guides.add(guide5);
			
			final Student student = new Student("Jose Mendes", guides);
			
			session.persist(student);
			
			transaction.commit();
			
			
		}catch(Exception e){
			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
			}
		}finally {
			if (session != null) {
				session.close();
			}			
		}
		
	}

}
