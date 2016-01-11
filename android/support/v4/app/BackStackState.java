package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new G();
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
    }

    public BackStackState(U u, A a) {
        int i = 0;
        for (E e = a.k; e != null; e = e.a) {
            if (e.i != null) {
                i += e.i.size();
            }
        }
        this.a = new int[(i + (a.m * 7))];
        if (a.t) {
            i = 0;
            for (E e2 = a.k; e2 != null; e2 = e2.a) {
                int i2 = i + 1;
                this.a[i] = e2.c;
                int i3 = i2 + 1;
                this.a[i2] = e2.d != null ? e2.d.mIndex : -1;
                int i4 = i3 + 1;
                this.a[i3] = e2.e;
                i2 = i4 + 1;
                this.a[i4] = e2.f;
                i4 = i2 + 1;
                this.a[i2] = e2.g;
                i2 = i4 + 1;
                this.a[i4] = e2.h;
                if (e2.i != null) {
                    int size = e2.i.size();
                    i4 = i2 + 1;
                    this.a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.a[i4] = ((Fragment) e2.i.get(i2)).mIndex;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.a[i2] = 0;
                }
            }
            this.b = a.r;
            this.c = a.s;
            this.d = a.v;
            this.e = a.x;
            this.f = a.y;
            this.g = a.z;
            this.h = a.A;
            this.i = a.B;
            this.j = a.C;
            this.k = a.D;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public A a(U u) {
        A a = new A(u);
        int i = 0;
        int i2 = 0;
        while (i2 < this.a.length) {
            E e = new E();
            int i3 = i2 + 1;
            e.c = this.a[i2];
            if (U.b) {
                Log.v("FragmentManager", "Instantiate " + a + " op #" + i + " base fragment #" + this.a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.a[i3];
            if (i2 >= 0) {
                e.d = (Fragment) u.l.get(i2);
            } else {
                e.d = null;
            }
            i3 = i4 + 1;
            e.e = this.a[i4];
            i4 = i3 + 1;
            e.f = this.a[i3];
            i3 = i4 + 1;
            e.g = this.a[i4];
            int i5 = i3 + 1;
            e.h = this.a[i3];
            i4 = i5 + 1;
            int i6 = this.a[i5];
            if (i6 > 0) {
                e.i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (U.b) {
                        Log.v("FragmentManager", "Instantiate " + a + " set remove fragment #" + this.a[i4]);
                    }
                    i5 = i4 + 1;
                    e.i.add((Fragment) u.l.get(this.a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            a.a(e);
            i++;
            i2 = i4;
        }
        a.r = this.b;
        a.s = this.c;
        a.v = this.d;
        a.x = this.e;
        a.t = true;
        a.y = this.f;
        a.z = this.g;
        a.A = this.h;
        a.B = this.i;
        a.C = this.j;
        a.D = this.k;
        a.e(1);
        return a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
    }
}
