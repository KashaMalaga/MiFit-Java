package cn.com.smartdevices.bracelet.eventbus;

public class Event12HourUpdate {
    int hour;

    public Event12HourUpdate(int i) {
        this.hour = i;
    }

    public int getHour() {
        return this.hour;
    }
}
