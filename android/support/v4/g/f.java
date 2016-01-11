package android.support.v4.g;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class f<T> implements Creator<T> {
    final g<T> a;

    public f(g<T> gVar) {
        this.a = gVar;
    }

    public T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public T[] newArray(int i) {
        return this.a.a(i);
    }
}
