package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class az implements UncaughtExceptionHandler {
    private static az a;
    private static ExecutorService e;
    private UncaughtExceptionHandler b;
    private Context c;
    private boolean d = true;

    class a implements bs {
        private Context a;

        a(Context context) {
            this.a = context;
        }

        public void a() {
            try {
                bg.b(this.a);
            } catch (Throwable th) {
                az.a(th, "LogNetListener", "onNetCompleted");
                th.printStackTrace();
            }
        }
    }

    private az(Context context, ad adVar) {
        this.c = context;
        br.a(new a(context));
        d();
    }

    public static synchronized az a(Context context, ad adVar) {
        az azVar;
        synchronized (az.class) {
            if (adVar == null) {
                throw new v("sdk info is null");
            } else if (adVar.a() == null || com.xiaomi.e.a.f.equals(adVar.a())) {
                throw new v("sdk name is invalid");
            } else {
                try {
                    if (a == null) {
                        a = new az(context, adVar);
                    } else {
                        a.d = false;
                    }
                    a.a(context, adVar, a.d);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                azVar = a;
            }
        }
        return azVar;
    }

    static synchronized ExecutorService a() {
        ExecutorService executorService;
        synchronized (az.class) {
            try {
                if (e == null || e.isShutdown()) {
                    e = Executors.newSingleThreadExecutor();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = e;
        }
        return executorService;
    }

    private void a(final Context context, final ad adVar, final boolean z) {
        try {
            ExecutorService a = a();
            if (a != null && !a.isShutdown()) {
                a.submit(new Runnable(this) {
                    final /* synthetic */ az d;

                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new ao(context).a(adVar);
                            }
                            if (z) {
                                synchronized (Looper.getMainLooper()) {
                                    ar arVar = new ar(context);
                                    at atVar = new at();
                                    atVar.c(true);
                                    atVar.a(true);
                                    atVar.b(true);
                                    arVar.a(atVar);
                                }
                                bg.a(this.d.c);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Throwable th, int i, String str, String str2) {
        bg.a(this.c, th, i, str, str2);
    }

    public static void a(Throwable th, String str, String str2) {
        if (a != null) {
            a.a(th, 1, str, str2);
        }
    }

    public static synchronized az b() {
        az azVar;
        synchronized (az.class) {
            azVar = a;
        }
        return azVar;
    }

    public static synchronized void c() {
        synchronized (az.class) {
            try {
                if (e != null) {
                    e.shutdown();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(a == null || Thread.getDefaultUncaughtExceptionHandler() != a || a.b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(a.b);
                }
                a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void d() {
        try {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.d = true;
            } else if (this.b.toString().indexOf("com.amap.api") != -1) {
                this.d = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.d = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            a(th, 0, null, null);
            if (this.b != null) {
                this.b.uncaughtException(thread, th);
            }
        }
    }
}
