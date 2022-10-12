package BTL;

import java.sql.Date;

public class Bill {
	private String idBill;
	private Date dateBill;
	public String getIdBill() {
		return idBill;
	}
	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}
	public Date getDateBill() {
		return dateBill;
	}
	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}
	public Bill() {
		super();
	}
	public Bill(String idBill, Date dateBill) {
		super();
		this.idBill = idBill;
		this.dateBill = dateBill;
	}
}
