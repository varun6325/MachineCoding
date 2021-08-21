package controller;

import models.Booking;
import models.Room;
import models.Slot;
import models.User;
import service.BookingService;
import service.RoomService;
import service.UserService;

import java.awt.print.Book;
import java.sql.Timestamp;
import java.util.List;

public class Controller {

    public User addUser(String userName, String country, String city, int floorNo, int locationNumber) {
        return UserService.getInstance().addUser(userName, country, city, floorNo, locationNumber);
    }
    public Room addRoom(String name, String country, String city, int floorNo, int locationNumber, int capacity, boolean hasScreen){
        return RoomService.getInstance().addRoom(name, country, city, floorNo, locationNumber, capacity, hasScreen);
    }

    public Room getRoom(String roomId){
        return RoomService.getInstance().getRoom(roomId);
    }
    public List<Room> getAvailableRooms(int capacity, boolean hasScreens, String country, String city, int floorNo, Timestamp startTime, Timestamp endTime){
        Slot slot = new Slot(startTime, endTime);
        return RoomService.getInstance().getRooms(capacity, hasScreens, country, city, floorNo, slot);
    }
    public Booking bookRoom(Room room, User owner, Slot slot, List<User> participants){
        try {
            return BookingService.getInstance().addBooking(room, owner, slot, participants);
        }catch(Exception ex){
            System.out.println(ex.getStackTrace());
            return null;
        }
    }
    public List<Booking> getAllBookingsForUser(User user){
        return BookingService.getInstance().getAllBookingsByUser(user);
    }
}
