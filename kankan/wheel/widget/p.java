package kankan.wheel.widget;

import android.util.Log;

class p implements c {
    final /* synthetic */ WheelView a;

    p(WheelView wheelView) {
        this.a = wheelView;
    }

    public void a(WheelView wheelView, int i, int i2) {
        Log.i("WheelView", "newValue=" + i2);
        this.a.b(true);
    }
}
