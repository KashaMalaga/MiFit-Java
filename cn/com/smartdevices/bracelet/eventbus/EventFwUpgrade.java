package cn.com.smartdevices.bracelet.eventbus;

public class EventFwUpgrade {
    public static final int FW_TYPE_PROGRESS = 1;
    public static final int FW_TYPE_START = 0;
    public static final int FW_TYPE_STOP = 2;
    private Object data = null;
    private int type = FW_TYPE_START;

    public EventFwUpgrade(int i, Object obj) {
        this.type = i;
        this.data = obj;
    }

    public Object data() {
        return this.data;
    }

    public int type() {
        return this.type;
    }
}
