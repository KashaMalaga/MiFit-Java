package com.huami.android.zxing;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.c.b.a;
import com.c.b.e;
import com.c.b.v;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class k extends Thread {
    public static final String a = "barcode_bitmap";
    public static final String b = "barcode_scaled_factor";
    private final CaptureActivity c;
    private final Map<e, Object> d = new EnumMap(e.class);
    private Handler e;
    private final CountDownLatch f = new CountDownLatch(1);

    k(CaptureActivity captureActivity, Collection<a> collection, Map<e, ?> map, String str, v vVar) {
        Object noneOf;
        this.c = captureActivity;
        if (map != null) {
            this.d.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            noneOf = EnumSet.noneOf(a.class);
            noneOf.addAll(h.a);
            noneOf.addAll(h.b);
            noneOf.addAll(h.c);
            noneOf.addAll(h.d);
        }
        this.d.put(e.POSSIBLE_FORMATS, noneOf);
        if (str != null) {
            this.d.put(e.CHARACTER_SET, str);
        }
        this.d.put(e.NEED_RESULT_POINT_CALLBACK, vVar);
        Log.i("DecodeThread", "Hints: " + this.d);
    }

    Handler a() {
        try {
            this.f.await();
        } catch (InterruptedException e) {
        }
        return this.e;
    }

    public void run() {
        Looper.prepare();
        this.e = new i(this.c, this.d);
        this.f.countDown();
        Looper.loop();
    }
}
