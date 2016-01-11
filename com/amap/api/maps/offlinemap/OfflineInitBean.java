package com.amap.api.maps.offlinemap;

public class OfflineInitBean {
    boolean a;
    String b;

    public String getVersion() {
        return this.b;
    }

    public boolean isNeedUpdate() {
        return this.a;
    }

    public void setNeedUpdate(boolean z) {
        this.a = z;
    }

    public void setVersion(String str) {
        this.b = str;
    }
}
