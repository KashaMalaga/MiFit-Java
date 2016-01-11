package cn.com.smartdevices.bracelet.gps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j implements Creator<RunningReminderInfo> {
    j() {
    }

    public RunningReminderInfo a(Parcel parcel) {
        RunningReminderInfo runningReminderInfo = new RunningReminderInfo();
        runningReminderInfo.c(parcel.readInt());
        runningReminderInfo.b(parcel.readInt());
        runningReminderInfo.a(parcel.readInt());
        return runningReminderInfo;
    }

    public RunningReminderInfo[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
