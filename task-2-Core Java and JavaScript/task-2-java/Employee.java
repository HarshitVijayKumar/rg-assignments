class Employee{
	private int id;
	private String name;
	private String department;

	public Employee(int id, String name, String department){
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;}

	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}

	public String getdept() {return this.department;}
	public void setdept(String dept) {this.department = dept;}

	@Override
	public String toString(){
		return "Employee [ID= "+this.id+", Name = "+this.name+" , Department = "+this.department +"]";
	}
}
