/** implement room business logic */
public class RoomBiz {
    /** Get the number of room in particular type */
    public int getRoomCount(Room... rooms) {// determine the room type and return the room count
        int count = 0;
        for (Room room : rooms) {
            if (room == null)
                break;
            count++;
        }
        return count;
    }

    /** Get the number of roomsingle */
    public int getRoomSingleCount() {
        int count = 0;
        for (Room room : Data.RoomSingle) {
            if (room == null)
                break;
            count++;
        }
        return count;
    }

    /** Get the number of roomdouble */
    public int getRoomDoubleCount() {
        int count = 0;
        for (Room room : Data.RoomDouble) {
            if (room == null)
                break;
            count++;
        }
        return count;
    }

    /** Get the number of roomking */
    public int getRoomKingCount() {
        int count = 0;
        for (Room room : Data.RoomKing) {
            if (room == null)
                break;
            count++;
        }
        return count;
    }

    public Room findByNo(String roomtype, String roomNo) {
        roomtype = roomtype.toLowerCase();
        if ("roomking".equals(roomtype)) {
            int roomCount = getRoomKingCount();
            for (int i = 0; i < roomCount; i++) {
                if (roomNo.equals(Data.RoomKing[i].getRoomNo()))
                    return Data.RoomKing[i];
            }

        } else if ("roomsingle".equals(roomtype)) {
            int roomCount = getRoomSingleCount();
            for (int i = 0; i < roomCount; i++) {
                if (roomNo.equals(Data.RoomSingle[i].getRoomNo()))
                    return Data.RoomSingle[i];
            }
        } else if ("roomdouble".equals(roomtype)) {
            int roomCount = getRoomDoubleCount();
            for (int i = 0; i < roomCount; i++) {
                if (roomNo.equals(Data.RoomDouble[i].getRoomNo()))
                    return Data.RoomDouble[i];
            }
        }

        return null;
    }

    /** add new roomking */
    public boolean addRoomKing(Room room) {
        int roomCount = getRoomKingCount();
        Data.RoomKing[roomCount] = room;
        return true;
    }

    /** add new roomsingle */
    public boolean addRoomSingle(Room room) {
        int roomCount = getRoomSingleCount();
        Data.RoomSingle[roomCount] = room;
        return true;
    }

    /** add new roomdouble */
    public boolean addRoomDouble(Room room) {
        int roomCount = getRoomDoubleCount();
        Data.RoomDouble[roomCount] = room;
        return true;
    }
}