import java.util.Date;

public class Guest {
    private String name;
    private String id;
    private Room room;

    private String dateCheckin;
    private int duration;  // how many days the guest live
    private String dateCheckout;

	public Guest()
	{
		name="none";
		id="none";
	}
   
	

    public Guest(String name, String id, Room room) {
        this.name = name;
        this.id = id;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Room getRoom(){
        return room;
    }
    public void setRoom(Room room){
        this.room = room;
    }
    public String getDateCheckin(){
        return dateCheckin;
    }
    public String getDateCheckout(){
        return dateCheckout;
    }
    public void setDateCheckin(String dateCheckin){
        this.dateCheckin = dateCheckin;
    }
    public void setDateCheckout(String dateCheckout){
        this.dateCheckout = dateCheckout;
    }
    private int getDuration(){
        return duration;
    }
    private void setDuration(int duration){
        this.duration = duration;
    }
}