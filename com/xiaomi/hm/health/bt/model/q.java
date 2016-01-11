package com.xiaomi.hm.health.bt.model;

public class q {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;

    public String toString() {
        return "<vendorId:" + Integer.toHexString(this.a) + ",productId:" + Integer.toHexString(this.b) + ",productVersion:" + Integer.toHexString(this.c) + ",companyId:" + Integer.toHexString(this.d) + ">";
    }
}
