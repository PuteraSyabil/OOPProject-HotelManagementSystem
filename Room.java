public abstract class Room {  //abstract class,inheritance,polymorphism
	private String roomNo;
	private Status status;
	private int price;

	private Guest guest;

	public Room() {
		roomNo = "A000";
		guest = new Guest();
	}

	public Room(String roomNo) {
		this.roomNo = roomNo;
		guest = new Guest();
	}
	

	public Room(String roomNo, Status status) {
		this.roomNo = roomNo;
		this.status = status;
		guest = new Guest();
	}
	
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Guest getGuest(){
		return guest;
	}
	public void setGuest(Guest guest){
		this.guest = guest;
	}
	
	public void clearGuest(){
		guest.setName("none");
		guest.setId("none");
		guest.setRoom(null);
		guest.setDateCheckin("null");
		guest.setDateCheckout("");
		status = Status.Available;
	}
}