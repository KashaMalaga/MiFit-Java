package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import com.d.a.a.h;
import com.xiaomi.mipush.sdk.f;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

abstract class bj {
    private ad a;

    bj() {
    }

    static bj a(int i) {
        switch (i) {
            case a.i /*0*/:
                return new bd();
            case l.a /*1*/:
                return new bf();
            case a.k /*2*/:
                return new bb();
            default:
                return null;
        }
    }

    private String a(Context context, ad adVar) {
        return y.a(context, adVar);
    }

    private String a(Context context, String str) {
        String str2 = null;
        try {
            str2 = y.a(context, str.getBytes(h.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    private String a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2).append(f.i).append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    private void a(al alVar, String str, String str2, int i, boolean z) {
        an anVar = new an();
        anVar.a(0);
        anVar.b(str);
        anVar.a(str2);
        alVar.b(anVar, i);
    }

    private boolean a(Context context, String str, String str2, String str3, al alVar) {
        boolean z;
        Throwable th;
        Throwable th2;
        OutputStream outputStream = null;
        bl blVar = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(bg.a);
            stringBuilder.append(str2);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                blVar = bl.a(file, 1, 1, 20480);
                blVar.a(a(alVar));
                if (blVar.a(str) != null) {
                    z = false;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    if (blVar == null || blVar.a()) {
                        return false;
                    }
                    try {
                        blVar.close();
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        th.printStackTrace();
                        return z;
                    }
                }
                byte[] bytes = str3.getBytes(h.DEFAULT_CHARSET);
                bl.a b = blVar.b(str);
                outputStream = b.a(0);
                outputStream.write(bytes);
                b.a();
                blVar.b();
                z = true;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th32) {
                        th32.printStackTrace();
                    }
                }
                if (blVar == null || blVar.a()) {
                    return true;
                }
                try {
                    blVar.close();
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    th.printStackTrace();
                    return z;
                }
            }
            z = false;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th322) {
                    th322.printStackTrace();
                }
            }
            if (blVar == null || blVar.a()) {
                return false;
            }
            try {
                blVar.close();
                return false;
            } catch (Throwable th6) {
                th = th6;
            }
            if (!(blVar == null || blVar.a())) {
                blVar.close();
            }
            return false;
            if (!(blVar == null || blVar.a())) {
                blVar.close();
            }
            return false;
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th7) {
            th2 = th7;
            th2.printStackTrace();
        }
    }

    private String b(Throwable th) {
        return th.toString();
    }

    private List<ad> b(Context context) {
        List<ad> a;
        Throwable th;
        Throwable th2;
        Throwable th3;
        List<ad> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    a = new ao(context).a();
                    try {
                    } catch (Throwable th22) {
                        th = th22;
                        list = a;
                        th3 = th;
                        try {
                            throw th3;
                        } catch (Throwable th32) {
                            th = th32;
                            a = list;
                            th22 = th;
                        }
                    }
                } catch (Throwable th4) {
                    th32 = th4;
                    throw th32;
                }
            }
        } catch (Throwable th322) {
            th = th322;
            a = null;
            th22 = th;
            th22.printStackTrace();
            return a;
        }
    }

    private String c() {
        return bk.a(new Date().getTime());
    }

    private String c(Context context) {
        return w.e(context);
    }

    protected abstract int a();

    protected abstract bo a(al alVar);

    protected abstract String a(String str);

    protected String a(Throwable th) {
        String str = null;
        try {
            str = bk.a(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return str;
    }

    protected abstract String a(List<ad> list);

    void a(Context context) {
        List b = b(context);
        if (b != null && b.size() != 0) {
            String a = a(b);
            if (a != null && !com.xiaomi.e.a.f.equals(a)) {
                String c = c();
                String a2 = a(context, this.a);
                int a3 = a();
                String a4 = a(c(context), a2, c, a3, "ANR", a);
                if (a4 != null && !com.xiaomi.e.a.f.equals(a4)) {
                    String a5 = a(a);
                    String a6 = a(context, a4);
                    String b2 = b();
                    synchronized (Looper.getMainLooper()) {
                        al alVar = new al(context);
                        a(alVar, this.a.a(), a5, a3, a(context, a5, b2, a6, alVar));
                    }
                }
            }
        }
    }

    void a(Context context, Throwable th, String str, String str2) {
        List<ad> b = b(context);
        if (b != null && b.size() != 0) {
            String a = a(th);
            if (a != null && !com.xiaomi.e.a.f.equals(a)) {
                for (ad adVar : b) {
                    if (a(adVar.f(), a)) {
                        a(adVar);
                        String c = c();
                        String a2 = a(context, adVar);
                        String c2 = c(context);
                        String b2 = b(th);
                        if (b2 != null && !com.xiaomi.e.a.f.equals(b2)) {
                            int a3 = a();
                            StringBuilder stringBuilder = new StringBuilder();
                            if (str != null) {
                                stringBuilder.append("class:").append(str);
                            }
                            if (str2 != null) {
                                stringBuilder.append(" method:").append(str2).append("$").append("<br/>");
                            }
                            stringBuilder.append(a);
                            String a4 = a(a);
                            String a5 = a(c2, a2, c, a3, b2, stringBuilder.toString());
                            if (a5 != null && !com.xiaomi.e.a.f.equals(a5)) {
                                String a6 = a(context, a5);
                                String b3 = b();
                                synchronized (Looper.getMainLooper()) {
                                    al alVar = new al(context);
                                    a(alVar, adVar.a(), a4, a3, a(context, a4, b3, a6, alVar));
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    protected void a(ad adVar) {
        this.a = adVar;
    }

    protected boolean a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String indexOf : strArr) {
                if (str.indexOf(indexOf) != -1) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    protected abstract String b();
}
