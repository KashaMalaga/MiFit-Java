package android.support.v4.app;

import android.view.View;

class K implements Q {
    final /* synthetic */ Fragment a;

    K(Fragment fragment) {
        this.a = fragment;
    }

    public View a(int i) {
        if (this.a.mView != null) {
            return this.a.mView.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public boolean a() {
        return this.a.mView != null;
    }
}
