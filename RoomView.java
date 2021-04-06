import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomView {
	private Scanner input = null;
	private RoomBiz roomBiz = null;
	private String choice;// choice is for inside room view

	public RoomView() {
		input = new Scanner(System.in);
		roomBiz = new RoomBiz();

		System.out.println("***********************************************");
		System.out.println("\tWelcome To Hotel Management System");
		System.out.println("\t\tPress any key to start\n\n\t\t Press 0 to exit");
		System.out.println("***********************************************");
		System.out.print("Please Choose: ");
		choice = input.next();

		if (!"0".equals(choice)) {// press any key, will go to main menu
			showMainView();
		}
		System.out.println("System Exit Successful!");// if enter 0, program exit
	}

	/** main menu */
	public void showMainView() {
		System.out.println("***********************************************");
		System.out.println("Hotel Management System >> Main Menu");
		System.out.println("***********************************************");
		System.out.println("1. Check In\n2. Check Out\n3. Add Room\n4. View Room \n5. Exit");
		System.out.print("\nPlease Choose: ");
		String choiceMM = input.next();// choiceMM is for main menu function only
		switch (choiceMM) {
			case "1":
				showCheckInView();
				break;
			case "2":
				showCheckOutView();
				break;
			case "3":
				showAddRoomView();
				break;
			case "4":
				showRoomView();
			case "5":
				System.out.println("System Exit Successful!");
				System.exit(0);
			default:
				System.out.println("You did not enter the correct number!");

		}
		showMainView(); // call itself if break
	}

	public void showCheckOutView() {
		try
		{
		System.out.println("\nHotel Management System >> Check Out");
		System.out.print("Room No: ");
		String roomNo = input.next();//
		System.out.print("\nGuest ID: ");
		String gID = input.next();
		System.out.print("Please enter Room Type (roomking/roomsingle/roomdouble): ");
		String roomtype = input.next();
		Room roomCheckout = roomBiz.findByNo(roomtype, roomNo);
		if (roomCheckout.getGuest().getId().equals(gID)) {
			roomCheckout.clearGuest();

			System.out.println("Check out Successfully!");
		} else {
			System.out.println("Guest ID does not match!");
		}
		}
		catch(NullPointerException e)
		{
			System.out.println("Room type does not exist!");
			System.out.println("You will be directing to main menu!");
			showMainView();
		}
	}

	/** check in view */
	public void showCheckInView() {
		System.out.println("\nHotel Management System >> Check In");
		System.out.print("Room No: ");
		String roomNo = input.next();
		System.out.print("Please enter Room Type (roomking/roomsingle/roomdouble): ");
		String roomtype = input.next();
		Room roomCheckin = roomBiz.findByNo(roomtype, roomNo);

		/**
		 * find this room by room type and roomNo if roomNo correct and status is
		 * avaliable, can check in
		 */
		if ((roomCheckin != null) && (roomCheckin.getStatus().equals(Status.Available))) {
			
			try{
			 int days;
			System.out.print("\nGuest Name: ");
			String gName = input.next();
			System.out.print("\nGuest ID: ");
			String gID = input.next();
			System.out.print("\nThe days prepaid: ");
			days = input.nextInt();
	
		
			Guest guest = new Guest(gName, gID, roomCheckin);
			roomCheckin.setStatus(Status.Occupied);
			roomCheckin.setGuest(guest);

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			// set check in date
			Calendar inDate = Calendar.getInstance();
			Date checkinDate = inDate.getTime();
			String strCheckinDate = formatter.format(checkinDate);
			guest.setDateCheckin(strCheckinDate);

			// set check out date
			inDate.add(Calendar.DATE, days);
			inDate.set(Calendar.HOUR_OF_DAY, 12); //  check out should before 12 noon
			inDate.set(Calendar.MINUTE, 0);
			inDate.set(Calendar.SECOND, 0);
			Date checkoutDate = inDate.getTime();
			String strCheckoutDate = formatter.format(checkoutDate);
			guest.setDateCheckout(strCheckoutDate);
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Day prepaid are not integer number!");
				System.out.println("You will be directed to main menu.\n\n");
				showMainView();//direct to main menu again.


				//bellow just ignore.
				/*System.out.println("\nDo you want to continue check in?(Y/N)");
				Scanner inputC=new Scanner(System.in);
				String confirmation=inputC.next().toUpperCase();
				
				switch (confirmation){
				case "Y":
				{
					showCheckInView();
					break;
				}
				case "N":
				{
					showMainView();
					break;
				}
				default:
				{
					System.out.println("Invalid input, please enter correct input!");
				}
				}*/
				
				
			}
			

			



			showRooms(roomCheckin);
		} else {
			System.out.println("This room can not use!");
		}

		// initialise roomNo, gName and date to CheckIN class? using constructor.

		// TODO
	}

	/** add room view */
	public Room showAddRoomView() {
		System.out.println("***********************************************");
		System.out.println("Hotel Management System >> Add Room");
		System.out.println("***********************************************");
		
		System.out.print("Please enter Room Type (roomking/roomsingle/roomdouble): ");
		String roomType = input.next();
		// room is available by default
		// System.out.print("Please enter Room Status: ");
		// String status = input.next();
		roomType = roomType.toLowerCase();
		System.out.println("K=King, D= double, S=single \nA=Level A, B= Level B, C= Level C ");
		System.out.println("format example = KA01, last two is room number.");
		System.out.print("Please enter Room No: ");
		String roomNo = input.next();
		Room newRoom = roomBiz.findByNo(roomType, roomNo);
		if ("roomking".equals(roomType)) {
			if (newRoom == null) {
				newRoom = new RoomKing(roomNo, Status.Available);
				roomBiz.addRoomKing(newRoom);
				System.out.println("***********************************************");
				showRooms(Data.RoomKing);
				System.out.println("***********************************************");
				System.out.println("Add room successfully!");
			} else {
				System.out.println("This room is already in the system.Please input again!");
				newRoom = showAddRoomView();
			}
		} else if ("roomsingle".equals(roomType)) {
			if (newRoom == null) {
				newRoom = new RoomSingle(roomNo, Status.Available);
				roomBiz.addRoomSingle(newRoom);
				System.out.println("***********************************************");
				showRooms(Data.RoomSingle);
				System.out.println("***********************************************");
				System.out.println("Add room successfully!");
			} else {
				System.out.println("This room is already in the system.Please input again!");
				newRoom = showAddRoomView();
			}
		} else if ("roomdouble".equals(roomType)) {
			if (newRoom == null) {
				newRoom = new RoomDouble(roomNo, Status.Available);
				roomBiz.addRoomDouble(newRoom);
				System.out.println("***********************************************");
				showRooms(Data.RoomDouble);
				System.out.println("***********************************************");
				System.out.println("Add room successfully!");
			} else {
				System.out.println("This room is already in the system.Please input again!");
				newRoom = showAddRoomView();
			}
		} else {
			System.out.println("Invalid room type.Please input again!");
			newRoom = showAddRoomView();
		}
		return newRoom;
	}

	/** room view */
	public void showRoomView() {
		System.out.println("***********************************************");
		System.out.println("Hotel Management System >> View Room");
		System.out.println("***********************************************");
		System.out.println("1.King\t\t2.Single\t\t3.Double\n\n4. Main Menu \n5. Exit");
		System.out.print("\nPlease choose: ");
		String choiceSR = input.next();// choiceSR is for inside showRoom function only
		switch (choiceSR) {
			case "1":
				System.out.println("Hotel Management System >> View Room >> RoomKing");
				showRooms(Data.RoomKing);
				System.out.println("Press any key to continue...");
				String pause = input.next(); // does not mean anything
				showMainView();
				break;
			case "2":
				System.out.println("Hotel Management System >> View Room >> RoomSingle");
				showRooms(Data.RoomSingle);
				System.out.println("Press any key to continue...");
				pause = input.next();
				showMainView();
				break;
			case "3":
				System.out.println("Hotel Management System >> View Room >> RoomDouble");
				showRooms(Data.RoomDouble);
				System.out.println("Press any key to continue...");
				pause = input.next();
				showMainView();
				break;
			case "4":
				showMainView();
				return;

			case "5":
				System.out.println("System Exit Successful!");
				System.exit(0);
			default:
				System.out.println("You did not enter the correct number!");
				break;
		}

	}

	public void showRooms(Room... roomList) {
		System.out.println("RoomNo\tPrice/day\tStatus\t\tGuest Name\tID\t\tTime Check In\t\tTime Check Out");
		int roomCount = roomBiz.getRoomCount(roomList);
		for (int i = 0; i < roomCount; i++) {
			System.out.printf("%s\t%d\t\t%s\t%s\t\t%s\t%24s%24s\n", roomList[i].getRoomNo(), roomList[i].getPrice(),
					roomList[i].getStatus(), roomList[i].getGuest().getName(), roomList[i].getGuest().getId(),
					roomList[i].getGuest().getDateCheckin(),roomList[i].getGuest().getDateCheckout());
		}
	}

}