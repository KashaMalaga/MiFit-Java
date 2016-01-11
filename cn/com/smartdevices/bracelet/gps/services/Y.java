package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import cn.com.smartdevices.bracelet.gps.h.c;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.huami.android.widget.share.m;
import java.util.List;

public class Y {
    private static final float g = 20.0f;
    private static final int h = 60;
    private Paint a;
    private List<Path> b;
    private final int c;
    private final int d;
    private int e;
    private int f;

    public Y(Context context) {
        this.a = null;
        this.b = null;
        this.c = 1080;
        this.d = 900;
        this.e = 0;
        this.f = 0;
        this.a = g();
    }

    public Y(Context context, int[] iArr) {
        int i = 1080;
        this.a = null;
        this.b = null;
        this.c = 1080;
        this.d = 900;
        this.e = 0;
        this.f = 0;
        if (context != null && context.getResources().getDisplayMetrics() != null) {
            this.a = g();
            if (iArr[0] > 0) {
                i = iArr[0];
            }
            this.e = i;
            this.f = iArr[1] <= 0 ? 900 : iArr[1];
        }
    }

    public static int a() {
        return b() + c();
    }

    private Bitmap a(List<Path> list, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(this.e, this.f, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (this.b != null) {
            for (Path drawPath : list) {
                canvas.drawPath(drawPath, this.a);
            }
        }
        int i3 = m.n;
        int i4 = RunningReminderInfo.b;
        int a = c.a(this.e, this.f, (int) m.n, (int) RunningReminderInfo.b);
        if (a != 0) {
            int f = f();
            i4 = this.e / a;
            if (i4 < f) {
                i4 = f();
            }
            i3 = this.f / a;
            if (i3 < f) {
                i3 = i4;
                i4 = f();
            } else {
                int i5 = i3;
                i3 = i4;
                i4 = i5;
            }
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, i3, i4, true);
        if (!(i3 == this.e || i4 == this.f)) {
            createBitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static int b() {
        return h;
    }

    public static int c() {
        return 20;
    }

    private static int f() {
        return b() + c();
    }

    private Paint g() {
        Paint paint = new Paint();
        paint.setColor(h());
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(g);
        paint.setStrokeCap(Cap.ROUND);
        paint.setStrokeJoin(Join.ROUND);
        return paint;
    }

    private int h() {
        return -1;
    }

    public Bitmap a(List<Path> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        this.b = list;
        return a(list, 0, 0);
    }

    public void d() {
        if (this.b != null) {
            for (Path reset : this.b) {
                reset.reset();
            }
        }
    }

    public void e() {
        d();
    }
}
