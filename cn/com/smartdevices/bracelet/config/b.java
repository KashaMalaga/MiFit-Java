package cn.com.smartdevices.bracelet.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import android.util.Log;
import cn.com.smartdevices.bracelet.config.a.c;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.j.h;
import com.c.a.C0993k;
import com.c.a.r;
import com.d.a.a.O;
import com.xiaomi.mistatistic.sdk.d;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kankan.wheel.widget.a;
import org.json.JSONObject;

public class b {
    private static final transient String C = "Config";
    private static final transient String D = "huami.health.getNewUrlConfig.json";
    private static final transient String E = "hm_channel";
    private static final transient String F = "hm_device_type";
    private static final transient int G = 524288;
    private static final transient C0993k H = new r().i();
    private static transient String J = null;
    private static transient int K = 0;
    private static transient String L = null;
    private static transient String M = null;
    private static transient String N = "https://hm.xiaomi.com/";
    private static transient b O = null;
    private static File P = null;
    public static final transient String a = "config.json";
    public static transient boolean x = false;
    public final transient String A = "1uMqYWpHo3MoLH";
    public final transient String B = a.bO;
    @com.c.a.a.b(a = "expireInterval")
    private Long I = Long.valueOf(d.h);
    @com.c.a.a.b(a = "login")
    public final k b = new k();
    @com.c.a.a.b(a = "partner")
    public final m c = new m();
    @com.c.a.a.b(a = "push")
    public final n d = new n();
    @com.c.a.a.b(a = "lab")
    public final cn.com.smartdevices.bracelet.config.a.a e = new cn.com.smartdevices.bracelet.config.a.a();
    @com.c.a.a.b(a = "service")
    public final cn.com.smartdevices.bracelet.config.a.d f = new cn.com.smartdevices.bracelet.config.a.d();
    @com.c.a.a.b(a = "runner")
    public final c g = new c();
    @com.c.a.a.b(a = "mall")
    public final l h = new l();
    @com.c.a.a.b(a = "game")
    public final g i = new g();
    @com.c.a.a.b(a = "bluetooth")
    public final a j = new a();
    @com.c.a.a.b(a = "log")
    public final j k = new j();
    @com.c.a.a.b(a = "weight")
    public final s l = new s();
    @com.c.a.a.b(a = "weather")
    public final r m = new r();
    @com.c.a.a.b(a = "upgrade")
    public final q n = new q();
    @com.c.a.a.b(a = "feature")
    public final f o = new f();
    @com.c.a.a.b(a = "relation")
    public final cn.com.smartdevices.bracelet.config.a.b p = new cn.com.smartdevices.bracelet.config.a.b();
    @com.c.a.a.b(a = "honor")
    public final i q = new i();
    @com.c.a.a.b(a = "sleep_notify")
    public final p r = new p();
    @com.c.a.a.b(a = "heartrate")
    public final h s = new h();
    @com.c.a.a.b(a = "shoes")
    public final o t = new o();
    @com.c.a.a.b(a = "agreement")
    public final String u = "https://hm.xiaomi.com/huami.health.agreement.do";
    @com.c.a.a.b(a = "agreement_global")
    public final String v = "https://hm.mi-ae.com/huami.health.agreement.do";
    @com.c.a.a.b(a = "global")
    public final Boolean w = Boolean.valueOf(false);
    public final transient String y = "1.0";
    public final transient String z = "c18c24046606b2e084edd37f9fe9f94d";

    private b() {
    }

    public static b a(InputStream inputStream) {
        b bVar = null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[C0113o.j];
        StringBuilder stringBuilder = new StringBuilder();
        int read;
        do {
            read = inputStreamReader.read(cArr, 0, cArr.length);
            if (read > 0) {
                stringBuilder.append(cArr, 0, read);
                continue;
            }
        } while (read > 0);
        if (stringBuilder.length() > 0) {
            bVar = (b) H.a(stringBuilder.toString(), b.class);
        }
        try {
            inputStreamReader.close();
        } catch (IOException e) {
            if (x) {
                Log.e(C, e.getMessage());
            }
        }
        return bVar;
    }

    public static String a() {
        return J;
    }

    public static void a(Context context) {
        O a = f.a(cn.com.smartdevices.bracelet.e.a.f(context));
        cn.com.smartdevices.bracelet.j.d.a.c(h.b(N + D, a.c(f.c)), a, new c(context));
    }

