package cn.com.smartdevices.bracelet.gps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RunningReminderInfo implements Parcelable {
    public static final Creator<RunningReminderInfo> CREATOR = new j();
    public static final int a = 5;
    public static final int b = 240;
    public static final int c = 15;
    private int d = -1;
    private int e = -1;
    private int f = -1;

    public RunningReminderInfo() {
        e();
    }

    private void e() {
    }

    public int a() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.e = i + b;
    }

    public int c() {
        return this.d;
    }

    public void c(int i) {
        this.d = i + a;
    }

    public void d() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }
}
