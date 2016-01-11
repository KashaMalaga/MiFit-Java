package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class G implements Creator<BackStackState> {
    G() {
    }

    public BackStackState a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] a(int i) {
        return new BackStackState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
