package com.xiaomi.account.openauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.account.a;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class z extends FutureTask<Bundle> {
    private final Activity a;
    private final j<l> b;

    public z(Activity activity, j<l> jVar) {
        super(new A());
        this.a = activity;
        this.b = jVar;
    }

    private a b() {
        return new B(this);
    }

    public Bundle a() {
        throw new IllegalStateException("this should never be called");
    }

    public Bundle a(long j, TimeUnit timeUnit) {
        throw new IllegalStateException("this should never be called");
    }

    public void a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(h.af)) {
            this.b.set(l.a(bundle));
            return;
        }
        a((Intent) bundle.getParcelable(h.af));
    }

    public boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        extras.setClassLoader(getClass().getClassLoader());
        if (!extras.containsKey(h.am)) {
            intent = AuthorizeActivity.a(this.a, intent, b());
        }
        this.a.startActivity(intent);
        return true;
    }

    public /* synthetic */ Object get() {
        return a();
    }

    public /* synthetic */ Object get(long j, TimeUnit timeUnit) {
        return a(j, timeUnit);
    }

    public /* synthetic */ void set(Object obj) {
        a((Bundle) obj);
    }

    protected void setException(Throwable th) {
        this.b.setException(th);
    }
}
