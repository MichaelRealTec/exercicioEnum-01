package entities;

public class Department {
	private String name;
	
	// Método Getter e Setter
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// Construtor
	public Department() {
		
	}
	
	public Department(String name) {
		this.name = name;
	}
}
