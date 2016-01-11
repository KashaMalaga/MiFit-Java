package com.huami.android.bitmapfun;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class C1064d extends FutureTask<Result> {
    final /* synthetic */ C1061a a;

    C1064d(C1061a c1061a, Callable callable) {
        this.a = c1061a;
        super(callable);
    }

    protected void done() {
        try {
            this.a.c(get());
        } catch (Throwable e) {
            Log.w("AsyncTask", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            this.a.c(null);
        }
    }
}
