package cn.com.smartdevices.bracelet.lab.sync;

import cn.com.smartdevices.bracelet.model.SyncedServerDataInfo;

class k {
    private k() {
    }

    public static void a(int i, boolean z) {
        SyncedServerDataInfo readInfoFromPref = SyncedServerDataInfo.readInfoFromPref(i);
        if (z) {
            readInfoFromPref.setState(3);
        } else {
            readInfoFromPref.restState();
        }
        readInfoFromPref.saveInfo();
    }
}
