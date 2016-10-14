package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.org.apache.xml.internal.security.keys.content.RetrievalMethod;

import entity.Address;
import entity.Person;
import util.HibernateUtil;

public class Client {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			Address address = new Address("Rue St-Patrick", "3700");
			Person person = new Person("Jose Mendes", address);

			session.save(person);

			Person retrivedPerson = (Person) session.get(Person.class, 1L);

			System.out.println("Person is: " + retrivedPerson.getName());

			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
				e.printStackTrace();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
