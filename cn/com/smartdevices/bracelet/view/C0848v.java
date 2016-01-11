package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0848v implements Creator<SavedState> {
    C0848v() {
    }

    public SavedState a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
