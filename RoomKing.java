public class RoomKing extends Room{
    public static int count = 0;

    public RoomKing(){
        super();
        
    }

    public RoomKing(String roomNo,Status status){
        super(roomNo,status);
        super.setPrice(500);
        count++;
    }

    public int getRoomCount(RoomKing room){
        return count;
    }
    
    

    
    
    
}