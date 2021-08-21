package models;

import java.sql.Timestamp;

public class Slot {
    Timestamp startTime;
    Timestamp endTime;

    public Slot(Timestamp startTime, Timestamp endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public boolean isIntersecting(Slot newSlot){
        if(this.startTime.compareTo(newSlot.startTime) > 0 && this.startTime.compareTo(newSlot.endTime) < 0)
            return true;
        if(this.endTime.compareTo(newSlot.startTime) > 0 && this.endTime.compareTo(newSlot.endTime) < 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
