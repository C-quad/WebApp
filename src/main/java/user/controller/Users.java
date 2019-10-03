package user.controller;

public class Users 
{
	private int employeeId; 
	private String firstName; 
	private String lastName; 
	
	//Constructor
	public Users()
	{
		
	}
	
	
	// Setters and getters 
	
	public int getEmployeeId()
	{
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId)
	{
		this.employeeId = employeeId;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	@Override
    public String toString() {
        return "Emplyee info{" +
                "Emplouee ID: " + employeeId +
                ", First Name: " + firstName + '\'' +
                ", Last Name: " + lastName+ '\'' +
                '}';
    }
}
