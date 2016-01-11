package com.xiaomi.account.openauth;

import a.b.a;
import a.b.b;
import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import com.xiaomi.account.d;

abstract class e<V> extends o<V> implements ServiceConnection {
    private static final String d = "android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE";
    private static final String e = "com.xiaomi.account";
    protected final Account a;
    protected final Bundle b;
    private final Context f;

    e(Context context, Account account, Bundle bundle) {
        this.f = context;
        this.a = account;
        this.b = bundle;
    }

    private static Intent b() {
        Intent intent = new Intent(d);
        if (VERSION.SDK_INT >= 21) {
            intent.setPackage(e);
        }
        return intent;
    }

    protected abstract V a(a aVar);

    protected abstract V a(d dVar);

    public final void a() {
        if (!this.f.bindService(b(), this, 1)) {
            this.f.unbindService(this);
            this.c.setException(new f());
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.c.set(a(com.xiaomi.account.e.a(iBinder)));
            this.f.unbindService(this);
        } catch (SecurityException e) {
            try {
                this.c.set(a(b.a(iBinder)));
                this.f.unbindService(this);
            } catch (SecurityException e2) {
                try {
                    this.c.setException(new f());
                } catch (Throwable e3) {
                    this.c.setException(e3);
                } finally {
                    this.f.unbindService(this);
                }
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
