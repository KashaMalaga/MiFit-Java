package cn.com.smartdevices.bracelet.eventbus;

import com.xiaomi.hm.health.bt.profile.Weight.e;

public class EventWeightWithUser {
    public e mWeightAdvData;
    public int uid;

    public EventWeightWithUser(e eVar, int i) {
        this.mWeightAdvData = eVar;
        this.uid = i;
    }
}
