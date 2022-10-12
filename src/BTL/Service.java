package BTL;

public class Service {
	private String idService, nameService;
	private int priceService;
	public String getIdService() {
		return idService;
	}
	public void setIdService(String idService) {
		this.idService = idService;
	}
	public String getNameService() {
		return nameService;
	}
	public void setNameService(String nameService) {
		this.nameService = nameService;
	}
	public int getPriceService() {
		return priceService;
	}
	public void setPriceService(int priceService) {
		this.priceService = priceService;
	}
	public Service(String idService, String nameService, int priceService) {
		super();
		this.idService = idService;
		this.nameService = nameService;
		this.priceService = priceService;
	}
	public Service() {
		super();
	}
	
}
