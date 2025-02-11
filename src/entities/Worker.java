package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	// Atributos
	private String name;
	private WorkerLevel level;
	private Double baseSalary;	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	// Métodos Getters e Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setWorkerLevel(WorkerLevel level) {
		this.level = level;
	}
	
	public WorkerLevel getLevel() {
		return level;
	}
	
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public Double getBaseSalary() {
		return baseSalary;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	//public void setContracts(List<HourContract> contracts) {
	//	this.contracts = contracts;
	//}
	
	public List<HourContract> getContracts(){
		return contracts;
	}
	
	
	// Construtor
	public Worker() {
		
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	// Métodos
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum; 
	}
	
}
