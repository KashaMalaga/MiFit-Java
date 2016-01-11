package com.xiaomi.mistatistic.sdk;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import cn.com.smartdevices.bracelet.F;
import com.xiaomi.channel.b.v;
import com.xiaomi.mistatistic.sdk.b.A;
import com.xiaomi.mistatistic.sdk.b.C;
import com.xiaomi.mistatistic.sdk.b.C1125b;
import com.xiaomi.mistatistic.sdk.b.E;
import com.xiaomi.mistatistic.sdk.b.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.a;
import org.apache.http.message.BasicNameValuePair;

public class f implements UncaughtExceptionHandler {
    private static boolean a = false;
    private static int b = 1;
    private final UncaughtExceptionHandler c;

    public f() {
        this.c = null;
    }

    public f(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.c = uncaughtExceptionHandler;
    }

    public static void a(int i) {
        b = i;
    }

    public static void a(Throwable th) {
        if (!a) {
            return;
        }
        if (th == null) {
            throw new IllegalArgumentException("the throwable is null.");
        } else if (th.getStackTrace() != null && th.getStackTrace().length != 0) {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(v.u, C1125b.b()));
            arrayList.add(new BasicNameValuePair("app_key", C1125b.c()));
            arrayList.add(new BasicNameValuePair("device_uuid", r.a(C1125b.a())));
            arrayList.add(new BasicNameValuePair("device_os", "Android " + VERSION.SDK_INT));
            arrayList.add(new BasicNameValuePair("device_model", Build.MODEL));
            arrayList.add(new BasicNameValuePair("app_version", C1125b.e()));
            arrayList.add(new BasicNameValuePair("app_channel", C1125b.d()));
            arrayList.add(new BasicNameValuePair("app_start_time", String.valueOf(System.currentTimeMillis())));
            arrayList.add(new BasicNameValuePair("app_crash_time", String.valueOf(System.currentTimeMillis())));
            arrayList.add(new BasicNameValuePair("crash_exception_type", th.getClass().getName() + a.ci + th.getMessage()));
            arrayList.add(new BasicNameValuePair("crash_exception_desc", th instanceof OutOfMemoryError ? "OutOfMemoryError" : obj));
            arrayList.add(new BasicNameValuePair("crash_callstack", obj));
            try {
                new A().a("upload the exception " + C.a(C1125b.a(), a.a() ? "http://10.99.168.145:8097/micrash" : "https://data.mistat.xiaomi.com/micrash", arrayList));
            } catch (Throwable e) {
                new A().a("Error to upload the exception", e);
            }
        }
    }

    public static void a(boolean z) {
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (!(defaultUncaughtExceptionHandler instanceof f)) {
            if (z) {
                defaultUncaughtExceptionHandler = null;
            }
            Thread.setDefaultUncaughtExceptionHandler(new f(defaultUncaughtExceptionHandler));
            a = true;
        }
    }

    public static ArrayList b() {
        ObjectInputStream objectInputStream;
        ArrayList arrayList;
        Object obj;
        Throwable e;
        ArrayList arrayList2 = new ArrayList();
        ObjectInputStream objectInputStream2 = null;
        try {
            ArrayList arrayList3;
            File filesDir = C1125b.a().getFilesDir();
            if (filesDir != null) {
                File file = new File(filesDir, ".exception");
                if (file.isFile()) {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    try {
                        arrayList3 = (ArrayList) objectInputStream.readObject();
                        objectInputStream2 = objectInputStream;
                        if (objectInputStream2 == null) {
                            try {
                                objectInputStream2.close();
                                arrayList = arrayList3;
                                obj = null;
                            } catch (IOException e2) {
                                arrayList = arrayList3;
                                obj = null;
                            }
                        } else {
                            arrayList = arrayList3;
                            obj = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            new A().a(com.xiaomi.e.a.f, e);
                            obj = 1;
                            if (objectInputStream == null) {
                                try {
                                    objectInputStream.close();
                                    arrayList = arrayList2;
                                } catch (IOException e4) {
                                    arrayList = arrayList2;
                                }
                            } else {
                                arrayList = arrayList2;
                            }
                            if (obj != null) {
                                c();
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            e = th;
                            objectInputStream2 = objectInputStream;
                            if (objectInputStream2 != null) {
                                try {
                                    objectInputStream2.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    }
                    if (obj != null) {
                        c();
                    }
                    return arrayList;
                }
            }
            arrayList3 = arrayList2;
            if (objectInputStream2 == null) {
                arrayList = arrayList3;
                obj = null;
            } else {
                objectInputStream2.close();
                arrayList = arrayList3;
                obj = null;
            }
        } catch (Exception e6) {
            e = e6;
            objectInputStream = null;
            new A().a(com.xiaomi.e.a.f, e);
            obj = 1;
            if (objectInputStream == null) {
                arrayList = arrayList2;
            } else {
                objectInputStream.close();
                arrayList = arrayList2;
            }
            if (obj != null) {
                c();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            throw e;
        }
        if (obj != null) {
            c();
        }
        return arrayList;
    }

    public static void b(Throwable th) {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        ArrayList b = b();
        b.add(th);
        if (b.size() > 5) {
            b.remove(0);
        }
        try {
            objectOutputStream = new ObjectOutputStream(C1125b.a().openFileOutput(".exception", 0));
            try {
                objectOutputStream.writeObject(b);
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    new A().a(com.xiaomi.e.a.f, e);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            objectOutputStream = null;
            new A().a(com.xiaomi.e.a.f, e);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Throwable th3) {
            e = th3;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw e;
        }
    }

    public static void c() {
        new File(C1125b.a().getFilesDir(), ".exception").delete();
    }

    public static int d() {
        return b;
    }

    public boolean a() {
        if (System.currentTimeMillis() - E.a(C1125b.a(), "crash_time", 0) > F.a) {
            E.b(C1125b.a(), "crash_count", 1);
            E.b(C1125b.a(), "crash_time", System.currentTimeMillis());
        } else {
            int a = E.a(C1125b.a(), "crash_count", 0);
            if (a == 0) {
                E.b(C1125b.a(), "crash_time", System.currentTimeMillis());
            }
            a++;
            E.b(C1125b.a(), "crash_count", a);
            if (a > 10) {
                return true;
            }
        }
        return false;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (VERSION.SDK_INT >= 9) {
            StrictMode.setThreadPolicy(new Builder().build());
        }
        if (!d.e()) {
            b(th);
        } else if (a()) {
            new A().a("crazy crash...");
        } else {
            a(th);
        }
        if (this.c != null) {
            this.c.uncaughtException(thread, th);
        }
    }
}
