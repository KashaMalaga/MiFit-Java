package cn.com.smartdevices.bracelet.eventbus.weight;

public class EventWeightSyncedServer {
    public static final int STATE_FAILED = 0;
    public static final int STATE_SUCCESSED = 1;
    public int state = STATE_FAILED;

    public EventWeightSyncedServer(boolean z) {
        int i = STATE_FAILED;
        if (z) {
            i = STATE_SUCCESSED;
        }
        this.state = i;
    }
}
