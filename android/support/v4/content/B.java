package android.support.v4.content;

import android.os.Process;

class B extends H<Params, Result> {
    final /* synthetic */ z a;

    B(z zVar) {
        this.a = zVar;
        super();
    }

    public Result call() {
        this.a.o.set(true);
        Process.setThreadPriority(10);
        return this.a.d(this.a.a(this.b));
    }
}
