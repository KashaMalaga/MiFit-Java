package kankan.wheel.widget;

import android.database.DataSetObserver;

class r extends DataSetObserver {
    final /* synthetic */ WheelView a;

    r(WheelView wheelView) {
        this.a = wheelView;
    }

    public void onChanged() {
        this.a.b(false);
    }

    public void onInvalidated() {
        this.a.b(true);
    }
}
