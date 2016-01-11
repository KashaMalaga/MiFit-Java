package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import cn.com.smartdevices.bracelet.gps.ui.WatermarkBar.Watermark;

final class bt implements Creator<Watermark> {
    bt() {
    }

    public Watermark a(Parcel parcel) {
        Watermark watermark = new Watermark();
        watermark.k = parcel.readString();
        watermark.l = parcel.readString();
        watermark.m = parcel.readString();
        watermark.n = parcel.readString();
        watermark.o = parcel.readInt();
        watermark.p = parcel.readInt();
        watermark.q = parcel.readString();
        watermark.r = parcel.readInt();
        watermark.s = parcel.readDouble();
        watermark.t = parcel.readInt();
        watermark.u = parcel.readString();
        watermark.v = parcel.readString();
        watermark.w = parcel.readString();
        watermark.x = parcel.readString();
        watermark.y = parcel.readString();
        return watermark;
    }

    public Watermark[] a(int i) {
        return new Watermark[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
