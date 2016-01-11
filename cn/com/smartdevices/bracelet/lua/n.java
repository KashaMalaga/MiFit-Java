package cn.com.smartdevices.bracelet.lua;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class n implements Creator<SlidingUpPanelLayoutSavedState> {
    n() {
    }

    public SlidingUpPanelLayoutSavedState a(Parcel parcel) {
        return new SlidingUpPanelLayoutSavedState(parcel);
    }

    public SlidingUpPanelLayoutSavedState[] a(int i) {
        return new SlidingUpPanelLayoutSavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
