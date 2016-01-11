package com.huami.android.zxing.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.util.Log;

final class h implements PreviewCallback {
    private static final String a = h.class.getSimpleName();
    private final d b;
    private Handler c;
    private int d;

    h(d dVar) {
        this.b = dVar;
    }

    void a(Handler handler, int i) {
        this.c = handler;
        this.d = i;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a = this.b.a();
        Handler handler = this.c;
        if (a == null || handler == null) {
            Log.d(a, "Got preview callback, but no handler or resolution available");
            return;
        }
        handler.obtainMessage(this.d, a.x, a.y, bArr).sendToTarget();
        this.c = null;
    }
}
