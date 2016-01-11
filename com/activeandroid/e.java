package com.activeandroid;

import android.content.Context;
import com.activeandroid.d.b;
import com.activeandroid.d.d;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e {
    private static final String a = "AA_DB_NAME";
    private static final String b = "AA_DB_VERSION";
    private static final String c = "AA_MODELS";
    private static final String d = "AA_SERIALIZERS";
    private static final String e = "AA_SQL_PARSER";
    private static final int f = 1024;
    private static final String g = "Application.db";
    private static final String h = "legacy";
    private Context i;
    private Integer j = Integer.valueOf(f);
    private String k;
    private Integer l;
    private String m;
    private List<Class<? extends g>> n;
    private List<Class<? extends com.activeandroid.c.e>> o;

    public e(Context context) {
        this.i = context.getApplicationContext();
    }

    private List<Class<? extends g>> a(String[] strArr) {
        List<Class<? extends g>> arrayList = new ArrayList();
        ClassLoader classLoader = this.i.getClass().getClassLoader();
        for (String trim : strArr) {
            try {
                Class cls = Class.forName(trim.trim(), false, classLoader);
                if (d.a(cls)) {
                    arrayList.add(cls);
                }
            } catch (Throwable e) {
                b.e("Couldn't create class.", e);
            }
        }
        return arrayList;
    }

    private String b() {
        String str = (String) d.a(this.i, a);
        return str == null ? g : str;
    }

    private List<Class<? extends com.activeandroid.c.e>> b(String[] strArr) {
        List<Class<? extends com.activeandroid.c.e>> arrayList = new ArrayList();
        ClassLoader classLoader = this.i.getClass().getClassLoader();
        for (String trim : strArr) {
            try {
                Class cls = Class.forName(trim.trim(), false, classLoader);
                if (d.b(cls)) {
                    arrayList.add(cls);
                }
            } catch (Throwable e) {
                b.e("Couldn't create class.", e);
            }
        }
        return arrayList;
    }

    private int c() {
        Integer num = (Integer) d.a(this.i, b);
        if (num == null || num.intValue() == 0) {
            num = Integer.valueOf(1);
        }
        return num.intValue();
    }

    private String d() {
        String str = (String) d.a(this.i, e);
        return str == null ? h : str;
    }

    public c a() {
        String str;
        c cVar = new c(this.i);
        cVar.i = this.j.intValue();
        if (this.k != null) {
            cVar.d = this.k;
        } else {
            cVar.d = b();
        }
        if (this.l != null) {
            cVar.e = this.l.intValue();
        } else {
            cVar.e = c();
        }
        if (this.m != null) {
            cVar.f = this.m;
        } else {
            cVar.f = d();
        }
        if (this.n != null) {
            cVar.g = this.n;
        } else {
            str = (String) d.a(this.i, c);
            if (str != null) {
                cVar.g = a(str.split(f.i));
            }
        }
        if (this.o != null) {
            cVar.h = this.o;
        } else {
            str = (String) d.a(this.i, d);
            if (str != null) {
                cVar.h = b(str.split(f.i));
            }
        }
        return cVar;
    }

    public e a(int i) {
        this.j = Integer.valueOf(i);
        return this;
    }

    public e a(Class<? extends g> cls) {
        if (this.n == null) {
            this.n = new ArrayList();
        }
        this.n.add(cls);
        return this;
    }

    public e a(String str) {
        this.k = str;
        return this;
    }

    public e a(Class<? extends g>... clsArr) {
        if (this.n == null) {
            this.n = new ArrayList();
        }
        this.n.addAll(Arrays.asList(clsArr));
        return this;
    }

    public e b(int i) {
        this.l = Integer.valueOf(i);
        return this;
    }

    public e b(Class<? extends com.activeandroid.c.e> cls) {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.add(cls);
        return this;
    }

    public e b(String str) {
        this.m = str;
        return this;
    }

    public e b(Class<? extends g>... clsArr) {
        this.n = Arrays.asList(clsArr);
        return this;
    }

    public e c(Class<? extends com.activeandroid.c.e>... clsArr) {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.addAll(Arrays.asList(clsArr));
        return this;
    }

    public e d(Class<? extends com.activeandroid.c.e>... clsArr) {
        this.o = Arrays.asList(clsArr);
        return this;
    }
}
