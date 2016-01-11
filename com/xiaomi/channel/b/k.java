package com.xiaomi.channel.b;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class k extends FutureTask<Bundle> implements AccountManagerFuture<Bundle> {
    final Handler e;
    final AccountManagerCallback<Bundle> f;
    final Activity g;
    final /* synthetic */ a h;

    public k(a aVar, Activity activity, Handler handler, AccountManagerCallback<Bundle> accountManagerCallback) {
        this.h = aVar;
        super(new l(aVar));
        this.e = handler;
        this.f = accountManagerCallback;
        this.g = activity;
    }

    private Bundle a(Long l, TimeUnit timeUnit) {
        Bundle bundle;
        if (!isDone()) {
            this.h.a();
        }
        if (l == null) {
            try {
                bundle = (Bundle) get();
                cancel(true);
            } catch (CancellationException e) {
                throw new OperationCanceledException();
            } catch (TimeoutException e2) {
                cancel(true);
                throw new OperationCanceledException();
            } catch (InterruptedException e3) {
                cancel(true);
                throw new OperationCanceledException();
            } catch (ExecutionException e4) {
                Throwable cause = e4.getCause();
                if (cause instanceof IOException) {
                    throw ((IOException) cause);
                } else if (cause instanceof UnsupportedOperationException) {
                    throw new AuthenticatorException(cause);
                } else if (cause instanceof AuthenticatorException) {
                    throw ((AuthenticatorException) cause);
                } else if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else {
                    throw new IllegalStateException(cause);
                }
            } catch (Throwable th) {
                cancel(true);
            }
        } else {
            bundle = (Bundle) get(l.longValue(), timeUnit);
            cancel(true);
        }
        return bundle;
    }

    public Bundle a(long j, TimeUnit timeUnit) {
        return a(Long.valueOf(j), timeUnit);
    }

    public abstract void a();

    public Bundle b() {
        return a(null, null);
    }

    public /* synthetic */ Object getResult() {
        return b();
    }

    public /* synthetic */ Object getResult(long j, TimeUnit timeUnit) {
        return a(j, timeUnit);
    }

    public final AccountManagerFuture<Bundle> start() {
        try {
            a();
        } catch (Throwable e) {
            setException(e);
        }
        return this;
    }
}
