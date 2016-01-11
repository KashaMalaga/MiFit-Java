package com.edmodo.cropper.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.TypedValue;

public class e {
    private static final int a = -1;
    private static final String b = "#AAFFFFFF";
    private static final String c = "#B0000000";
    private static final float d = 1.0f;
    private static final float e = 2.0f;
    private static final float f = 1.0f;

    public static Paint a() {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(b));
        paint.setStrokeWidth(f);
        return paint;
    }

    public static Paint a(Context context) {
        float applyDimension = TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(b));
        paint.setStrokeWidth(applyDimension);
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public static float b() {
        return e;
    }

    public static Paint b(Context context) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(c));
        return paint;
    }

    public static float c() {
        return f;
    }

    public static Paint c(Context context) {
        float applyDimension = TypedValue.applyDimension(1, e, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        paint.setColor(a);
        paint.setStrokeWidth(applyDimension);
        paint.setStyle(Style.STROKE);
        return paint;
    }
}
