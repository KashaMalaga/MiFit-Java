package com.xiaomi.market.sdk;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

class u implements Runnable {
    final /* synthetic */ s a;

    u(s sVar) {
        this.a = sVar;
    }

    public void run() {
        Throwable th;
        if (this.a.a.d == null || this.a.a.c == null || this.a.a.f == null) {
            this.a.a.d = d.b(this.a.a.b);
            if (this.a.a.d != null) {
                Cursor a;
                try {
                    a = w.a(this.a.a.b).a(q.b, q.l, "package_name=?", new String[]{this.a.a.d.a}, null, null, null);
                    if (a != null) {
                        try {
                            if (a.moveToFirst()) {
                                this.a.a.e = a.getLong(a.getColumnIndex(q.d));
                                B b = new B();
                                b.d = a.getInt(a.getColumnIndex(q.e));
                                b.f = a.getString(a.getColumnIndex(q.f));
                                b.g = a.getString(a.getColumnIndex(q.g));
                                b.i = a.getString(a.getColumnIndex(q.h));
                                b.j = a.getString(a.getColumnIndex(q.i));
                                this.a.a.c = b;
                                Object string = a.getString(a.getColumnIndex(q.j));
                                if (!TextUtils.isEmpty(string)) {
                                    this.a.a.f = new File(string);
                                    if (a != null) {
                                        a.close();
                                    }
                                } else if (a != null) {
                                    a.close();
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (a != null) {
                                a.close();
                            }
                            throw th;
                        }
                    }
                    if (a != null) {
                        a.close();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    a = null;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
            return;
        }
        String a2 = !TextUtils.isEmpty(this.a.a.c.i) ? this.a.a(this.a.a.f.getAbsolutePath(), this.a.a.c.j) : this.a.a.f.getAbsolutePath();
        if (TextUtils.isEmpty(this.a.a.c.g) || TextUtils.isEmpty(a2) || TextUtils.equals(g.a(new File(a2)), this.a.a.c.g)) {
            Uri parse = Uri.parse("file://" + a2);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(parse, "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            this.a.a.b.startActivity(intent);
        }
    }
}
