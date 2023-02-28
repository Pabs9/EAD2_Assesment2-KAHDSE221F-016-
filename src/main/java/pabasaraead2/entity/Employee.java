package pabasaraead2.entity;

public class Employee {
	
	private int id;
	private String nic;
	private String name;
	private String department;
	private String designation;
	private String joinedDate;
	
	public Employee() {
		this.id = 000000000000000;
		this.nic = "";
		this.name = "";
		this.department = "";
		this.designation = "";
		this.joinedDate = "";
	}
	
	public String getNic() {
		return nic;
	}

	public void setNic(String _nic) {
		this.nic = _nic;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String _name) {
		this.name = _name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String _department) {
		this.department = _department;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String _designation) {
		this.designation = _designation;
	}
	public String getJoinedDate() {
		return joinedDate;
	}
	
	public void setJoinedDate(String _joinedDate) {
		this.joinedDate = _joinedDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int _id) {
		this.id = _id;
	}
}
