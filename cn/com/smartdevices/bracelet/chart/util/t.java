package cn.com.smartdevices.bracelet.chart.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.base.c;
import com.amap.api.maps.model.GroundOverlayOptions;
import java.util.List;

public class t {
    private static float a = GroundOverlayOptions.NO_DIMENSION;
    private static float b = GroundOverlayOptions.NO_DIMENSION;
    private static float c = GroundOverlayOptions.NO_DIMENSION;
    private static boolean d = false;

    public static float a(int i, float f, int i2) {
        return ((((float) ((i / i2) * i2)) / ((float) i)) * f) / (((float) ((i2 + 1) * i2)) / 2.0f);
    }

    public static float a(int i, int i2, float f, int i3) {
        int i4 = i / i3;
        int i5 = ((i2 + i4) - 1) / i4;
        float f2 = ((float) (((i2 - 1) % i4) + 1)) / ((float) i4);
        return (f2 * (b(i5, f, i3) - b(i5 - 1, f, i3))) + b(i5 - 1, f, i3);
    }

    public static float a(Context context) {
        if (a < 0.0f) {
            if (context == null) {
                return 3.0f;
            }
            a = context.getResources().getDisplayMetrics().density;
            if (c < 0.0f) {
                c = a;
            }
        }
        return a;
    }

    public static float a(Context context, float f) {
        return a(context) * f;
    }

    public static int a(int i, int i2, float f) {
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        return Color.argb((int) ((((float) alpha) * (1.0f - f)) + (((float) Color.alpha(i2)) * f)), (int) ((((float) red) * (1.0f - f)) + (((float) Color.red(i2)) * f)), (int) ((((float) green) * (1.0f - f)) + (((float) Color.green(i2)) * f)), (int) ((((float) blue) * (1.0f - f)) + (((float) Color.blue(i2)) * f)));
    }

    public static int a(List<c> list, int i, int i2) {
        int i3;
        synchronized (list) {
            i3 = i2;
            for (c cVar : list) {
                int i4 = (cVar.c < i || cVar.b <= i3) ? i3 : cVar.b;
                i3 = i4;
            }
        }
        return i3;
    }

    public static Canvas a(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
        return canvas;
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, int i) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Configuration configuration = context.getResources().getConfiguration();
        configuration.densityDpi = i;
        displayMetrics.densityDpi = i;
        displayMetrics.density = (float) (i / 160);
        context.getResources().updateConfiguration(configuration, displayMetrics);
        a = GroundOverlayOptions.NO_DIMENSION;
        b = GroundOverlayOptions.NO_DIMENSION;
        a(context);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, Bitmap bitmap, Paint paint) {
        a(canvas, f, f2, f3, true, true, bitmap, paint);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, boolean z, boolean z2, Bitmap bitmap, Paint paint) {
        if (z) {
            f -= (((float) bitmap.getWidth()) * f3) / 2.0f;
        }
        if (z2) {
            f2 -= (((float) bitmap.getHeight()) * f3) / 2.0f;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f3, f3);
        matrix.postTranslate(f, f2);
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    public static void a(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setDither(true);
        paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        canvas.drawRect(rectF, paint);
    }

    public static void a(Canvas canvas, RectF rectF, String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, rectF.left + ((rectF.width() - ((float) rect.width())) / 2.0f), ((((float) rect.height()) + rectF.height()) / 2.0f) + rectF.top, paint);
    }

    public static void a(Canvas canvas, RectF rectF, String str, String str2, Paint paint, Paint paint2) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        float width = rectF.left + ((rectF.width() - ((float) rect.width())) / 2.0f);
        float height = rectF.top + ((rectF.height() + ((float) rect.height())) / 2.0f);
        canvas.drawText(str, width, height, paint);
        Rect rect2 = new Rect();
        paint2.getTextBounds(str, 0, str.length(), rect2);
        canvas.drawText(str2, (width + ((float) rect.width())) + 6.0f, (height - ((float) rect.height())) + ((float) rect2.height()), paint2);
    }

    public static boolean a() {
        return d;
    }

    public static float b(int i, float f, int i2) {
        return i <= 0 ? 0.0f : (((float) ((((i2 - i) + 1) + i2) * i)) / 2.0f) * f;
    }

    public static float b(Context context) {
        if (b < 0.0f) {
            if (context == null) {
                return 1.0f;
            }
            b = context.getResources().getDisplayMetrics().density / 3.0f;
        }
        return b;
    }

    public static float c(Context context) {
        if (c < 0.0f) {
            a(context);
        }
        return c;
    }

    public static boolean d(Context context) {
        boolean z = Utils.h() && c(context) == 2.75f;
        d = z;
        return d;
    }
}
