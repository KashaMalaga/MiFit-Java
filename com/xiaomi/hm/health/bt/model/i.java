package com.xiaomi.hm.health.bt.model;

public class i {
    public String a = null;
    public String b = null;
    public String c = null;
    public q d = null;

    public i(String str, String str2, String str3, q qVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = qVar;
    }

    public boolean a() {
        return (this.a == null || this.c == null) ? false : true;
    }

    public String toString() {
        return "<deviceID:" + this.a + ",serialNumber:" + this.b + ",firmwareRevision:" + this.c + ",pnp:" + this.d + ">";
    }
}
