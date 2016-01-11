package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.DrawerLayout.SavedState;

final class C0252x implements Creator<SavedState> {
    C0252x() {
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
