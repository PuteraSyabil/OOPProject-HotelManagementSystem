public class RoomSingle extends Room{
    public static int count = 0;

    public RoomSingle(){
        super();
    }

    public RoomSingle(String roomNo,Status status){
        super(roomNo,status);
        super.setPrice(100);
        count++;
    }
    public int getRoomCount(RoomSingle room){
        return count;
    }
   
    

    
    
    
}