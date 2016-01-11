package com.huami.android.zxing.a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

final class a implements AutoFocusCallback {
    private static final String a = a.class.getSimpleName();
    private static final long b = 2000;
    private static final Collection<String> c = new ArrayList(2);
    private boolean d;
    private boolean e;
    private final boolean f;
    private final Camera g;
    private AsyncTask<?, ?, ?> h;

    static {
        c.add("auto");
        c.add("macro");
    }

    a(Camera camera) {
        this.g = camera;
        String focusMode = camera.getParameters().getFocusMode();
        this.f = c.contains(focusMode);
        Log.i(a, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f);
        start();
    }

    private synchronized void a() {
        if (!this.d && this.h == null) {
            AsyncTask cVar = new c();
            try {
                cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.h = cVar;
            } catch (Throwable e) {
                Log.w(a, "Could not request auto focus", e);
            }
        }
    }

    private synchronized void b() {
        if (this.h != null) {
            if (this.h.getStatus() != Status.FINISHED) {
                this.h.cancel(true);
            }
            this.h = null;
        }
    }

    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.e = false;
        a();
    }

    synchronized void start() {
        if (this.f) {
            this.h = null;
            if (!(this.d || this.e)) {
                try {
                    this.g.autoFocus(this);
                    this.e = true;
                } catch (Throwable e) {
                    Log.w(a, "Unexpected exception while focusing", e);
                    a();
                }
            }
        }
    }

    synchronized void stop() {
        this.d = true;
        if (this.f) {
            b();
            try {
                this.g.cancelAutoFocus();
            } catch (Throwable e) {
                Log.w(a, "Unexpected exception while cancelling focusing", e);
            }
        }
    }
}
