package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.support.v4.g.g;
import cn.com.smartdevices.bracelet.view.VerticalViewPager.SavedState;

final class W implements g<SavedState> {
    W() {
    }

    public /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
        return b(parcel, classLoader);
    }

    public /* synthetic */ Object[] a(int i) {
        return b(i);
    }

    public SavedState b(Parcel parcel, ClassLoader classLoader) {
        return new SavedState(parcel, classLoader);
    }

    public SavedState[] b(int i) {
        return new SavedState[i];
    }
}
