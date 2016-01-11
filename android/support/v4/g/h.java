package android.support.v4.g;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class h<T> implements ClassLoaderCreator<T> {
    private final g<T> a;

    public h(g<T> gVar) {
        this.a = gVar;
    }

    public T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.a.a(i);
    }
}
