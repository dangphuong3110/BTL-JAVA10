package BTL;

import java.sql.Date;

public class Staff {
	private String idStaff, nameStaff, positionStaff,contactSatff;
	private int salaryStaff;
	private Date dateOfBirthStaff;
	private boolean genderStaff;
	public String getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}
	public String getNameStaff() {
		return nameStaff;
	}
	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}
	public String getPositionStaff() {
		return positionStaff;
	}
	public void setPositionStaff(String positionStaff) {
		this.positionStaff = positionStaff;
	}
	public String getContactSatff() {
		return contactSatff;
	}
	public void setContactSatff(String contactSatff) {
		this.contactSatff = contactSatff;
	}
	public int getSalaryStaff() {
		return salaryStaff;
	}
	public void setSalaryStaff(int salaryStaff) {
		this.salaryStaff = salaryStaff;
	}
	public Date getDateOfBirthStaff() {
		return dateOfBirthStaff;
	}
	public void setDateOfBirthStaff(Date dateOfBirthStaff) {
		this.dateOfBirthStaff = dateOfBirthStaff;
	}
	public boolean isGenderStaff() {
		return genderStaff;
	}
	public void setGenderStaff(boolean genderStaff) {
		this.genderStaff = genderStaff;
	}
	public Staff(String idStaff, String nameStaff, String positionStaff, String contactSatff, int salaryStaff,
			Date dateOfBirthStaff, boolean genderStaff) {
		super();
		this.idStaff = idStaff;
		this.nameStaff = nameStaff;
		this.positionStaff = positionStaff;
		this.contactSatff = contactSatff;
		this.salaryStaff = salaryStaff;
		this.dateOfBirthStaff = dateOfBirthStaff;
		this.genderStaff = genderStaff;
	}
	public Staff() {
		super();
	}
	
}