    public static void a(Context context, boolean z) {
        InputStream inputStream;
        Exception e;
        b a;
        Throwable th;
        b bVar = null;
        if (O == null) {
            O = new b();
            O.c(context);
            synchronized (b.class) {
                P = new File(context.getCacheDir(), a);
                if (z) {
                    a(P);
                }
                Object obj;
                try {
                    if (!P.exists() || x) {
                        obj = bVar;
                    } else if (P.length() > 524288) {
                        a(P);
                        inputStream = bVar;
                    } else {
                        try {
                            inputStream = new FileInputStream(P);
                            try {
                                bVar = a(inputStream);
                            } catch (Exception e2) {
                                e = e2;
                                if (x) {
                                    Log.e(C, e.getMessage());
                                }
                                a(P);
                                if (bVar == null) {
                                    try {
                                        inputStream = context.getResources().getAssets().open(a);
                                        a = a(inputStream);
                                    } catch (Exception e3) {
                                        if (x) {
                                            Log.e(C, e3.getMessage());
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e4) {
                                                if (x) {
                                                    Log.e(C, e4.getMessage());
                                                }
                                            }
                                        }
                                        throw th;
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e42) {
                                            if (x) {
                                                Log.e(C, e42.getMessage());
                                            }
                                        }
                                    }
                                    if (a != null) {
                                        O = a;
                                    }
                                    return;
                                }
                                a = bVar;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (a != null) {
                                    O = a;
                                }
                                return;
                            }
                        } catch (Exception e5) {
                            e3 = e5;
                            inputStream = bVar;
                            if (x) {
                                Log.e(C, e3.getMessage());
                            }
                            a(P);
                            if (bVar == null) {
                                inputStream = context.getResources().getAssets().open(a);
                                a = a(inputStream);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (a != null) {
                                    O = a;
                                }
                                return;
                            }
                            a = bVar;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (a != null) {
                                O = a;
                            }
                            return;
                        }
                    }
                    if (bVar == null) {
                        inputStream = context.getResources().getAssets().open(a);
                        a = a(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (a != null) {
                            O = a;
                        }
                    }
                    a = bVar;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (a != null) {
                        O = a;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = bVar;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
            return;
        }
        return;
    }

    private static void a(File file) {
        if (file != null && file.exists() && !file.delete()) {
            file.deleteOnExit();
        }
    }

    static void a(String str) {
        N = str;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object obj = jSONObject2.get(str);
                if (jSONObject.isNull(str)) {
                    jSONObject.put(str, obj);
                } else if (obj instanceof JSONObject) {
                    Object obj2 = jSONObject.get(str);
                    if (obj2 instanceof JSONObject) {
                        a((JSONObject) obj2, (JSONObject) obj);
                    }
                } else if (jSONObject.get(str).getClass() == obj.getClass()) {
                    jSONObject.put(str, obj);
                }
            }
        }
    }

    public static int b() {
        return K;
    }

