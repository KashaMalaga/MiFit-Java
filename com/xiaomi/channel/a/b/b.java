package com.xiaomi.channel.a.b;

import android.util.Log;

public class b implements a {
    private String a = "xiaomi";

    public void a(String str) {
        this.a = str;
    }

    public void a(String str, Throwable th) {
        Log.v(this.a, str, th);
    }

    public void b(String str) {
        Log.v(this.a, str);
    }
}
