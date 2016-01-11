package cn.com.smartdevices.bracelet.eventbus.weight;

public class EventUserPicked {
    public static final int ACTION_MOVE_WEIGHT = 1;
    public static final int ACTION_VIEW = 2;
    public int action;
    public int uid;

    public EventUserPicked(int i, int i2) {
        this.uid = i;
        this.action = i2;
    }
}
