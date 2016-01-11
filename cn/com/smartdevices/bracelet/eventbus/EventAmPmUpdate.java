package cn.com.smartdevices.bracelet.eventbus;

public class EventAmPmUpdate {
    int ampm;

    public EventAmPmUpdate(int i) {
        this.ampm = i;
    }

    public int getAmPm() {
        return this.ampm;
    }
}
