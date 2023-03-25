package SerializationPackage;

public class EmployeeDetails {
	
	String name;
	String place;
	String emailid;
	Long phoneno[];
	Kids kids;
	public Long[] getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(Long[] phoneno) {
		this.phoneno = phoneno;
	}
	public EmployeeDetails(String name, String place, String emailid,Long[] phoneno,Kids kids) {
		super();
		this.name = name;
		this.place = place;
		this.emailid = emailid;
		this.phoneno=phoneno;
		this.kids=kids;
	}
	public EmployeeDetails()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getKids() {
		return kids;
	}
	public void setKids(Kids kids) {
		this.kids = kids;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	

}
