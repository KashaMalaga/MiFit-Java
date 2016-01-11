package cn.com.smartdevices.bracelet.gps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RunningData implements Parcelable {
    public static final Creator<RunningData> CREATOR = new b();
    private boolean a = false;
    private long b = -1;
    private long c = -1;

    public long a() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public long b() {
        return this.b;
    }

    public void b(long j) {
        this.b = j;
    }

    public boolean c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RunningData [mIsConnectBracelet=" + this.a + ", mGPSStartTime=" + this.b + ", mGPSAvailableTime=" + this.c + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
    }
}
