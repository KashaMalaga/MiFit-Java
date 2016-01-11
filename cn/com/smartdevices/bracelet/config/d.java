package cn.com.smartdevices.bracelet.config;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.e.a;
import java.io.FileInputStream;

class d extends ContentObserver {
    private Context a = null;

    public d(Context context, Handler handler) {
        super(handler);
        this.a = context;
    }

    public void onChange(boolean z) {
        try {
            b a = b.a(new FileInputStream(b.P));
            if (a != null) {
                b.a(a.b(this.a));
                b.L = a.a(this.a);
                C0596r.a(a.k.d.booleanValue(), a.k.e.booleanValue());
                b.b(a);
                if (b.x) {
                    Log.e(ConfigProvider.a, "reload config success");
                }
            } else if (b.x) {
                Log.e(ConfigProvider.a, "reload config error");
            }
        } catch (Throwable e) {
            if (b.x) {
                Log.e(ConfigProvider.a, "reload config error", e);
            }
        }
    }
}
