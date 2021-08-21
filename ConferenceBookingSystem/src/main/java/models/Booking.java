package models;

import java.sql.Timestamp;
import java.util.List;

public class Booking {
    String id;
    User owner;
    Room room;
    Timestamp startTime, endTime;
    List<User> participants;
    Slot slot;
    public Booking(String id, User owner, Room room, Slot slot, List<User> participants) {
        this.id = id;
        this.owner = owner;
        this.room = room;
        this.slot = slot;
        this.participants = participants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", owner=" + owner +
                ", room=" + room +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", participants=" + participants +
                ", slot=" + slot +
                '}';
    }
}
