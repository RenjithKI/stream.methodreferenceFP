package streams.map.ToOtherObj.Examples;


import java.math.BigDecimal;

public class StaffPublic {

    private String name;
    private int age;
    private String extra;
    
    
    
	public StaffPublic() {
		super();
	}
	public StaffPublic(String name, int age, String extra) {
		super();
		this.name = name;
		this.age = age;
		this.extra = extra;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getExtra() {
		return extra;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
    
}