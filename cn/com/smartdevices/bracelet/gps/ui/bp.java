package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import com.xiaomi.hm.health.b.a.b;
import java.lang.ref.WeakReference;
import kankan.wheel.widget.l;

final class bp extends Handler {
    private WeakReference<WatermarkActivity> a = null;

    public bp(WatermarkActivity watermarkActivity) {
        this.a = new WeakReference(watermarkActivity);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case l.a /*1*/:
                WatermarkActivity watermarkActivity = (WatermarkActivity) this.a.get();
                if (watermarkActivity != null) {
                    watermarkActivity.n.setVisibility(0);
                    watermarkActivity.n.startAnimation(AnimationUtils.loadAnimation(watermarkActivity, b.watermark_activity_scroll_to_top));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
