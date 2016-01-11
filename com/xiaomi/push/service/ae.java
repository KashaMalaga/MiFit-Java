package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.xiaomi.market.sdk.o;

public class ae {
    private static ae a;
    private Context b;
    private int c = 0;

    private ae(Context context) {
        this.b = context.getApplicationContext();
    }

    public static ae a(Context context) {
        if (a == null) {
            a = new ae(context);
        }
        return a;
    }

    public boolean a() {
        return o.w.contains("xmsf") || o.w.contains("xiaomi") || o.w.contains(C0763dl.b);
    }

    @SuppressLint({"NewApi"})
    public int b() {
        if (this.c != 0) {
            return this.c;
        }
        if (VERSION.SDK_INT >= 17) {
            this.c = Global.getInt(this.b.getContentResolver(), "device_provisioned", 0);
            return this.c;
        }
        this.c = Secure.getInt(this.b.getContentResolver(), "device_provisioned", 0);
        return this.c;
    }

    @SuppressLint({"NewApi"})
    public Uri c() {
        return VERSION.SDK_INT >= 17 ? Global.getUriFor("device_provisioned") : Secure.getUriFor("device_provisioned");
    }
}
