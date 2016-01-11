package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class aq implements Creator<FullSpanItem> {
    aq() {
    }

    public FullSpanItem a(Parcel parcel) {
        return new FullSpanItem(parcel);
    }

    public FullSpanItem[] a(int i) {
        return new FullSpanItem[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
