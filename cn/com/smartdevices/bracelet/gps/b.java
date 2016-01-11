package cn.com.smartdevices.bracelet.gps;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator<RunningData> {
    b() {
    }

    public RunningData a(Parcel parcel) {
        boolean z = true;
        RunningData runningData = new RunningData();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        runningData.a = z;
        runningData.b = parcel.readLong();
        runningData.c = parcel.readLong();
        return runningData;
    }

    public RunningData[] a(int i) {
        return new RunningData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
