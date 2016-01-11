package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.MotionEvent;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.lang.reflect.Method;

public class b {
    protected Method a;
    protected Method b;
    protected Method c;
    private boolean d = false;
    private final a e;
    private long f = 0;
    private boolean g = false;

    public interface a {
        void a();

        void a(float f, float f2, float f3, float f4, float f5);

        boolean a(MotionEvent motionEvent, float f, float f2, float f3, float f4);
    }

    public b(Context context, a aVar) {
        this.e = aVar;
        c();
    }

    private void c() {
        try {
            this.a = MotionEvent.class.getMethod("getPointerCount", new Class[0]);
            this.b = MotionEvent.class.getMethod("getX", new Class[]{Integer.TYPE});
            this.c = MotionEvent.class.getMethod("getY", new Class[]{Integer.TYPE});
            this.d = true;
        } catch (Throwable th) {
            this.d = false;
            az.a(th, "MultiTouchSupport", "initMethods");
            th.printStackTrace();
        }
    }

    public boolean a() {
        return this.g;
    }

    public boolean a(MotionEvent motionEvent) {
        if (!this.d) {
            return false;
        }
        int action = motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE;
        try {
            if (((Integer) this.a.invoke(motionEvent, new Object[0])).intValue() < 2) {
                this.f = 0;
                this.g = false;
                return false;
            }
            Float f = (Float) this.b.invoke(motionEvent, new Object[]{Integer.valueOf(0)});
            Float f2 = (Float) this.b.invoke(motionEvent, new Object[]{Integer.valueOf(1)});
            Float f3 = (Float) this.c.invoke(motionEvent, new Object[]{Integer.valueOf(0)});
            Float f4 = (Float) this.c.invoke(motionEvent, new Object[]{Integer.valueOf(1)});
            float sqrt = (float) Math.sqrt((double) (((f2.floatValue() - f.floatValue()) * (f2.floatValue() - f.floatValue())) + ((f4.floatValue() - f3.floatValue()) * (f4.floatValue() - f3.floatValue()))));
            if (action == 5) {
                this.e.a(sqrt, f.floatValue(), f3.floatValue(), f2.floatValue(), f4.floatValue());
                this.g = true;
                return true;
            } else if (action == 6) {
                this.f = motionEvent.getEventTime();
                if (motionEvent.getPointerCount() == 2 && this.f - motionEvent.getDownTime() < 100) {
                    this.e.a();
                }
                if (this.g) {
                    this.g = false;
                }
                return false;
            } else {
                if (this.g && action == 2) {
                    return this.e.a(motionEvent, f.floatValue(), f3.floatValue(), f2.floatValue(), f4.floatValue());
                }
                return false;
            }
        } catch (Throwable th) {
            az.a(th, "MultiTouchSupport", "onTouchEvent");
            th.printStackTrace();
        }
    }

    public long b() {
        return this.f;
    }
}
