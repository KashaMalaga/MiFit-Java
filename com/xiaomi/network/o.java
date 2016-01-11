package com.xiaomi.network;

import android.content.Context;
import cn.com.smartdevices.bracelet.gps.services.C0454m;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import com.d.a.a.C1012a;
import com.d.a.a.h;
import com.xiaomi.b.a.a.a;
import com.xiaomi.b.a.a.a.c;
import com.xiaomi.b.a.a.a.e;
import com.xiaomi.mistatistic.sdk.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
import org.apache.thrift.b;
import org.apache.thrift.g;

public class o {
    private static o e;
    private List<p> a = new ArrayList();
    private final Random b = new Random();
    private Timer c = new Timer("Upload Http Record Timer");
    private boolean d = false;
    private Context f = null;

    private o(Context context) {
        this.f = context.getApplicationContext();
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            oVar = e;
        }
        return oVar;
    }

    private String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(b(str));
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return String.format("%1$032X", new Object[]{bigInteger});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void a(Context context) {
        synchronized (o.class) {
            if (e == null) {
                e = new o(context);
            }
        }
    }

    private void a(String str, String str2) {
        List arrayList = new ArrayList();
        String valueOf = String.valueOf(System.nanoTime());
        String valueOf2 = String.valueOf(System.currentTimeMillis());
        arrayList.add(new BasicNameValuePair("n", valueOf));
        arrayList.add(new BasicNameValuePair("d", str2));
        arrayList.add(new BasicNameValuePair(C0454m.c, valueOf2));
        arrayList.add(new BasicNameValuePair(GroupItemBaseInfo.KEY_START_TIME, a(valueOf + str2 + valueOf2 + "56C6A520%$C99119A0&^229(!@2746C7")));
        k.a(this.f, String.format("http://%1$s/diagnoses/v1/report", new Object[]{str}), arrayList);
    }

    private void a(List<c> list, double d) {
        for (c cVar : list) {
            b eVar = new e();
            eVar.a("httpapi");
            eVar.a(cVar);
            eVar.a(new a());
            String str = new String(b.a(new g(new org.apache.thrift.protocol.b.a()).a(eVar)));
            if (((double) this.b.nextInt(C1012a.b)) < 10000.0d * d) {
                try {
                    a("f3.mi-stat.gslb.mi-idc.com", str);
                } catch (IOException e) {
                } catch (Exception e2) {
                }
            }
        }
    }

    private byte[] b(String str) {
        try {
            return str.getBytes(h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    public void a(p pVar) {
        this.a.add(pVar);
    }

    public void b() {
        if (!this.d) {
            this.d = true;
            this.c.schedule(new t(this), d.g);
        }
    }
}
