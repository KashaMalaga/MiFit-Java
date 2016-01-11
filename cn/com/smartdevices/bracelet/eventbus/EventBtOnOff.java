package cn.com.smartdevices.bracelet.eventbus;

public class EventBtOnOff {
    public static final int OFF = 1;
    public static final int ON = 0;
    public int type = 0;

    public EventBtOnOff(int i) {
        this.type = i;
    }
}
