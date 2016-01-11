package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0018ad implements Creator<FragmentState> {
    C0018ad() {
    }

    public FragmentState a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] a(int i) {
        return new FragmentState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
