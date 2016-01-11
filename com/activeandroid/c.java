package com.activeandroid;

import android.content.Context;
import com.activeandroid.c.e;
import java.util.List;

public class c {
    public static final String a = "legacy";
    public static final String b = "delimited";
    private Context c;
    private String d;
    private int e;
    private String f;
    private List<Class<? extends g>> g;
    private List<Class<? extends e>> h;
    private int i;

    private c(Context context) {
        this.c = context;
    }

    public Context a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public List<Class<? extends g>> e() {
        return this.g;
    }

    public List<Class<? extends e>> f() {
        return this.h;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.g != null && this.g.size() > 0;
    }
}
