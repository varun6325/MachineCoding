import controller.Controller;
import models.Booking;
import models.Room;
import models.Slot;
import models.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Controller controller = new Controller();
        User user1 = controller.addUser("Varun", "India", "Delhi", 5, 2);
        User user2 = controller.addUser("Bharat", "India", "Delhi", 2, 6);
        User user3 = controller.addUser("Jatin", "India", "Delhi", 6, 1);
        User user4 = controller.addUser("charu", "India", "Delhi", 5, 1);
        User user5 = controller.addUser("Astha", "India", "Delhi", 5, 10);
        //System.out.println(user5);
        Room room1 = controller.addRoom("room1", "India", "Delhi", 2, 4, 10, true);
        Room room2 = controller.addRoom("room2", "India", "Delhi", 2, 1, 10, true);
        Room room3 = controller.addRoom("room3", "India", "Delhi", 5, 5, 10, false);
        Room room4 = controller.addRoom("room1", "India", "Delhi", 5, 10, 10, true);
        Room room5 = controller.addRoom("room1", "India", "Delhi", 2, 4, 10, true);
        //System.out.println(room5);
        List<Room> availableRooms = controller.getAvailableRooms(11, true, "India", "Delhi", 5,
                new Timestamp(System.currentTimeMillis()+3600000), new Timestamp(System.currentTimeMillis()+7200000));
        System.out.println(availableRooms.size());
        availableRooms = controller.getAvailableRooms(5, true, "India", "Delhi", 5,
                new Timestamp(System.currentTimeMillis()+3600000), new Timestamp(System.currentTimeMillis()+7200000));
        System.out.println(availableRooms.size());
        availableRooms = controller.getAvailableRooms(5, true, "India", "Delhi", 2,
                new Timestamp(System.currentTimeMillis()+3600000), new Timestamp(System.currentTimeMillis()+7200000));
        System.out.println(availableRooms.size());
        Slot slot = new Slot(new Timestamp(System.currentTimeMillis()+3600000), new Timestamp(System.currentTimeMillis()+7200000));
        System.out.println(availableRooms.get(0));
        Booking booking = controller.bookRoom(availableRooms.get(0), user1, slot, new ArrayList<>());
        System.out.println(booking);
        availableRooms = controller.getAvailableRooms(5, true, "India", "Delhi", 2,
                new Timestamp(System.currentTimeMillis()+3600000), new Timestamp(System.currentTimeMillis()+7200000));
        System.out.println(availableRooms.size());
        booking = controller.bookRoom(availableRooms.get(0), user1, slot, new ArrayList<>());
        System.out.println(booking);
    }
}
