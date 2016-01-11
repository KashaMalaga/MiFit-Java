package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0280z implements Creator<SavedState> {
    C0280z() {
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
