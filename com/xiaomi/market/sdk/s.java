package com.xiaomi.market.sdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;

public class s extends Handler {
    final /* synthetic */ r a;

    public s(r rVar, Looper looper) {
        this.a = rVar;
        super(looper);
    }

    private String a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(g.a(new File(str)), str2)) {
            return null;
        }
        String absolutePath = this.a.f.getAbsolutePath();
        if (this.a.d == null || TextUtils.isEmpty(this.a.d.f)) {
            return null;
        }
        C1122a.a(this.a.d.f, absolutePath, str);
        return absolutePath;
    }

    public void a() {
        post(new t(this));
    }

    public void b() {
        post(new u(this));
    }
}
