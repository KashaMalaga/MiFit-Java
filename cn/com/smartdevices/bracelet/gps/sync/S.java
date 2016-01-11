package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import kankan.wheel.widget.a;

class S {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final String e = "syncRunningState";
    private int f = a;
    private int g = a;

    public S(int i) {
        this.g = i;
    }

    public static S a(Context context, int i) {
        S s = new S(i);
        switch (i) {
            case a.aQ /*4*/:
                s.f = context.getSharedPreferences(a.m, a).getInt(e, a);
                break;
        }
        return s;
    }

    public int a() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(Context context) {
        Editor edit = context.getSharedPreferences(a.m, a).edit();
        switch (this.g) {
            case a.aQ /*4*/:
                edit.putInt(e, this.f);
                break;
        }
        edit.commit();
    }

    public boolean b() {
        return this.f == d;
    }

    public boolean c() {
        return this.f != 0;
    }

    public boolean d() {
        return this.f == c;
    }

    public void e() {
        this.f = a;
    }
}
