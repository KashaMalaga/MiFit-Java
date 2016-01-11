package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0022ah implements Creator<SavedState> {
    C0022ah() {
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
