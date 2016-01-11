package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bF extends Handler {
    WeakReference<Activity> b;

    bF(Activity activity) {
        this.b = new WeakReference(activity);
    }

    public void handleMessage(Message message) {
        if (((Activity) this.b.get()) != null) {
        }
    }
}
