package cn.com.smartdevices.bracelet.eventbus.weight;

public class EventWeightChanged {
    public boolean forceUpdate;
    public int[] uids;

    public EventWeightChanged(boolean z, int... iArr) {
        this.forceUpdate = z;
        this.uids = iArr;
    }

    public EventWeightChanged(int... iArr) {
        this.uids = iArr;
    }
}
