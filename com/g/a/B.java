package com.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import b.a.C0352cm;
import b.a.bW;
import b.a.bX;
import java.io.File;
import java.io.InputStream;

public final class B {
    private static B a = new B();
    private static Context b = null;
    private static String c = null;
    private static long d = 1209600000;
    private static long e = 2097152;
    private static final String f = "age";
    private static final String g = "sex";
    private static final String h = "id";
    private static final String i = "url";
    private static final String j = "mobclick_agent_user_";
    private static final String k = "mobclick_agent_online_setting_";
    private static final String l = "mobclick_agent_header_";
    private static final String m = "mobclick_agent_update_";
    private static final String n = "mobclick_agent_state_";
    private static final String o = "mobclick_agent_cached_";
    private static final String p = "mobclick_agent_sealed_";

    public static B a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
        if (c == null) {
            c = context.getPackageName();
        }
        return a;
    }

    private static boolean a(File file) {
        return file.exists() && file.length() > e;
    }

    private SharedPreferences k() {
        return b.getSharedPreferences(new StringBuilder(j).append(c).toString(), 0);
    }

    private String l() {
        return new StringBuilder(l).append(c).toString();
    }

    private String m() {
        return new StringBuilder(o).append(c).append(bW.c(b)).toString();
    }

    private String n() {
        return new StringBuilder(p).append(c).toString();
    }

    public void a(int i, int i2) {
        Editor edit = a(b).g().edit();
        edit.putInt(p.h, i);
        edit.putLong(p.i, (long) i2);
        edit.commit();
    }

    public void a(String str, String str2, int i, int i2) {
        Editor edit = k().edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(h, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(i, str2);
        }
        if (i > 0) {
            edit.putInt(f, i);
        }
        edit.putInt(g, i2);
        edit.commit();
    }

    public void a(byte[] bArr) {
        try {
            C0352cm.a(new File(b.getFilesDir(), m()), bArr);
        } catch (Exception e) {
            bX.b(p.e, e.getMessage());
        }
    }

    public int[] a() {
        SharedPreferences g = g();
        int[] iArr = new int[2];
        if (g.getInt(p.h, -1) != -1) {
            iArr[0] = g.getInt(p.h, 1);
            iArr[1] = (int) g.getLong(p.i, 0);
        } else {
            iArr[0] = g.getInt(p.k, 1);
            iArr[1] = (int) g.getLong(p.l, 0);
        }
        return iArr;
    }

    public void b(byte[] bArr) {
        try {
            C0352cm.a(new File(b.getFilesDir(), n()), bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] b() {
        InputStream openFileInput;
        Exception e;
        Throwable th;
        byte[] bArr = null;
        String m = m();
        File file = new File(b.getFilesDir(), m);
        if (a(file)) {
            file.delete();
        } else if (file.exists()) {
            try {
                openFileInput = b.openFileInput(m);
                try {
                    bArr = C0352cm.b(openFileInput);
                    C0352cm.c(openFileInput);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        C0352cm.c(openFileInput);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        C0352cm.c(openFileInput);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openFileInput = bArr;
                e.printStackTrace();
                C0352cm.c(openFileInput);
                return bArr;
            } catch (Throwable th3) {
                openFileInput = bArr;
                th = th3;
                C0352cm.c(openFileInput);
                throw th;
            }
        }
        return bArr;
    }

    public Object[] b(Context context) {
        SharedPreferences k = k();
        Object[] objArr = new Object[4];
        if (k.contains(h)) {
            objArr[0] = k.getString(h, null);
        }
        if (k.contains(i)) {
            objArr[1] = k.getString(i, null);
        }
        if (k.contains(f)) {
            objArr[2] = Integer.valueOf(k.getInt(f, -1));
        }
        if (k.contains(g)) {
            objArr[3] = Integer.valueOf(k.getInt(g, -1));
        }
        return objArr;
    }

    public void c() {
        b.deleteFile(l());
        b.deleteFile(m());
    }

    public byte[] d() {
        Exception e;
        Throwable th;
        String n = n();
        File file = new File(b.getFilesDir(), n);
        try {
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            InputStream openFileInput;
            try {
                openFileInput = b.openFileInput(n);
            } catch (Exception e2) {
                e = e2;
                openFileInput = null;
                try {
                    e.printStackTrace();
                    C0352cm.c(openFileInput);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C0352cm.c(openFileInput);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                openFileInput = null;
                C0352cm.c(openFileInput);
                throw th;
            }
            try {
                byte[] b = C0352cm.b(openFileInput);
                C0352cm.c(openFileInput);
                return b;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                C0352cm.c(openFileInput);
                return null;
            }
        } catch (Exception e4) {
            file.delete();
            e4.printStackTrace();
        }
    }

    public void e() {
        bX.a("--->", "delete envelope:" + b.deleteFile(n()));
    }

    public boolean f() {
        File file = new File(b.getFilesDir(), n());
        return file.exists() && file.length() > 0;
    }

    public SharedPreferences g() {
        return b.getSharedPreferences(new StringBuilder(k).append(c).toString(), 0);
    }

    public SharedPreferences h() {
        return b.getSharedPreferences(new StringBuilder(l).append(c).toString(), 0);
    }

    public SharedPreferences i() {
        return b.getSharedPreferences(new StringBuilder(m).append(c).toString(), 0);
    }

    public SharedPreferences j() {
        return b.getSharedPreferences(new StringBuilder(n).append(c).toString(), 0);
    }
}
