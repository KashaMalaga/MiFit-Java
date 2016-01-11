package android.support.v4.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class C0089C extends FutureTask<Result> {
    final /* synthetic */ z a;

    C0089C(z zVar, Callable callable) {
        this.a = zVar;
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
        } catch (Throwable e4) {
            RuntimeException runtimeException = new RuntimeException("An error occured while executing doInBackground()", e4);
        }
    }
}
