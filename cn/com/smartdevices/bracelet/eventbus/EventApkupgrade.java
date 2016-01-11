package cn.com.smartdevices.bracelet.eventbus;

public class EventApkupgrade {
    private boolean forceCheck;

    public EventApkupgrade(boolean z) {
        this.forceCheck = z;
    }

    public boolean isForceCheck() {
        return this.forceCheck;
    }
}
