package cn.com.smartdevices.bracelet.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.mipush.sdk.f;

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new b();
    private double a;
    private double b;
    private Address c;

    public class Address implements Parcelable {
        public static final Creator<Address> CREATOR = new c();
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;

        private Address(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
            this.g = parcel.readString();
        }

        public String a() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public String d() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }

        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.e;
        }

        public void e(String str) {
            this.e = str;
        }

        public String f() {
            return this.f;
        }

        public void f(String str) {
            this.f = str;
        }

        public String g() {
            return this.g;
        }

        public void g(String str) {
            this.g = str;
        }

        public String h() {
            return this.h;
        }

        public void h(String str) {
            this.h = str;
        }

        public String i() {
            return this.i;
        }

        public void i(String str) {
            this.i = str;
        }

        public String j() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ctr:").append(this.a).append(",CtrCode:").append(this.b).append(",Admin:").append(this.c).append(",SubAdm:").append(this.d).append(",Loc:").append(this.e).append(",SubLoc:").append(this.f).append(",Thoro:").append(this.g).append(",AdCode:").append(this.h).append(",CityCode:").append(this.i);
            return stringBuilder.toString();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t\t").append("Country : " + this.a).append(", CountryCode : " + this.b).append(", Admin : " + this.c).append(", SubAdmin : " + this.d).append(", Locality : " + this.e).append(", SubLocality : " + this.f).append(", Thoroughfare : " + this.g).append(", AdCode : " + this.h).append(", CityCode : " + this.i);
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeString(this.g);
        }
    }

    public Location() {
        this.a = 0.0d;
        this.b = 0.0d;
    }

    private Location(Parcel parcel) {
        this.a = 0.0d;
        this.b = 0.0d;
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
        this.c = (Address) parcel.readParcelable(null);
    }

    public double a() {
        return this.a;
    }

    public void a(double d) {
        this.a = d;
    }

    public void a(Address address) {
        this.c = address;
    }

    public double b() {
        return this.b;
    }

    public void b(double d) {
        this.b = d;
    }

    public Address c() {
        return this.c;
    }

    public String d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Long:").append(this.a).append(",Lat:").append(this.b);
        if (this.c != null) {
            stringBuilder.append(f.i).append(this.c.j());
        }
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\t").append("Longitude : " + this.a).append(", Latitude : " + this.b);
        stringBuilder.append("\n\t").append("Address : " + this.c);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
        parcel.writeParcelable(this.c, i);
    }
}
