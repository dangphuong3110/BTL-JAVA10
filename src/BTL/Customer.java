package BTL;

public class Customer {
	private String idCustomer, nameCustomer, identityCardCustomer, nationalityCustomer,contactCustomer;
	public Customer() {
		super();
	}
	public Customer(String idCustomer, String nameCustomer, String identityCardCustomer, String nationalityCustomer,
			String contactCustomer, boolean genderCustomer, int ageCustomer) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.identityCardCustomer = identityCardCustomer;
		this.nationalityCustomer = nationalityCustomer;
		this.contactCustomer = contactCustomer;
		this.genderCustomer = genderCustomer;
		this.ageCustomer = ageCustomer;
	}
	public String getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getIdentityCardCustomer() {
		return identityCardCustomer;
	}
	public void setIdentityCardCustomer(String identityCardCustomer) {
		this.identityCardCustomer = identityCardCustomer;
	}
	public String getNationalityCustomer() {
		return nationalityCustomer;
	}
	public void setNationalityCustomer(String nationalityCustomer) {
		this.nationalityCustomer = nationalityCustomer;
	}
	public String getContactCustomer() {
		return contactCustomer;
	}
	public void setContactCustomer(String contactCustomer) {
		this.contactCustomer = contactCustomer;
	}
	public boolean isGenderCustomer() {
		return genderCustomer;
	}
	public void setGenderCustomer(boolean genderCustomer) {
		this.genderCustomer = genderCustomer;
	}
	public int getAgeCustomer() {
		return ageCustomer;
	}
	public void setAgeCustomer(int ageCustomer) {
		this.ageCustomer = ageCustomer;
	}
	private boolean genderCustomer;
	private int ageCustomer;
}
