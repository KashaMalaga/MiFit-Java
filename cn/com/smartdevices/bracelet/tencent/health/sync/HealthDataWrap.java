package cn.com.smartdevices.bracelet.tencent.health.sync;

import cn.com.smartdevices.bracelet.i.a.i;
import cn.com.smartdevices.bracelet.tencent.health.HealthData;
import com.d.a.a.O;
import java.util.HashMap;
import java.util.Map;

public class HealthDataWrap extends i<HealthData, O> {
    public Map<String, String> mOAuthInfo;

    public HealthDataWrap(Map<String, String> map) {
        this.mOAuthInfo = map;
    }

    public O wrap(HealthData healthData) {
        Map hashMap = new HashMap();
        hashMap.putAll(this.mOAuthInfo);
        hashMap.putAll(healthData.toMap());
        return new O(hashMap);
    }
}