    private static String b(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[C0113o.j];
        try {
            String stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            while (true) {
                int read = inputStreamReader.read(cArr, 0, cArr.length);
                if (read > 0) {
                    stringBuilder2.append(cArr, 0, read);
                    continue;
                }
                if (read <= 0) {
                    break;
                }
            }
            if (stringBuilder2.length() > 0) {
                stringBuilder = stringBuilder2.toString();
            } else {
                stringBuilder = null;
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    if (x) {
                        Log.e(C, e.getMessage());
                    }
                }
            }
            return stringBuilder;
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e2) {
                if (x) {
                    Log.e(C, e2.getMessage());
                }
            }
        }
    }

    public static JSONObject b(Context context) {
        InputStream open;
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        try {
            String b;
            CharSequence b2 = (P == null || !P.exists()) ? null : b(new FileInputStream(P));
            if (TextUtils.isEmpty(b2)) {
                open = context.getResources().getAssets().open(a);
                try {
                    b2 = b(open);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (x) {
                            Log.e(C, e.getMessage());
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e3) {
                                if (x) {
                                    Log.e(C, e3.getMessage());
                                }
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = open;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                if (x) {
                                    Log.e(C, e4.getMessage());
                                }
                            }
                        }
                        throw th;
                    }
                }
            }
            open = null;
            if (TextUtils.isEmpty(b2)) {
                b = H.b(O);
            } else {
                CharSequence charSequence = b2;
            }
            JSONObject jSONObject = new JSONObject(b);
            if (open == null) {
                return jSONObject;
            }
            try {
                open.close();
                return jSONObject;
            } catch (IOException e42) {
                if (!x) {
                    return jSONObject;
                }
                Log.e(C, e42.getMessage());
                return jSONObject;
            }
        } catch (Exception e5) {
            e = e5;
            open = null;
            if (x) {
                Log.e(C, e.getMessage());
            }
            if (open != null) {
                open.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(cn.com.smartdevices.bracelet.config.b r3) {
        /*
        r1 = cn.com.smartdevices.bracelet.config.b.class;
        monitor-enter(r1);
        if (r3 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
    L_0x0006:
        return;
    L_0x0007:
        O = r3;	 Catch:{ all -> 0x0022 }
        r0 = de.greenrobot.event.EventBus.getDefault();	 Catch:{ all -> 0x0022 }
        r0.post(r3);	 Catch:{ all -> 0x0022 }
        r0 = O;	 Catch:{ all -> 0x0022 }
        r0.i();	 Catch:{ all -> 0x0022 }
        r0 = x;	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0020;
    L_0x0019:
        r0 = "Config";
        r2 = "config load complete";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x0022 }
    L_0x0020:
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x0006;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.config.b.b(cn.com.smartdevices.bracelet.config.b):void");
    }

    public static String c() {
        return L;
    }

    private void c(Context context) {
        String str;
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), C0113o.o);
            str = packageInfo.versionName;
            i = packageInfo.versionCode;
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageInfo.packageName, C0113o.h);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    L = bundle.getString(E);
                    M = bundle.getString(F);
                }
            }
        } catch (NameNotFoundException e) {
            i = 0;
            str = com.xiaomi.e.a.f;
        }
        context.getContentResolver().registerContentObserver(ConfigProvider.c, true, new d(context, new Handler()));
        K = i;
        J = str;
        Object b = cn.com.smartdevices.bracelet.e.a.b(context);
        if (TextUtils.isEmpty(b)) {
            N = "https://hm.xiaomi.com/";
        } else {
            N = b;
        }
        if (TextUtils.isEmpty(M)) {
            M = "android_phone";
        }
        b = cn.com.smartdevices.bracelet.e.a.a(context);
        if (!TextUtils.isEmpty(b)) {
            L = b;
        }
    }

    public static String d() {
        return M;
    }

    public static String e() {
        return N;
    }

    public static String f() {
        return "https://hm.mi-ae.com/";
    }

    public static String g() {
        return "http://hm-scale.app-xae.xiaomi.com/";
    }

    public static b h() {
        b bVar;
        synchronized (b.class) {
            bVar = O;
        }
        return bVar;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            b((b) H.a(jSONObject.toString(), b.class));
        }
    }

    public void b(JSONObject jSONObject) {
        BufferedOutputStream bufferedOutputStream;
        Throwable e;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(P));
            try {
                bufferedOutputStream.write(jSONObject.toString().getBytes());
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable e2) {
                        Log.e(C, "save file close failed", e2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    if (x) {
                        Log.e(C, "config save file", e2);
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e22) {
                            Log.e(C, "save file close failed", e22);
                        }
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            Log.e(C, "save file close failed", e4);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            bufferedOutputStream = null;
            if (x) {
                Log.e(C, "config save file", e22);
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        } catch (Throwable th2) {
            e22 = th2;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw e22;
        }
    }

    public void i() {
        Throwable e;
        if (O == null) {
            Log.e(C, "config don't init");
            return;
        }
        BufferedOutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(P));
            try {
                bufferedOutputStream.write(H.b(O).getBytes());
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable e2) {
                        Log.e(C, "save file close failed", e2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    if (x) {
                        Log.e(C, "config save file", e2);
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e22) {
                            Log.e(C, "save file close failed", e22);
                        }
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            Log.e(C, "save file close failed", e4);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            bufferedOutputStream = null;
            if (x) {
                Log.e(C, "config save file", e22);
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        } catch (Throwable th2) {
            e22 = th2;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw e22;
        }
    }
}
