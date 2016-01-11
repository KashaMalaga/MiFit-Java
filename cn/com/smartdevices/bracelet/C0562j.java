package cn.com.smartdevices.bracelet;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;

public class C0562j implements UncaughtExceptionHandler {
    public static final String a = "crash";
    private static C0562j b = null;
    private UncaughtExceptionHandler c;

    private C0562j() {
        this.c = null;
        this.c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static C0562j a() {
        return b;
    }

    private void a(Throwable th) {
        if (th == null) {
            C0596r.d(a, "Throwable is null!!!");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        C0596r.d(a, "\n" + stringBuffer.toString());
    }

    public static void b() {
        if (b == null) {
            b = new C0562j();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.c != null) {
            this.c.uncaughtException(thread, th);
        }
    }
}
