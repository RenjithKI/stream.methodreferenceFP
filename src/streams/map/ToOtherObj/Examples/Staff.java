package streams.map.ToOtherObj.Examples;

import java.math.BigDecimal;

public class Staff {

    private String name;
    private int age;
    private BigDecimal salary;
    
    
    
    
	public Staff(String name, int age, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
    
    
}