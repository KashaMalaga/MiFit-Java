package android.support.v4.media.a;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.sina.weibo.sdk.constant.WBConstants;
import java.lang.reflect.Method;

public final class m implements Runnable {
    private static final int a = 15000;
    private final DisplayManager b;
    private final Handler c;
    private Method d;
    private boolean e;

    public m(Context context, Handler handler) {
        if (VERSION.SDK_INT != 17) {
            throw new UnsupportedOperationException();
        }
        this.b = (DisplayManager) context.getSystemService(WBConstants.AUTH_PARAMS_DISPLAY);
        this.c = handler;
        try {
            this.d = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
        } catch (NoSuchMethodException e) {
        }
    }

    public void a(int i) {
        if ((i & 2) != 0) {
            if (!this.e) {
                if (this.d != null) {
                    this.e = true;
                    this.c.post(this);
                    return;
                }
                Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
            }
        } else if (this.e) {
            this.e = false;
            this.c.removeCallbacks(this);
        }
    }

    public void run() {
        if (this.e) {
            try {
                this.d.invoke(this.b, new Object[0]);
            } catch (Throwable e) {
                Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e);
            } catch (Throwable e2) {
                Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e2);
            }
            this.c.postDelayed(this, 15000);
        }
    }
}
