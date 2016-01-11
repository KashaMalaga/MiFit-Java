package cn.com.smartdevices.bracelet.eventbus.weight;

public class EventWeightSyncedDevice {
    public boolean forceUpdate;
    public int uid;

    public EventWeightSyncedDevice(int i) {
        this.uid = i;
    }

    public EventWeightSyncedDevice(boolean z) {
        this.forceUpdate = z;
    }
}
