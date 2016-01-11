package com.huami.android.zxing;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;

final class n {
    private static final String a = n.class.getSimpleName();
    private static final long b = 300000;
    private final Activity c;
    private final BroadcastReceiver d = new q();
    private boolean e = false;
    private AsyncTask<Object, Object, Object> f;

    n(Activity activity) {
        this.c = activity;
        a();
    }

    private synchronized void f() {
        AsyncTask asyncTask = this.f;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f = null;
        }
    }

    synchronized void a() {
        f();
        this.f = new p();
        this.f.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public synchronized void b() {
        f();
        if (this.e) {
            this.c.unregisterReceiver(this.d);
            this.e = false;
        } else {
            Log.w(a, "PowerStatusReceiver was never registered?");
        }
    }

    public synchronized void c() {
        if (this.e) {
            Log.w(a, "PowerStatusReceiver was already registered?");
        } else {
            this.c.registerReceiver(this.d, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.e = true;
        }
        a();
    }

    void d() {
        f();
    }
}
