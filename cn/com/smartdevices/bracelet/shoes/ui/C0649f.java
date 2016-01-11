package cn.com.smartdevices.bracelet.shoes.ui;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class C0649f extends Handler {
    private WeakReference<ShoesBindActivity> a = null;

    public C0649f(ShoesBindActivity shoesBindActivity) {
        this.a = new WeakReference(shoesBindActivity);
    }

    public void a() {
        removeCallbacksAndMessages(null);
    }

    public void handleMessage(Message message) {
        ShoesBindActivity shoesBindActivity = (ShoesBindActivity) this.a.get();
        if (shoesBindActivity != null) {
            shoesBindActivity.a(message);
        }
    }
}
