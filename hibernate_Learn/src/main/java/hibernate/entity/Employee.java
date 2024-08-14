package hibernate.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name="HCL_emp")
@Getter
@Setter


public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
	private String name;
	private String gender;

	private int salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address add;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", add=" + add
				+ "]";
	}

	public Employee(String name, String gender, int salary, Address add) {
		super();
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.add = add;
	}
	public Employee() {}
	
	
	

	

	

}
