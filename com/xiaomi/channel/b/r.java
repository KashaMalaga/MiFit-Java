package com.xiaomi.channel.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;

public class r {
    public static final String a = "extra_share_bundle";
    public String b;
    private Context c;
    private String d;
    private String e;
    private String f;
    private Drawable g;
    private String h;

    public r(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context could not be null!");
        }
        a(context);
    }

    public r(Context context, String str, String str2) {
        if (context == null) {
            throw new IllegalArgumentException("context could not be null!");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("appId could not be empty!");
        } else {
            this.d = str;
            this.b = str2;
            a(context);
        }
    }

    private void a(Context context) {
        this.c = context.getApplicationContext();
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo(this.f, 0);
            this.e = packageInfo.applicationInfo.loadLabel(this.c.getPackageManager()).toString();
            this.g = packageInfo.applicationInfo.loadIcon(this.c.getPackageManager());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String a(o oVar, boolean z) {
        String str = a.f;
        if (oVar != null) {
            Intent intent = new Intent();
            Bundle a = oVar.a();
            if (a != null) {
                if (!TextUtils.isEmpty(this.d)) {
                    a.putString(v.u, this.d);
                }
                a.putString(v.v, this.e);
                if (z) {
                    a.putString(v.w, this.f);
                    p b = oVar.b();
                    if (b != null) {
                        a.putString(v.s, b.a());
                    }
                }
                if (this.g != null) {
                    a.putParcelable(v.x, w.a(this.g));
                }
                a.putString(v.y, TextUtils.isEmpty(this.b) ? v.S : this.b);
                if (!TextUtils.isEmpty(this.h)) {
                    a.putString(v.t, this.h);
                }
            }
            if (x.d(this.c)) {
                return b.b(this.c).a(a);
            }
        }
        return a.f;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f = str;
            if (!TextUtils.isEmpty(str2)) {
                this.e = str2;
            }
        }
    }
}
