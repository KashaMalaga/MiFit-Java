package b.a;

import com.g.a.C1059a;
import java.lang.Thread.UncaughtExceptionHandler;

public class dC implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler a;
    private C0365dJ b;

    public dC() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void a(Throwable th) {
        if (C1059a.m) {
            this.b.a(th);
        } else {
            this.b.a(null);
        }
    }

    public void a(C0365dJ c0365dJ) {
        this.b = c0365dJ;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.a != null && this.a != Thread.getDefaultUncaughtExceptionHandler()) {
            this.a.uncaughtException(thread, th);
        }
    }
}
