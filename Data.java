public class Data {
	/** To store room information */
	public static Room[] RoomKing = new RoomKing[30];
	public static Room[] RoomSingle = new RoomSingle[30];
	public static Room[] RoomDouble = new RoomDouble[30];

	static {

		Room room1 = new RoomKing("KA01", Status.Available);
		Room room7 = new RoomKing("KA02", Status.Available);
		Room room10 = new RoomKing("KA03", Status.Available);
		Room room11 = new RoomKing("KA04", Status.Available);
		Room room12 = new RoomKing("KA05", Status.Available);

		Room room2 = new RoomSingle("SA01", Status.Available);
		Room room4 = new RoomSingle("SA02", Status.Available);
		Room room5 = new RoomSingle("SA03", Status.Available);
		Room room6 = new RoomSingle("SA04", Status.Available);
		Room room9 = new RoomSingle("SA05", Status.Available);

		Room room3 = new RoomDouble("DA01", Status.Available);
		Room room8 = new RoomDouble("DA02", Status.Available);
		Room room13 = new RoomDouble("DA03", Status.Available);
		Room room14 = new RoomDouble("DA04", Status.Available);
		Room room15 = new RoomDouble("DA05", Status.Available);

		RoomKing[0] = room1;
		RoomKing[1] = room7;
		RoomKing[2] = room10;
		RoomKing[3] = room11;
		RoomKing[4] = room12;

		RoomDouble[0] = room3;
		RoomDouble[1] = room8;
		RoomDouble[2] = room13;
		RoomDouble[3] = room14;
		RoomDouble[4] = room15;

		RoomSingle[0] = room2;
		RoomSingle[1] = room4;
		RoomSingle[2] = room5;
		RoomSingle[3] = room6;
		RoomSingle[4] = room9;

	}

}