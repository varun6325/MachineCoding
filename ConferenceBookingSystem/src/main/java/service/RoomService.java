package service;

import models.Room;
import models.Slot;

import java.sql.Timestamp;
import java.util.*;

public class RoomService {
    int counter = 0;
    Map<String, Room> rooms = new HashMap<>();
    private static RoomService roomService;
    private RoomService(){}
    public static RoomService getInstance(){
        if(roomService == null)
            roomService = new RoomService();
        return roomService;
    }

    public Room addRoom(String name, String country, String city, int floorNo, int locationNumber, int capacity, boolean hasScreen){
        counter++;
        String roomId = "Room-"+counter;
        Room room = new Room(roomId, name, country, city, floorNo, locationNumber, capacity, hasScreen);
        rooms.put(roomId, room);
        return room;
    }
    public Room getRoom(String roomId){
        return rooms.getOrDefault(roomId, null);
    }
    public void deleteRoom(String roomId) throws Exception{
        if(rooms.get(roomId) == null)
            throw new Exception("room does not exist with room id : " + roomId);
        rooms.remove(roomId);
    }
    public List<Room> getRooms(int capacity, boolean hasScreens, String country, String city, int floorNo, Slot slot){
        List<Room> ret = new ArrayList<>();
        for(Room room : rooms.values()){
            if(room.isHasScreen() == hasScreens && room.getCapacity() >= capacity && room.getCountry().equals(country) && room.getCity().equals(city) && room.getFloorNo() == floorNo){
                List<Slot> slots = room.getSlots();
                boolean hasIntersectingSlot = false;
                for(Slot s : slots){
                    if(s.isIntersecting(slot)){
                        hasIntersectingSlot = true;
                        break;
                    }
                }
                if(!hasIntersectingSlot)
                    ret.add(room);
            }
        }
        Collections.sort(ret, (a,b) -> a.getNumber()-b.getNumber());
        return ret;
    }
}
