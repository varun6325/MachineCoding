package service;

import models.Booking;
import models.Room;
import models.Slot;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    Map<String, Booking> bookings = new HashMap();
    Map<User, List<Booking>> usertoBookingsMap = new HashMap<>();
    int counter = 0;
    private static BookingService bookingService;
    private BookingService(){}
    public static BookingService getInstance(){
        if(bookingService == null)
            bookingService = new BookingService();
        return bookingService;
    }
    public Booking addBooking(Room room, User owner, Slot slot, List<User> participants) throws Exception{
        counter++;
        String bookingId = "Booking-"+counter;
        Booking booking = null;
        synchronized (this){
            boolean isIntersectingSlot = false;
            List<Slot> slots = room.getSlots();
            for(Slot s : slots){
                if(s.isIntersecting(slot)) {
                    isIntersectingSlot = true;
                    break;
                }
            }
            if(isIntersectingSlot)
                throw new Exception(" slot already booked for this room + " + room.getId());
            booking = new Booking(bookingId, owner, room, slot, participants);
            bookings.put(bookingId, booking);
            room.getSlots().add(slot);
        }
        if(!usertoBookingsMap.containsKey(owner))
            usertoBookingsMap.put(owner, new ArrayList());
        usertoBookingsMap.get(owner).add(booking);
        return booking;
    }
    public List<Booking> getAllBookingsByUser(User user){
        return usertoBookingsMap.get(user);
    }
}
