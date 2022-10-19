package BTL;

public class Room {
	private String idRoom, nameRoom, typeRoom,stateRoom,noteRoom,idStaff, idService;
	public String getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}
	public String getIdService() {
		return idService;
	}
	public void setIdService(String idService) {
		this.idService = idService;
	}
	private int priceRoom;

	public String getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}
	public String getNameRoom() {
		return nameRoom;
	}
	public Room() {
		super();
	}
	public Room(String idRoom, String nameRoom, String typeRoom, int priceRoom, String stateRoom, String noteRoom, String idStaff,
			String idService) {
		super();
		this.idRoom = idRoom;
		this.nameRoom = nameRoom;
		this.typeRoom = typeRoom;
		this.stateRoom = stateRoom;
		this.noteRoom = noteRoom;
		this.idStaff = idStaff;
		this.idService = idService;
		this.priceRoom = priceRoom;
	}
	
	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}
	public String getTypeRoom() {
		return typeRoom;
	}
	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}
	public String getStateRoom() {
		return stateRoom;
	}
	public void setStateRoom(String stateRoom) {
		this.stateRoom = stateRoom;
	}
	public String getNoteRoom() {
		return noteRoom;
	}
	public void setNoteRoom(String noteRoom) {
		this.noteRoom = noteRoom;
	}
	public int getPriceRoom() {
		return priceRoom;
	}
	public void setPriceRoom(int priceRoom) {
		this.priceRoom = priceRoom;
	}
}
