package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new C0018ad();
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    Bundle j;
    Fragment k;

    public FragmentState(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.h = z;
        this.i = parcel.readBundle();
        this.j = parcel.readBundle();
    }

    public FragmentState(Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.b = fragment.mIndex;
        this.c = fragment.mFromLayout;
        this.d = fragment.mFragmentId;
        this.e = fragment.mContainerId;
        this.f = fragment.mTag;
        this.g = fragment.mRetainInstance;
        this.h = fragment.mDetached;
        this.i = fragment.mArguments;
    }

    public Fragment a(FragmentActivity fragmentActivity, Fragment fragment) {
        if (this.k != null) {
            return this.k;
        }
        if (this.i != null) {
            this.i.setClassLoader(fragmentActivity.getClassLoader());
        }
        this.k = Fragment.instantiate(fragmentActivity, this.a, this.i);
        if (this.j != null) {
            this.j.setClassLoader(fragmentActivity.getClassLoader());
            this.k.mSavedFragmentState = this.j;
        }
        this.k.setIndex(this.b, fragment);
        this.k.mFromLayout = this.c;
        this.k.mRestored = true;
        this.k.mFragmentId = this.d;
        this.k.mContainerId = this.e;
        this.k.mTag = this.f;
        this.k.mRetainInstance = this.g;
        this.k.mDetached = this.h;
        this.k.mFragmentManager = fragmentActivity.e;
        if (U.b) {
            Log.v("FragmentManager", "Instantiated fragment " + this.k);
        }
        return this.k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        if (!this.h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.i);
        parcel.writeBundle(this.j);
    }
}
