package models;

import java.util.ArrayList;
import java.util.List;

public class Room {
    String id, name;
    String country, city;
    int floorNo, number;
    int capacity;
    boolean hasScreen;
    List<Slot> slots;

    public Room(String id, String name, String country, String city, int floorNo, int number, int capacity, boolean hasScreen) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.floorNo = floorNo;
        this.number = number;
        this.capacity = capacity;
        this.hasScreen = hasScreen;
        slots = new ArrayList<>();
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void addTimeSlot(Slot slot){
        slots.add(slot);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasScreen() {
        return hasScreen;
    }

    public void setHasScreen(boolean hasScreen) {
        this.hasScreen = hasScreen;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", floorNo=" + floorNo +
                ", number=" + number +
                ", capacity=" + capacity +
                ", hasScreen=" + hasScreen +
                ", slots=" + slots +
                '}';
    }
}
