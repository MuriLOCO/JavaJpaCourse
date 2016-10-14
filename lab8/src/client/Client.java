package client;

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
				
			final Guide guide = new Guide("646HGDG","Guide 1", 55);
			
			final Student student1 = new Student("Jose Mendes1", guide);
			final Student student2 = new Student("Jose Mendes2", guide);
			final Student student3 = new Student("Jose Mendes3", guide);
		
		    guide.addStudent(student1);
			guide.addStudent(student2);
			guide.addStudent(student3);			
			
			
			session.persist(guide);
			
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
