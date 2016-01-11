package android.support.v4.media.session;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.RatingCompat;

public abstract class q {
    final Object a;

    public q() {
        if (VERSION.SDK_INT >= 21) {
            this.a = w.a(new r());
        } else {
            this.a = null;
        }
    }

    public void a() {
    }

    public void a(long j) {
    }

    public void a(RatingCompat ratingCompat) {
    }

    public void a(String str, Bundle bundle, ResultReceiver resultReceiver) {
    }

    public boolean a(Intent intent) {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }
}
