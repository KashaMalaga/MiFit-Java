package com.xiaomi.mistatistic.sdk.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.b.A;
import com.xiaomi.mistatistic.sdk.b.u;
import com.xiaomi.mistatistic.sdk.c.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.util.InetAddressUtils;

public class d extends HttpsURLConnection {
    private String a = null;
    private long b;
    private long c;
    private long d;
    private int e = -1;
    private boolean f = false;
    private String g = null;
    private HttpsURLConnection h;

    public d(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        this.h = httpsURLConnection;
        this.b = SystemClock.elapsedRealtime();
    }

    private boolean a(String str) {
        return InetAddressUtils.isIPv4Address(str) || InetAddressUtils.isIPv6Address(str);
    }

    private void c() {
        String host = this.url.getHost();
        if (this.g == null && host != null && !a(host)) {
            a.a().execute(new e(this));
        }
    }

    private synchronized void d() {
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

    private int e() {
        int i = -1;
        if (this.e != i) {
            return this.e;
        }
        try {
            return this.h.getResponseCode();
        } catch (Exception e) {
            return i;
        }
    }

    private synchronized void f() {
        if (this.c == 0) {
            this.c = SystemClock.elapsedRealtime();
            this.b = this.c;
        }
    }

    private synchronized void g() {
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
            a aVar = new a(getURL().toString(), -1, e(), exception.getClass().getSimpleName());
            aVar.d(this.g);
            aVar.c(this.a);
            u.a().a(aVar);
        }
    }

    public void addRequestProperty(String str, String str2) {
        this.h.addRequestProperty(str, str2);
    }

    public void b() {
        if (!this.f) {
            this.f = true;
            a aVar = new a(getURL().toString(), SystemClock.elapsedRealtime() - this.b, 0, e());
            aVar.d(this.g);
            aVar.a(this.d);
            aVar.c(this.a);
            u.a().a(aVar);
        }
    }

    public void connect() {
        try {
            this.h.connect();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public void disconnect() {
        this.h.disconnect();
        b();
    }

    public boolean getAllowUserInteraction() {
        return this.h.getAllowUserInteraction();
    }

    public String getCipherSuite() {
        return this.h.getCipherSuite();
    }

    public int getConnectTimeout() {
        return this.h.getConnectTimeout();
    }

    public Object getContent() {
        return this.h.getContent();
    }

    public Object getContent(Class[] clsArr) {
        try {
            return this.h.getContent(clsArr);
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public String getContentEncoding() {
        return this.h.getContentEncoding();
    }

    public int getContentLength() {
        return this.h.getContentLength();
    }

    public String getContentType() {
        return this.h.getContentType();
    }

    public long getDate() {
        return this.h.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.h.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.h.getDoInput();
    }

    public boolean getDoOutput() {
        return this.h.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.h.getErrorStream();
    }

    public long getExpiration() {
        return this.h.getExpiration();
    }

    public String getHeaderField(int i) {
        return this.h.getHeaderField(i);
    }

    public String getHeaderField(String str) {
        return this.h.getHeaderField(str);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.h.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.h.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        return this.h.getHeaderFieldKey(i);
    }

    public Map getHeaderFields() {
        return this.h.getHeaderFields();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.h.getHostnameVerifier();
    }

    public long getIfModifiedSince() {
        return this.h.getIfModifiedSince();
    }

    public InputStream getInputStream() {
        try {
            f();
            InputStream fVar = new f(this, this.h.getInputStream());
            g();
            c();
            return fVar;
        } catch (Exception e) {
            d();
            a(e);
            throw e;
        }
    }

    public boolean getInstanceFollowRedirects() {
        return this.h.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.h.getLastModified();
    }

    public Certificate[] getLocalCertificates() {
        return this.h.getLocalCertificates();
    }

    public Principal getLocalPrincipal() {
        return this.h.getLocalPrincipal();
    }

    public OutputStream getOutputStream() {
        try {
            f();
            OutputStream gVar = new g(this, this.h.getOutputStream());
            g();
            c();
            return gVar;
        } catch (Exception e) {
            d();
            a(e);
            throw e;
        }
    }

    public Principal getPeerPrincipal() {
        try {
            return this.h.getPeerPrincipal();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public Permission getPermission() {
        try {
            return this.h.getPermission();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public int getReadTimeout() {
        return this.h.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.h.getRequestMethod();
    }

    public Map getRequestProperties() {
        return this.h.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.h.getRequestProperty(str);
    }

    public int getResponseCode() {
        try {
            f();
            this.e = this.h.getResponseCode();
            g();
            return this.e;
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public String getResponseMessage() {
        try {
            return this.h.getResponseMessage();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.h.getSSLSocketFactory();
    }

    public Certificate[] getServerCertificates() {
        try {
            return this.h.getServerCertificates();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public URL getURL() {
        return this.h.getURL();
    }

    public boolean getUseCaches() {
        return this.h.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.h.setAllowUserInteraction(z);
    }

    public void setChunkedStreamingMode(int i) {
        this.h.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i) {
        this.h.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.h.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.h.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.h.setDoOutput(z);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.h.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long j) {
        try {
            this.h.getClass().getMethod("setFixedLengthStreamingMode", new Class[]{Long.TYPE}).invoke(this.h, new Object[]{Long.valueOf(j)});
        } catch (Throwable e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.h.setHostnameVerifier(hostnameVerifier);
    }

    public void setIfModifiedSince(long j) {
        this.h.setIfModifiedSince(j);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.h.setInstanceFollowRedirects(z);
    }

    public void setReadTimeout(int i) {
        this.h.setReadTimeout(i);
    }

    public void setRequestMethod(String str) {
        try {
            this.h.setRequestMethod(str);
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public void setRequestProperty(String str, String str2) {
        if ("x-mistats-header".equals(str)) {
            this.a = str2;
        }
        this.h.setRequestProperty(str, str2);
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.h.setSSLSocketFactory(sSLSocketFactory);
    }

    public void setUseCaches(boolean z) {
        this.h.setUseCaches(z);
    }

    public String toString() {
        return this.h.toString();
    }

    public boolean usingProxy() {
        return this.h.usingProxy();
    }
}
