public class RoomDouble extends Room{
    public static int count = 0;

    public RoomDouble(){
        super();
        
    }

    public RoomDouble(String roomNo,Status status){
        super(roomNo,status);
        super.setPrice(150);
        count++;
    }
    public int getRoomCount(RoomDouble room){
        return count;
    }

   
    

    
    
    
}