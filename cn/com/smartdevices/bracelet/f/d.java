package cn.com.smartdevices.bracelet.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.r;

public class d {
    private d() {
    }

    public static int a(int i, int i2, int i3, int i4) {
        if (i <= i3 && i2 <= i4) {
            return 1;
        }
        int round = Math.round(((float) i) / ((float) i3));
        int round2 = Math.round(((float) i2) / ((float) i4));
        return round2 >= round ? round2 : round;
    }

    public static int a(Options options, int i, int i2) {
        return a(options.outWidth, options.outHeight, i, i2);
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        if (bitmap == null && bitmap2 == null) {
            return null;
        }
        if (bitmap == null) {
            return bitmap2;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        if (!bitmap.isMutable()) {
            bitmap = bitmap.copy(Config.ARGB_8888, true);
        }
        Paint paint = new Paint();
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bitmap2, (float) i, (float) i2, paint);
        canvas.save(31);
        canvas.restore();
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, int i4) {
        if (bitmap == null && bitmap2 == null) {
            return null;
        }
        if (bitmap == null) {
            return bitmap2;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        if (!bitmap.isMutable()) {
            bitmap = bitmap.copy(Config.ARGB_8888, true);
        }
        Paint paint = new Paint();
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bitmap2, (float) i, (float) i2, paint);
        canvas.save(31);
        canvas.restore();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int a = a(width, height, i3, i4);
        return Bitmap.createScaledBitmap(bitmap, width / a, height / a, true);
    }

    public static void a(Activity activity, boolean z) {
        if (activity != null) {
            b h = b.h();
            h.h.getClass();
            if (a((Context) activity, "com.xiaomi.shop.action_show_m_site")) {
                h.h.getClass();
                Intent intent = new Intent("com.xiaomi.shop.action_show_m_site");
                String str = SocialConstants.PARAM_URL;
                h.h.getClass();
                intent.putExtra(str, "http://s1.mi.com/m/product/shouhuan/index.html");
                activity.startActivity(intent);
            } else if (z) {
                h.h.getClass();
                Utils.a("http://s1.mi.com/m/product/shouhuan/index.html", (int) r.bracelet_store_desc, activity);
            } else {
                h.h.getClass();
                Utils.a("http://s1.mi.com/m/product/shouhuan/index.html", (int) r.buy_bracelet_desc, activity);
            }
        }
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().queryIntentActivities(new Intent(str), C0113o.q).size() > 0;
    }
}
