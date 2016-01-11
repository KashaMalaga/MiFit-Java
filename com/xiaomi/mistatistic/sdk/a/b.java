package com.xiaomi.mistatistic.sdk.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.b.A;
import com.xiaomi.mistatistic.sdk.b.u;
import com.xiaomi.mistatistic.sdk.c.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.Permission;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;

public class b extends HttpURLConnection {
    private String a = null;
    private long b = SystemClock.elapsedRealtime();
    private long c;
    private long d;
    private int e = -1;
    private boolean f = false;
    private String g = null;
    private g h;
    private f i;
    private HttpURLConnection j;

    public b(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.j = httpURLConnection;
    }

    private boolean a(String str) {
        return InetAddressUtils.isIPv4Address(str) || InetAddressUtils.isIPv6Address(str);
    }

    private int c() {
        int i = 0;
        int a = this.i != null ? this.i.a() : 0;
        if (this.h != null) {
            i = this.h.a();
        }
        return ((a + 1100) + i) + getURL().toString().getBytes().length;
    }

    private void d() {
        String host = this.url.getHost();
        if (this.g == null && host != null && !a(host)) {
            a.a().execute(new c(this));
        }
    }

    private synchronized void e() {
        if (TextUtils.isEmpty(this.g) && !this.f) {
            String host = this.url.getHost();
            if (!(this.g != null || host == null || a(host))) {
                try {
                    this.g = InetAddress.getByName(host).getHostAddress();
                } catch (Throwable e) {
                    new A().a("can not get ip", e);
                }
            }
        }
    }

    private int f() {
        int i = -1;
        if (this.e != i) {
            return this.e;
        }
        try {
            return this.j.getResponseCode();
        } catch (Exception e) {
            return i;
        }
    }

    private synchronized void g() {
        if (this.c == 0) {
            this.c = SystemClock.elapsedRealtime();
            this.b = this.c;
        }
    }

    private synchronized void h() {
        if (this.d == 0 && this.c != 0) {
            this.d = SystemClock.elapsedRealtime() - this.c;
        }
    }

    public void a() {
        b();
    }

    public void a(long j) {
        this.b = j;
    }

    void a(Exception exception) {
        if (!this.f) {
            this.f = true;
            a aVar = new a(getURL().toString(), -1, f(), exception.getClass().getSimpleName());
            aVar.d(this.g);
            aVar.c(this.a);
            u.a().a(aVar);
        }
    }

    public void addRequestProperty(String str, String str2) {
        this.j.addRequestProperty(str, str2);
    }

    void b() {
        if (!this.f) {
            this.f = true;
            a aVar = new a(getURL().toString(), SystemClock.elapsedRealtime() - this.b, (long) c(), f());
            aVar.d(this.g);
            aVar.a(this.d);
            aVar.c(this.a);
            u.a().a(aVar);
        }
    }

    public void connect() {
        try {
            this.j.connect();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public void disconnect() {
        this.j.disconnect();
        b();
    }

    public boolean getAllowUserInteraction() {
        return this.j.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.j.getConnectTimeout();
    }

    public Object getContent() {
        try {
            return this.j.getContent();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public Object getContent(Class[] clsArr) {
        try {
            return this.j.getContent(clsArr);
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public String getContentEncoding() {
        return this.j.getContentEncoding();
    }

    public int getContentLength() {
        return this.j.getContentLength();
    }

    public String getContentType() {
        return this.j.getContentType();
    }

    public long getDate() {
        return this.j.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.j.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.j.getDoInput();
    }

    public boolean getDoOutput() {
        return this.j.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.j.getErrorStream();
    }

    public long getExpiration() {
        return this.j.getExpiration();
    }

    public String getHeaderField(int i) {
        return this.j.getHeaderField(i);
    }

    public String getHeaderField(String str) {
        return this.j.getHeaderField(str);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.j.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.j.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        return this.j.getHeaderFieldKey(i);
    }

    public Map getHeaderFields() {
        return this.j.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.j.getIfModifiedSince();
    }

    public InputStream getInputStream() {
        try {
            g();
            this.i = new f(this, this.j.getInputStream());
            h();
            d();
            return this.i;
        } catch (Exception e) {
            e();
            a(e);
            throw e;
        }
    }

    public boolean getInstanceFollowRedirects() {
        return this.j.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.j.getLastModified();
    }

    public OutputStream getOutputStream() {
        try {
            g();
            this.h = new g(this, this.j.getOutputStream());
            h();
            d();
            return this.h;
        } catch (Exception e) {
            e();
            a(e);
            throw e;
        }
    }

    public Permission getPermission() {
        try {
            return this.j.getPermission();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public int getReadTimeout() {
        return this.j.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.j.getRequestMethod();
    }

    public Map getRequestProperties() {
        return this.j.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.j.getRequestProperty(str);
    }

    public int getResponseCode() {
        try {
            g();
            this.e = this.j.getResponseCode();
            h();
            return this.e;
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public String getResponseMessage() {
        try {
            return this.j.getResponseMessage();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public URL getURL() {
        return this.j.getURL();
    }

    public boolean getUseCaches() {
        return this.j.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.j.setAllowUserInteraction(z);
    }

    public void setChunkedStreamingMode(int i) {
        this.j.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i) {
        this.j.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.j.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.j.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.j.setDoOutput(z);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.j.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long j) {
        try {
            this.j.getClass().getDeclaredMethod("setFixedLengthStreamingMode", new Class[]{Long.TYPE}).invoke(this.j, new Object[]{Long.valueOf(j)});
        } catch (Throwable e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public void setIfModifiedSince(long j) {
        this.j.setIfModifiedSince(j);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.j.setInstanceFollowRedirects(z);
    }

    public void setReadTimeout(int i) {
        this.j.setReadTimeout(i);
    }

    public void setRequestMethod(String str) {
        try {
            this.j.setRequestMethod(str);
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public void setRequestProperty(String str, String str2) {
        if ("x-mistats-header".equals(str)) {
            this.a = str2;
        }
        this.j.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.j.setUseCaches(z);
    }

    public String toString() {
        return this.j.toString();
    }

    public boolean usingProxy() {
        return this.j.usingProxy();
    }
}
