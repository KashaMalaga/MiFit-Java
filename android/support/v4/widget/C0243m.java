package android.support.v4.widget;

import android.database.DataSetObserver;

class C0243m extends DataSetObserver {
    final /* synthetic */ C0206j a;

    private C0243m(C0206j c0206j) {
        this.a = c0206j;
    }

    public void onChanged() {
        this.a.a = true;
        this.a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.a.a = false;
        this.a.notifyDataSetInvalidated();
    }
}
