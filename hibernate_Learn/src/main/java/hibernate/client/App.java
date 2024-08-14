package hibernate.client;

import hibernate.entity.Address;
import hibernate.entity.Employee;
import hibernate.util.config;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {

	public static void main(String[] args) {

		SessionFactory sf = config.getSessionFactory();
		Session ss = sf.openSession();
	
//		save(ss);
//		update(ss, 1, "Anu");
//		delete(ss, 2);
//		searchById(ss, 5);
		fectAllData(ss);

	}

	public static void save(Session ss) {

		Transaction tx = ss.beginTransaction();
		Address ad = new Address();
		ad.setCity("jaunpur");
		ad.setState("UP");
		ad.setPin_code(202115);

		Employee e = new Employee("arpit ", "male", 2580000, ad);

		ss.persist(e);
		tx.commit();
		System.out.println(".............Data Inserted Successfully...........");
	}

	public static void fectAllData(Session ss) {
		System.out.println("............Data Fetching............");
		List<Employee> Emp = ss.createQuery("From Employee", Employee.class).getResultList();

		for (Employee E : Emp) {
			System.out.println(E);
		}
	}
	
	public static void update(Session ss, int employeeId, String newName) {
		Transaction tx = ss.beginTransaction();
		Employee e = ss.get(Employee.class, employeeId);
		if (e != null) {
			e.setName(newName);
			ss.update(e);
			tx.commit();
			System.out.println(".............Data Updated Successfully...........");
		} else {
			tx.rollback();
			System.out.println(".............Employee Not Found...........");
		}
	}

	public static void delete(Session ss, int employeeId) {
		Transaction tx = ss.beginTransaction();
		Employee e = ss.get(Employee.class, employeeId);
		if (e != null) {
			ss.delete(e);
			tx.commit();
			System.out.println(".............Data Deleted Successfully...........");
		} else {
			tx.rollback();
			System.out.println(".............Employee Not Found...........");
		}
	}
	
	 public static void searchById(Session ss, int employeeId) {
	        System.out.println("............Searching Data............");
	        Employee e = ss.get(Employee.class, employeeId);
	        if (e != null) {
	            System.out.println(e);
	        } else {
	            System.out.println(".............Employee Not Found...........");
	        }
	    }
	
}
