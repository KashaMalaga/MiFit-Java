package cn.com.smartdevices.bracelet.eventbus.shoes;

import kankan.wheel.widget.a;

public class EventDeviceBoundState {
    public static final int BOUND = 1;
    public static final int UNBOUND = 0;
    public int mState = 0;
    public int mType = 3;

    public EventDeviceBoundState(int i, int i2) {
        this.mType = i;
        this.mState = i2;
    }

    public String toString() {
        return "[" + this.mType + a.ci + this.mState + "]";
    }
}
