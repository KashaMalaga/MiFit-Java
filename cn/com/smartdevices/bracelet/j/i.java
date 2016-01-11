package cn.com.smartdevices.bracelet.j;

import android.content.Context;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.model.LoginData;

public class i {
    public String i;
    public int j = -1;
    public String k = null;
    public String l = null;
    public int m;
    public int n = 0;
    public LoginData o;
    public long p = 0;
    public String q = null;
    public String r = null;

    public i(Context context) {
        this.o = a.f(context);
        this.i = a.d(context);
    }

    public i(Context context, int i) {
        this.o = a.f(context);
        this.i = a.d(context);
        this.m = i;
    }

    public i(Context context, int i, int i2) {
        this.o = a.f(context);
        this.i = a.d(context);
        this.m = i;
        this.n = i2;
    }
}
