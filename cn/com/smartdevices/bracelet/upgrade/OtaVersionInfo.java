package cn.com.smartdevices.bracelet.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OtaVersionInfo implements Parcelable {
    public static final Creator<OtaVersionInfo> CREATOR = new g();
    public String a;
    public float b;
    public String c;
    public String d;
    public int e;
    public String f;

    private OtaVersionInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readFloat();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "\n" + this.a + "\n" + this.b + "\n" + this.c + "\n" + this.d + "\n" + this.e + "\n" + this.f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeFloat((float) this.e);
        parcel.writeString(this.f);
    }
}
