package com.xiaomi.hm.health.bt.model;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public final class h {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public int g = -1;

    public h(String str, int i, int i2) {
        this.a = str;
        this.b = Integer.decode("0x" + str.substring(8, 10)).intValue();
        this.c = Integer.decode("0x" + str.substring(10, 12)).intValue();
        this.d = Integer.decode("0x" + str.substring(12, 14)).intValue();
        this.e = i;
        this.f = i2;
    }

    public h(String str, int i, int i2, int i3) {
        this.a = str;
        this.b = Integer.decode("0x" + str.substring(8, 10)).intValue();
        this.c = Integer.decode("0x" + str.substring(10, 12)).intValue();
        this.d = Integer.decode("0x" + str.substring(12, 14)).intValue();
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    public boolean a() {
        return (this.g == -1 || (this.d & HeartRateInfo.HR_EMPTY_VALUE) == 8) ? false : true;
    }

    public boolean b() {
        return ((this.b & HeartRateInfo.HR_EMPTY_VALUE) == 5 && (this.c & HeartRateInfo.HR_EMPTY_VALUE) == 0) || (((this.b & HeartRateInfo.HR_EMPTY_VALUE) == 0 && (this.d & HeartRateInfo.HR_EMPTY_VALUE) == 208) || (((this.b & HeartRateInfo.HR_EMPTY_VALUE) == 0 && (this.d & HeartRateInfo.HR_EMPTY_VALUE) == 8) || c()));
    }

    public boolean c() {
        return (this.b & HeartRateInfo.HR_EMPTY_VALUE) == 4 && (this.d & HeartRateInfo.HR_EMPTY_VALUE) == 8;
    }

    public int d() {
        return this.f & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int e() {
        return (this.f >> 24) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int f() {
        return (this.f >> 16) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int g() {
        return (this.f >> 8) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int h() {
        return this.e & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int i() {
        return (this.e >> 24) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int j() {
        return (this.e >> 16) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int k() {
        return (this.e >> 8) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public String l() {
        return e() + "." + f() + "." + g() + "." + d();
    }

    public int m() {
        return this.g & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int n() {
        return (this.g >> 24) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int o() {
        return (this.g >> 16) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int p() {
        return (this.g >> 8) & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public String q() {
        return n() + "." + o() + "." + p() + "." + m();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(PersonInfo.INCOMING_CALL_DISABLE_BIT);
        String str = a.f + i() + "." + j() + "." + k() + "." + h();
        stringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
        stringBuilder.append("\n         deviceID: " + this.a);
        stringBuilder.append("\n          feature: " + Integer.toHexString(this.b));
        stringBuilder.append("\n       appearance: " + Integer.toHexString(this.c));
        stringBuilder.append("\n  hardwareVersion: " + Integer.toHexString(this.d));
        stringBuilder.append("\n   profileVersion: " + str);
        stringBuilder.append("\n  firmwareVersion: " + l());
        stringBuilder.append("\n  firmware2Version: " + q());
        return stringBuilder.toString();
    }
}
