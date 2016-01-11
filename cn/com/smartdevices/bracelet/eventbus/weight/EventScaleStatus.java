package cn.com.smartdevices.bracelet.eventbus.weight;

public class EventScaleStatus {
    public static final int SCALE_CONNECT_TIME_OUT = 256;
    public static final int SCALE_FOUNDED = 257;
    public int status;

    public EventScaleStatus(int i) {
        this.status = i;
    }
}
