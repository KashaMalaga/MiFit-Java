package com.xiaomi.c.a;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import cn.com.smartdevices.bracelet.gps.services.C0454m;
import com.d.a.a.O;
import com.d.a.a.h;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.d.a;
import com.xiaomi.channel.a.e.b;
import com.xiaomi.channel.b.v;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

final class w implements C1084o {
    private final Lock a = new ReentrantLock();
    private final HttpContext b;
    private final HttpClient c;
    private HttpPost d;
    private long e;
    private boolean f;
    private C1070b g;
    private C1078u h;
    private int i;

    w(HttpClient httpClient, O o, C1077i c1077i, C1078u c1078u, Context context) {
        this.c = httpClient;
        this.b = new BasicHttpContext();
        this.f = false;
        try {
            String d = c1078u.d();
            this.e = Long.parseLong(c1078u.a(K.q));
            String valueOf = String.valueOf((int) (Math.random() * 1000.0d));
            String encode = URLEncoder.encode(b.a("xm-http-bind&" + d));
            if (a.b(context)) {
                String host = o.a().getHost();
                Builder buildUpon = Uri.parse(a.a(o.a().toURL())).buildUpon();
                buildUpon.appendQueryParameter(C0454m.c, valueOf);
                this.d = new HttpPost(buildUpon.build().toString());
                this.d.addHeader("X-Online-Host", host);
            } else {
                Builder buildUpon2 = Uri.parse(o.a().toString()).buildUpon();
                buildUpon2.appendQueryParameter(C0454m.c, valueOf);
                this.d = new HttpPost(buildUpon2.build().toString());
            }
            this.d.addHeader("X-Content-Sig", encode);
            this.d.addHeader("Connection", "Keep-Alive");
            HttpEntity byteArrayEntity = new ByteArrayEntity(C1082m.a(d.getBytes(h.DEFAULT_CHARSET)));
            byteArrayEntity.setContentType(O.a);
            this.d.setEntity(byteArrayEntity);
        } catch (Throwable e) {
            this.g = new C1070b("Could not generate request", e);
        }
    }

    private synchronized void e() {
        c.b("SMACK-BOSH: requesting, rid=" + this.e + " url=" + this.d.getURI().toString());
        int i = 0;
        C1070b c1070b = null;
        while (i < 3) {
            try {
                HttpResponse execute = this.c.execute(this.d, this.b);
                byte[] toByteArray = EntityUtils.toByteArray(execute.getEntity());
                int statusCode = execute.getStatusLine().getStatusCode();
                c.b("SMACK-BOSH: get server response, code=" + statusCode);
                if (statusCode != v.C || toByteArray == null || !execute.containsHeader("X-Content-Sig")) {
                    d();
                    break;
                }
                toByteArray = C1082m.b(toByteArray);
                String decode = URLDecoder.decode(execute.getLastHeader("X-Content-Sig").getValue());
                C1078u a = C1088s.a(new String(toByteArray, h.DEFAULT_CHARSET));
                String a2 = b.a("xm-http-bind&" + a.d());
                if (!a2.equals(decode)) {
                    c.c("SMACK-BOSH: the server signature doesn't match, drop the response. received " + decode + ", expected " + a2);
                    this.g = new C1070b("signature mismatch");
                    d();
                    break;
                }
                this.h = a;
                c.b("SMACK-BOSH: server response, rid=" + this.e);
                this.i = statusCode;
                this.f = true;
                c1070b = null;
                break;
            } catch (Throwable e) {
                if (e instanceof SocketException) {
                    C1070b c1070b2 = new C1070b("Could not obtain response", e);
                    c.a("SMACK-BOSH: request error, retry=" + i, e);
                    i++;
                    c1070b = c1070b2;
                } else {
                    d();
                    this.g = new C1070b("Could not obtain response", e);
                    throw this.g;
                }
            }
        }
        if (i == 3) {
            d();
            this.g = c1070b;
            throw this.g;
        }
    }

    public int a() {
        if (this.g != null) {
            throw this.g;
        }
        this.a.lock();
        try {
            if (!this.f) {
                e();
            }
            this.a.unlock();
            return this.i;
        } catch (Throwable th) {
            this.a.unlock();
        }
    }

    public C1078u b() {
        if (this.g != null) {
            throw this.g;
        }
        this.a.lock();
        try {
            if (!this.f) {
                e();
            }
            this.a.unlock();
            return this.h;
        } catch (Throwable th) {
            this.a.unlock();
        }
    }

    public long c() {
        return this.e;
    }

    public void d() {
        if (this.d != null) {
            this.d.abort();
            this.g = new C1070b("HTTP request aborted");
        }
    }
}
