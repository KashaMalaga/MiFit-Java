package com.xiaomi.account.openauth;

import android.accounts.OperationCanceledException;
import android.os.Looper;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class j<V> extends FutureTask<V> implements i<V> {
    private static final long a = 10;

    j() {
        super(new k());
    }

    private V a(Long l, TimeUnit timeUnit) {
        V v;
        if (!isDone()) {
            b();
        }
        if (l == null) {
            try {
                v = get();
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
                } else if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else if (cause instanceof g) {
                    throw ((g) cause);
                } else if (cause instanceof OperationCanceledException) {
                    throw ((OperationCanceledException) cause);
                } else {
                    throw new IllegalStateException(cause);
                }
            } catch (Throwable th) {
                cancel(true);
            }
        } else {
            v = get(l.longValue(), timeUnit);
            cancel(true);
        }
        return v;
    }

    private void b() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == Looper.getMainLooper()) {
            throw new IllegalStateException("calling this from your main thread can lead to deadlock");
        }
    }

    public V a() {
        return a(Long.valueOf(a), TimeUnit.MINUTES);
    }

    public V a(long j, TimeUnit timeUnit) {
        return a(Long.valueOf(j), timeUnit);
    }

    public void set(V v) {
        super.set(v);
    }

    public void setException(Throwable th) {
        super.setException(th);
    }
}
