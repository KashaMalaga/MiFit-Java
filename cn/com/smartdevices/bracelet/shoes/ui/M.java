package cn.com.smartdevices.bracelet.shoes.ui;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

final class M extends Handler {
    private WeakReference<ShoesDetailActivity> a = null;

    public M(ShoesDetailActivity shoesDetailActivity) {
        this.a = new WeakReference(shoesDetailActivity);
    }

    public void a() {
        removeCallbacksAndMessages(null);
    }

    public void handleMessage(Message message) {
        ShoesDetailActivity shoesDetailActivity = (ShoesDetailActivity) this.a.get();
        if (shoesDetailActivity != null) {
            switch (message.what) {
                case l.a /*1*/:
                case a.aQ /*4*/:
                    shoesDetailActivity.d(3);
                    return;
                case a.l /*3*/:
                case a.bt /*6*/:
                    shoesDetailActivity.d(2);
                    return;
                case a.X /*5*/:
                    shoesDetailActivity.d(4);
                    if (shoesDetailActivity.f()) {
                        shoesDetailActivity.i();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
